package com.liferay.searchresult.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.searchresult.web.constants.AMFSearchResultPortletKeys;
import com.liferay.searchresult.web.constants.MVCCommandNames;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AMFSearchResultPortletKeys.AMFSEARCHRESULT,
                "mvc.command.name=" + MVCCommandNames.VIEW,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)

public class ViewUsersMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        PortletSession portletSession = renderRequest.getPortletSession();
        String zipCode = (String) portletSession.getAttribute("LIFERAY_SHARED_zipCode", PortletSession.APPLICATION_SCOPE);

        renderRequest.setAttribute("zipCode",zipCode);
        return "/amfsearchresult/view.jsp";
    }
}
