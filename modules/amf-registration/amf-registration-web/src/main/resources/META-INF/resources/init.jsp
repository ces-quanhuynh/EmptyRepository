<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.registration.web.constants.MVCCommandNames" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.model.Contact" %>
<%@ page import="com.liferay.registration.exception.BasicInfoValidationException" %>
<%@ page import="com.liferay.registration.exception.PhoneValidationException" %>
<%@ page import="com.liferay.registration.exception.BillingAddressValidationException" %>
<%@ page import="com.liferay.registration.exception.SecurityQuestionValidationException" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />