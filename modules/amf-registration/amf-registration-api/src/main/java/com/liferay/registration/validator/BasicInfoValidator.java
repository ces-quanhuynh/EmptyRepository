package com.liferay.registration.validator;

import com.liferay.registration.exception.BasicInfoValidationException;

public interface BasicInfoValidator {
    public void validate(String firstName, String lastName, String email,String screenName, int birthdayMonth, int birthdayDay,
                         int birthdayYear, String password1, String password2)
            throws BasicInfoValidationException;
}
