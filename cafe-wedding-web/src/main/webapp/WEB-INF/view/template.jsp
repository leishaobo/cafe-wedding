<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"  %>

<!-- 分页模板 -->	
<script id="pager_template" type="text/html">
{{if is_first}}
<li class="disabled">
	<a href="#" aria-label="上一页">
  		<span aria-hidden="true">&laquo;</span>
	</a>
</li>
{{else}}
<li>
	<a href="#{{:page-1}}" aria-label="上一页">
  		<span aria-hidden="true">&laquo;</span>
	</a>
</li>
{{/if}}

<$ var end_num=page+2; for(var i=page-2;i<=end_num;i++){
	if(i<0 || i>(total_page-1)){
		if(i<0){
        	++end_num;
		}
		continue;

	}
 $>
	<li <$ if(i==page){ $>class="active"<$ } $> ><a href="#<$=i $>"><$=(i+1)$></a></li>
<$ } $>

{{if is_last}}
<li class="disabled" >
<a href="#" aria-label="下一页" >
  <span aria-hidden="true">&raquo;</span>
</a>
</li>
{{else}}
<li>
<a href="#{{:page+1}}" aria-label="下一页" >
  <span aria-hidden="true">&raquo;</span>
</a>
</li>
{{/if}}
</script>

<script type="text/html" id="sys_error_template" >
<div class="alert alert-warning alert-dismissible" role="alert">
<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
<strong >系统异常：</strong>code:<$=status $>,info:<$=statusText$>
</div>
</script>
