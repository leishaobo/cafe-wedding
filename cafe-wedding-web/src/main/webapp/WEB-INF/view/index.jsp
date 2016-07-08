<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../common/head.jsp"></jsp:include>
<script type="text/javascript">
	
</script>
<style type="text/css">
</style>
</head>
<body>
	<div class="ui-layout-north">
		<div class="container-fluid"></div>
	</div>
	<div class="ui-layout-west">
		<div class="container-fluid menu-container">
			<div class="row">
				<div class="col-md-12">
					<ul class="leftmenu">
						<li class="active_block">
							<div class="center-block">
								<img src="${ctx}/res/leftmenu/syetem_management.png" /><span>系统管理</span><i
									class="glyphicon glyphicon-chevron-right pull-right"></i>
							</div>
							<ul>
								<li id="www.baidu.com">用户管理</li>
								<li id="www.baidu.com">资源管理</li>
								<li id="www.baidu.com">角色管理</li>
							</ul>
						</li>
						<li>
							<div>
								<img src="${ctx}/res/leftmenu/custom.png" /><span>客户管理</span><i
									class="glyphicon glyphicon-chevron-right pull-right"></i>
							</div>
							<ul>
								<li id="www.baidu.com">客户管理</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="ui-layout-center">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-tabs center-tabs">
						<li role="presentation" class="active"><a href="#home" data-toggle="tab">概览</a></li>
						<li role="presentation"><a href="#user"  data-toggle="tab" >用户管理</a><i class="glyphicon glyphicon-remove"></i></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="home">...</div>
						<div role="tabpanel" class="tab-pane fade" id="user">...</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="ui-layout-south">South</div>
	<div class="ui-layout-east">East</div>
</body>
</html>