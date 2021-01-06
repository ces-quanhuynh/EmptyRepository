<%@ page import="java.util.List" %>
<%@ page import="entities.Author" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.Book" %><%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 05/01/2021
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>DANH MUC SACH</title>
</head>
<style>
    a{
        background-color: whitesmoke;
        color: black;
        border: 2px gray;
        padding: 5px 10px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }
    a:hover{
        background-color: darkgray;
        color: whitesmoke;
    }
    table{
        border-collapse: collapse;
        width: 1000px;
    }
</style>
<body>
    <h1 align="center">Danh muc sach</h1>
    <table border="1" align="center">
        <tr>
            <th>Ten sach</th>
            <th>Tac gia</th>
            <th>Chinh sua</th>
            <th>Xoa</th>
        </tr>
        <tbody>
            <%
                for(Book book : (List<Book>)request.getAttribute("books")){
            %>
            <tr>
                <td><%=book.getName()%></td>
                <td><%=book.getAuthor()%></td>
                <td align="center">
                    <a href="BookUpdate?bookIdUpdate=<%=book.getId()%>">Edit</a>
                </td>
                <td align="center">
                    <a href="BookDelete?bookIdDelete=<%=book.getId()%>">Del</a>
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
