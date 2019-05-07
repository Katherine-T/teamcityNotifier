<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.notifierDomain.teamcity.notifierPlugin.*"%>
<%@ page import="java.util.List" %>

<%
    String userids= request.getParameter("userids");
%>

<html>
<body>
<%=userids %>
</body>
</html>