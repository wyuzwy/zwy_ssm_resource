<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/6
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>修改密码</title>
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
                    <a class="list-group-item" title="我的信息" href="user/getUserById?uid=${currentUser.userId}&tag=1">我的信息</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item active" title="修改密码" >修改密码</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的资源" href="utils.jsp?page=beforeOwnRes">我的资源</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的帖子" href="utils.jsp?page=beforeOwnPost">我的帖子</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的关注" href="utils.jsp?page=beforeOwnRes">我的关注</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="我的收藏" href="utils.jsp?page=beforeOwnCollect">我的收藏</a>
                </li>
            </ul>
        </div>

        <div class="col-md-10">

            <div>
                <h3>修改密码</h3>
            </div>

            <div class="panel panel-default ">
                <div class="container">
                    <div style="margin: 20px">

                        <form class="col-md-9 form-horizontal"  id="updatePassword" >

                                    <div hidden class="alert alert-dismissable"id="tipes1">
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                                        </button>
                                        <h4>
                                            提示!
                                        </h4> <strong id="tipe1"></strong>
                                    </div>

                            <input type="text" hidden name="userId" value="${currentUser.userId}"/>
                            <div class="form-group">
                                <label for="user_password_old" class="col-sm-2 control-label">旧密码</label>
                                <div class="col-sm-4">
                                    <input type="password" class="form-control" name="uPass" id="user_password_old" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_password_new" class="col-sm-2 control-label">新密码</label>
                                <div class="col-sm-4">
                                    <input type="password" class="form-control" name="NuPass" id="user_password_new" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_password_confirm" class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-4">
                                    <input type="password" class="form-control" name="uPassConfirm" id="user_password_confirm" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-default" id="save_password">提交</button>
                                    <button type="reset" class="btn btn-danger">重置</button>
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
    var value = "update";

    $(document).on("click","#save_password",function () {
        //alert($("#editUser").serialize());
        ///alert($("#editUser form").serialize());
        //alert($("#updatePassword").serialize());
        $.ajax({
            url:"<%request.getContextPath();%>/user/update/"+value,
            type:"PUT",
            data:$("#updatePassword").serialize(),
            success:function (result) {
                console.log(result);
                show_cue1(result);

               // javascript:location.reload();
            }
        });
    });
        function show_cue1(result) {
            $("#tipes1").removeClass("alert-success alert-danger");
            $("#tipe1").empty();
            if(result.codel==100){
                $("#tipes1").addClass("alert-success");
                $("#tipe1").append(result.extend.msg);
                $("#tipes1").show();
                setTimeout("chage()","2000");
            }else{
                $("#tipes1").addClass("alert-danger");
                $("#tipe1").append(result.extend.msg);
                $("#tipes1").show();
                setTimeout("hidenCue()","3000");
                //setTimeout("hidenCue()","3000");
            }
            event.preventDefault();
        }

        function chage() {
            window.location.href="user/exit";
        }
    function hidenCue() {
        $("#tipes1").hide();
    }

</script>

</body>
</html>
