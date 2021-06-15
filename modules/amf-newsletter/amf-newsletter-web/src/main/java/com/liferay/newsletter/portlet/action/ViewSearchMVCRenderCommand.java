package com.liferay.newsletter.portlet.action;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.newsletter.constants.AMFNewsletterPortletKeys;
import com.liferay.newsletter.constants.MVCCommandNames;
import com.liferay.newsletter.model.Issue;
import com.liferay.newsletter.model.IssueArticle;
import com.liferay.newsletter.service.IssueArticleLocalService;
import com.liferay.newsletter.service.IssueLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AMFNewsletterPortletKeys.AMFNEWSLETTER,
                "mvc.command.name=" + MVCCommandNames.VIEW_SEARCH
        },
        service = MVCRenderCommand.class
)

public class ViewSearchMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();

        String keywords = ParamUtil.getString(renderRequest, "keywords");

        if(keywords.equals("")){
            return "/newsletter/search.jsp";
        }

        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
        SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);

        searchContext.setKeywords(keywords);

        Indexer<JournalArticle> indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);

        Hits hits = null;
        try {
            hits = indexer.search(searchContext);
        } catch (SearchException e) {
            e.printStackTrace();
        }

        List<JournalArticle> journalArticles = new ArrayList<>();

        for(int i = 0; i<hits.getDocs().length; i++){
            Document doc = hits.doc(i);

            long journalArticleId = GetterUtil.getLong(doc.get("articleId"));

            JournalArticle journalArticle = null;

            try{
                journalArticle = JournalArticleLocalServiceUtil.getArticle(groupId,String.valueOf(journalArticleId));
            } catch(Exception e){
                e.printStackTrace();
            }

            journalArticles.add(journalArticle);
        }

        List<Issue> issueSearch = null;
        try {
            issueSearch = _issueLocalService.getIssuesBySearch(groupId,journalArticles);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (PortalException portalException) {
            portalException.printStackTrace();
        }

        renderRequest.setAttribute("issueSearch",issueSearch);
        renderRequest.setAttribute("keywords",keywords);

        return "/newsletter/view.jsp";
    }

    @Reference
    IssueLocalService _issueLocalService;

    @Reference
    IssueArticleLocalService _issueArticleLocalService;
}
