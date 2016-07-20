<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cafe-wedding</title>
<jsp:include page="./common/head.jsp"></jsp:include>
</head>
<body>
<!-- 所有页面的容器 -->
<div class="container" style="width: 1200px !important; ">
	<!-- 顶部top -->
	<div class="row top">
		<div class="col-xs-12">
			<div class="pull-left">
				<a href="#">全国</a>
			</div>
			<div class="pull-right">
				<a href="#">登入</a>
				<a href="#">注册</a>
				<a href="#">登入商城</a>
			</div>
		</div>
		<div class="line"></div>
	</div>
	<!-- /(.top)顶部top -->
	<!-- 顶部head -->
	<div class="row head">
		<div class="col-xs-3">
			log
		</div>
		<div class="col-xs-6 seach">
			<div class="input-group input-group-lg">
		      <input type="text" class="form-control" placeholder="Search for...">
		      <span class="input-group-btn">
		        <button class="btn btn-success btn-lg" type="button">搜索</button>
		      </span>
		    </div>
		</div>
		<div class="col-xs-3">
			phone
		</div>
	</div>
	<!-- /(.head)顶部head -->
</div>
<!-- /(.container)所有页面的容器 -->
</body>
</html>