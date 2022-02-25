<%--
  Created by IntelliJ IDEA.
  User: Islom
  Date: 2/25/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/auth/register" method="post">
    <label for="fullName"></label>
    <input id="fullName" type="text" name="fullName">
    <label for="description"></label>
    <input id="description" type="text" name="description">
    <label for="userName"></label>
    <input id="userName" type="text" name="userName">
    <label for="password"></label>
    <input id="password" type="text" name="password">
    <label for="authors"></label>
    <input id="authors" type="text" name="authors">
    <button type="submit">Send</button>

</form>

</body>
</html>
