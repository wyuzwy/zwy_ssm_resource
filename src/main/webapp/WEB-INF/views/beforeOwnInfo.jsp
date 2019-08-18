<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/6
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>校园资源共享平台</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%request.getContextPath();%>/static/js/jquery-1.12.4.min.js"></script>
    <link href="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link src="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js" rel="stylesheet">
    <script src="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
    <script src="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-default " role="navigation">
        <div class="navbar container-fluid navbar-default  navbar-fixed-top">
            <div class="navbar-header">
                <h4 class="logo navbar-text "><a  title="校园资源共享平台">校园资源共享平台</a></h4>
            </div>

            <div id="login-info">
                <c:choose>
                    <c:when test="${not empty sessionScope.get('currentUser')}">
                        <ul class="nav navbar-nav navbar-right">
                            <li title="个人中心"><a href="user/getUserById?uid=${currentUser.userId}&tag=1"><span
                                    class="glyphicon glyphicon-user"></span>${currentUser.userId}</a>
                            </li>
                            <li title="退出"><a href="user/exit"><span class="glyphicon glyphicon-log-in"></span>退出</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul class="nav navbar-nav navbar-right">
                            <li title="注册"><a href="utils.jsp?page=register"><span class="glyphicon glyphicon-user"></span> 注册</a>
                            </li>
                            <li title="登录"><a href="utils.jsp?page=login"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
                            </li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>


            <div class="navbar-collapse collapse" style="text-align: center">
                <ul class="nav navbar-nav nav-pills" style="display: inline-block;float: none">
                    <li title="首页" ><a href="#">首页</a></li>
                    <li title="资源"><a href="utils.jsp?page=beforeAllResource">资源</a></li>
                    <li title="论坛"><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
                    <li title="个人中心" class="active"><a >个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section class="panel panel-default container">
    <div class="row">

        <div class="col-md-2">
            <ul class="clearfix">
                <h3>个人中心</h3>
                <li style="display:block">
                    <a class="list-group-item active" title="我的信息" >我的信息</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="修改密码" href="utils.jsp?page=beforeUpdatePwd">修改密码</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的资源" href="utils.jsp?page=beforeOwnRes">我的资源</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的帖子" href="utils.jsp?page=beforeOwnPost">我的帖子</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的关注" href="utils.jsp?page=beforeOwnFollow">我的关注</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的收藏" href="utils.jsp?page=beforeOwnCollect">我的收藏</a>
                </li>
            </ul>
        </div>

        <div class="col-md-10">

            <div>
                <c:choose>
                    <c:when test="${currentUser.userLevel == '学生'}">
                        <h3>我的信息<sup style="border-radius: 5px;font-size: 15px;background-color: #c7ddef;color: blue">${currentUser.userLevel}</sup></h3>
                    </c:when>
                    <c:otherwise>
                        <h3>我的信息<sup style="border-radius: 5px;font-size: 15px;background-color: gray;color: yellow">${currentUser.userLevel}</sup></h3>

                    </c:otherwise>
                </c:choose>
            </div>

            <div class="panel panel-default ">
                <div class="container">

                    <div style="margin: 20px">

                        <form  class="col-md-9 form-horizontal"  id="editUser" >

                                    <div hidden="" class="alert alert-dismissable alert-success" id="tipes">
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                                        </button>
                                        <h4>
                                            提示!
                                        </h4> <strong id="tipe"></strong>
                                    </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">帐号</label>
                                <div class="col-sm-4">
                                    <input type="text" readonly class="form-control" name="uId" id="user_id" value="${currentUser.userId}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="uName" id="user_name" readonly value="${user.uName}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4">
                                    <select  class="form-control" name="uSex" id="user_sex" disabled  >
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
                            <c:choose>
                                <c:when test="${currentUser.userLevel == '学生'}">
                                    <div class="form-group" id="user_class_div">
                                        <label class="col-sm-2 control-label">班级</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="uClass" id="user_class" readonly value="${user.uClass}"/>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">生日</label>
                                <div class="col-sm-4">
                                    <input  class="form-control" name="uBirth" id="user_birth" readonly disabled value="<fmt:formatDate value="${user.uBirth}" pattern="yyyy-MM-dd"/>"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">个人说明</label>
                                <div class="col-sm-4">
                                    <textarea class="form-control" name="uDesc" id="user_desc" rows="4" readonly style="resize: none">${user.uDesc}</textarea>
                                </div>
                            </div>
                            <input type="text" name="uLevel" hidden value="${currentUser.userLevel}"/>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-default" id="update_btn">编辑</button>
                                    <button type="button" class="btn btn-default" id="save_btn">保存</button>
                                    <a  href="javascript:location.reload();" class="btn btn-default" id="cancel_btn">取消</a>
                                </div>
                            </div>
                        </form>
                    </div>


                </div>
            </div>


        </div>


    </div>
</section>


<script type="text/javascript">
    var value="${currentUser.userId}";
    $("#update_btn").click(function () {
        $("#save_btn").show();
        $("#update_btn").hide();
        $("#cancel_btn").show();
        $("#user_name").attr("readonly",false);
        $("#user_sex").attr("disabled",false);
        $("#user_birth").attr("disabled",false);
        $("#user_class").attr("readonly",false);
        $("#user_desc").attr("readonly",false);
    });

    $("#cancel_btn").click(function () {
        $("#flag").val('');
        $("#save_btn").click();
    });

    $("#user_birth").datetimepicker({
        pickDate:true,
        minView:"month",
        language:"zh-CN",
        format:"yyyy-mm-dd",

    });

    $(function () {
        $("#save_btn").hide();
        $("#update_btn").show();
        $("#cancel_btn").hide();
        $("#user_sex").val("${user.uSex}");
    });

    $(document).on("click","#save_btn",function () {
        //alert($("#editUser").serialize());
        ///alert($("#editUser form").serialize());
        $.ajax({
            url:"<%request.getContextPath();%>/user/edit/"+value,
            type:"PUT",
            data:$("#editUser").serialize(),
            success:function (result) {
                javascript:location.reload();
                show_msg(result);

            }
        });
    });

    function show_msg(result) {
        if(result.codel==100) {
            $("#tipes").addClass("alert-success");
            $("#tipe").append("修改成功！");
            $("#tipes").show();
            setTimeout("hidenCue()","3000");
        }
    }

    function hidenCue() {
        $("#tipes").hide();
    }
</script>
</body>
</html>
