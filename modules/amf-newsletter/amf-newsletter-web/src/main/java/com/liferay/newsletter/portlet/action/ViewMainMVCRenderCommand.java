package com.liferay.newsletter.portlet.action;

import com.liferay.newsletter.constants.AMFNewsletterPortletKeys;
import com.liferay.newsletter.constants.MVCCommandNames;
import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.newsletter.portlet.util.IssueUtil;
import com.liferay.newsletter.service.IssueArticleLocalService;
import com.liferay.newsletter.service.IssueLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property ={
                "javax.portlet.name=" + AMFNewsletterPortletKeys.AMFNEWSLETTER,
                "mvc.command.name=" + MVCCommandNames.VIEW_MAIN,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ViewMainMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getLayout().getGroupId();

            List<Issue> issues = _issueLocalService.getAllIssues(groupId);
            List<IssueArticle> issueArticles = _issueArticleLocalService.getAllIssueArticles(groupId);
            List<String> years = IssueUtil.yearsOfIssue(issues);
            renderRequest.setAttribute("years",years);

            String year = ParamUtil.getString(renderRequest,"yearss");
            String month = ParamUtil.getString(renderRequest,"months");
            String date = year+"-"+month+"-1";

            if(year.equals("")){
                return "/newsletter/view.jsp";
            }

            if(date != null){

                Map<Issue, ArrayList<IssueArticle>> issueWithArticle = IssueUtil.getAllIssueWithArticleByDate(issues,issueArticles,date);

                renderRequest.setAttribute("issueWithArticle",issueWithArticle);
            } else {
                renderRequest.setAttribute("issueWithArticle",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/newsletter/view.jsp";
    }

    @Reference
    IssueLocalService _issueLocalService;

    @Reference
    IssueArticleLocalService _issueArticleLocalService;
}
