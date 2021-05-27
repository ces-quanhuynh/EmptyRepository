package com.liferay.search.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.search.web.constants.AMFSearchPortletKeys;
import com.liferay.search.web.constants.MVCCommandNames;
import com.liferay.search.web.portlet.exception.ZipCodeValidationException;
import com.liferay.search.web.portlet.validator.ZipCodeValidator;
import com.liferay.search.web.portlet.validator.impl.ZipCodeValidatorImpl;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AMFSearchPortletKeys.AMFSEARCH,
                "mvc.command.name=" + MVCCommandNames.GET_ZIPCODE,
        },
        service = MVCActionCommand.class
)
public class GetZipCodeMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String zipCode = ParamUtil.getString(actionRequest,"zip_code");

        try{
            _zipZipCodeValidator.validate(zipCode);
            PortletSession portletSession = actionRequest.getPortletSession();
            portletSession.setAttribute("LIFERAY_SHARED_zipCode",zipCode, PortletSession.APPLICATION_SCOPE);

            actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.GET_ZIPCODE);
        }catch(PortalException portalException){
            if(portalException instanceof ZipCodeValidationException){

                SessionErrors.add(actionRequest,portalException.getClass(),portalException);

                PortletSession portletSession = actionRequest.getPortletSession();
                portletSession.setAttribute("LIFERAY_SHARED_zipCode",null, PortletSession.APPLICATION_SCOPE);

                actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.GET_ZIPCODE);
            } else {
                throw portalException;
            }
        }
    }

    ZipCodeValidator _zipZipCodeValidator = new ZipCodeValidatorImpl();
}
