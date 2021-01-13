<%@ page import="entity.AuthorEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 11/01/2021
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Author</title>
</head>
<style>
    a,button{
        background-color: whitesmoke;
        color: black;
        border: 2px gray;
        padding: 5px 10px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }
    a:hover,button:hover{
        background-color: darkgray;
        color: whitesmoke;
    }
    table{
        border-collapse: collapse;
        width: 1000px;
    }
</style>
<body>
<jsp:include page="MenuJSP.jsp"></jsp:include>
<h1 align="center">Danh sach tac gia</h1>
<table border="1" align="center">
    <tr>
        <th>Ten tac gia</th>
        <th>Chinh sua</th>
        <th>Xoa</th>
    </tr>
    <tbody>
    <%
        for(AuthorEntity authorEntity: (List<AuthorEntity>)request.getAttribute("listAuthor")){
    %>
    <tr>
        <td><%=authorEntity.getNameAuthor()%></td>
        <td align="center">
            <a href="AuthorUpdate?authorIdUpdate=<%=authorEntity.getIdAuthor()%>">Edit</a>
        </td>
        <td align="center">
            <form action="AuthorDelete?authorIdDelete=<%=authorEntity.getIdAuthor()%>" method="post">
                <button name="btn_del">Del</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<p align="center"><a href="AuthorInsert">+ Them tac gia</a></p>
</body>
</html>
