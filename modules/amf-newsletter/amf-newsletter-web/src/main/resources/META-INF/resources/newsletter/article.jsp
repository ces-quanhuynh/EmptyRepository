<%@ include file="../init.jsp" %>

<%
    Map<Issue, ArrayList<IssueArticle>> issueWithArticleByIssueNumber = (Map<Issue, ArrayList<IssueArticle>>)renderRequest.getAttribute("issueWithArticleByIssueNumber");
    List<Issue> issue = new ArrayList<>(issueWithArticleByIssueNumber.keySet());
    ArrayList<IssueArticle> articles = issueWithArticleByIssueNumber.get(issue.get(0));
    renderRequest.setAttribute("articles",articles);
%>

<h3>#<%=issue.get(0).getIssueNumber() %>,<%=issue.get(0).getIssueDate()%></h3>

<h1><%=issue.get(0).getTitle()%></h1>
<c:forEach items="${articles}" var="article">
    <c:out value="${article.author}. "/>
</c:forEach>
<p><%=issue.get(0).getDescription()%></p>

<c:forEach items="${articles}" var="article">
    <h3>&emsp;${article.title}</h3>
    <p>&emsp;${article.content}</p>
</c:forEach>