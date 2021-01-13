<%@ page import="service.AuthorService" %><%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 12/01/2021
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<jsp:include page="MenuJSP.jsp"></jsp:include>
<h1 align="center">Nhap thong tin tac gia</h1>
<form method="post" action=<%request.getAttribute("type");%>>
    <table align="center">
        <tr>
            <td>Nhap ten tac gia:</td>
            <%
                if(request.getAttribute("type").equals("AuthorUpdate")){
            %>
            <td><input type="text" name="nameAuthor" align="center" required value="<%=request.getAttribute("oldNameAuthor")%>" id="name"></td>
            <%
                }else{
            %>
            <td><input type="text" name="nameAuthor" align="center" required></td>
            <%
                }
            %>
        </tr>
        <tr>
            <%
                if(request.getAttribute("type").equals("AuthorUpdate")){
            %>
            <td><input type="submit" name="btnSubmit" value="OK" id="submit" disabled></td>
            <%
            }else{
            %>
            <td><input type="submit" name="btnSubmit" value="OK"></td>
            <%
                }
            %>
            <td><a href="AuthorList">Cancel</a></td>
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
<script type="text/javascript">
    const nameInput = document.getElementById("name");
    const submit = document.getElementById("submit");
    nameInput.onkeydown = function () {
        submit.disabled = false;
    }
</script>
</html>
