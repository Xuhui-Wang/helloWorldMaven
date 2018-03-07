package com.xuhui.demoAnnotations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Autowired
    private FortuneService fortuneService;

    /* default constructor */
    public TennisCoach() {
        System.out.println(">> TennisCoach: Inside the default constructor");
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
