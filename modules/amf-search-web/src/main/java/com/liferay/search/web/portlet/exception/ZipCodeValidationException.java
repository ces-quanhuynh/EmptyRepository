package com.liferay.search.web.portlet.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class ZipCodeValidationException extends PortalException {

    public ZipCodeValidationException(){}

    public ZipCodeValidationException(String msg){super(msg);}

    public static class ZipCodeMustNotBeNull extends ZipCodeValidationException{

        public ZipCodeMustNotBeNull() { super(String.format("Zip code must not be null"));}
    }

    public static class ZipCodeMustBeCorrect extends ZipCodeValidationException{

        public ZipCodeMustBeCorrect() { super(String.format("Zip code must be correct"));}
    }
}
