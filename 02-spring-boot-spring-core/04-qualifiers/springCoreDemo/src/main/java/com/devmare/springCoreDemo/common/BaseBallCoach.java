package com.devmare.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWordOut() {
        return "Spend 30 minutes in batting practice";
    }
}
