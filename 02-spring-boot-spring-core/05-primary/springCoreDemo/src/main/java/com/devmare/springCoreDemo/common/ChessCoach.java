package com.devmare.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {

    @Override
    public String getDailyWordOut() {
        return "Play Chess...";
    }
}
