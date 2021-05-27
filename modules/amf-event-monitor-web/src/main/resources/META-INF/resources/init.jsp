<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>

<%@ page import="com.liferay.registration.web.portlet.util.AuditEventUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.registration.web.constants.MVCCommandNames" %>
<%@ page import="com.liferay.portal.security.audit.storage.model.AuditEvent" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>

<%@ page import="com.liferay.registration.web.permission.resource.AdminMonitorPermission" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />