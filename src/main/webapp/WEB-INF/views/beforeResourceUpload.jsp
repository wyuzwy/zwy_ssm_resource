<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/11
  Time: 16:33
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
                    <li title="资源" class="active"><a href="utils.jsp?page=beforeAllResource">资源</a></li>
                    <li title="论坛" ><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
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
                <h3>资源中心</h3>
                <li style="display:block">
                    <a class="list-group-item " title="全部资源" href="utils.jsp?page=beforeAllResource">全部资源</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item active" title="上传资源" href="utils.jsp?page=beforeResourceUpload">上传资源</a>
                </li>
            </ul>
        </div>

        <div class="col-md-9">
            <div>
                <h3>上传资源</h3>
            </div>
            <div class="panel panel-default">
                <div class="container-fluid ">
                    <div style="margin: 20px">
                        <form class="form-horizontal" name="uploadForm" role="form" enctype="multipart/form-data" id="sendResource">

                            <div hidden class="alert alert-dismissable " id="tipes6">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                                </button>
                                <h4>
                                    提示!
                                </h4> <strong id="tipe6"></strong>
                            </div>

                            <input type="text" id="resource_uid" name="resourcesUid" hidden value="${currentUser.userId}"/>
                            <div class="form-group">
                                <label for="resource_name" class="col-sm-2 control-label">资源名字</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="resourcesName" id="resource_name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="resource_cid" class="col-sm-2 control-label">资源类别</label>
                                <div class="col-sm-4">
                                    <select id="resource_cid" class="form-control" name="resourcesCid" >

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="resource_level" class="col-sm-2 control-label">资源等级</label>
                                <div class="col-sm-4">
                                    <select id="resource_level" class="form-control" name="resourcesLevel" >
                                        <option value="初级">初级</option>
                                        <option value="中级">中级</option>
                                        <option value="高级">高级</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="resource_desc" class="col-sm-2 control-label">资源描述</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" name="resourcesDesc" id="resource_desc" rows="10"
                                               style="resize: none"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="resource_images" class="col-sm-2 control-label">图片展示</label>
                                <div class="col-sm-8">
                                    <input accept="image/*" type="file" multiple id="resource_images"
                                           name="resourcesImages">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="resource" class="col-sm-2 control-label">选择资源</label>
                                <div class="col-sm-8">
                                    <input type="file" id="resource" name="resources" >
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-info" id="upload_btn">上传</button>
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


    $(function () {
        //页面加载完成之后，查出类别信息显示在下拉列表中；
        show_category();
    });

    function show_category() {
        $("#resource_cid").empty();
        $.ajax({
            url:"<%request.getContextPath();%>/category/allCategory",
            type:"GET",
            success: function (result6) {
                console.log(result6);
                var cate = result6.extend.cates;
                $.each(cate, function (index,cates) {
                    var optionEle = $("<option></option>").append(cates.categoryName).attr("value", cates.categoryId);
                    optionEle.appendTo("#resource_cid");
                });
            }
        });
    }

    //上传资源
    $(document).on("click","#upload_btn",function () {
       if(!checkMessage()){
           setTimeout("hiddenCue()","3000");
           return false;
       }

       // var postUid = $.trim($("#post_uid").val());
       var resourceUid = $.trim($("#resource_uid").val());
       var resourceName = $.trim($("#resource_name").val());
       var resourceCid = $.trim($("#resource_cid").val());
       var resourceLevel = $.trim($("#resource_level").val());
       var resourceDesc = $.trim($("#resource_desc").val());
       var resourceImages = $("#resource_images")[0].files[0];
       var resource = $("#resource")[0].files[0];

        var formData = new FormData();
        formData.append("resourceUid",resourceUid);
        formData.append("resourceName",resourceName);
        formData.append("resourceCid",resourceCid);
        formData.append("resourceLevel",resourceLevel);
        formData.append("resourceDesc",resourceDesc);
        formData.append("resourceImages",resourceImages);
        formData.append("resource",resource);

       $.ajax({
           url:"<%request.getContextPath();%>/resource/addResource",
           data:formData,
           type:"POST",
           processData:false,
           contentType:false,
           async:false,
           cache:false,
           success:function (result7) {
               console.log(result7);
               $("#tipes6").removeClass("alert-danger alert-success");
               $("#tipe6").empty();
               if(result7.codel == 100){
                   $("#tipes6").addClass("alert-success");
                   $("#tipe6").append("发布成功！！！");
                   $("#tipes6").show();
                   setTimeout("3000");
                   window.location.href="<%request.getContextPath();%>/resource/getResourceById?rid="+result7.extend.id;
               }else{
                   $("#tipes6").addClass("alert-danger");
                   $("#tipe6").append("发布失败！！！");
                   $("#tipes6").show();
                   setTimeout("hiddenCue()","3000");

               }
           }

       });



    });


    function checkMessage() {
        $("#tipes6").removeClass("alert-danger alert-success");
        $("#tipe6").empty();
        var name=$("#resource_name").val();
        if(name ==""){
            $("#tipes6").addClass("alert-danger");
            $("#tipe6").append("名字不能为空！！！");
            $("#tipes6").show();
            return false;
        }

        var cate = $("#resource_cid").val();
        if(cate ==""){
            $("#tipes6").addClass("alert-danger");
            $("#tipe6").append("资源类别不能为空！！！");
            $("#tipes6").show();
            return false;
        }

        var level = $("#resource_level").val();
        if(level ==""){
            $("#tipes6").addClass("alert-danger");
            $("#tipe6").append("资源等级不能为空！！！");
            $("#tipes6").show();
            return false;
        }

        var desc = $("#resource_desc").val();
        if(desc ==""){
            $("#tipes6").addClass("alert-danger");
            $("#tipe6").append("资源描述不能为空！！！");
            $("#tipes6").show();
            return false;
        }

        var images = $("#resource_images").val();
        if(images ==""){
            $("#tipes6").addClass("alert-danger");
            $("#tipe6").append("请选择上传图片！！！");
            $("#tipes6").show();
            return false;
        }

        var resources = $("#resource").val();
        if(resources ==""){
            $("#tipes6").addClass("alert-danger");
            $("#tipe6").append("请选择上传资源文件！！！");
            $("#tipes6").show();
            return false;
        }
        return true;
    }


    function hiddenCue() {
        $("#tipes6").hide();
    }




</script>


</body>
</html>
