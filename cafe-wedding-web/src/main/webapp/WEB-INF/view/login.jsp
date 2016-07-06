<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../common/head.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-4">
			<form class="form-horizontal" action="/sys/login/login" method="POST">
			  <div class="form-group">
			    <label for=""username"" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-10">
			      <input type="username" class="form-control" id=""username"" name="username" placeholder="用户名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="password" name="password" placeholder="密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> 记住我们
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">登入</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>

</body>
</html>