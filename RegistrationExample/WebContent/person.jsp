<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <title>Student</title>
    </head>
    <body>
        <div id="menu">
            <div align="left" class="smallbluetext" style="padding:9px;">
                <a href="person.jsp">Person</a> | 
                   <a href="PersonController?action=listPerson">list Person</a>
            </div>
        </div>
        <form method="post" action="PersonController" name="frmAdd">
            <table align="left">
                <tr>
                    <td>Person Id :</td>
                    <td><input type="text" name="personId" value="<c:out value="${person.id}"/>" required/></td>
                </tr>
                <tr>
                    <td>First name :</td>
                    <td><input type="text" name="firstName" value="<c:out value="${person.firstName}" />" /></td>
                </tr>
                <tr>
                    <td>Last name :</td>
                    <td><input type="text" name="lastName" value="<c:out value="${person.lastName}" />" /> </td>
                </tr>
                <tr>
                    <td>City :</td>
                    <td><input type="text" name="city" value="<c:out value="${person.city}" />" /></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><input type="text" name="phone" value="<c:out value="${person.phone}" />" /> </td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><input type="text" name="email" value="<c:out value="${person.email}" />" /> </td>
                </tr>
                <tr>
                    <td><input  type="submit" value="Submit"></td>
                </tr> 
            </table>
        </form>
    </body>
</html>