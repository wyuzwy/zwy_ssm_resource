<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/3
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>校园资源共享平台</title>
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
                    <li title="首页" class="active"><a href="#">首页</a></li>
                    <li title="资源"><a href="utils.jsp?page=beforeAllResource">资源</a></li>
                    <li title="论坛"><a href="utils.jsp?page=beforeAllPost">论坛</a></li>
                    <li title="个人中心"><a href="user/getUserById?uid=${currentUser.userId}&tag=1">个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<section class="panel panel-default container">


    <div class="row" style="margin: 5px">

        <div class="col-md-8">

            <div class="panel panel-default">

                <div class="panel-heading">
                    <h2><a href="utils.jsp?page=beforeAllResource" class="panel-info">推荐资源</a></h2>
                </div>
                <ul class="list-group" id="show_resources">


                </ul>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><a href="forum" class="panel-info">热门帖子</a></h2>
                </div>
                <ul class="list-group" id="show_post">


                </ul>
            </div>

        </div>

        <aside class="sidebar col-md-4">
            <div class="fixed">
                <div class="widget widget_search">
                    <form class="navbar-form" >
                        <div class="input-group">
                            <input type="text" name="keyword" id="searchName" class="form-control" size="35" placeholder="请输入关键字"
                                   maxlength="15" autocomplete="off">
                            <span class="input-group-btn">
									<button class="btn btn-default btn-search" id="search" type="button">搜索</button>
								</span>
                        </div>
                    </form>
                </div>
            </div>

            <div class="widget widget_hot">
                <h3>最新评论</h3>
                <ul id="show_comment">

                </ul>
            </div>
        </aside>

    </div>
</section>




