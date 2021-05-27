<%@ page import="com.liferay.search.web.portlet.exception.ZipCodeValidationException" %>
<%@ include file="../init.jsp" %>

<liferay-ui:error exception="<%=ZipCodeValidationException.ZipCodeMustBeCorrect.class%>" message="exception.zipcode-must-be-correct"/>
<liferay-ui:error exception="<%=ZipCodeValidationException.ZipCodeMustNotBeNull.class%>" message="exception.zipcode-must-not-be-null"/>

<h1 align="center">ENTER US ZIP</h1>

<portlet:actionURL name="<%= MVCCommandNames.GET_ZIPCODE%>" var="getZipURL" />

<aui:form action="${getZipURL}" name="portlet:namespace/>fm">

	<aui:input type="number" name="zip_code" label="Zip Code" required="true"/>

	<aui:button-row>
		<aui:button type="submit" value="Search"/>
	</aui:button-row>

</aui:form>