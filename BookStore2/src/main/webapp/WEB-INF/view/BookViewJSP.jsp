<%@ page import="entity.BookEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 12/01/2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Book</title>
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
<h1 align="center">Danh sach sach</h1>
<table border="1" align="center">
    <tr>
        <th>Ten sach</th>
        <th>Ten tac gia</th>
        <th>The loai</th>
        <th>Chinh sua</th>
        <th>Xoa</th>
    </tr>
    <tbody>
    <%
        for(BookEntity bookEntity: (List<BookEntity>)request.getAttribute("listBook")){
    %>
    <tr>
        <td><%=bookEntity.getNameBook()%></td>
        <td><%=bookEntity.getAuthorBook().getNameAuthor()%></td>
        <td><%=bookEntity.getTypeBook().getNameType()%></td>
        <td align="center">
            <a href="BookUpdate?bookIdUpdate=<%=bookEntity.getIdBook()%>">Edit</a>
        </td>
        <td align="center">
            <form action="BookDelete?bookIdDelete=<%=bookEntity.getIdBook()%>" method="post">
                <button name="btn_del">Del</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<p align="center"><a href="BookInsert">+ Them sach</a></p>
</body>
</html>
