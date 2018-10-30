<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-10-30
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<shiro:hasRole name="admin">
    这是admin角色登录：<shiro:principal></shiro:principal>
</shiro:hasRole>
<shiro:hasPermission name="user:create">
    有user:create权限信息
</shiro:hasPermission>
<br>
登录成功
</body>

</body>
</html>
