package com.liferay.registration.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.registration.web.constants.AdminMonitorPortletKeys;
import com.liferay.registration.web.constants.MVCCommandNames;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AdminMonitorPortletKeys.ADMINMONITOR,
                "mvc.command.name=" + MVCCommandNames.VIEW,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ViewAllMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/adminmonitor/view.jsp";
    }
}
