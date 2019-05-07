<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.notifierDomain.teamcity.notifierPlugin.*"%>
<%@ page import="java.util.List" %>

<%
    List<WeChatUser> lists =  WeChatAPI.getUserList();
%>

<html>
<body>
<table>
    <thead>
    <tr>
        <td>
            <input type="checkbox" onclick="checkAll()" />
        </td>
        <td>
            用户ID
        </td>
        <td>
            用户名
        </td>
    </tr>
    </thead>
    <tbody>
    <%
        List<WeChatUser> lists1 =  WeChatAPI.getUserList();
        for(int i=0;i<lists1.size();i++){
    %>
    <tr>
        <td>
            <input type="checkbox" name="check" value="<%=lists1.get(i).getId() %>" />
        </td>
        <td>
            <%=lists1.get(i).getId() %>
        </td>
        <td>
            <%=lists1.get(i).getName() %>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
<form method="post" id="myForm" action="dowork.html">
    <input type="hidden" id="userids" name="userids" value="">
    <input type="button" onclick="selCheck()" value="确定">
</form>
<br>
（此功能还在开发中，暂时可以看下可通知的全部用户。
敬请期待~~
</body>
<script>
    function checkAll() {
        var check=document.getElementsByName("check");
        for(var i=0;i<check.length;i++){
            check[i].checked=true;
        }
    }
    function selCheck(){
        var check=document.getElementsByName("check");
        var valstr="";
        for(var i=0;i<check.length;i++){
            if(check[i].checked){
                valstr=valstr+check[i].value+",";
            }
        }
        document.getElementById("userids").value=valstr.substr(0,valstr.length-1);
        document.getElementById("myForm").submit();

    }
</script>
</html>