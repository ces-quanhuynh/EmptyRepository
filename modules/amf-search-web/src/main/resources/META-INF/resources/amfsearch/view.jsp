<%@ include file="../init.jsp" %>

<h1 align="center">ENTER US ZIP</h1>

<portlet:actionURL name="<%= MVCCommandNames.GET_ZIPCODE%>" var="getZipURL" />

<aui:form action="${getZipURL}" name="portlet:namespace/>fm">

	<aui:input type="number" name="zip_code" label="Zip Code" required="true"/>

	<aui:button-row>
		<aui:button type="submit" value="Search"/>
	</aui:button-row>

</aui:form>