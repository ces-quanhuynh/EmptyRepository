<%@ include file="../init.jsp" %>

<%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLLL dd, yyyy", Locale.getDefault());

    Map<Issue, ArrayList<IssueArticle>> issueWithArticleByIssueNumber = (Map<Issue, ArrayList<IssueArticle>>)renderRequest.getAttribute("issueWithArticleByIssueNumber");
    List<Issue> issue = new ArrayList<>(issueWithArticleByIssueNumber.keySet());
    ArrayList<IssueArticle> articles = issueWithArticleByIssueNumber.get(issue.get(0));
    renderRequest.setAttribute("articles",articles);

    String dateFormat = simpleDateFormat.format(issue.get(0).getIssueDate());
    renderRequest.setAttribute("dateFormat",dateFormat);
%>



<h3>#<%=issue.get(0).getIssueNumber() %>,<%=renderRequest.getAttribute("dateFormat")%></h3>

<h1><%=issue.get(0).getTitle()%></h1>
<c:forEach items="${articles}" var="article">
    <c:out value="${article.author}. "/>
</c:forEach>
<p><%=issue.get(0).getDescription()%></p>

<c:forEach items="${articles}" var="article">
    <h3>&emsp;${article.title}</h3>
    <p>&emsp;${article.content}</p>
</c:forEach>