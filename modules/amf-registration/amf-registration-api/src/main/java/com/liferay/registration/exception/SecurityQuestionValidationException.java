package com.liferay.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class SecurityQuestionValidationException extends PortalException {
    public SecurityQuestionValidationException(){}

    public SecurityQuestionValidationException(String msg){ super(msg); }

    public SecurityQuestionValidationException(String msg, Throwable throwable){ super(msg,throwable); }

    public SecurityQuestionValidationException(Throwable throwable){ super(throwable); }

    public static class AnswerMustNotBeNull extends SecurityQuestionValidationException {

        public AnswerMustNotBeNull() { super(String.format("Answer must not be null"));}
    }

    public static class AnswerMustBeCorrect extends SecurityQuestionValidationException {

        public AnswerMustBeCorrect() { super(String.format("Answer must be correct"));}
    }
}
