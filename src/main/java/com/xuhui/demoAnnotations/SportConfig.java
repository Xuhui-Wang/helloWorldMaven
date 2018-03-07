package com.xuhui.demoAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.xuhui.demoAnnotations")
public class SportConfig {
    // define bean for SadFortuneService
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for SwimCoach
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
