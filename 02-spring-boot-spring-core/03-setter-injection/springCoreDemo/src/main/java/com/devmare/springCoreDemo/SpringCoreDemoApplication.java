package com.devmare.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
		scanBasePackages = {"com.devmare.springCoreDemo", "com.devmare.util"}
)*/
@SpringBootApplication
public class SpringCoreDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreDemoApplication.class, args);
    }
}
