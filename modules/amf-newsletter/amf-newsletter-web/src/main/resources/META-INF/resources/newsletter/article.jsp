<%@ include file="../init.jsp" %>

<%
    Map<Issue, ArrayList<IssueArticle>> map = (Map<Issue, ArrayList<IssueArticle>>)renderRequest.getAttribute("article");
    List<Issue> issue = new ArrayList<>(map.keySet());
    ArrayList<IssueArticle> arrayList = map.get(issue.get(0));
    renderRequest.setAttribute("arrayList",arrayList);
%>

<p>
    <b><liferay-ui:message key="amfnewsletter.caption"/></b>
</p>

<h3>#<%=issue.get(0).getIssueNumber() %>,<%=issue.get(0).getIssueDate()%></h3>
<h1><%=issue.get(0).getTitle()%></h1>
<c:forEach items="${arrayList}" var="article">
    <c:out value="${article.author}. "/>
</c:forEach>
<p><%=issue.get(0).getDescription()%></p>

<c:forEach items="${arrayList}" var="article">
    <h3>&emsp;${article.title}</h3>
    <p>&emsp;${article.content}</p>
</c:forEach>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/newsletter/view.jsp"></portlet:param>
</portlet:renderURL>