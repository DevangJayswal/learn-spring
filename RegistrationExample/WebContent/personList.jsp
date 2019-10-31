<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>Student</title>
</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
	<div id="menu">
		<div align="left" class="smallbluetext" style="padding:9px;">
			<a href="person.jsp">Person</a> | 
                        <a href="PersonController?action=listPerson">list Person</a>
		</div>
	</div>
    <table border=1>
        <thead>
            <tr>
            	<th>Student Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>city</th>
                <th>Phone</th>
                <th>email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${persons}" var="person">
                <tr>
                	<td><c:out value="${person.id}" /></td>
                    <td><c:out value="${person.firstName}" /></td>
                    <td><c:out value="${person.lastName}" /></td>
                    <td><c:out value="${person.city}" /></td>
                    <td><c:out value="${person.phone}" /></td>
                    <td><c:out value="${person.email}" /></td>
                    <td><a href="PersonController?action=edit&personId=<c:out value="${person.id}"/>">Update</a></td>
                    <td><a href="PersonController?action=delete&personId=<c:out value="${person.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="PersonController?action=insert">Add Student</a></p>
</body>
</html>