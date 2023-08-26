package com.devmare.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    //! Create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        return "helloWorld"; //? helloWorld.html
    }
}
