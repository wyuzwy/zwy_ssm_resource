<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/15
  Time: 14:46
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
<table id="dg6" title="管理帖子信息" class="easyui-datagrid" fitColumns="true"
       pagination="true" url="post/allPost" fit="true" toolbar="#tb" .>
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="postId" width="50" align="center">帖子编号</th>
        <th field="postTitle" width="50" align="center">帖子标题</th>
        <th field="postText" width="100" align="center">帖子内容</th>
        <th field="postUid" width="50" align="center">作者</th>
        <th field="user" width="50" align="center" data-options="formatter:formatLevel">作者类别</th>
        <th field="postTime" width="50" align="center">发布时间</th>

    </tr>
    </thead>
</table>

<div id="tb" align="center">
    <div>
        <a href="javascript:deletePost()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;帖子标题：&nbsp;<input type="text" name="f_postTitle" id="f_postTitle" size="10"/>
        &nbsp;作者类别：&nbsp;
        <select class="easyui-combobox" id="f_userLevel" name="f_userLevel" editable="false" panelHeight="auto"  size="20">
            <option value="">请选择... </option>
            <option value="学生">学生</option>
            <option value="教师">教师</option>
        </select>
        <a href="javascript:searchPost()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
</div>
</div>



<script type="text/javascript">
    var user_level = "${currentUser.userLevel}";
    var url;


    //解析作者类别
    function formatLevel(val,row) {
        return row.user['userLevel'];
    }


        function deletePost() {
        if (user_level == "超级管理员") {

        } else {
            $.messager.alert("系统提示", "您没有这个权限！");
            return;
        }
        var selectedRows = $("#dg6").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的帖子！");
            return;
        }

        var strIds = [];
        for (var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].postId);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确认要删掉这<font color=red>" + selectedRows.length + "</font>个帖子吗？", function (r) {
            if (r) {
                $.post("post/deletePost", {delIds: ids}, function (result) {
                    // var json = $.parseJSON(result);
                    if (result.success == "true") {
                        $.messager.alert("系统提示", "您已成功删除<font color=red>" + result.delNums + "</font>个帖子！");
                        $("#dg6").datagrid("reload");
                    } else {
                        $.messager.alert('系统提示', result.msg);
                    }
                }, "json");
            }
        });
    }

    function searchPost() {
        $('#dg6').datagrid('load', {
            postTitle: $('#f_postTitle').val(),
            userLevel: $('#f_userLevel').combobox("getValue"),
        });
    }

</script>


</body>
</html>
