<%@ page import="entity.TypeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.AuthorEntity" %>
<%@ page import="entity.BookEntity" %><%--
  Created by IntelliJ IDEA.
  User: ces-user
  Date: 12/01/2021
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Insert</title>
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
<h1 align="center">Nhap thong tin sach</h1>
<form method="post" action=<%request.getAttribute("type");%>>
    <table align="center">
        <tr>
            <td>Nhap ten sach:</td>
            <%
                if(request.getAttribute("type").equals("BookUpdate")){
            %>
            <td><input type="text" name="nameBook" align="center" required id="name"
                       value="<%=((BookEntity)request.getAttribute("oldBook")).getNameBook()%>"></td>
            <%
            }else{
            %>
            <td><input type="text" name="nameBook" align="center" required= ></td>
            <%
                }
            %>
        </tr>
        <tr>
            <td>Nhap ten tac gia:</td>
            <%
                if(request.getAttribute("type").equals("BookUpdate")){
            %>
            <td>
                <select name="nameAuthor" id="nameAuthor">
                    <%
                        for(AuthorEntity authorEntity: (List<AuthorEntity>)request.getAttribute("listAuthor")){
                            if(((BookEntity)request.getAttribute("oldBook")).getAuthorBook().getNameAuthor()
                                    .equals(authorEntity.getNameAuthor())){
                    %>
                    <option value="<%=authorEntity.getIdAuthor()%>" selected="selected"><%=authorEntity.getNameAuthor()%></option>
                    <%
                    }else
                        {
                    %>
                    <option value="<%=authorEntity.getIdAuthor()%>"><%=authorEntity.getNameAuthor()%></option>
                    <%
                        } }
                    %>
                </select>
            </td>
            <%
            }else{
            %>
            <td>
                <select name="nameAuthor">
                    <%
                        for(AuthorEntity authorEntity: (List<AuthorEntity>)request.getAttribute("listAuthor")){
                    %>
                    <option value="<%=authorEntity.getIdAuthor()%>"><%=authorEntity.getNameAuthor()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
            <%
                }
            %>
        </tr>
        <tr>
            <td>Nhap the loai:</td>
            <%
                if(request.getAttribute("type").equals("BookUpdate")){
            %>
            <td>
                <select name="nameType" id="nameType">
                    <%
                        for(TypeEntity typeEntity: (List<TypeEntity>)request.getAttribute("listType")){
                            if(((BookEntity)request.getAttribute("oldBook")).getTypeBook().getNameType()
                                    .equals(typeEntity.getNameType())){
                    %>
                    <option value="<%=typeEntity.getIdType()%>" selected="selected"><%=typeEntity.getNameType()%></option>
                    <%
                    }else
                    {
                    %>
                    <option value="<%=typeEntity.getIdType()%>"><%=typeEntity.getNameType()%></option>
                    <%
                            } }
                    %>
                </select>
            </td>
            <%
            }else{
            %>
            <td>
                <select name="nameType">
                    <%
                        for(TypeEntity typeEntity: (List<TypeEntity>)request.getAttribute("listType")){
                    %>
                    <option value="<%=typeEntity.getIdType()%>"><%=typeEntity.getNameType()%></option>
                    <%
                        }
                    %>
                </select>
            </td>
            <%
                }
            %>
        </tr>
        <tr>
            <%
                if(request.getAttribute("type").equals("BookUpdate")){
            %>
            <td><input type="submit" name="btnSubmit" value="OK" id="submit" disabled></td>
            <%
            }else{
            %>
            <td><input type="submit" name="btnSubmit" value="OK"></td>
            <%
                }
            %>
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
<script type="text/javascript">
    const nameInput = document.getElementById("name");
    const submitInput = document.getElementById("submit");
    const nameAuthor = document.getElementById("nameAuthor");
    const nameType = document.getElementById("nameType");
     nameInput.onkeydown = nameAuthor.onchange = nameType.onchange = function (){
         submitInput.disabled = false;
     }


</script>
</html>