<script type="text/javascript">

    $(function () {
        //加载资源信息
        show_resource();
        //加载帖子信息
        show_post();
        //加载评论信息
        show_comment();
    });
    //加载资源信息
    function show_resource() {
        $.ajax({
            url:"<%request.getContextPath();%>/resource/all",
            type:"GET",
            success:function (result) {
                //console.log(result);
                //解析资源数据
                build_Resource_table(result);
            }
        });
    }



    function show_post() {
        $.ajax({
            url:"<%request.getContextPath();%>/post/all",
            type:"GET",
            success:function (result) {
               //解析评论信息
               build_post_table(result);
            }
        });

    }

    function show_comment() {
        $.ajax({
            url:"<%request.getContextPath();%>/comment/all",
            type:"GET",
            success:function (result) {
                //解析评论信息
                build_comment_table(result);
            }
        });
    }




    //解析资源数据
   function build_Resource_table(result){
        $("#show_resources").empty();
        var res = result.extend.pageInfo.list;
        $.each(res,function (index,item) {
            // var hre=$("<a href='"+<%request.getContextPath();%>/resource/getResouceById/"'></a>").addClass("list-group-item");
            //var hre=$(this).wrap("<a href='"+home/resource/getResouceById?rid=item.resourceId+"'></a>".addClass());
            var hre=$("<a href=\'<%request.getContextPath();%>/resource/getResourceById?rid="+item.resourceId+"\'></a>").addClass("list-group-item");
            var side = $("<h4></h4>").addClass("list-group-item-heading").append(item.resourceName);
            var sideData1 ;
            if(item.user.userLevel=="学生"){
                sideData1=$("<sup style=\"border-radius: 5px;font-size: 1px;background-color: #c7ddef;color: blue\"></sup>").append("学生");
            }else if(item.user.userLevel=="教师"){
                sideData1= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color:gray;color: yellow\"></sup>").append("教师");
            }
            side.append(sideData1);
            if(item.resourceGood=="1") {
                var sideData2 = $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: pink;color: red\"></sup>").append("优质");
                side.append(sideData2);
            }
            var context =$("<h6 style=\"overflow: hidden;text-overflow: ellipsis\"></h6>").addClass("text").append(item.resourceDesc);
            var desc1 =$("<span></span>").addClass("muted glyphicon glyphicon-user").append(item.resourceUid).append("&nbsp;");
            var desc2 = $("<span></span>").addClass("text").append("资源类别:").append(item.categoryKey.categoryName).append("&nbsp;");
            var desc3 = $("<span></span>").addClass("text").append("资源等级:").append(item.resourceLevel).append("&nbsp;");
            var time=timeStamp2String(item.resourceTime);
            var desc4 = $("<span></span>").addClass("muted glyphicon glyphicon-time").append(time);



            hre.append(side).append(context).append(desc1).append(desc2).append(desc3).append(desc4).appendTo("#show_resources");

        });
        var seeMore = $("<a href=\'utils.jsp?page=beforeAllResource\'></a>").addClass("see-more list-group-item").append("查看更多...");
        seeMore.appendTo("#show_resources");
    }


    //解析帖子数据
    function build_post_table(result) {
        $("#show_post").empty();
        var posts = result.extend.postInfo.list;
        $.each(posts,function (index,item) {
            // var hre=$("<a href='"+<%request.getContextPath();%>/resource/getResouceById/"'></a>").addClass("list-group-item");
            //var hre=$(this).wrap("<a href='"+home/resource/getResouceById?rid=item.resourceId+"'></a>".addClass());
            var hre=$("<a href=\'<%request.getContextPath();%>/post/getPostById?pid="+item.postId+"\'></a>").addClass("list-group-item");
            var side = $("<h4></h4>").addClass("list-group-item-heading").append(item.postTitle);
            var sideData1 ;
            if(item.user.userLevel=="学生"){
                sideData1=$("<sup style=\"border-radius: 5px;font-size: 1px;background-color: #c7ddef;color: blue\"></sup>").append("学生");
            }else if(item.user.userLevel=="教师"){
                sideData1= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color:gray;color: yellow\"></sup>").append("教师");
            }
            side.append(sideData1);
            var context =$("<h6 style=\"overflow: hidden;text-overflow: ellipsis\"></h6>").addClass("text").append(item.postText);
            var desc1 =$("<span></span>").addClass("muted glyphicon glyphicon-user").append(item.postUid).append("&nbsp;");
            var time=timeStamp2String(item.postTime);
            var desc4 = $("<span></span>").addClass("muted glyphicon glyphicon-time").append(time);
            hre.append(side).append(context).append(desc1).append(desc4).appendTo("#show_post");

        });
        var seeMore = $("<a href=\'utils.jsp?page=beforeAllPost\'></a>").addClass("see-more list-group-item").append("查看更多...");
        seeMore.appendTo("#show_post");
    }


    function build_comment_table(result) {
        $("#show_comment").empty();
        var comms = result.extend.commentInfo.list;
        $.each(comms,function (index,item) {
           var li = $("<li style=\"display:block\"></li>");
           var hre = $("<a href=\'<%request.getContextPath();%>/post/getPostById?pid="+item.commentPid+"\' ></a>").addClass("list-group-item");
           var title = $("<h5></h5>").addClass("list-group-item-heading").append(item.post.postTitle);
           var context = $("<span style=\"overflow: hidden;text-overflow: ellipsis\"></span>").addClass("text").append(item.commentText);
           var des1 =$("<span></span>").append($("<p></p>"));
           var des2 = $("<span></span>").addClass("muted glyphicon glyphicon-user").append(item.commentUid).append("&nbsp;");
           var time = timeStamp2String(item.commentTime);
           var des3 = $("<span></span>").addClass("muted glyphicon glyphicon-time").append(time);

           hre.append(title).append(context).append(des1).append(des2).append(des3);
           li.append(hre).appendTo("#show_comment");
        });
        var seeMore = $("<a href=\'utils.jsp?page=beforeAllPost\'></a>").addClass("see-more list-group-item").append("查看更多...");
        seeMore.appendTo("#show_comment");

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
    

    //搜索键
    //$("#search").onclick(function () {
    $(document).on("click","#search",function () {
       var name = $("#searchName").val();
        if(name==""){
            return false;
        }else{
            window.location.href="utils.jsp?page=beforeFindUser&parm="+name;
        }
    });


    
    
    
</script>
</body>
</html>
