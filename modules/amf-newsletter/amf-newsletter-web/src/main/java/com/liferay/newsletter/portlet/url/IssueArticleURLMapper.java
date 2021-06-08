package com.liferay.newsletter.portlet.url;

import com.liferay.newsletter.constants.AMFNewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + AMFNewsletterPortletKeys.AMFNEWSLETTER
        },
        service = FriendlyURLMapper.class
)

public class IssueArticleURLMapper extends DefaultFriendlyURLMapper {
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "article-issue";
}
