package com.xuhui.demoAnnotations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
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
