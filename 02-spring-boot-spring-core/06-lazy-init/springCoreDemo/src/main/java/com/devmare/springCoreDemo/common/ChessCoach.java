package com.devmare.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ChessCoach implements Coach {

    public ChessCoach() {
        System.out.println("In ChessCoach Constructor");
    }

    @Override
    public String getDailyWordOut() {
        return "Play Chess...";
    }
}
