<%@ include file="../init.jsp" %>

<c:if test="<%= !themeDisplay.isSignedIn()%>">
	<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
	%>
</c:if>

<liferay-ui:tabs
		names="<%= "All,Registration,Login" %>"
		refresh="<%= false %>"
		value="${selectedTab}"
>
	<liferay-ui:section>
		<%@ include file="/adminmonitor/view_all.jsp" %>
	</liferay-ui:section>

	<liferay-ui:section>
		<%@ include file="/adminmonitor/view_registration.jsp" %>
	</liferay-ui:section>

	<liferay-ui:section>
		<%@ include file="/adminmonitor/view_login.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs>