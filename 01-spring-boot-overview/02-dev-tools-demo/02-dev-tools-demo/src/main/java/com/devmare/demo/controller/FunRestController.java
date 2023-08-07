package com.devmare.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //! expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello Ankush Paul";
    }

    //! expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String workOut() {
        return "Run a hard!";
    }

    //! expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String fortune() {
        return "Today is your lucky day!";
    }
}
