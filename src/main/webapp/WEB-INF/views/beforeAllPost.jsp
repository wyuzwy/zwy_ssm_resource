<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/5
  Time: 22:54
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
    <title>全部帖子</title>
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
                    <li title="论坛" class="active"><a>论坛</a></li>
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
                    <a class="list-group-item active" title="全部帖子" >全部帖子</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="上传帖子" href="utils.jsp?page=beforePostUpload">我要发帖</a>
                </li>
            </ul>
        </div>

        <div class="col-md-9">

            <div>
                <h3>全部帖子</h3>
            </div>

            <div class="panel panel-default">
                <div class="container-fluid ">
                    <div style="margin: 20px">

                        <form class=" form-inline"  id="form-search">
                            <span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>
                            <input type="text" class="form-control" placeholder="关键词" name="title" id="title">
                            <span>&nbsp &nbsp </span>
                            <label class="form-inline">用户类别</label>
                            <select id="type" class="form-control " name="type">
                                <option value="">全部</option>
                                <option value="学生">学生</option>
                                <option value="教师">教师</option>
                            </select>
                            <span> &nbsp </span>
                            <a id="search_btn" class="btn btn-info">搜索</a>
                            <span id="test"></span>
                        </form>

                        <div class="panel panel-default">
                            <ul class="list-group" id="show_post1">

                            </ul>
                        </div>
                        <div class="row">
                            <div class="col-md-6" id="page_info_area" >
                            </div>
                            <div class="col-md-6" id="page_nav_area">
                            </div>
                        </div>
                    </div>
                </div>
                <%--<%@ include file="pagination.jsp" %>--%>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript">

    $(function () {
        show_post(1);
    });

    //根据标题用户类型进行模糊查询
    $(document).on("click","#search_btn",function () {
        var title = $("#title").val();
        var type = $("#type").val();
        if(!title&&!type){
            //3个选项全无内容，显示所有的第一页！！！
            show_post(1);
            return false;
        }

        $.ajax({
            url:"<%request.getContextPath();%>post/findPostByConditions",
            data:"title="+title+"&types="+type,
            type:"GET",
            success:function (result) {
                console.log(result);
                $("#test").empty();
                $("#show_post1").empty();
                $("#page_info_area").empty();
                $("#page_nav_area").empty();
                if(result.codel==100) {//查询成功
                    //alert("111");

                    build_post_table2(result);
                    $("#test").append("共"+result.extend.tipes+"条记录！")
                }else{

                    $("#test").append("无记录！！！")
                }

            }

        })



    });



    //显示分页帖子
    function show_post(pn) {
        $("#test").empty();
        $.ajax({
            url:"<%request.getContextPath();%>/post/all",
            data:"pn="+pn,
            type:"GET",
            success:function (result) {
                //解析评论信息
                build_post_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });

    }

    //解析帖子数据
    function build_post_table(result) {
        $("#show_post1").empty();
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
            hre.append(side).append(context).append(desc1).append(desc4).appendTo("#show_post1");

        });
    }

    //解析帖子数据(无分页效果)
    function build_post_table2(result) {
        $("#show_post1").empty();
        var posts = result.extend.postInfo;
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
            hre.append(side).append(context).append(desc1).append(desc4).appendTo("#show_post1");

        });
    }


    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前 "+result.extend.postInfo.pageNum+" 页,总 "+
            result.extend.postInfo.pages+" 页,总 "+
            result.extend.postInfo.total+" 条记录");
        totalRecord = result.extend.postInfo.total;
        currentPage = result.extend.postInfo.pageNum;
    }
    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result){
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.postInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加点击翻页的事件
            firstPageLi.click(function(){
                show_post(1);
            });
            prePageLi.click(function(){
                show_post(result.extend.postInfo.pageNum -1);
            });
        }



        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        if(result.extend.postInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                show_post(result.extend.postInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                show_post(result.extend.postInfo.pages);
            });
        }



        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.postInfo.navigatepageNums,function(index,item){

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.postInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                show_post(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
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
