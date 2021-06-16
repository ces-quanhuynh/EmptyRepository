<%@ include file="../init.jsp" %>

<%
    List<Issue> issueSearch = (List<Issue>) renderRequest.getAttribute("issueSearch");
%>

<portlet:renderURL var="viewSearch">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_SEARCH%>"></portlet:param>
</portlet:renderURL>
<aui:form action="${viewSearch}" name="<portlet:namespace/>fm">

    <aui:input name="keywords" placeholder="Search Issues"/>

    <aui:button-row>
        <aui:button type="submit" value="Search"/>
    </aui:button-row>

</aui:form>


<c:choose>
    <c:when test="<%=issueSearch!=null%>">
        <h3>Search results for: <%=renderRequest.getAttribute("keywords")%></h3>
        <liferay-ui:search-container total="<%=issueSearch.size()%>" emptyResultsMessage="No results found. Please try searching with other keywords." delta="5">
            <liferay-ui:search-container-results results="<%=IssueUtil.getIssueSearchPagination(issueSearch,searchContainer.getStart(),searchContainer.getEnd())%>"/>

            <liferay-ui:search-container-row
                    className="com.liferay.newsletter.model.Issue" keyProperty="issueNumber" modelVar="entry">

                <portlet:renderURL var="viewIssue">
                    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ISSUE%>" />
                    <portlet:param name="issueNumber" value="${entry.issueNumber}" />
                    <portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()%>"/>
                </portlet:renderURL>

                <liferay-ui:search-container-column-text name="Title" value="${entry.title}" href="${viewIssue}"/>
                <liferay-ui:search-container-column-text name="Date" value="${entry.issueDate}"/>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator searchContainer="<%= searchContainer%>"/>

        </liferay-ui:search-container>
    </c:when>
</c:choose>