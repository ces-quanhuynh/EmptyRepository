package com.liferay.newsletter.portlet.action;

import com.liferay.newsletter.constants.AMFNewsletterPortletKeys;
import com.liferay.newsletter.constants.MVCCommandNames;
import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.portlet.util.IssueUtil;
import com.liferay.newsletter.service.IssueLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.List;

@Component(
        immediate = true,
        property ={
                "javax.portlet.name=" + AMFNewsletterPortletKeys.AMFNEWSLETTER,
                "mvc.command.name=" + MVCCommandNames.VIEW_MAIN,
//                "mvc.command.name=/"
        },
        service = MVCActionCommand.class
)
public class ViewMainMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String year = ParamUtil.getString(actionRequest,"yearss");
        String month = ParamUtil.getString(actionRequest,"months");
        String date = year+"-"+month+"-1";
//        actionResponse.setRenderParameter("date",date);
//        actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.VIEW_ISSUE);



        actionResponse.setRenderParameter("date",date);
        actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.VIEW_MAIN);

    }

    @Reference
    IssueLocalService _issueLocalService;
}
