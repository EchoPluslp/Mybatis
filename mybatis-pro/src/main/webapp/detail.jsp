<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
%>
<head>
<title>用户信息管理中心</title>
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
				</p>
			</div>
			<c:set var="user" value="${user }"></c:set>
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<form class="form-horizontal" action="<%=path%>/updateusers">
						<input type="hidden" name="id" value="${user.id }">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户账号</label>
							<div class="col-sm-10">
								<%-- 								<p class="form-control-static">${user.username }</p>--%>
								<p class="form-control-static">${user.name }</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">登陆密码</label>
							<div class="col-sm-10">
								<p class="form-control-static">******</p>
							</div>
						</div>
						<div class="form-group">
							<label for="nickname" class="col-sm-2 control-label">昵称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nickname"
									name="nickname" placeholder="请输入昵称" value="${user.nickname }">
							</div>
						</div>
						<div class="form-group">
							<label for="age" class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="age" name="age"
									placeholder="请输入年龄" value="${user.age }">
							</div>
						</div>
						<div class="form-group">
							<label for="gender" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="gender"
									name="gender" placeholder="请输入性别" value="${user.gender }">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">联系方式</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phone" name="phone"
									placeholder="请输入联系方式" value="${user.phone }">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="请输入邮箱" value="${user.email }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">账号创建时间</label>
							<div class="col-sm-10">
								<p class="form-control-static">
									<fmt:formatDate value="${user.createTime }"
										pattern="yyyy-MM-dd" />
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">最后修改时间</label>
							<div class="col-sm-10">
								<p class="form-control-static">
									<fmt:formatDate value="${user.updateTime }"
										pattern="yyyy-MM-dd" />
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">最后登陆时间</label>
							<div class="col-sm-10">
								<p class="form-control-static">
									<fmt:formatDate value="${user.lastLogin }" pattern="yyyy-MM-dd" />
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">用户状态</label>
							<div class="col-sm-10">
								<c:if test="${user.userStatus==0}">
									<p class="form-control-static">正常</p>
								</c:if>
								<c:if test="${user.userStatus==1}">
									<p class="form-control-static">锁定</p>
								</c:if>
								<c:if test="${user.userStatus==2}">
									<p class="form-control-static">删除</p>
								</c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="remark" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="remark"
									name="remark" placeholder="请输入备注" value="${user.remark }">
							</div>
						</div>
						<div class="row">
							<table class="table table-striped">
								<tr>
									<th>地区编号</th>
									<th>国家</th>
									<th>省</th>
									<th>市</th>
									<th>县</th>
									<th>街道</th>
									<th>详细地址</th>
									<th>是否默认</th>
								</tr>
									<c:forEach var="address" items="${user.address }">
								<tr>
										<th>${address.id }</th>
										<th>${address.nation }</th>
										<th>${address.province }</th>
										<th>${address.city }</th>
										<th>${address.country }</th>
										<th>${address.street }</th>
										<th>${address.remark }</th>
										<c:if test="${address.defaultAddr==1 }">
											<th>默认地址</th>
										</c:if>
										<c:if test="${address.defaultAddr==0 }">
											<th>*****</th>
										</c:if>
								</tr>
								</c:forEach>
							</table>
						</div>
						<div class="form-group">
							<input type="submit" value="提交数据更新" class="btn btn-primary">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
