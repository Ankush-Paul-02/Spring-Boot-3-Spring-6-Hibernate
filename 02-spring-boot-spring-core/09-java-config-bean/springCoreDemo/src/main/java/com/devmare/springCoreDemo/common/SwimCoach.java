package com.devmare.springCoreDemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }
    @Override
    public String getDailyWordOut() {
        return "Swim 1000 meters as a warm up";
    }
}
