<%-- 
    Document   : student
    Created on : 16 нояб. 2023 г., 01:23:41
    Author     : Admin
--%>
<%@page import="java.util.*"%>
<%@page import="com.mycompany.pw3.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
            text-align:center;
            color: white;
            }
            #page{
            width:800px;
            margin:auto;
            }
            form{
            width:400px;
            margin:20px auto;
            color: white;
            }
            input[type=submit]{
            margin:auto;
            }
            .list, .list td, .list th {
            margin:auto;
            border:1px solid whitesmoke;
            border-collapse: collapse;
            color: white;
            }
            body {
                background-image: url(back.jpeg);
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%
            }
        </style>
    </head>

<body>
    <div id="page">
    <h1>Student Form</h1>
    <form>
    <table>
    <tbody>
        <tr>
            <td><label for="name">Name</td>
            <td><input id="name" type="text" name="name"></td>
        </tr>
        <tr>
            <td><label for="surname">Surname</td>
            <td><input id="surname" type="text" name="surname"></td>
        </tr>
        <tr>
            <td><label for="email">Email</td>
            <td><input id="email" type="email" name="email"></td>
        </tr>
    </tbody>
    </table>
    <input type="submit" name="send" value="Send">
    </form>

        <% List<Student> students= (List<Student>)application.getAttribute("students"); %>
        <c:if test="${not empty param.send }">
        <%
        if(students ==null){
            students= new LinkedList<Student>();
            application.setAttribute("students",students);
        }
        if(request.getParameter("name")!=""||request.getParameter("surname")!=""){
            Student student=new Student();
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setEmail(request.getParameter("email"));
            students.add(student);
        }
        response.sendRedirect("student.jsp");
        %>

        </c:if>

        <%
        if(students != null){
            out.println("<table class=\"list\"><tr><th>Name</th><th>Surname</th><th>Email</th></tr>");
            for(Student s:students){
                out.println("<tr><td>"+s.getName()+"</td><td>"+s.getSurname()+"</td><td>"+s.getEmail()+"</td></tr>");
            }
            out.println("</table>");
        }
        %>

    </>
</body>
</html>
