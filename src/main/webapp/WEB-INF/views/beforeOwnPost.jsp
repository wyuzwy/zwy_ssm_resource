<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/6
  Time: 21:21
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
                            <li title="个人中心"><a ><span
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
                    <a class="list-group-item " title="修改密码" href="utils.jsp?page=beforeUpdatePwd">修改密码</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item " title="我的资源" href="utils.jsp?page=beforeOwnRes">我的资源</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item active" title="我的帖子" >我的帖子</a>
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
                <h3>我的帖子</h3>
            </div>

            <div class="panel panel-default ">
                <div class="container-fluid">
                    <div style="margin: 20px">
                        <%--<form class=" form-inline" action="user/user_post?uid=" method="GET" id="form-search">--%>
                            <%--<span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>--%>
                            <%--<input type="hidden" name="uid" id="uid"--%>
                                   <%--value="${currentUser.userId}">--%>
                            <%--<input type="hidden" name="page" id="page"--%>
                                   <%--value="${empty pagination.curPage ? 1 : pagination.curPage }">--%>
                            <%--<input type="text" class="form-control" placeholder="关键词" name="query" id="query"--%>
                                   <%--value="${query}">--%>
                            <%--<span> &nbsp </span>--%>
                            <%--<a id="search_btn" class="btn btn-info">搜索</a>--%>
                        <%--</form>--%>

                                <div hidden="" class="alert alert-dismissable alert-success" id="tipes10">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                                    </button>
                                    <h4>
                                        提示!
                                    </h4> <strong>删除成功!</strong>
                                </div>


                        <div class="panel panel-default">
                            <ul class="list-group" id="post">

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
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
    var value = "${currentUser.userId}";
    $(function () {
        show_post(1);
    });

    function show_post(pn) {
        $.ajax({
            url:"<%request.getContextPath();%>/post/getSomeOnePosts",
            data:"pn="+pn+"&uid="+value,
            type:"GET",
            dataType:"json",
            success:function (result) {

                //console.log(result);
                show_postData(result);

                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }



    function show_postData(result) {
        $("#post").empty();
        var pos = result.extend.pageInfo.list;
        $.each(pos,function (index,item) {
            var center1 = $("<a href=\'<%request.getContextPath();%>/post/getPostById?pid="+item.postId+"\'></a>").addClass("list-group-item");
            var center2 = $("<h4></h4>").addClass("list-group-item-heading").append(item.postTitle);
            var center;
            if(item.user.userLevel=="学生"){
                center= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: #c7ddef;color: blue\"></sup>").append("学生");

            }else{
                center= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: gray;color: yellow\"></sup>").append("教师");

            }
            var center3_2=$("<div style=\"margin-right: 10px\"></div>").addClass("navbar-right");
            var center3_3=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append("删除帖子");
            center3_3.attr("del-id",item.postId);
            center3_2.append(center3_3);
            center2.append(center).append(center3_2);

            var center4 = $("<h6 style=\"overflow: hidden;text-overflow: ellipsis\"></h6>").addClass("text").append(item.postText);
            var center5 = $("<span></span>").addClass("muted glyphicon glyphicon-user").append(item.postUid);
            var time = timeStamp2String(item.postTime);
            var center8 = $("<span></span>").addClass("muted glyphicon glyphicon-time").append(time);

            center2.append(center4);
            center1.append(center2).append(center5).append(center8);
            center1.appendTo("#post");

        });

    }
    function build_page_info(result){
        $("#page_info_area").empty();
        $("#page_info_area").append("当前 "+result.extend.pageInfo.pageNum+" 页,总 "+
            result.extend.pageInfo.pages+" 页,总 "+
            result.extend.pageInfo.total+" 条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result){
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加点击翻页的事件
            firstPageLi.click(function(){
                show_post(1);
            });
            prePageLi.click(function(){
                show_post(result.extend.pageInfo.pageNum -1);
            });
        }



        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                show_post(result.extend.pageInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                show_post(result.extend.pageInfo.pages);
            });
        }



        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums,function(index,item){

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum == item){
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



    $(document).on("click",".delete_btn",function () {
        var postId=$(this).attr("del-id");
        if(confirm("是否删除该帖子？")){
            $.ajax({
                url:"<%request.getContextPath();%>/post/delete/"+postId,
                type:"DELETE",
                success:function (result) {
                    if(result.codel==100){
                        show_post(1);
                        $("#tipes10").show();
                        setTimeout("hidden_cue()","3000")
                    }



                }


            });
        }

        return false;
    });



    function hidden_cue() {
        $("#tipes10").hide();
    }






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
