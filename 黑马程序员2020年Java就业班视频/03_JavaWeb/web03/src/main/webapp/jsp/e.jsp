<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    jsp中的九大内置对象（隐式）
    jsp天生就具备了九大对象
    1：request
    2：response
    3：session
    4：servletContext 在jsp中，定义了变量application
    5：servletConfig 在jsp中，定义了变量config
    6：out 字符输出流，向客户端响应
    7：page=this 当前对象，page就是当前的jsp页面
    8：pageContext 接口对象PageContext 是最小的域对象，当前的jsp页面中有效
    9：exception 异常对象，页面中出现的异常，我来处理
--%>
<%
    request.setAttribute("", "");
    session.setAttribute("", "");
    response.getWriter().write("");
    //pageContext.setAttribute("", "");
%>
</body>
</html>
