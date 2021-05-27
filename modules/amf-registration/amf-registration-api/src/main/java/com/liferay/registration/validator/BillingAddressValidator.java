package com.liferay.registration.validator;

import com.liferay.registration.exception.BillingAddressValidationException;

public interface BillingAddressValidator {
    public void validate(String address1, String address2, String city, String state, String zipCode) throws BillingAddressValidationException;
}
