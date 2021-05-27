package com.liferay.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class PhoneValidationException extends PortalException {

    public PhoneValidationException(){}

    public PhoneValidationException(String msg, Throwable throwable){ super(msg,throwable);}

    public PhoneValidationException(String msg){super(msg);}

    public PhoneValidationException(Throwable throwable){super(throwable);}

    public static class HomePhoneMustBeCorrect extends PhoneValidationException{

        public HomePhoneMustBeCorrect(){
            super(String.format("The Home Phone must be 10 digits long"));
        }
    }

    public static class MobilePhoneMustBeCorrect extends PhoneValidationException{

        public MobilePhoneMustBeCorrect(){
            super(String.format("The Mobile Phone must be 10 digits long"));
        }
    }
}