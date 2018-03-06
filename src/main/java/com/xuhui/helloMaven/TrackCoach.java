package com.xuhui.helloMaven;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// add an init method
	private void doMyStartupStuff() {
		System.out.println("TrackCoach: initialized");
	}

	// add a destroy method
	private void doMyCleanupStuff() {
		System.out.println("TrackCoach: destroyed");
	}
}
