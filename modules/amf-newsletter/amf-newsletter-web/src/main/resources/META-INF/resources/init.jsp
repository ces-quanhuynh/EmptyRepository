<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.newsletter.model.Issue" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.newsletter.model.IssueArticle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.newsletter.constants.MVCCommandNames" %>
<%@ page import="com.liferay.newsletter.portlet.util.IssueUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />