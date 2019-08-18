<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/9
  Time: 14:40
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
    <title>注册界面</title>
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
                            <li title="注册" class="active" ><a href="utils.jsp?page=register"><span class="glyphicon glyphicon-user"></span> 注册</a>
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
                    <li title="个人中心"><a href="user/getUserById?uid=${currentUser.userId}&tag=1">个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section class=" container">
    <div class="panel panel-default" style="margin: 50px">
        <div class="row clearfix">
            <div class="col-md-12" style="text-align: center"><h2>用户注册</h2></div>
            <div class="col-md-12 column" style="margin: 20px">


                <div class="col-md-3"></div>

                <form class="col-md-9 form-horizontal" id="register">
                    <div class="form-group">
                        <div hidden class="alert alert-dismissable  col-sm-7" id="tipes3">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                            </button>
                            <h4>
                                提示!
                            </h4> <strong id="tipe3"></strong>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_id" class="col-sm-2 control-label">账号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="registerId" id="user_id" />
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_password" class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="registerPassword" id="user_password"/>
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_password_confirm" class="col-sm-2 control-label">确认密码：</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="registerPasswordConfirm"
                                   id="user_password_confirm"/>
                            <span  class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_level" class="col-sm-2 control-label">等级：</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="registerLevel" id="user_level" >
                                <option value="学生">学生</option>
                                <option value="教师">教师</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" id="student_class_form">
                        <label for="student_class" class="col-sm-2 control-label">班级：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="registerClass" id="student_class"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" id="saveUser">注册</button>
                            <button type="reset" class="btn btn-danger">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript">
    //检验表单数据
    function validate_add_form(){
        var userId = $("#user_id").val();
        var regId =  /(^[a-zA-Z0-9_-]{6,16}$)/;
        //alert(userId);
        if(!regId.test(userId)){
            show_validate_msg("#user_id", "error", "账号必须为6-16位英文和数字的组合！");
            return false;
        }else {

            show_validate_msg("#user_id", "success", "");
        }

        var password = $("#user_password").val();
        //alert(password);
        var regPass =  /(^[a-zA-Z0-9_-]{6,12}$)/;
        if(!regPass.test(password)){
            show_validate_msg("#user_password", "error", "密码必须为6-12位英文和数字的组合！");
            return false;
        }else{

            show_validate_msg("#user_password", "success", "");
        }
        var passwordConfire = $("#user_password_confirm").val();
        //alert(passwordConfire);
        if(password == (passwordConfire)){
            show_validate_msg("#user_password_confirm", "success", "");
        }
        else {

            show_validate_msg("#user_password_confirm", "error", "两次密码不一致！");
            return false;
        }
       // alert("ok!!!")
        return true;
    }

    function show_validate_msg(ele,status,msg){

        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);

        }else if("error" == status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);

        }
    }

    $("#user_id").change(function () {
       var userId = this.value;
        $("#saveUser").removeAttr("ajax-va");
       $.ajax({
           url:"<%request.getContextPath();%>/register/checkId",
           data:"userId="+userId,
           type:"POST",
           success:function (result) {

               if(result.codel ==100){
                   show_validate_msg("#user_id","success","用户名可用");
                   $("#saveUser").attr("ajax-va","success");
               }else{
                   show_validate_msg("#user_id","error","用户名已被注册！");
                   $("#saveUser").attr("ajax-va","error");
               }
           }


       });




    });




    $(document).on("click","#saveUser",function () {
        //alert($("#register").serialize());
            $("#tipes3").removeClass("alert-success alert-danger");
            $("#tipe3").empty();
        //1、先对要提交给服务器的数据进行校验
        //alert("<%request.getContextPath();%>");
        if(!validate_add_form()){

            return false;
        };

        //1、判断之前的ajax用户名校验是否成功。如果成功。
        if($(this).attr("ajax-va")=="error"){
            return false;
        }
        $("#saveUser").removeAttr("ajax-va");
        $.ajax({
            url:"<%request.getContextPath();%>/register/addRegister",
            data:$("#register").serialize(),
            type:"POST",
            success:function (result1) {
                console.log(result1);
                // alert("lalalala");
                if(result1.codel=="100"){

                    $("#tipes3").addClass("alert-success");
                    $("#tipe3").append("添加注册成功！请等待管理员的审核");
                        $("#tipes3").show();
                        setTimeout("changePage()","3000");
                }else{
                    $("#tipes3").addClass("alert-danger");
                    $("#tipe3").append("注册失败！");
                    $("#tipes3").show();

                }

            }
        });
    });


    function changePage() {
        window.location.href="#";
    }


    $("#user_level").change(function () {
        if ($('#user_level').val() == "学生") {
            $('#student_class_form').show();
        } else {
            $('#student_class_form').hide();

        }
    });



</script>


</body>
</html>
