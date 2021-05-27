package com.liferay.search.web.portlet.validator;

import com.liferay.search.web.portlet.exception.ZipCodeValidationException;

public interface ZipCodeValidator {
    public void validate(String zipCode) throws ZipCodeValidationException;
}
