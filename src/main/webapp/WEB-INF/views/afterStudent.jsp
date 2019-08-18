<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/13
  Time: 14:24
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

<table id="dg" title="管理学生帐号" class="easyui-datagrid"  fitColumns="true"
      pagination="true" rownumbers="true" url="student/allStudent" fit="true"  toolbar="#tb".><!--url="student/allStudent"-->
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="studentId" width="100" align="center">帐号</th>
        <th field="studentName" width="100" align="center">姓名</th>
        <th field="studentSex" width="50" align="center">性别</th>
        <th field="studentBirth" width="100" align="center">生日</th>
        <th field="studentClass" width="50" align="center">班级</th>
        <th field="studentDesc" width="150" align="center">个人说明</th>

    </tr>
    </thead>

</table>

<div id="tb" align="center">
    <div>
        <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>&nbsp;帐号：&nbsp;<input type="text" name="f_StudentId" id="f_StudentId" size="10" />
        <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
</div>



<script type="text/javascript">




    var user_level = "${currentUser.userLevel}";



    function deleteUser() {
        if (user_level == "超级管理员") {

        } else {
            $.messager.alert("系统提示", "您没有这个权限！");
            return;
        }

        var selectedRows = $("#dg").datagrid('getSelections');
        if (selectedRows.length == 0) {
            $.messager.alert("系统提示", "请选择要删除的数据！");
            return;
        }
        var strIds = [];
        for (var i = 0; i < selectedRows.length; i++) {
            strIds.push(selectedRows[i].studentId);
        }
        var ids = strIds.join(",");
        $.messager.confirm("系统提示", "您确认要删掉这<font color=red>" + selectedRows.length + "</font>条数据吗？", function (r) {
            if (r) {
                $.post("student/deleteStudent", {delIds: ids }, function (result) {
                    if (result.success == "true") {
                        $.messager.alert("系统提示", "您已成功删除<font color=red>" + result.delNums + "</font>条数据！");
                        $("#dg").datagrid("reload");
                    } else {
                        $.messager.alert('系统提示', result.msg);
                    }
                }, "json");
            }
        });
    }

    function searchUser() {
        $('#dg').datagrid('load', {
            studentId: $('#f_StudentId').val(),
        });
    }





    function closeDialog() {
        $("#dlg").dialog("close");
        resetValue();
    }




    //时间格式的转换
    function timeStamp2String(time){
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();

        return year + "-" + month + "-" + date;
    }

</script>

</body>
</html>
