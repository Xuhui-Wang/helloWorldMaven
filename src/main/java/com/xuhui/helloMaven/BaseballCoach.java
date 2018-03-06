package com.xuhui.helloMaven;

public class BaseballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on practice";
	}

	@Override
	public String getDailyFortune() {
		// use my FortuneService to get a 'Fortune'
		return fortuneService.getFortune();
	}
}
