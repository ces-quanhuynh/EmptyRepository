package com.liferay.search.web.portlet.validator.impl;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.search.web.portlet.exception.ZipCodeValidationException;
import com.liferay.search.web.portlet.validator.ZipCodeValidator;

public class ZipCodeValidatorImpl implements ZipCodeValidator {
    @Override
    public void validate(String zipCode) throws ZipCodeValidationException {

        if(Validator.isNull(zipCode)){
            throw new ZipCodeValidationException.ZipCodeMustNotBeNull();
        }

        if(!isZipCode(zipCode)){
            throw new ZipCodeValidationException.ZipCodeMustBeCorrect();
        }

    }

    public boolean isZipCode(String zipCode){
        boolean result = true;

        String zipCodeRegex = "^\\d{5}$";

        if(!zipCode.matches(zipCodeRegex)){
            result = false;
        }

        return result;
    }
}
