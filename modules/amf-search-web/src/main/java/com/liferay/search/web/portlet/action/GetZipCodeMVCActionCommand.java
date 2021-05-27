package com.liferay.search.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.search.web.constants.AMFSearchPortletKeys;
import com.liferay.search.web.constants.MVCCommandNames;
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

            PortletSession portletSession = actionRequest.getPortletSession();
            portletSession.setAttribute("LIFERAY_SHARED_zipCode",zipCode, PortletSession.APPLICATION_SCOPE);

            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.GET_ZIPCODE);
    }
}
