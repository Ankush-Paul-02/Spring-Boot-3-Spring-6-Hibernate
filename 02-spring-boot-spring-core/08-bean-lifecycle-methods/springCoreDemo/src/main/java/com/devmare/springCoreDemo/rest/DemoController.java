package com.devmare.springCoreDemo.rest;

import com.devmare.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach newCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCouch") Coach coach, @Qualifier("cricketCouch") Coach newCoach) {
        this.coach = coach;
        this.newCoach = newCoach;
    }

    @GetMapping("/getDailyWork")
    public String getDailyWork() {
        return coach.getDailyWordOut();
    }

    @GetMapping("/getCheck")
    public String getCheck() {
        return "Comparing beans: coach == newCoach, " + (coach == newCoach);
    }
}
