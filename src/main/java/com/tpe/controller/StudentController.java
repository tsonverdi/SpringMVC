package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller//end point gelecek bize. https://127.0.0.1:8080/students
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("hi") //students/hi
    public ModelAndView sayHi(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","Merhaba");
        mav.addObject("messagebody","Ben Bir Ogrenci Yonetim Sistemiyim");
        mav.setViewName("hi");//hi/jsp

        return mav;
    }
    //get
    @GetMapping("/new")
    public String sendStudentForm(@ModelAttribute("student")Student student){
        return "studentForm";
        //Yeni ogrenci kaydetmiyoruz burada o yuzden forma yonlendirdim model view objesine ihtiyacim yok.
    }
    //save
    @PostMapping("/saveStudent")
    public String createStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    //get
    @GetMapping
    public ModelAndView getStudents(){
        List<Student> list = studentService.getAllStudent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",list);
        modelAndView.setViewName("students");
        return modelAndView;
    }
    //update http://localhost:8080/springmvc/students?id=1
    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model){
        Student student = studentService.findStudentById(id); //bize student objesi getirir. Yoksa onceki classta exception atar.
        model.addAttribute(student);//model
        return "studentForm";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
