<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/9
  Time: 20:05
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
    <title>个人详细资源</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%request.getContextPath();%>/static/js/jquery-3.2.1.min.js"></script>
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
                    <li title="首页"><a href="#">首页</a></li>
                    <li title="资源" ><a href="utils.jsp?page=beforeAllResource">资源</a></li>
                    <li title="论坛" class="active"><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
                    <li title="个人中心"><a href="user/getUserById?uid=${currentUser.userId}&tag=1">个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>


<section class="panel panel-default container">
    <div class="row">

        <div class="col-md-3">
            <ul class="clearfix">
                <h3>论坛中心</h3>
                <li style="display:block">
                    <a class="list-group-item " title="全部资源" href="utils.jsp?page=beforeAllPost">全部帖子</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item active" title="发布帖子" >我要发帖</a>
                </li>
            </ul>
        </div>

        <div class="col-md-9">

            <div>
                <h3>我要发帖</h3>
            </div>

            <div class="panel panel-default">
                <div class="container-fluid ">
                    <div style="margin: 20px">
                        <form class="form-horizontal" name="uploadForm"  id="addPost"    enctype="multipart/form-data">
                            <input type="text" hidden name="postUid" value="${currentUser.userId}" id="post_uid"/>
                                    <div hidden class="alert alert-dismissable " id="tipes4">
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                        <h4>
                                            提示!
                                        </h4> <strong id="tipe4">提交成功!</strong>
                                    </div>

                            <div class="form-group">
                                <label for="post_title" class="col-sm-2 control-label">标题</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="postTitle" id="post_title" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="post_text" class="col-sm-2 control-label">正文</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" name="postText" id="post_text" rows="10"  style="resize: none" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="post_images" class="col-sm-2 control-label">选择图片</label>
                                <div class="col-sm-8">
                                    <input accept="image/*"  type="file" multiple id="post_images" name="postImages"  >
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-info" id="sendPost">提交</button>
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


   $(document).on("click","#sendPost",function () {

        if(!checkMessage()){
            setTimeout("hidden_mes()","3000");
            return false;
        }
        var postUid = $.trim($("#post_uid").val());
       var postTitle = $.trim($("#post_title").val());
       var postText = $.trim($("#post_text").val());
       var postImages = $("#post_images")[0].files[0];
       var formData = new FormData();
       formData.append("postImages",postImages);
       formData.append("postUid",postUid);
       formData.append("postTitle",postTitle);
       formData.append("postText",postText);



        $.ajax({
            url:"<%request.getContextPath();%>/post/addPost",
            data:formData,
            type:"POST",
            processData:false,
            contentType:false,
            async:false,
            cache:false,
            success:function (result3) {
                $("#tipes4").removeClass("alert-danger alert-success");
                $("#tipe4").empty();
                if(result3.codel==100){

                    $("#tipes4").addClass("alert-success");
                    $("#tipe4").append("发布成功！！！");
                    $("#tipes4").show();
                    setTimeout("3000");
                    window.location.href="<%request.getContextPath();%>/post/getPostById?pid="+result3.extend.id;
                }else{
                    $("#tipes4").addClass("alert-danger");
                    $("#tipe4").append("发布失败！！！");
                    $("#tipes4").show();
                    setTimeout("hidden_mes()","3000");
                }


            }



        });




    });



    function checkMessage() {
        $("#tipes4").removeClass("alert-danger alert-success");
        $("#tipe4").empty();
        var title = $("#post_title").val();
        if(title==""){
            $("#tipes4").addClass("alert-danger");
            $("#tipe4").append("标题不能为空！！！");
            $("#tipes4").show();
            return false;
        }
        var text = $("#post_text").val();
        if(text==""){
            $("#tipes4").addClass("alert-danger");
            $("#tipe4").append("正文不能为空！！！");
            $("#tipes4").show();
            return false;
        }
        return true;
    }


    function hidden_mes() {
        $("#tipes4").hide();
    }


</script>

</body>
</html>
