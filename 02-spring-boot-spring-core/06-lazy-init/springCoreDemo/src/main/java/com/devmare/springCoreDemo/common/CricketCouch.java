package com.devmare.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCouch implements Coach {

    @Override
    public String getDailyWordOut() {
        return "Practice batting bowling for 15 minute :-)";
    }
}
