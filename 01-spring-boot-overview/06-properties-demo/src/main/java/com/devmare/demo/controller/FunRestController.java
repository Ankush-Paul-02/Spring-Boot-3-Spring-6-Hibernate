package com.devmare.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //! Inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    //! expose endpoints for team-info
    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

    //! expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello Ankush Paul, I'm a Java developer";
    }
}
