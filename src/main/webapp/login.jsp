<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-30
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/loginAdmin" method="post">
        <input  type="text" placeholder="请输入用户名" id="userName" name="userName"></br>
        <input  type="password" placeholder="请输入密码" id="psw" name="password"></br>
        <span class="warning">${error}</span>
        <input class="btn-submit" type="submit" value="登录">
    </form>
</div>
</body>
</html>
