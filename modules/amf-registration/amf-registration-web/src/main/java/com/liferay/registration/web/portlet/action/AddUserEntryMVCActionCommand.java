package com.liferay.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.registration.exception.BasicInfoValidationException;
import com.liferay.registration.exception.PhoneValidationException;
import com.liferay.registration.exception.SecurityQuestionValidationException;
import com.liferay.registration.model.UserEntry;
import com.liferay.registration.service.UserEntryLocalService;
import com.liferay.registration.web.constants.MVCCommandNames;
import com.liferay.registration.web.constants.SignUpPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
                "mvc.command.name=" + MVCCommandNames.ADD_USER_ENTRIES
        },
        service = MVCActionCommand.class
)
public class AddUserEntryMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(UserEntry.class.getName(),actionRequest);

        ThemeDisplay themeDisplay =(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Company company = themeDisplay.getCompany();

        boolean autoPassword = false;
        boolean autoScreenName = false;

        //Basic Info
        String firstName = ParamUtil.getString(actionRequest,"first_name");
        String lastName = ParamUtil.getString(actionRequest,"last_name");
        String emailAddress = ParamUtil.getString(actionRequest,"email_address");
        String username = ParamUtil.getString(actionRequest,"username");
        boolean male = ParamUtil.getBoolean(actionRequest,"male",true);
        int birthdayMonth = ParamUtil.getInteger(actionRequest,"birthdayMonth");
        int birthdayDay = ParamUtil.getInteger(actionRequest,"birthdayDay");
        int birthdayYear = ParamUtil.getInteger(actionRequest,"birthdayYear");

        String password1 = ParamUtil.getString(actionRequest, "password1");
        String password2 = ParamUtil.getString(actionRequest, "password2");

        //Phone
        String homePhone = ParamUtil.getString(actionRequest,"home_phone");
        String mobilePhone = ParamUtil.getString(actionRequest,"mobile_phone");

        //Billing Address
        String address1 = ParamUtil.getString(actionRequest,"address");
        String address2 = ParamUtil.getString(actionRequest,"address2");
        String city = ParamUtil.getString(actionRequest,"city");
        String state = ParamUtil.getString(actionRequest, "state");
        String zipCode = ParamUtil.getString(actionRequest, "zip");

        //Misc.
        String securityQuestion = ParamUtil.getString(actionRequest,"security_question");
        String securityAnswer = ParamUtil.getString(actionRequest,"security_answer");

        long[] groupIds = null;
        long[] organizationIds = null;
        long[] roleIds = null;
        long[] userGroupIds = null;
        boolean sendEmail = true;

        String languageId = ParamUtil.getString(actionRequest, "languageId");

        try{
            UserEntry _userEntry = _userEntryLocalService.addUserEntry(0,company.getCompanyId(),autoPassword,
                    password1,password2,autoScreenName,username,emailAddress,0,null, LocaleUtil.fromLanguageId(languageId),firstName,"",
                    lastName,0,0,male,birthdayMonth,birthdayDay,birthdayYear,null,groupIds,organizationIds,roleIds,
                    userGroupIds,sendEmail,homePhone,mobilePhone,address1,address2,city,state,zipCode,securityQuestion,securityAnswer,serviceContext);


            //actionRequest.getPortletSession().setAttribute(WebKeys.LAST_PATH, new LastPath(StringPool.BLANK, "/"));
            actionResponse.sendRedirect("/c/portal/login");

        }catch (PortalException portalException){
            if(portalException instanceof BasicInfoValidationException || portalException instanceof PhoneValidationException
                    || portalException instanceof BasicInfoValidationException || portalException instanceof SecurityQuestionValidationException){

                SessionErrors.add(actionRequest,portalException.getClass(),portalException);

                actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.ADD_USER_ENTRIES);
            }
            else {
                throw portalException;
            }
        }
    }

    @Reference
    private UserEntryLocalService _userEntryLocalService;
}
