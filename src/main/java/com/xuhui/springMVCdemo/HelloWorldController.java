package com.xuhui.springMVCdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    // how the initial HTML form

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // a controller method to read from data & add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all uppercase
        theName = theName.toUpperCase();

        // create message
        String result = "Yo! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    // a controller method to read from data & add data to the model
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String theName, Model model) {
        // convert the data to all uppercase
        theName = theName.toUpperCase();

        // create message
        String result = "Hey my friend from v3!\n " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
