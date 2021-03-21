<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h3>SpringMVC框架的文件上传</h3>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile">
    <input type="text" name="username">
    <input type="submit" name="上传">
</form>
</body>
</html>
