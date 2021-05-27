package com.liferay.registration.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.registration.web.constants.MVCCommandNames;
import com.liferay.registration.web.constants.SignUpPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
                "mvc.command.name=" + MVCCommandNames.ADD_USER_ENTRIES,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)

public class AddUserEntryMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/signup/add_entry.jsp";
    }
}
