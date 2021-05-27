package com.liferay.registration.util.validator;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.registration.exception.SecurityQuestionValidationException;
import com.liferay.registration.validator.SecurityQuestionValidator;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = SecurityQuestionValidator.class
)

public class SecurityQuestionValidatorImpl implements SecurityQuestionValidator {

    @Override
    public void validate(String answer) throws SecurityQuestionValidationException {

        if(Validator.isNull(answer)){
            throw new SecurityQuestionValidationException.AnswerMustNotBeNull();
        }

        if(!isAlphanumeric(answer,1,255)){
            throw new SecurityQuestionValidationException.AnswerMustBeCorrect();
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
}
