package com.liferay.registration.util.validator;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.registration.exception.BillingAddressValidationException;
import com.liferay.registration.validator.BillingAddressValidator;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = BillingAddressValidator.class
)

public class BillingAddressValidatorImpl implements BillingAddressValidator {

    @Override
    public void validate(String address1, String address2, String city, String state, String zipCode) throws BillingAddressValidationException {

        if(Validator.isNull(address1)){
            throw new BillingAddressValidationException.Address1MustBeCorrect();
        }

        if(!isAlphanumeric(address1,1,255)){
            throw new BillingAddressValidationException.Address1MustBeCorrect();
        }

        if(!address2.equals("") && address2 != null && !isAlphanumeric(address1,1,255)){
            throw new BillingAddressValidationException.Address2MustBeCorrect();
        }

        if(Validator.isNull(city)){
            throw new BillingAddressValidationException.CityMustNotBeNull();
        }

        if(!isAlphanumeric(city,1,255)){
            throw new BillingAddressValidationException.CityMustBeCorrect();
        }

        if(Validator.isNull(state)){
            throw new BillingAddressValidationException.StateMustNotBeNull();
        }

        if(Validator.isNull(zipCode)){
            throw new BillingAddressValidationException.ZipCodeMustNotBeNull();
        }

        if(!isZipCode(zipCode)){
            throw new BillingAddressValidationException.ZipCodeMustBeCorrect();
        }

    }

    private boolean isAlphanumeric(String text, int minCharacter,int maxCharacter){

        boolean result = true;

        String alphanumericRegex =  "^(\\w||\\s){"+minCharacter+","+maxCharacter+"}$";

        if(!text.matches(alphanumericRegex)){
            result = false;
        }

        return result;
    }

    private boolean isZipCode(String zipCode){

        boolean result = true;

        String zipCodeRegex = "^\\d{5}$";

        if(!zipCode.matches(zipCodeRegex)){
            result = false;
        }

        return result;
    }
}
