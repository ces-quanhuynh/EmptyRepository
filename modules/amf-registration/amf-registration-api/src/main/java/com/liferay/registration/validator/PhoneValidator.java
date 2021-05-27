package com.liferay.registration.validator;

import com.liferay.registration.exception.PhoneValidationException;

public interface PhoneValidator {
    public void validate(String homePhone, String mobilePhone) throws PhoneValidationException;
}
