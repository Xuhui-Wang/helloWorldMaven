package com.xuhui.demoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    /* default constructor */
    public TennisCoach() {
        System.out.println(">> TennisCoach: Inside the default constructor");
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside doMyStartupStuff");
    }

    // define my destroy method - JDK 9.0 problems waiting to be resolved
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside doMyStartupStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "practice on tennis every day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
