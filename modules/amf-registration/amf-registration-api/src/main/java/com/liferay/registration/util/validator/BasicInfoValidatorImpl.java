package com.liferay.registration.util.validator;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.registration.exception.BasicInfoValidationException;
import com.liferay.registration.validator.BasicInfoValidator;
import org.osgi.service.component.annotations.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component(
        immediate = true,
        service = BasicInfoValidator.class
)

public class BasicInfoValidatorImpl implements BasicInfoValidator {
    @Override
    public void validate(String firstName, String lastName, String email, String screenName, int birthdayMonth, int birthdayDay,
                         int birthdayYear, String password1, String password2)
            throws BasicInfoValidationException {

        if(Validator.isNull(firstName)){
            throw new BasicInfoValidationException.FirstNameMustNotBeNull();
        }

        if(!isAlphanumeric(firstName,1,50)){
            throw new BasicInfoValidationException.FirstNameMustBeCorrect();
        }

        if(Validator.isNull(lastName)){
            throw new BasicInfoValidationException.LastNameMustNotBeNull();
        }

        if(!isAlphanumeric(lastName,1,50)){
            throw new BasicInfoValidationException.LastNameMustBeCorrect();
        }

        if(!Validator.isEmailAddress(email)){
            throw new BasicInfoValidationException.EmailMustBeCorrect();
        }

        if(Validator.isNull(screenName)){
            throw new BasicInfoValidationException.ScreenNameMustNotBeNull();
        }

        if(!isAlphanumeric(screenName,4,16)){
            throw new BasicInfoValidationException.ScreenNameMustBeCorrect();
        }

        if(Validator.isNull(getDate(birthdayMonth,birthdayDay,birthdayYear))){
            throw new BasicInfoValidationException.BirthdayMustNotBeNull();
        }

        if(!isMoreThan13YearsOld(birthdayMonth,birthdayDay,birthdayYear)){
            throw new BasicInfoValidationException.BirthdayMustBeCorrect();
        }

        if(Validator.isNull(password1)){
            throw new BasicInfoValidationException.PasswordMustNotBeNull();
        }

        if(!isPassword(password1)){
            throw new BasicInfoValidationException.PasswordMustBeCorrect();
        }

        if(Validator.isNull(password2)){
            throw new BasicInfoValidationException.ConfirmedPasswordMustNotBeNull();
        }

        if(!password2.equals(password1)){
            throw new BasicInfoValidationException.ConfirmedPasswordMustBeCorrect();
        }

    }

    private boolean isAlphanumeric(String text, int minCharacter,int maxCharacter){

        boolean result = true;

        String alphanumericRegex =  "^\\w{"+minCharacter+","+maxCharacter+"}$";

        if(!text.matches(alphanumericRegex)){
            result = false;
        }

        return result;
    }

    private boolean isPassword(String password){

        boolean result = true;

        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";

        if(!password.matches(passwordRegex)){
            result = false;
        }

        return result;
    }

    private boolean isMoreThan13YearsOld(int birthdayMonth, int birthdayDay, int birthdayYear){
        Date dateNow = new Date();
        Calendar calendarNow = getCalendar(dateNow);
        Calendar calendarBirthday = getCalendar(getDate(birthdayMonth,birthdayDay,birthdayYear));
        int diff = calendarNow.get(Calendar.YEAR) - calendarBirthday.get(Calendar.YEAR);
        if (calendarBirthday.get(Calendar.MONTH) > calendarNow.get(Calendar.MONTH) ||
                (calendarBirthday.get(Calendar.MONTH) == calendarNow.get(Calendar.MONTH)
                        && calendarBirthday.get(Calendar.DATE) > calendarNow.get(Calendar.DATE))) {
            diff--;
        }
        return diff>=13?true:false;
    }

    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.setTime(date);
        return calendar;
    }

    private Date getDate(int birthdayMonth, int birthdayDay, int birthdayYear){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH,birthdayMonth);
        calendar.set(Calendar.DATE,birthdayDay);
        calendar.set(Calendar.YEAR,birthdayYear);

        Date date = calendar.getTime();

        return date;
    }
}
