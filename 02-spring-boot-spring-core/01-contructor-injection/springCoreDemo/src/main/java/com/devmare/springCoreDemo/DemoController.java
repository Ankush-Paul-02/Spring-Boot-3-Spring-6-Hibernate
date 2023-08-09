package com.devmare.springCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private Coach coach;

    public DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getDailyWork")
    public String getDailyWork() {
        return coach.getDailyWordOut();
    }
}
