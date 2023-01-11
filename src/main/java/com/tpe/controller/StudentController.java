package com.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//end point gelecek bize. https://127.0.0.1:8080/students
@RequestMapping("/students")
public class StudentController {

    @GetMapping("hi") //students/hi
    public ModelAndView sayHi(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message","Merhaba");
        mav.addObject("messagebody","Ben Bir Ogrenci Yonetim Sistemiyim");
        mav.setViewName("hi");//hi/jsp

        return mav;
    }
}
