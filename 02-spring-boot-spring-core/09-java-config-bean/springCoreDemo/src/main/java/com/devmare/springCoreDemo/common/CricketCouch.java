package com.devmare.springCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCouch implements Coach {

    public CricketCouch() {
        System.out.println("In CricketCouch Constructor");
    }

    //! Define our init method
    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println("Hey! in doMyStartUpStuff(): " + getClass().getName());
    }
    //! Define our destroy method
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("Hey! in doMyCleanUpStuff(): " + getClass().getName());
    }

    @Override
    public String getDailyWordOut() {
        return "Practice batting bowling for 15 minute :-)";
    }
}
