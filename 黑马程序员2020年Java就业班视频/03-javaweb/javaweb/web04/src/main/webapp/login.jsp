<%--
  Created by IntelliJ IDEA.
  User: jiahuiw
  Date: 2021/1/20
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login">
    <%--
        从Cookie中取出 user=tom
        放在输入框
    --%>
    用户名：<input type="text" name="username" value="${cookie.user.value}"><br>
    密　码：<input type="password" name="password"><br>
    <input type="checkbox" name="rem" value="remUsername">记住用户名<br>
    <input type="submit" value="登录">
</form>
</body>
</html>
