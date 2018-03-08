package com.xuhui.springMVCdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        // create a new Student object
        Student student = new Student();

        // add the object to the model
        theModel.addAttribute("student", student);

        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        // log the input data
        System.out.println("theStudent: " + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
}