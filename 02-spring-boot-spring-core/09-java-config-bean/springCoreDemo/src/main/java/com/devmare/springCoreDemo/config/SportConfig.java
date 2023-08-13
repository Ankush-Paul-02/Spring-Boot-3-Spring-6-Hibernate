package com.devmare.springCoreDemo.config;

import com.devmare.springCoreDemo.common.Coach;
import com.devmare.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return  new SwimCoach();
    }
}
