<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 28/01/2021
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
    <link href="<c:url value="/resources/css/tabnav.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/author/list">Authors</a>
    <a href="${pageContext.request.contextPath}/book/list">Books</a>
</div>
<body>
<h1 align="center">Danh sach tac gia</h1>
<div class="table">
<table align="center" border="1">
    <tr>
        <th>Tac gia</th>
        <th>Edit</th>
        <th>Del</th>
    </tr>
    <c:forEach items="${listAuthors}" var="author">
        <tr>
            <td>${author.nameAuthor}</td>
            <td><a href="${pageContext.request.contextPath}/author/${author.idAuthor}">Edit</a></td>
            <td>
                <form action="${pageContext.request.contextPath}/author/delete/${author.idAuthor}" method="post">
                    <button>Del</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
<p align="center"><a href="${pageContext.request.contextPath}/author/new">New Author</a></p>
</body>
</html>
