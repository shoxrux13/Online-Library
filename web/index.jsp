<%--
  Created by IntelliJ IDEA.
  User: Islom
  Date: 2/25/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<form action="/auth" method="post">
    <label for="userName"></label>
    <input id="userName" type="text" name="userName">
    <label for="password"></label>
    <input id="password" type="text" name="password">
    <button type="submit">Send</button>
</form>

</body>
</html>
