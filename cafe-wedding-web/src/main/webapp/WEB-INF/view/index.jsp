<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../common/head.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function () {
	var indexUIOptions={
			applyDefaultStyles: true,
			initClosed:true,
			west__initClosed: false,
			north__initClosed: false,
			north__resizable:false
	};
	
	$('body').layout(indexUIOptions);
});
</script>
</head>
<body>
<div class="ui-layout-center">Center</div>
<div class="ui-layout-north">North</div>
<div class="ui-layout-south">South</div>
<div class="ui-layout-east">East</div>
<div class="ui-layout-west">West</div>

</body>
</html>