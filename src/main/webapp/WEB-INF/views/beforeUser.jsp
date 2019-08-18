<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/4
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>用户信息</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%request.getContextPath();%>/static/js/jquery-1.12.4.min.js"></script>
    <link href="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%request.getContextPath();%>/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-default " role="navigation">
        <div class="navbar container-fluid navbar-default  navbar-fixed-top">
            <div class="navbar-header">
                <h4 class="logo navbar-text "><a href="#" title="校园资源共享平台">校园资源共享平台</a></h4>
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
                    <li title="首页"><a href="#">首页</a></li>
                    <li title="资源"><a href="utils.jsp?page=beforeAllResource">资源</a></li>
                    <li title="论坛"><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
                    <li title="个人中心"><a href="user/getUserById?uid=${currentUser.userId}&tag=1">个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section class="panel panel-default container">
    <div>
        <ul class="breadcrumb">
            <li class="active">
                用户主页
            </li>
            <li>
                        ${user.uName }的主页
            </li>
        </ul>
    </div>

    <div class="row">

        <div class="col-md-2">
            <ul class="clearfix">
                <h3>他的主页</h3>
                <li style="display:block">
                    <a class="list-group-item active" title="他的信息" >他的信息</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="他的资源"
                      href="utils.jsp?page=beforeUserResource&parm=${user.uId}" >他的资源</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="他的帖子" href="utils.jsp?page=beforeUserPost&parm=${user.uId}">他的帖子</a>
                </li>
            </ul>
        </div>


        <div class="col-md-10">

            <div>

                        <h3>用户信息
                            <c:choose>
                                <c:when test="${target == '学生'}">
                            <sup style="border-radius: 5px;font-size: 15px;background-color: #c7ddef;color: blue">${target}</sup>
                                </c:when>
                                <c:otherwise>
                                    <sup style="border-radius: 5px;font-size: 15px;background-color: gray;color: yellow">${target}</sup>
                                </c:otherwise>
                            </c:choose>
                        </h3>




            </div>

            <div class="panel panel-default ">
                <div class="container">

                    <div style="margin: 20px">

                        <form id="form" class="col-md-9 form-horizontal" role="form">

                                    <div hidden class="alert alert-dismissable" id="cue">
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                                        </button>
                                        <h4>
                                            提示!
                                        </h4>
                                    </div>

                            <input type="text" name="flag" hidden value="addFollow"/>
                            <input type="text" name="uid" hidden value="${currentUser.userId}"/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">帐号</label>
                                <div class="col-sm-4">
                                    <input type="text" readonly class="form-control" name="user_id" id="user_id"
                                           value="${user.uId }"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="user_name" readonly
                                           value="${user.uName}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="sex" readonly
                                           value="${user.uSex}"/>
                                </div>
                            </div>
                            <c:choose>
                                <c:when test="${target == '学生'}">
                                    <div class="form-group" id="user_class_div">
                                        <label class="col-sm-2 control-label">班级</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="user_class" readonly
                                                   value="${user.uClass}"/>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">生日</label>
                                <div class="col-sm-4">
                                    <input class="form-control" id="user_birth" readonly disabled
                                           value="<fmt:formatDate value="${user.uBirth}" pattern="yyyy-MM-dd"/>"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">个人说明</label>
                                <div class="col-sm-4">
                                    <textarea class="form-control" id="user_desc1" rows="4" readonly
                                              style="resize: none">${user.uDesc}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-10">
                                    <a type="submit" class="btn btn-info" id="save_btn">关注用户</a>
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

    $(document).on("click","#save_btn",function () {
        var value = "${currentUser.userId}";
        var uId = "${user.uId }";
        $.ajax({
            url:"<%request.getContextPath();%>/follow/addFollow",
            data:"uId="+value+"&ufId="+uId,
            type:"GET",
            success:function (result) {
                show_cue(result);
                setTimeout("hidenCue()","3000");

            }
        });
    });
    function hidenCue() {
        $("#cue").hide();
    }

    function show_cue(result) {
        $("#cue").empty();
        if(result.codel=='100'){
            var cue = $("<strong></strong>").append("关注成功！");
            $("#cue").addClass(" alert-success").append(cue);

        }else{

            var cue = $("<strong></strong>").append("已经关注过了!");
            $("#cue").addClass(" alert-danger").append(cue);
        }
        $("#cue").show();
    }




</script>
</body>
</html>
