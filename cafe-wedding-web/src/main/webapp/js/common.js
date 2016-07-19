$.cafe={
   //模板文件
  templateMap:{
	  
  },
  //根据模板id,获取渲染后页面
  renderTemplate:function(temp_id,data){
	  if(this.templateMap[temp_id]==null){
		  this.templateMap[temp_id]=$.templates(temp_id);
	  }
	  return this.templateMap[temp_id].render(data);
  },
  //定义默认分页
  defaultPage:{
	  page:0,
	  size:8,
	  total:0,
	  total_page:0,
	  is_first:true,//是否是第一页
	  is_last:false //是否是最后一页
  },
  //解析远程数据的分页部分
  parsePager:function(data){
		var pager={
				
		};
		pager.page=data.pageable.page;
		pager.size=data.pageable.size;
		pager.total=data.total;
		pager.total_page=pager.total%pager.size==0?pager.total/pager.size:pager.total%pager.size+1;
		pager.is_first=pager.page==0?true:false;
		pager.is_last=pager.page==(pager.total_page-1)?true:false;
		return pager;
  },
  //从远程服务器抓取数据
  fetchRemoteWithGet:function(url,queryParams,pager,callback,errorHandler){
	  queryParams.page=pager.page;
	  queryParams.size=pager.size;
	  
	  $.ajax({
		  method:"GET",
		  url:url,
		  data:queryParams,
		  success:function(data){
			  callback(data);
		  },
		  error:function(e){
			  if(errorHandler==null || errorHandler=='undefined'){
				  console.log(e);
			  }else{
				  errorHandler(e);  
			  }
		  }
	  });
  }
	
};
