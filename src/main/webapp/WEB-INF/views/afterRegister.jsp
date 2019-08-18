<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/14
  Time: 14:08
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
    <script type="text/javascript" src="<%request.getContextPath();%>/static/js/jquery-1.12.4.min.js"></script>
    <link href="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/md5.js"></script>
</head>
<body>
<table id="dg3" title="管理注册帐号信息" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true" url="register/allRegister" fit="true" toolbar="#tb" .>
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="registerId" width="50" align="center">帐号</th>
        <th field="registerPassword" width="50" align="center">密码</th>
        <th field="registerName" width="50" align="center">姓名</th>
        <th field="registerClass" width="50" align="center">班级</th>
        <th field="registerLevel" width="50" align="center">权限</th>
    </tr>
    </thead>
</table>

<div id="tb" align="center">
    <div>
        <a href="javascript:checkUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">审核通过</a>
    </div>
</div>



<script type="text/javascript">
    var url;

    // function openAddRegisterDialog() {
    //     $("#dlg").dialog("open").dialog("setTitle", "批量导入帐号");
    //     url = "register?flagText=addRegister";
    // }

    function checkUser() {
        var selectedRows = $("#dg3").datagrid('getSelections');
        if (selectedRows.length == 0 ) {
            $.messager.alert("系统提示", "请选择要审核通过的数据！");
            return;
        }
        var strIds = [];
        for (var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].registerId);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确认要通过这<font color=red>" + selectedRows.length + "</font>条数据吗？", function (r) {
            if (r) {
                $.post("register/checkOk", {delIds: ids}, function (result) {
                    if (result.success == "true") {
                        $.messager.alert("系统提示", "您已成功审核<font color=red>" + result.delNums + "</font>条数据！");
                        $("#dg3").datagrid("reload");
                    } else {
                        $.messager.alert('系统提示', result.msg);
                    }
                }, "json");
            }
        });
    }

    // function save() {
    //     $("#fm").form("submit", {
    //         url: url,
    //         onSubmit: function () {
    //             return $(this).form("validate");
    //         },
    //         success: function (result) {
    //             var json = $.parseJSON(result);
    //             console.info(json)
    //             if (json.success == "false") {
    //                 $.messager.alert("系统提示", json.msg);
    //                 return;
    //             } else {
    //                 $.messager.alert("系统提示", json.msg);
    //                 $("#dlg").dialog("close");
    //                 $("#dg").datagrid("reload");
    //             }
    //         }
    //     });
    // }

</script>

</body>
</html>
