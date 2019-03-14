<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户列表</title>
</head>
<body>
<a href="add" >添加</a>
<br/>
<c:forEach items="${notifierUser }" var="userMap">
    ${userMap.key }
    <!-- 这里使用jstl取值，如果我们把User对象的字段，所对应的getter和setter方法去掉，页面会报错 -->
    -----><a href="${userMap.value.name }">${userMap.value.name }        </a>
    ----->${userMap.value.id }
    ----->${userMap.value.nickname }
    </br>
</c:forEach>
</body>
</html>