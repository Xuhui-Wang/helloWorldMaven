package com.xuhui.demoAnnotations;


import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "practice on tennis every day";
    }
}
