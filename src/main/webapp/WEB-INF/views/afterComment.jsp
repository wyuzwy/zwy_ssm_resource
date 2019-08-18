<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/15
  Time: 15:48
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
<table id="dg7" title="管理评论信息" class="easyui-datagrid" fitColumns="true"
       pagination="true" url="comment/allComment" fit="true" toolbar="#tb" .>
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="commentId" width="50" align="center">评论编号</th>
        <th field="post" width="50" align="center" data-options="formatter:formatPost">帖子标题 </th>
        <th field="commentText" width="100" align="center">评论内容</th>
        <th field="commentUid" width="50" align="center">作者</th>
        <th field="commentTime" width="50" align="center">评论时间</th>
    </tr>
    </thead>
</table>
<div id="tb" align="center">
    <div>
        <a href="javascript:deleteComment()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
    </div>
</div>

<script type="text/javascript">
    var url;

    //解析资源类别
    function formatPost(value,row) {
        return row.post['postTitle'];
    }

    function deleteComment() {
        var selectedRows = $("#dg7").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的评论！");
            return;
        }
        var strIds = [];
        for (var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].commentId);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确认要删掉这<font color=red>" + selectedRows.length + "</font>条评论吗？", function (r) {
            if (r) {
                $.post("comment/deleteComment", {delIds: ids}, function (result) {
                    // var json = $.parseJSON(result);
                    if (result.success == "true") {
                        $.messager.alert("系统提示", "您已成功删除<font color=red>" + result.delNums + "</font>条评论！");
                        $("#dg7").datagrid("reload");
                    } else {
                        $.messager.alert('系统提示', result.msg);
                    }
                }, "json");
            }
        });
    }

</script>


</body>
</html>
