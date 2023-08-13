package com.devmare.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach() {
        System.out.println("In BaseBallCoach Constructor");
    }
    @Override
    public String getDailyWordOut() {
        return "Spend 30 minutes in batting practice";
    }
}
