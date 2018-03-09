package com.xuhui.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode, String> {

    private String[] prefixes;

    @Override
    public void initialize(CourseCode courseCode) {
        prefixes = courseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code != null) {
            for (String prefix : prefixes) {
                if (code.startsWith(prefix))
                    return true;
            }
            return false;
        } else {
            return true;
        }
    }
}
