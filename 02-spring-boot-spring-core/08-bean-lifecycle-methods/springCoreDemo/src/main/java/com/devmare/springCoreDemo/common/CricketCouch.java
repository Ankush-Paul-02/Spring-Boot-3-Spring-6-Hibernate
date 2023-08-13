package com.devmare.springCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCouch implements Coach {

    public CricketCouch() {
        System.out.println("In CricketCouch Constructor");
    }

    @Override
    public String getDailyWordOut() {
        return "Practice batting bowling for 15 minute :-)";
    }
}
