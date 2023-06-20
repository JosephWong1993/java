<%--
  Created by IntelliJ IDEA.
  User: jiahuiw
  Date: 2020/12/14
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    HTML中嵌入Java代码
    将一个语言，嵌入到另一个语言
    java嵌入到HTML（Java换名，脚本语言）
--%>

<%
    int a = 1;
//    a++;
    if (a > 1) {
%>
<div style="color:red">div区域一</div>
<%
} else {
%>
<div style="color:blue">div区域二</div>
<%
    }
%>
</body>
</html>
