package com.liferay.registration.web.portlet;

import com.liferay.registration.web.constants.AdminMonitorPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.registration.web.portlet.util.AuditEventUtilDynamic;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AdminMonitor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/adminmonitor/view.jsp",
		"javax.portlet.name=" + AdminMonitorPortletKeys.ADMINMONITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html",
			"com.liferay.portlet.scopeable=true",
	},
	service = Portlet.class
)
public class AdminMonitorPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("audit", _auditEventUtilDynamic);
		super.render(renderRequest, renderResponse);
	}

	@Reference
	AuditEventUtilDynamic _auditEventUtilDynamic;
}