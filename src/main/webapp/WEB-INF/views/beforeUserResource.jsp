
<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/4
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>个人资源</title>
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
    <div id="head">
        <ul class="breadcrumb">
            <li class="active">
                用户资源
            </li>
            <li>
                ${param.parm}的资源
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-2" id="left">
            <ul class="clearfix">
                <h3>他的主页</h3>
                <li style="display:block">
                    <a class="list-group-item " title="他的信息" href="user/getUserById?uid=${param.parm}&tag=0">他的信息</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item active" title="他的资源"
                       >他的资源</a>
                </li>
                <li style="display:block">
                    <a class="list-group-item" title="他的帖子" href="utils.jsp?page=beforeUserPost&parm=${param.parm}">他的帖子</a>
                </li>
            </ul>
        </div>
        <div class="col-md-10">

            <div>
                <h3>他的资源</h3>
            </div>

            <div class="panel panel-default ">
                <div class="container-fluid">
                    <div style="margin: 20px">
                        <form class=" form-inline" action="ouser_resource?user_id=" method="GET" id="form-search">
                            <span>&nbsp &nbsp &nbsp &nbsp &nbsp </span>
                            <input type="text" class="form-control" placeholder="关键词" name="query" id="query"
                                   value="${query}">
                            <span>&nbsp &nbsp </span>
                            <label class="form-inline">资源类别</label>
                            <select id="resource_cid" class="form-control" name="resource_cid">
                                <option value="-1">全部</option>
                                <c:forEach var="category_i" items="${categories}">
                                    <option value="${category_i.category_id}">${category_i.category_name}</option>
                                </c:forEach>
                            </select>
                            <span> &nbsp </span>
                            <a id="search_btn" class="btn btn-info">搜索</a>
                        </form>

                        <div class="panel panel-default">
                            <ul class="list-group" id="resources">

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
    var value="${param.parm }";
    $(function () {
        //show_head();
        //show_left();
       show_resource1(1);


    });

    function show_resource1(pn) {
        $.ajax({
            url:"<%request.getContextPath();%>/resource/getSomeOneResource",
            data:"pn="+pn+"&uid="+value,
            type:"GET",
            dataType:"json",
            success:function (result) {

                //console.log(result);
               show_resource(result);

                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }
    /*function show_head() {
        var head1=$("<li></li>").addClass("active").append("用户资源");
        var head2=$("<li></li>").append(value).append("的资源");
        var head0=("<ul></ul>").addClass("breadcrumb");
        head0.append(head1).append(head2).appendTo("#head");
    }
    function show_left() {
        var left1=$("<h3></h3>").append("他的主页");
        var left2 =$("<a></a>").addClass("list-group-item ").append("他的信息");
        left2.append($("<li style=\"display:block\"></li>"));
        var left3 =$("<a></a>").addClass("list-group-item active").append("他的资源");
        left3.append($("<li style=\"display:block\"></li>"));
        var left4 = $("<a></a>").addClass("list-group-item ").append("他的帖子");
        left4.append($("<li style=\"display:block\"></li>"));
        var left0=$("<ul ></ul>").addClass("clearfix");
        left0.append(left1).append(left2).append(left3).append(left4).appendTo("#left");
    }*/
    function show_resource(result) {
        $("#resources").empty();
        var res = result.extend.pageInfo.list;
        $.each(res,function (index,item) {
            var center1 = $("<a href=\'<%request.getContextPath();%>/resource/getResourceById?rid="+item.resourceId+"\'></a>").addClass("list-group-item");
            var center2 = $("<h4></h4>").addClass("list-group-item-heading").append(item.resourceName);
            var center;
            if(item.user.userLevel=="学生"){
                center= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: #c7ddef;color: blue\"></sup>").append("学生");

            }else{
                center= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: gray;color: yellow\"></sup>").append("教师");

            }
            center2.append(center);
            if(item.resourceGood=="1"){
                var center3_3 = $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: pink;color: red\"></sup>").append("优质");
                center2.append(center3_3);
            }
            var center4 = $("<h6 style=\"overflow: hidden;text-overflow: ellipsis\"></h6>").addClass("text").append(item.resourceDesc);
            var center5 = $("<span></span>").addClass("muted glyphicon glyphicon-user").append(item.user.userId);
            var center6 = $("<span></span>").addClass("text").append("资源类别：").append(item.categoryKey.categoryName);
            var center7 = $("<span></span>").addClass("text").append("资源等级：").append(item.resourceLevel);
            var time = timeStamp2String(item.resourceTime);
            var center8 = $("<span></span>").addClass("muted glyphicon glyphicon-time").append(time);

            center2.append(center4);
            center1.append(center2).append(center5).append(center6).append(center7).append(center8);
            center1.appendTo("#resources");

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
                show_resource1(1);
            });
            prePageLi.click(function(){
                show_resource1(result.extend.pageInfo.pageNum -1);
            });
        }



        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                show_resource1(result.extend.pageInfo.pageNum +1);
            });
            lastPageLi.click(function(){
                show_resource1(result.extend.pageInfo.pages);
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
                show_resource1(item);
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
