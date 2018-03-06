package com.xuhui.helloMaven;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String emailAddress,team;

    // create a no-arg constructor
    public  CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    // setter method that will be called by Spring to inject dependency
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Cricket Coach: inside setter method");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Cricket Coach: set email address");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("Cricket Coach: set team");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice cricket 24 hours a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
