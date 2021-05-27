package com.liferay.search.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.search.web.constants.AMFSearchPortletKeys;
import com.liferay.search.web.constants.MVCCommandNames;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AMFSearchPortletKeys.AMFSEARCH,
                "mvc.command.name=" + MVCCommandNames.GET_ZIPCODE,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class GetZipCodeMVCRenderCommand implements MVCRenderCommand{
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        return "/amfsearch/view.jsp";
    }
}
