<%@ include file="../init.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.newsletter.constants.MVCCommandNames" %>
<%
    List<String> years = (List<String>)renderRequest.getAttribute("years");
    Map<String,String> months = new HashMap<String,String>();
    List<String> monthNames = new ArrayList<String>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV","DEC"
    ));
    for(int i = 0; i <monthNames.size();i++){
        months.put(monthNames.get(i),String.valueOf(i+1));
    }
    renderRequest.setAttribute("months",months);


    Map<Issue, ArrayList<IssueArticle>> map = (Map<Issue, ArrayList<IssueArticle>>)renderRequest.getAttribute("article");

    if(map!=null){
        List<Issue> issues = new ArrayList<>(map.keySet());
        renderRequest.setAttribute("issues", issues);
    }
%>

<liferay-ui:tabs names="${years}" refresh="false" tabsValues="${years}">
    <c:forEach items="${years}" var="year">
        <liferay-ui:section>
            haha ${year}
            <portlet:actionURL name="<%= MVCCommandNames.VIEW_MAIN%>" var="viewMain" />
            <aui:form action="${viewMain}" name="<portlet:namespace/>fm">
                <aui:input name="yearss" type="hidden" value="${year}"/>
                <aui:select name="months" label="Month" required="true">
                <c:forEach var="month" items="<%=monthNames%>">
                    <aui:option label="${month}" value="${months.get(month)}"/>
                </c:forEach>
            </aui:select>

                <aui:button-row>
                    <aui:button type="submit" value="Search"/>
                </aui:button-row>

            </aui:form>
        </liferay-ui:section>
    </c:forEach>
</liferay-ui:tabs>

<c:choose>
    <c:when test="<%=map!=null%>">
        <c:choose>
            <c:when test="<%=map.size()>0%>">
                <c:forEach items="${issues}" var="issue">
                    <h3>#${issue.issueNumber},${issue.issueDate}</h3>
                    <h1>${issue.title}</h1>
                    <c:forEach items="<%=map.get((Issue) pageContext.getAttribute("issue"))%>" var="article">
                        <p>${article.title}</p>
                    </c:forEach>

                    <aui:button-row cssClass="issue-button">

                        <portlet:renderURL var="viewIssue">
                            <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ARTICLE%>" />
                            <portlet:param name="issueNumber"
                                           value="${issue.issueNumber}" />
                        </portlet:renderURL>

                        <aui:button onClick="${viewIssue}" value="View" ></aui:button>

                    </aui:button-row>

                </c:forEach>
            </c:when>
            <c:otherwise>
                <h3>No issue available</h3>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>

