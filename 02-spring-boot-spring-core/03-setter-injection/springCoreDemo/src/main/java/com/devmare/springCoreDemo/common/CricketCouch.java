package com.devmare.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCouch implements Coach {

    @Override
    public String getDailyWordOut() {
        return "Practice fast bowling for 15 minutes...";
    }
}
