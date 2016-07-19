$(function(){
	//定义查询列表
	var urlList={
			list:"/sys/user/findAll"
	}

	//定义分页
	var pager=$.extend(true,{},$.cafe.defaultPage);
	//定义查询参数
	var queryParams={
			
	};
	//处理异常
	var errorHandler=function(e){
		var message={
				status:	e.status,
				statusText:e.statusText
		}
		var errorhtml=$.cafe.renderTemplate("sys_error_template",message);
		$("#sys_user_error").html(errorhtml);
		
	}
	//渲染列表页面
	var renderList=function(data){
		var listhtml=$.cafe.renderTemplate("sys_user_list_template",data);
		$("#sys_user_list_data tr").each(function(i){
			if(i!=0) $(this).remove();
		});
		$("#sys_user_list_data tbody").append(listhtml);
		
		var pager_id="sys_user_list_pager";
		pager=$.cafe.parsePager(data);
		var pagerhtml=$.cafe.renderTemplate("pager_template",pager);
		$("#"+pager_id).html(pagerhtml);
		acitivePagerClickEvent(pager_id);
		
	};
	//重新渲染页面后，page点击事件需要重新激活
	var acitivePagerClickEvent=function(pager_id){
		$("#"+pager_id+" > li >a").each(function(){
			$this=$(this);
			var page=$this.attr("href").replace(/#/g,"");
			$this.click(function(){
				pager.page=page;
				$.cafe.fetchRemoteWithGet(urlList.list,queryParams,pager,renderList,errorHandler);
			});
		});
	}
	
	$.cafe.fetchRemoteWithGet(urlList.list,queryParams,pager,renderList,errorHandler);
	
});