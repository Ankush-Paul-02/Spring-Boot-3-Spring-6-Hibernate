package com.devmare.springCoreDemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCouch implements Coach {

    public CricketCouch() {
        System.out.println("In CricketCouch Constructor");
    }

    @Override
    public String getDailyWordOut() {
        return "Practice batting bowling for 15 minute :-)";
    }
}
