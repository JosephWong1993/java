<%--
  Created by IntelliJ IDEA.
  User: jiahuiw
  Date: 2021/3/4
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet" method="post">
    <input type="text" name="user">
    <input type="submit">
</form>
</body>
</html>
