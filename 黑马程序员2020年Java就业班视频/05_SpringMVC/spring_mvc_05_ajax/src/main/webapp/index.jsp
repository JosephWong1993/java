<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
    <%--导入js文件--%>
    <script src="js/vue.js"></script>
    <script src="js/axios-0.18.0.js"></script>
</head>
<body>
SpringMVC框架的进行Ajax交互
<fieldset>
    <h4>Ajax 的 Json 数据</h4>
    <div id="app">
        <input type="button" @click="clickMe()" value="发送Ajax的数据">
        <%--使用插值表达式--%>
        {{userList}}
    </div>
</fieldset>
</body>
</html>
<script>
    /*创建vue对象*/
    new Vue({
        el: '#app',
        data: {
            userList: []
        },
        methods: {
            clickMe: function () {
                var params = {id: 1, username: '张三', sex: '男'}
                //发起ajax
                axios.post("${pageContext.request.contextPath}/ajax/testAjax.do", params)
                    .then(response => {
                        //成功
                        console.log(response.data);
                        this.userList = response.data;
                    })
                    .catch(error => {
                        //失败
                        console.dir(error);
                    });
            }
        }
    })
</script>
