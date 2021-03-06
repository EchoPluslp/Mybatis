<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
%>
<title>用户信息管理中心</title>
<!-- <link type="text/css" href="/mybatis-pro/src/main/webapp/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<script type="text/javascript" src="/mybatis-pro/src/main/webapp/lib/2.2.4/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/mybatis-pro/src/main/webapp/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header">
				<h1>
					信息后台管理系统 <small>用户数据管理中心</small>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="jumbotron">
				<h1>Hello, world!</h1>
				<p>哈哈哈哈哈哈哈</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more</a>
						<a class="btn btn-primary btn-lg" href="<%=path %>/addusers.jsp" role="button">新增用户</a>
				</p>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover table-striped">
				<tr>
					<th>用户编号</th>
					<th>登陆账号</th>
					<th>用户昵称</th>
					<th>邮箱</th>
					<th>联系方式</th>
					<th>账号创建时间</th>
					<th>用户状态</th>
					<th>操作</th>
				</tr>
				 <c:forEach items="${userLists}" var="user">
					<tr>
						<td>${user.id}</td>
<%-- 						<td>${user.username }</td>
 --%>					
 						<td>${user.name }</td>	
 						<td>${user.nickname }</td>
						<td>${user.email}</td>
						<td>${user.phone }</td>
						<td><fmt:formatDate value="${user.createTime }"
										pattern="yyyy-MM-dd" /></td>
						<%-- <td>${user.createTime })</td> --%>
						<c:if test="${user.userStatus==0 }">
							<td>正常</td>
						</c:if>
						<c:if test="${user.userStatus==1 }">
							<td>锁定</td>
						</c:if><c:if test="${user.userStatus==2 }">
							<td>删除</td>
						</c:if>
						<td>
						
						<a href="<%=path%>/detail?id=${user.id}">查看</a> 
						
						<c:if test="${user.userStatus==0 }">
						<a href="<%=path%>/deluser?id=${user.id }&type=lock">锁定</a> 
						</c:if>
						<c:if test="${user.userStatus==1 }">
						<a href="<%=path%>/deluser?id=${user.id }&type=unlock">解锁</a> 
						</c:if>
						
						<a href="<%=path%>/deluser?id=${user.id }&type=del">删除</a></td>
					</tr>
				</c:forEach> 
			</table>
		</div>
	</div>
</body>
</html>
