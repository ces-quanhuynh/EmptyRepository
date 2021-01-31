<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 31/01/2021
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookSearch</title>
    <link href="<c:url value="/resources/css/tabnav.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/author/list">Authors</a>
    <a href="${pageContext.request.contextPath}/book/list">Books</a>
    <div class="search-container">
        <form:form method="post" action="search">
            <input type="text" name="namebook" placeholder="name book ..." required/>
            <button type="submit">Search</button>
        </form:form>
    </div>
</div>
<h1 align="center">Danh sach sach tim duoc</h1>
<div class="table">
<table align="center" border="1">
    <tr>
        <th>Sach</th>
        <th>The loai</th>
        <th>Tac gia</th>
        <th>Edit</th>
        <th>Del</th>
    </tr>
    <c:forEach items="${listBooksSearch}" var="book">
        <tr>
            <td>${book.namebook}</td>
            <td>${book.typebook.nameType}</td>
            <td>
                <c:forEach items="${book.authors}" var="author">
                    <p>${author.nameAuthor}</p>
                </c:forEach>
            </td>
            <td><a href="${pageContext.request.contextPath}/book/${book.idbook}">Edit</a></td>
            <td>
                <form action="${pageContext.request.contextPath}/book/delete/${book.idbook}" method="post">
                    <button>Del</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
<c:if test="${listBooksSearch.size()==0}"><h3>Khong tim thay</h3></c:if>
</body>
</html>
</body>
</html>
