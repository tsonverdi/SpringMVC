package com.tpe.repository;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//Componenti da iceriyor Spring Frameworke bu classimin Repo katmani oldugunu soylemis oluyorum.
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private SessionFactory sessionFactory;//Db katmaninda oldugum icin SessionFactory bagimliligini RootContextConfigden einject ettik.

    @Override
    public List<Student> getAll() {
       Session session = sessionFactory.openSession();
       Transaction tx = session.beginTransaction();
       List<Student> listOfStudents = session.createQuery("from Student", Student.class).getResultList();
       tx.commit();
       session.close();
       return listOfStudents;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class,id);//Get ile aldik
        Optional<Student> opt;//Bok bi optinal instance i olusturduk.
        opt = Optional.ofNullable(student);//Ona ofNullable atadik
        //eger donen deger null ise, ici bos bir student objesi olusturup dondurur.
        tx.commit();
        session.close();

        return opt;
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(student);//varsa update yoksa save

        tx.commit();
        session.close();

    }

    @Override
    public void update(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(student);

        tx.commit();
        session.close();

    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.load(Student.class,id);
        session.delete(student);

        tx.commit();
        session.close();

    }
}
