<%--
  Created by IntelliJ IDEA.
  User: zhangwenyu
  Date: 2019/8/4
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("utf-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
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
    <div>
        <ul class="breadcrumb">
            <li class="active">
                其他操作
            </li>
            <li>
                查找用户
            </li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-1"></div>

        <div class="col-md-10">

            <div class="panel panel-default ">
                <div class="container-fluid">
                    <div style="margin: 20px">
                        <form id="form-search" class="navbar-form" >
                            <%--<input type="hidden" name="page" id="page"  value="${empty pagination.curPage ? 1 : pagination.curPage }">--%>
                            <div class="input-group">
                                <input id="keyword" type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字"
                                       maxlength="15"
                                       autocomplete="off">
                                <span class="input-group-btn">
									<button class="btn btn-default btn-search" id="search_btn" type="button">搜索</button>
								</span>
                            </div>
                        </form>
                        <div class="panel panel-default">
                            <ul class="list-group" id="show_user">

                            </ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">

    $(function () {
        var flag = $("#show_user").val();
        if(flag == null){
            return false;
        }else{
            var name = "${param.parm}";
            show_users(name);
        }
    });
    
    function show_users(name) {
        $("#keyword").append(name).attr("value",name);
        $.ajax({
            url:"<%request.getContextPath();%>/user/findUser",
            data:"userId="+name,
            type:"GET",
            success:function (result) {
                console.log(result);
                $("#show_user").empty();
                if(result.codel==100){
                    var message = result.extend.list;
                    showUser_message(message);
                }else{
                     $("#show_user").append("未找到与 "+name+" 有关的用户！");

                }
            }
            
            
        });
        
        
        function showUser_message(user) {
            $.each(user,function (index,item) {
                var center1 = $("<a href=\"user/getUserById?uid="+item.uId+"&tag=0\"></a>").addClass("list-group-item");
                var center2 = $("<h4></h4>").append(item.uName);
                var center2_1 ;
                if(item.uLevel=='学生'){
                    center2_1= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: #c7ddef;color: blue\"></sup>").append("学生");
                }else {
                    center2_1= $("<sup style=\"border-radius: 5px;font-size: 1px;background-color: gray;color: yellow\"></sup>").append("教师");
                }
                var center3;
                if(item.uDesc==null){
                    center3 = $("<span style=\"margin-left: 30px;margin-right: 20px;font-size: small;text-align: center\"></span>").append("这个人很懒，什么也没留下！");
                }else{
                    center3 = $("<span style=\"margin-left: 30px;margin-right: 20px;font-size: small;text-align: center\"></span>").append(item.uDesc);
                }

                center2.append(center2_1).append(center3);
                center1.append(center2);
                center1.appendTo("#show_user");
            });
        }

    }


    $(document).on("click","#search_btn",function () {
        var name = $("#keyword").val();
        if(name == ""){
            return false;
        }
        show_users(name);
    });

</script>
</body>
</html>
