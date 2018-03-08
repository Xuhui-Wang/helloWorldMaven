package com.xuhui.springMVCdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        // create a new Student object
        Student student = new Student();

        // add the object to the model
        theModel.addAttribute("student", student);

    // add the country options to the model
        theModel.addAttribute("theCountryOptions", countryOptions);

        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        // log the input data
        System.out.println("theStudent: " + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
}