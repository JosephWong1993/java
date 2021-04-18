<%@ page import="com.wong.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    EL 表达式支持运算符
    三元运算符
        (布尔表达式)?结果1:结果2
--%>

${3>2?"欢迎你":"拒绝你"}
<br/>
<%--
    EL 表达式 判空运算
    运算符 empty
    如果被判断的对象是空，结果是true
    容器判断，判断的是长度 ==0 就是空

    基本类型数组，不是判断长度，判断数组容器是否存在
    基本类型数组，判断是空 = null
--%>
<%
    User user = new User();
    pageContext.setAttribute("user", user);

    String[] str = {};
    request.setAttribute("str", str);

    List<String> list = new ArrayList<>();
    request.setAttribute("list", list);

    int[] arr = {};
    request.setAttribute("arr", arr);
%>
user对象是空吗::${empty user} <%--user对象 false--%><br/>
str数组是空吗::${empty str} <%--数组 false--%><br/>
list集合是空吗::${empty list }<br/>
arr数组是是空吗::${empty arr }
</body>
</html>