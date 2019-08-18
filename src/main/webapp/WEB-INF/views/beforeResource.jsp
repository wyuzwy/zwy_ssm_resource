<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/5
  Time: 21:53
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
                    <li title="首页"><a href="#">首页</a></li>
                    <li title="资源" class="active"><a href="utils.jsp?page=beforeAllResource">资源</a></li>
                    <li title="论坛" ><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
                    <li title="个人中心"><a href="user/getUserById?uid=${currentUser.userId}&tag=1">个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<section class="container">
    <%--panel panel-default--%>
    <div class="row">

        <div class="col-md-1"></div>

        <div class="col-md-10">
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="utils.jsp?page=beforeAllResource">资源</a>
                    </li>
                    <li class="active">
                        ${resource.resourceName}
                    </li>
                </ul>
            </div>

            <div class="panel panel-default" >
                <div hidden id="cue" class="alert alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" id="cueClose">×
                    </button>
                    <h4>
                        提示!
                    </h4>
                </div>
                <ul class="list-group">
                    <li style="display:block" class="list-group-item">
                        <h3>${resource.resourceName}
                            <c:choose>
                                <c:when test="${resource.user.userLevel=='学生'}">
                                    <sup style="border-radius: 5px;font-size: 15px;background-color: #c7ddef;color: blue">学生</sup>
                                </c:when>
                                <c:otherwise>
                                    <sup style="border-radius: 5px;font-size: 15px;background-color: gray;color: yellow">教师</sup>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${resource.resourceGood == 1}">
                                    <sup style="border-radius: 5px;font-size: 15px;background-color: pink;color: red">优质</sup>
                                </c:when>
                            </c:choose>
                            <span><button style="margin-right: 10px" title="收藏资源" id="addCollect"
                                     class="btn btn-danger btn-sm navbar-right" onclick="javascript:alert(msg)">收藏资源</button></span>
                        </h3>

                    </li>
                    <li style="display:block" class="list-group-item">
                        <h4>${resource.resourceDesc}</h4>

                        <c:forEach var="image" items="${images }">
                            <img style="width: 70%;height: auto" src="${image}">
                        </c:forEach>

                    </li>
                    <li style="display:block" class="list-group-item">

                        <div align="right">
                            <span><a class="btn btn-info btn-sm navbar-left"
                                     href="${resource.resourceUrl}">下载资源</a></span>
                            <span class="text">资源类别：${resource.categoryKey.categoryName}</span>
                            <span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>
                            <span class="text">资源等级：${resource.resourceLevel}</span>
                            <span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>
                            <span class="muted "><i class="glyphicon glyphicon-user"></i>${resource.resourceUid}</span>
                            <span><a title="查看作者" href="user/getUserById?uid=${resource.resourceUid}&tag=0" class="btn btn-success btn-sm">查看作者</a></span>
                            <span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>
                            <span class="muted"><i class="glyphicon glyphicon-time "></i><fmt:formatDate
                                    value="${resource.resourceTime}" pattern="yyyy-MM-dd"/></span>
                            <span>&nbsp &nbsp </span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </div>
</section>
<script type="text/javascript">
    $(document).on("click","#addCollect",function () {
        var value="${currentUser.userId}";
        var resId = "${resource.resourceId}";
            $.ajax({
                url:"<%request.getContextPath();%>/resource/addCollect",
                data:"uid="+value+"&rid="+resId,
                type:"POST",
                success:function (result) {
                    //alert(result.msg);
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
            var cue = $("<strong></strong>").append("收藏成功！");
           $("#cue").addClass(" alert-success").append(cue);

        }else{

            var cue = $("<strong></strong>").append("已经收藏过了!");
            $("#cue").addClass(" alert-danger").append(cue);
        }
        $("#cue").show();
    }
</script>


</body>
</html>
