package com.liferay.registration.web.portlet.url;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.registration.web.constants.SignUpPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/resources/friendly-url-routes/routes.xml",
                "javax.portlet.name="+ SignUpPortletKeys.SIGNUP
        },
        service = FriendlyURLMapper.class
)

public class SignupFriendlyURLMapper extends DefaultFriendlyURLMapper {

    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "signup";
}
