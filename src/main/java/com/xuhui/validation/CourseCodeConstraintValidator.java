package com.xuhui.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
        System.out.println("Initiazlied: prefix: |" + coursePrefix + "|");
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("code: |" + code + "|");
        System.out.println("prefix: |" + coursePrefix + "|");
        if (code != null) {
            return code.startsWith(coursePrefix);
        } else {
            return true;
        }
    }
}
