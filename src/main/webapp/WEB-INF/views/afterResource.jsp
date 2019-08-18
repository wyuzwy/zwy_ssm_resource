<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/14
  Time: 16:12
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
<table id="dg4" title="管理资源信息" class="easyui-datagrid" fitColumns="true"
       pagination="true" url="resource/allResource" fit="true" toolbar="#tb" .>
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="resourceId" width="50" align="center">资源编号</th>
        <th field="resourceName" width="50" align="center">资源名称</th>
        <th field="resourceCid" width="50" align="center" hidden="true">资源类别号</th>
        <th field="categoryKey" width="50" align="center" data-options="formatter:formatCategory">资源类别</th>
        <th field="resourceLevel" width="50" align="center">资源等级</th>
        <th field="resourceUid" width="50" align="center">作者</th>
        <th field="user" width="50" align="center" data-options="formatter:formatLevel">作者类别</th>
        <th field="resourceTime" width="50" align="center">上传时间</th>
        <th field="resourceGood" width="50" align="center" data-options="formatter:formatGood">是否优秀</th>
    </tr>
    </thead>
</table>
<div id="tb" align="center">
    <div>
        <a href="javascript:setGood()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">设为优秀</a>
        <a href="javascript:deleteResource()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;资源名称：&nbsp;<input type="text" name="f_resourceName" id="f_resourceName" size="10"/>
        &nbsp;资源类别：&nbsp;<input class="easyui-combobox" name="f_resourceCid" id="f_resourceCid" size="20"
                                data-options="panelHeight:'auto',editable:false,valueField:'categoryId',textField:'categoryName',url:'category/allCategoryList'"/>
        &nbsp;作者类别：&nbsp;
        <select class="easyui-combobox" id="f_userLevel" name="f_userLevel" editable="false" panelHeight="auto"  size="20">
            <option value="">请选择... </option>
            <option value="学生">学生</option>
            <option value="教师">教师</option>
        </select>
        <a href="javascript:searchResource()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
</div>

<script type="text/javascript">
    var user_level = "${currentUser.userLevel}";
    var url;


    //解析资源类别
    function formatCategory(value,row) {
        return row.categoryKey['categoryName'];
    }

//解析作者类别
    function formatLevel(val,row) {
        return row.user['userLevel'];
    }

    //标优转为是否
    function formatGood(val, row) {
        if (val == 1) {
            return '是';
        } else {
            return '否';
        }
    }

    function deleteResource() {
        if (user_level == "超级管理员") {

        } else {
            $.messager.alert("系统提示", "您没有这个权限！");
            return;
        }
        var selectedRows = $("#dg4").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的资源！");
            return;
        }

        var strIds = [];
        for (var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].resourceId);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确认要删掉这<font color=red>" + selectedRows.length + "</font>个资源吗？", function (r) {
            if (r) {
                $.post("resource/deleteResource", {delIds: ids}, function (result) {
                    // var json = $.parseJSON(result);
                    if (result.success == "true") {
                        $.messager.alert("系统提示", "您已成功删除<font color=red>" + result.delNums + "</font>个资源！");
                        $("#dg4").datagrid("reload");
                    } else {
                        $.messager.alert('系统提示', result.msg);
                    }
                }, "json");
            }
        });
    }

    function setGood() {
        var selectedRows = $("#dg4").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要标优的资源！");
            return;
        }

        var strIds = [];
        for (var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].resourceId);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确认要标优这<font color=red>" + selectedRows.length + "</font>个资源吗？", function (r) {
            if (r) {
                $.post("resource/setGood", {delIds: ids}, function (result) {
                    // var json = $.parseJSON(result);
                    if (result.success == "true") {
                        $.messager.alert("系统提示", "您已成功标优<font color=red>" + result.delNums + "</font>个资源！");
                        $("#dg4").datagrid("reload");
                    } else {
                        $.messager.alert('系统提示', result.msg);
                    }
                }, "json");
            }
        });
    }

    function searchResource() {
        var name = $('#f_resourceName').val();
        var level=$('#f_userLevel').combobox("getValue");
        var cId = $('#f_resourceCid').combobox("getValue");
        if(cId =="-1"){
            cId=null;
        }
        if(name==""){
            name=null;
        }
        if(level==""){
            level=null;
        }
        $('#dg4').datagrid('load', {
            resourceName: name,
            userLevel: level,
            resourceCid: cId
        });
    }

</script>

</body>
</html>
