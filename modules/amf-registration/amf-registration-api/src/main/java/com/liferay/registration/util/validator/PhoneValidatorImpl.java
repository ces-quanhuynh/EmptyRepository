package com.liferay.registration.util.validator;

import com.liferay.registration.exception.PhoneValidationException;
import com.liferay.registration.validator.PhoneValidator;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = PhoneValidator.class
)

public class PhoneValidatorImpl implements PhoneValidator {

    @Override
    public void validate(String homePhone, String mobilePhone) throws PhoneValidationException {

        if(!homePhone.equals("") && homePhone!=null && !isPhoneNumber(homePhone)){
            throw new PhoneValidationException.HomePhoneMustBeCorrect();
        }

        if(!mobilePhone.equals("") && mobilePhone!=null && !isPhoneNumber(mobilePhone)){
            throw new PhoneValidationException.MobilePhoneMustBeCorrect();
        }

    }

    private boolean isPhoneNumber (String phoneNumber){

        boolean result = true;

        String phoneRegex = "^\\d{10}$";

        if(!phoneNumber.matches(phoneRegex)){
            result = false;
        }

        return result;
    }
}
