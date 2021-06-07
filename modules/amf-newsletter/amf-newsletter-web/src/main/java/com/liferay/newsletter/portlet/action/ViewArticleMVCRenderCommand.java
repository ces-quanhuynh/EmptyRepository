package com.liferay.newsletter.portlet.action;

import com.liferay.newsletter.constants.AMFNewsletterPortletKeys;
import com.liferay.newsletter.constants.MVCCommandNames;
import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.newsletter.portlet.util.IssueUtil;
import com.liferay.newsletter.service.IssueArticleLocalService;
import com.liferay.newsletter.service.IssueLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
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
                "mvc.command.name=" + MVCCommandNames.VIEW_ARTICLE,
        },
        service = MVCRenderCommand.class
)
public class ViewArticleMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            List<Issue> issues = _issueLocalService.getAllIssues(20124);
            List<IssueArticle> issueArticles = _issueArticleLocalService.getAllIssueArticles(20124);
            long num = ParamUtil.getLong(renderRequest,"issueNumber");
            Map<Issue, ArrayList<IssueArticle>> map = IssueUtil.getIssueWithArticleByIssueNumber(issues,issueArticles,num);
            renderRequest.setAttribute("article",map);
        } catch (Exception e){
            throw new PortletException(e);
        }

        return "/newsletter/article.jsp";
    }

    @Reference
    IssueLocalService _issueLocalService;

    @Reference
    IssueArticleLocalService _issueArticleLocalService;
}
