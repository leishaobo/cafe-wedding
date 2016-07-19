<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../../common/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/sys/user.js"></script>
<div id="sys_user_error">

</div>
<div class="panel panel-success">
  <div class="panel-heading">
    <h3 class="panel-title">用户列表</h3>
  </div>
  <div class="panel-body">
   
  </div>
  <table class="table table-hover" id="sys_user_list_data">
    <tr>
    	<th>ID</th>
    	<th>用户名</th>
    	<th>昵称</th>
    	<th>真实姓名</th>
    	<th>qq</th>
    	<th>email</th>
    	<th>电话</th>
    </tr>
  </table>
  <div class="panel-footer">
	<ul class="pagination" id="sys_user_list_pager"></ul>
  </div>
</div>
<script id="sys_user_list_template" type="text/jsrender">
{{for content}}
   <tr>
    	<td>{{:id }}</th>
    	<td>{{:username}}</th>
    	<td>{{:nickname}}</th>
    	<td>{{:realname}}</th>
		<td>{{:qq }}</th>
		<td>{{:email}}</th>
		<td>{{:phone}}</th>
    </tr>
{{/for}}
</script>