<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/3
  Time: 22:24
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
    <title>个人帖子</title>
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
                                    class="glyphicon glyphicon-user">${currentUser.userId}</span></a>
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
                    <li title="论坛" class="active"><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
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
                        <a href="utils.jsp?page=beforeAllPost">论坛</a>
                    </li>
                    <li class="active">
                        ${post.postTitle}
                    </li>
                </ul>
            </div>



            <div class="panel panel-default">
                <ul class="list-group">
                    <li style="display:block" class="list-group-item">
                        <h3>${post.postTitle}
                            <c:choose>
                                <c:when test="${post.user.userLevel=='学生'}">
                                    <sup style="border-radius: 5px;font-size: 15px;background-color: #c7ddef;color: blue">学生</sup>
                                </c:when>
                                <c:otherwise>
                                    <sup style="border-radius: 5px;font-size: 15px;background-color: gray;color: yellow">教师</sup>
                                </c:otherwise>
                            </c:choose>
                        </h3>
                    </li>
                    <li style="display:block" class="list-group-item">
                        <h4>${post.postText}</h4>
                            <c:forEach var="image" items="${images }">
                                <img style="width: 70%;height: auto" src="${image }">
                            </c:forEach>
                            <%--<img src="${pageContext.request.contextPath}/upload/images/IMG.jpg">--%>


                    </li>
                    <li style="display:block" class="list-group-item">
                        <div align="right">
                            <span class="muted "><i class="glyphicon glyphicon-user"></i>${post.postUid}</span>
                            <span><a title="查看作者" href="user/getUserById?uid=${post.postUid}&tag=0" class="btn btn-success btn-sm">查看作者</a></span>
                            <span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>
                            <span class="muted"><i class="glyphicon glyphicon-time "></i><fmt:formatDate
                                    value="${post.postTime}" pattern="yyyy-MM-dd"/></span>
                            <span>&nbsp &nbsp </span>
                        </div>
                    </li>
                </ul>
            </div>
            <div>
                <ul class="container-fluid">

                    <form class=" form-horizontal " role="form" id="sendComment">
                        <div hidden class="alert alert-dismissable"id="tipes1">
                            <h4>
                                提示!
                            </h4> <strong id="tipe1"></strong>
                        </div>

                        <input type="text" name="commentUid" hidden value="${currentUser.userId}"/>
                        <input type="text" name="commentPid" hidden value="${post.postId}"/>
                        <div align="center" class="form-group">
                            <div>
                                <textarea required class="form-control" name="commentText" id="comment_text" rows="3"
                                          style="resize: none;font-size: 20px" placeholder="在此处留下你的评论"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                                <button type="button" style="margin-right: 10px" class="btn btn-info navbar-right"
                                        id="save_btn">提交评论
                                </button>
                            </div>
                        </div>
                    </form>
                </ul>
            </div>
            <div class="widget widget_hot">
                <c:choose>
                    <c:when test="${not empty post.comment}">
                        <h3>全部评论</h3>
                    </c:when>
                </c:choose>

                <ul>
                    <c:forEach var="comment" items="${post.comment }" varStatus="status">
                        <li style="display:block" class="row">
                            <h4 class="col-md-1">第${status.count}楼</h4>
                            <a class="list-group-item col-md-11" title="${comment.commentText}">
                                <h5 class="list-group-item-heading">${comment.commentText}</h5>
                                <span><p></p></span>
                                <span class="muted"><i
                                        class="glyphicon glyphicon-user"></i>${comment.commentUid}</span>
                                <span>&nbsp &nbsp</span>
                                <span class="muted"><i
                                        class="glyphicon glyphicon-time"></i><fmt:formatDate value="${comment.commentTime}"
                                                                                             pattern="yyyy-MM-dd"/></span>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </div>
    </div>
    </div>
</section>

<script type="text/javascript">
        $(document).on("click","#save_btn",function () {
       //$("#save_btn").onclick(function () {
            if(!cue()){
                setTimeout("hidenCue()", "3000");
                return false;
            }
            $.ajax({
                url:"<%request.getContextPath();%>/comment/addComment",
                data:$("#sendComment ").serialize(),
                type:"POST",
                success:function (result5) {

                    $("#tipes1").removeClass("alert-success alert-danger");
                    $("#tipe1").empty();
                    if(result5.codel==100){


                        $("#tipes1").addClass("alert-success");
                        $("#tipe1").append("评论成功！！");
                        $("#tipes1").show();
                        setTimeout("chage()","1000");
                    }
                    else {
                        $("#tipes1").addClass("alert-danger");
                        $("#tipe1").append("评论失败！！");
                        $("#tipes1").show();
                        setTimeout("hidenCue()","3000");
                    }
                }

            });
        });


        function cue() {
            var text = $("#comment_text").val();
            if(text == "") {
                $("#tipes1").removeClass("alert-success alert-danger");
                $("#tipe1").empty();
                $("#tipes1").addClass("alert-danger");
                $("#tipe1").append("正文不能为空！！！");
                $("#tipes1").show();
                return false;
            }
            return true;
        }


        function hidenCue() {
            $("#tipes1").hide();
        }

        function chage() {
            javascript:location.reload();

        }
</script>

</body>
</html>
