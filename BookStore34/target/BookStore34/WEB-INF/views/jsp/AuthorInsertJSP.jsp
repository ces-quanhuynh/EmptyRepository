<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 29/01/2021
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AuthorInsert</title>
    <link href="<c:url value="/resources/css/tabnav.css" />" rel="stylesheet">
</head>
<body>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/author/list">Authors</a>
    <a href="${pageContext.request.contextPath}/book/list">Books</a>
</div>
<div align="center">
    <h2>Author</h2>
    <form:form action="${type}" method="post" modelAttribute="author">
        <table border="0" cellpadding="5" align="center">
            <input value="${author.idAuthor}" name="idAuthor" hidden/>
            <tr>
                <td>Name: </td>
                <td><form:input path="nameAuthor" required="required" id="name"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" id="submit" disabled></td>
                <td><a href="${pageContext.request.contextPath}/author/list">Cancel</a></td>
            </tr>
        </table>
    </form:form>
</div>
<c:if test="${warn!=null}"><p align="center" style="color: red">${warn}</p></c:if>
</body>
<script type="text/javascript">
    const nameInput = document.getElementById("name");
    const submit = document.getElementById("submit");
    nameInput.onkeydown = function () {
        submit.disabled = false;
    }
</script>
</html>
