<%--
  Created by IntelliJ IDEA.
  User: jiahuiw
  Date: 2021/1/18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    EL 表达式 内置对象
    用到了内置的4个对象
    applicationScope    ServletContext
    sessionScope        session域
    requestScope        request域
    pageScope           pageContext域

    pageContext 是EL中的内置对象
    内置对象，获取到JSP中的九大内置对象
    request对象.getContextPath()获取Web应用名称
    getContextPath()
--%>

${pageContext.request.contextPath}

<form action="${pageContext.request.contextPath}/servlet" method="post">
    <input type="submit">
</form>
</body>
</html>
