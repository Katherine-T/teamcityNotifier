<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.notifierDomain.teamcity.notifierPlugin.*"%>
<%@ page import="java.util.List" %>

<%
    String userids= request.getParameter("userids");
    WeChatNotifier notifi = new WeChatNotifier();
    notifi.setIDs(userids);
    String msg =notifi.getIDs();
%>

<html>
<body>
test
<%=msg %>
</body>
</html>