package com.liferay.search.web.portlet;

import com.liferay.search.web.constants.AMFSearchPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AMFSearch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/amfsearch/view.jsp",
		"javax.portlet.name=" + AMFSearchPortletKeys.AMFSEARCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AMFSearchPortlet extends MVCPortlet {
}