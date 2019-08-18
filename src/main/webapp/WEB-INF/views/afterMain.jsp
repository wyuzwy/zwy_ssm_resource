<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/13
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("utf-8");

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>校园资源共享平台</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.6.10/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.6.10/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.6.10/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.6.10/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/default.js" charset="UTF-8"></script>

</head>
<body class="easyui-layout">
<div region="north"
     style="height: 90px;background-image: url(${pageContext.request.contextPath}/static/images/main.jpg);background-repeat: no-repeat;width: 100%;background-color: #bfc6d8 ">

    <div style=" float: right;padding-right: 20px;">
        <div>当前时间：<span style="color: blue" id="time"></span></div>
        <%--<div id="time">当前时间：</div>--%>
        <p>

        </p>
        <div style="padding-top: 30px" align="right">
            <font color="red">${currentUser.userId }</font>
            ,欢迎您！
            <a href="javascript:(0)" style="background-color: white" onclick="exit()"><font
                    color="#0E2D5F">注销</font></a>
        </div>
    </div>

</div>
<div data-options="region: 'center'" >
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" >
            <div align="center" style="padding-top: 100px;"><font color="red" size="10">欢迎使用校园资源共享平台</font></div>
        </div>
    </div>
</div>

<div region="west" style="width: 150px;" title="平台管理中心" split="true">
    <div id="nav" class="easyui-accordion" fit="true" border="false">

    </div>
</div>
<%--<div region="south" style="height: 25px;" align="center">版权所有<a href="#"></a></div>--%>

<script type="text/javascript">
    setInterval("time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 1000);
    function exit() {
        $.messager.confirm("系统提示", "您确认要注销登录吗？", function (r) {
            if (r) {
                location.replace("<%=basePath%>user/exit");
            }
        });
    }

</script>
</body>
</html>
