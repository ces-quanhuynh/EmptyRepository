<%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 06/01/2021
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD BOOK</title>
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
    p{
        color: red;
    }
</style>
<body>
    <h1 align="center">Nhap thong tin sach</h1>
    <form method="post" action=<%request.getAttribute("type");%>>
        <table align="center">
            <tr>
                <td>Nhap ten sach:</td>
                <td><input type="text" name="nameBook" align="center" required></td>
            </tr>
            <tr>
                <td>Nhap ten tac gia:</td>
                <td><input type="text" name="nameAuthor" align="center" ></td>
            </tr>
            <tr>
                <td><input type="submit" name="btnSubmit" value="OK"></td>
                <td><a href="BookList">Cancel</a></td>
            </tr>
        </table>
    </form>
    <%
        if(request.getAttribute("warn")!=null){
    %>
        <p align="center"><%=request.getAttribute("warn")%></p>
    <%
        }
    %>
</body>
</html>
