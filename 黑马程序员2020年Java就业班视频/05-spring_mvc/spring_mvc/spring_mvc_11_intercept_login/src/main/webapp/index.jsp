<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%--加载js文件--%>
    <script src="./js/vue.js"></script>
    <script src="./js/axios-0.18.0.js"></script>
</head>
<body>
SpringMVC框架的拦截器的登录案例
<fieldset>
    <form action="${pageContext.request.contextPath}/default/login.do" method="post">
        <input type="text" name="username" placeholder="请输入用户名">
        <input type="text" name="password" placeholder="请输入密码">
        <input type="submit" value="提交">
    </form>
</fieldset>
</body>
</html>