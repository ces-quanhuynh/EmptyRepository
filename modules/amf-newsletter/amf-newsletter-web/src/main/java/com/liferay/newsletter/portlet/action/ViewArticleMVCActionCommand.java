package com.liferay.newsletter.portlet.action;

import com.liferay.newsletter.constants.AMFNewsletterPortletKeys;
import com.liferay.newsletter.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property ={
                "javax.portlet.name=" + AMFNewsletterPortletKeys.AMFNEWSLETTER,
                "mvc.command.name=" + MVCCommandNames.VIEW_ARTICLE,
//                "mvc.command.name=/"
        },
        service = MVCActionCommand.class
)

public class ViewArticleMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

    }
}
