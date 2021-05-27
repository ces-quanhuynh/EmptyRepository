<%@ include file="../init.jsp" %>

<%
	String zipCode = (String)renderRequest.getAttribute("zipCode");
%>

<c:if test="<%=Validator.isNull(zipCode)%>">
	<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
	%>
</c:if>

<h1>Search Result for <%=zipCode%></h1>

<c:choose>
	<c:when test="<%=UserUtil.getUserByZipCodeCount(themeDisplay.getCompanyId(),zipCode)==0%>">
		<p align="center">No results found. Please try a different search criteria.</p>
	</c:when>
	<c:otherwise>
		<liferay-ui:search-container total="<%=UserUtil.getUserByZipCodeCount(themeDisplay.getCompanyId(),zipCode)%>" id="usersByZip" delta="5">
			<liferay-ui:search-container-results results="<%=UserUtil.getUsersByZipCode(themeDisplay.getCompanyId(),searchContainer.getStart(),
    searchContainer.getEnd(),zipCode)%>"/>

			<liferay-ui:search-container-row
					className="com.liferay.portal.kernel.model.User" keyProperty="userId" modelVar="entry">

				<liferay-ui:search-container-column-text name="Fisrtname" value="${entry.firstName} ${entry.lastName}" />

				<liferay-ui:search-container-column-text name="ScreenName" value="${entry.screenName}" />

				<liferay-ui:search-container-column-text name="EmailAddress" value="${entry.emailAddress}" />

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />

		</liferay-ui:search-container>
	</c:otherwise>
</c:choose>
