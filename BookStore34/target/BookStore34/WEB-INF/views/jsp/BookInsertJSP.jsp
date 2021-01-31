<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 29/01/2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookInsert</title>
    <link href="<c:url value="/resources/css/tabnav.css" />" rel="stylesheet">
</head>
<body>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/author/list">Authors</a>
    <a href="${pageContext.request.contextPath}/book/list">Books</a>
</div>
<h2 align="center">Them sach</h2>
<div align="center">
<form:form action="${type}" method="post" modelAttribute="book">
    <table border="0" cellpadding="5" align="center">
        <input value="${book.idbook}" name="idbook" hidden/>
        <tr>
            <td>Name: </td>
            <td><form:input path="namebook" required="required"/></td>
        </tr>
        <tr>
            <td>Type: </td>
            <td>
                <select id="typeselect" name="type">
                    <c:forEach items="${types}" var="type">
                        <c:choose>
                            <c:when test="${type.nameType.equals(book.typebook.nameType)}">
                                <option value="${type.idType}" selected="selected">${type.nameType}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type.idType}">${type.nameType}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Author: </td>
            <td>
                <c:forEach items="${authors}" var="author">
                    <c:choose>
                        <c:when test="${nameAuthorsOfBook.contains(author.nameAuthor)}">
                            <label>${author.nameAuthor}
                                <input name="author" type="checkbox" value="${author.idAuthor}" checked>
                                <span class="checkmark"></span>
                            </label></br>
                        </c:when>
                        <c:otherwise>
                            <label>${author.nameAuthor}
                                <input name="author" type="checkbox" value="${author.idAuthor}">
                                <span class="checkmark"></span>
                            </label></br>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
            <td><a href="${pageContext.request.contextPath}/book/list">Cancel</a></td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
