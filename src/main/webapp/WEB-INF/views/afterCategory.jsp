<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/14
  Time: 20:10
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
<table id="dg5" title="管理资源类别" class="easyui-datagrid" fitColumns="true"
       pagination="true" url="category/allAfterCategory" fit="true" toolbar="#tb" .>
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="categoryId" width="50" align="center">编号</th>
        <th field="categoryName" width="100" align="center">类别名称</th>
        <th field="categoryDesc" width="200" align="center">类别说明</th>
    </tr>
    </thead>
</table>
<div id="tb" align="center">
    <div>
        <a href="javascript:openAddCategoryDialog()" class="easyui-linkbutton" iconCls="icon-add"
           plain="true">添加</a>
        <a href="javascript:openUpdateCategoryDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
    </div>
    <div>
        &nbsp;类别名称：&nbsp;<input type="text" name="f_categoryName" id="f_categoryName" size="10"/>
        <a href="javascript:searchCategory()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width: 400px;height: 350px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="10px;">
            <tr>
                <td>类别名称：</td>
                <td><input type="text" name="categoryName" id="categoryName" class="easyui-validatebox"
                           required="true" width="300px"/></td>
            </tr>
            <tr>
                <td valign="top">类别说明：</td>
                <td><textarea class="easyui-validatebox" name="categoryDesc" id="categoryDesc"
                              style="width: 173px;height:100px;resize: none"></textarea></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveCategory()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>




<script type="text/javascript">
    var url;


    // function deleteCategory() {
    //     var selectedRows = $("#dg5").datagrid('getSelections');
    //     if (selectedRows.length == 0) {
    //         $.messager.alert("系统提示", "请选择要删除的数据！");
    //         return;
    //     }
    //     if (true) {
    //         $.messager.alert("系统提示", "存在资源数据，不能删除！");
    //         return;
    //     }
    //     var strIds = [];
    //     for (var i = 0; i < selectedRows.length; i++) {
    //         strIds.push(selectedRows[i].categoryId);
    //     }
    //     var ids = strIds.join(",");
    //     $.messager.confirm("系统提示", "您确认要删掉这<font color=red>" + selectedRows.length + "</font>条数据吗？", function (r) {
    //         if (r) {
    //             $.post("category", {delIds: ids}, function (result) {
    //                 // var json = $.parseJSON(result);
    //                 if (result.success == "true") {
    //                     $.messager.alert("系统提示", "您已成功删除<font color=red>" + result.delNums + "</font>条数据！");
    //                     $("#dg5").datagrid("reload");
    //                 } else {
    //                     $.messager.alert('系统提示', result.msg);
    //                 }
    //             }, "json");
    //         }
    //     });
    // }

    function searchCategory() {
        $('#dg5').datagrid('load', {
            categoryName: $('#f_categoryName').val(),
        });
    }

    function openAddCategoryDialog() {
        $("#dlg").dialog("open").dialog("setTitle", "添加资源类别");
        resetValue();
        url = "category/addCategory";
    }

    function saveCategory() {
        $("#fm").form("submit", {
            url: url,
            onSubmit: function () {
                return $(this).form("validate");
            },
            success: function (result) {
                var json = $.parseJSON(result);
                console.info(json)
                if (json.success == "false") {
                    $.messager.alert("系统提示", json.msg);
                    return;
                } else {
                    $.messager.alert("系统提示", json.msg);
                    resetValue();
                    $("#dlg").dialog("close");
                    $("#dg5").datagrid("reload");
                }
            }
        });
    }

    function resetValue() {
        $("#categoryName").val("");
        $("#categoryDesc").val("");
    }

    function closeDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }

    function openUpdateCategoryDialog() {
        var selectedRows = $("#dg5").datagrid('getSelections');
        if (selectedRows.length != 1) {
            $.messager.alert("系统提示", "请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dlg").dialog("open").dialog("setTitle", "编辑类别信息");
        $("#fm").form("load", row);
        url = "category/updateCategory?categoryId=" + row.categoryId;
    }
</script>
</body>
</html>
