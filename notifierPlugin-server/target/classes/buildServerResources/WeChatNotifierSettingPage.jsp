<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.notifierDomain.teamcity.notifierPlugin.*"%>
<%@ page import="java.util.List" %>

<%
    List<WeChatUser> lists =  WeChatAPI.getUserList();



%>

<html>

<body>


<select name="select" style="width:160px" >
    <option value="0" selected>请选择：</option>
    <%
        List<WeChatUser> lists1 =  WeChatAPI.getUserList();
        for(int i=0;i<lists1.size();i++){
    %>
    <option value="<%=i+1 %>"><%=lists1.get(i).getName() %></option>
    <%} %>
</select>

<script type="text/javascript">
    var selectedItem = select.options(select.selectedIndex);//获取当前选中项
    var text=selectedItem.text; //选中项的文本
    var value=selectedItem.value; //选中项的值
</script>

<input type="submit" value="添加">

<br>


（此功能还在开发中，暂时可以看下可通知的全部用户。
敬请期待~~
</body>

</html>