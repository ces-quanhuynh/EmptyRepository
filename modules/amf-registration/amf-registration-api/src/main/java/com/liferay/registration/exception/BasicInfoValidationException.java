package com.liferay.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class BasicInfoValidationException extends PortalException {

    public BasicInfoValidationException(){}

    public BasicInfoValidationException(String msg){ super(msg); }

    public BasicInfoValidationException(String msg, Throwable throwable){ super(msg,throwable); }

    public BasicInfoValidationException(Throwable throwable){ super(throwable); }

    public static class FirstNameMustNotBeNull extends BasicInfoValidationException{

        public FirstNameMustNotBeNull() { super(String.format("Fist Name must not be null"));}
    }

    public static class FirstNameMustBeCorrect extends BasicInfoValidationException{

        public FirstNameMustBeCorrect() { super(String.format("First Name must be correct"));}
    }

    public static class LastNameMustNotBeNull extends BasicInfoValidationException{

        public LastNameMustNotBeNull() { super(String.format("Last Name must not be null"));}
    }

    public static class LastNameMustBeCorrect extends BasicInfoValidationException{

        public LastNameMustBeCorrect() { super(String.format("Last Name must be correct"));}
    }

    public static class EmailMustNotBeNull extends BasicInfoValidationException{

        public EmailMustNotBeNull() { super(String.format("Email must not be null"));}
    }

    public static class EmailMustBeCorrect extends BasicInfoValidationException{

        public EmailMustBeCorrect() { super(String.format("Email must be correct"));}
    }

    public static class ScreenNameMustNotBeNull extends BasicInfoValidationException{

        public ScreenNameMustNotBeNull() { super(String.format("Screen name must not be null"));}
    }

    public static class ScreenNameMustBeCorrect extends BasicInfoValidationException{

        public ScreenNameMustBeCorrect() { super(String.format("Screen name must be correct"));}
    }

    public static class BirthdayMustNotBeNull extends BasicInfoValidationException{

        public BirthdayMustNotBeNull() { super(String.format("Birthday must not be null"));}
    }

    public static class BirthdayMustBeCorrect extends BasicInfoValidationException{

        public BirthdayMustBeCorrect() { super(String.format("Birthday must be correct"));}
    }

    public static class PasswordMustNotBeNull extends BasicInfoValidationException{

        public PasswordMustNotBeNull() { super(String.format("Password must not be null"));}
    }

    public static class PasswordMustBeCorrect extends BasicInfoValidationException{

        public PasswordMustBeCorrect() { super(String.format("Password must be correct"));}
    }

    public static class ConfirmedPasswordMustNotBeNull extends BasicInfoValidationException{

        public ConfirmedPasswordMustNotBeNull() { super(String.format("Confirmed Password must not be null"));}
    }

    public static class ConfirmedPasswordMustBeCorrect extends BasicInfoValidationException{

        public ConfirmedPasswordMustBeCorrect() { super(String.format("Confirmed Password must be correct"));}
    }
}
