<%--
  Created by IntelliJ IDEA.
  User: jiahuiw
  Date: 2021/3/11
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h3>请求参数绑定</h3>
<fieldset>
    <h4>功能1：默认支持ServletAPI</h4>
    <a href="${pageContext.request.contextPath}/params/gotoParams?id=123&name=LiSi">测试</a>
</fieldset>
</body>
</html>
