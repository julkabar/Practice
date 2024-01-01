<%-- 
    Document   : scores
    Created on : 31 дек. 2023 г., 00:51:58
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.pw35.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.mycompany.pw35.Content"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scores</title>
                <style>
            h1{
            text-align:center;
            color: white;
            }
            #page{
            width:800px;
            margin:auto;
            }
            .list, .list td, .list th {
            margin:auto;
            border:1px solid whitesmoke;
            border-collapse: collapse;
            color: white;
            }
            .list td, .list th {
                padding:10px;
            }
            body {
                background-image: url(back.jpeg);
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%
            }
            #content{
                width: 800px;
                text-align:center;
            }
        </style>
    </head>
    <body>
  <div id="page">
        <h1><%= (new java.util.Date()).toLocaleString()%></h1>
        <h1>Scores of <c:out value="${user.getId()}"/><c:out value="${user.getName()}"/><c:out value="${user.getSurname()}"/></h1>
    <div id="content">
        <c:if test="${scores.size() > 0}">
            <table class="list">
                <tr>
                    <th>Discipline</th>
                    <th>Score</th>
                    <th>ECTS</th>
                </tr>
                <c:forEach var="disc" items="${scores}">
                    <tr>
                        <td><c:out value="${disc.getTitle()}"/></td>
                        <td><c:out value="${disc.getScore_num()}"/></td>
                        <td><c:out value="${disc.getScore_l()}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
  </div>
    </body>
</html>
