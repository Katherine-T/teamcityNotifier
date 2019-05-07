<%@ include file="/include.jsp" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
    function sendTest() {

        var gs = $('properties[notifierPlugin.notiUsers].value');
        if(!gs || gs.value.length == 0) {
            alert("请输入要通知的用户，以|分隔");
            return;
        }

</script>