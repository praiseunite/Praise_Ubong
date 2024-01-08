<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>GreenBay Stores Inc</title>
</head>
<body>
<div align="center">
    <h1>Admin Registration Form</h1>
    <form action="<%= request.getContextPath() %>/AdminServlet" method="post">
        <table style="with: 80%">
            <tr>
                <td>User-Name</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="fname" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="password" name="address" /></td>
            </tr>
            <tr>
                <td>Contact</td>
                <td><input type="text" name="contact" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>