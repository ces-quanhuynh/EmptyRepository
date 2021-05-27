package com.liferay.registration.validator;

import com.liferay.registration.exception.SecurityQuestionValidationException;

public interface SecurityQuestionValidator {
    public void validate(String answer) throws SecurityQuestionValidationException;
}
