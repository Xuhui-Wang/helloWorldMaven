package com.xuhui.demoAnnotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "RESTful service!";
    }
}
