package com.liferay.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class BillingAddressValidationException extends PortalException{

    public BillingAddressValidationException(){ }

    public BillingAddressValidationException(String msg){ super(msg);}

    public BillingAddressValidationException(String msg, Throwable throwable){ super(msg,throwable); }

    public BillingAddressValidationException(Throwable throwable){ super(throwable); }

    public static class Address1MustNotBeNull extends BillingAddressValidationException{
        public Address1MustNotBeNull(){ super(String.format("Address1 must not be null"));}
    }

    public static class Address1MustBeCorrect extends BillingAddressValidationException{
        public Address1MustBeCorrect(){ super(String.format("Address1 must be correct"));}
    }

    public static class Address2MustBeCorrect extends BillingAddressValidationException{
        public Address2MustBeCorrect(){ super(String.format("Address2 must be correct"));}
    }

    public static class CityMustNotBeNull extends BillingAddressValidationException{
        public CityMustNotBeNull(){ super(String.format("City must not be null"));}
    }

    public static class CityMustBeCorrect extends BillingAddressValidationException{
        public CityMustBeCorrect() {super(String.format("City must be correct"));}
    }

    public static class StateMustNotBeNull extends BillingAddressValidationException{
        public StateMustNotBeNull(){ super(String.format("State must not be null"));}
    }

    public static class ZipCodeMustNotBeNull extends BillingAddressValidationException{
        public ZipCodeMustNotBeNull(){ super(String.format("Zip Code must not be null"));}
    }

    public static class ZipCodeMustBeCorrect extends BillingAddressValidationException{
        public ZipCodeMustBeCorrect() {super(String.format("Zip Code must be correct"));}
    }
}
