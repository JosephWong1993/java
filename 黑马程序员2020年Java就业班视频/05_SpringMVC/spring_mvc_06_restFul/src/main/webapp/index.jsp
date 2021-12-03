<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h3>SpringMVC框架的RestFul风格的URL介绍</h3>
<fieldset>
    <h4>查询，get</h4>
    <a href="${pageContext.request.contextPath}/user/1">GET测试</a>
</fieldset>

<fieldset>
    <h4>新增，post</h4>
    <form action="${pageContext.request.contextPath}/user/1" method="post">
        <input type="submit" value="POST测试">
    </form>
</fieldset>

<fieldset>
    <h4>更新，put</h4>
    <form action="${pageContext.request.contextPath}/user/1" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="PUT测试">
    </form>
</fieldset>

<fieldset>
    <h4>删除，Delete</h4>
    <form action="${pageContext.request.contextPath}/user/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="DELETE测试">
    </form>
</fieldset>
</body>
</html>