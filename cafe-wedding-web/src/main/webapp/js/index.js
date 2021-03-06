$(function(){
	
	//初始化ui-layout
	var indexUIOptions = {
			applyDefaultStyles : false,
			initClosed : true,
			west__initClosed : false,
			north__initClosed : true,
			north__resizable : false,
			togglerTip_closed : "隐藏面板",
			togglerTip_open : "打开面板",
			resizerTip : "拉伸",
			north__size : 100,
			west__size : 200,
			west__minSize : 200,
			west__maxSize : 300
		};

	$('body').layout(indexUIOptions);
	
	//初始化中间的tabs
	var tabCloseMethod=function($li){
		//console.log($li)
		$this=$li;
		var $close=$this.children("i").eq(0);
		var $a=$this.children("a").eq(0);
		var href_id=$a.attr("href");
		 $close.click(function(e){
			 console.log($("a[href='"+href_id+"']"))
			 $("a[href='"+href_id+"']").remove();
			 $(href_id).remove();
			 $close.css({"display":"none"});
			 $("a[href='#home']").tab("show");
		 });
		 $a.on("show.bs.tab",function(){
			 $close.css({"display":"block"});
		 });
		 $a.on("hide.bs.tab",function(){
			 $close.css({"display":"none"});
		 });
	}
	$(".center-tabs > li").each(function(e){
		tabCloseMethod($(this));
	});
	
	//初始化leftmenu
	var loadCenterPane=function(url,$container){
		$.ajax({
			type:"GET",
			url:url,
			data:null,
			crossDomain:true,
			success:function(data){
				$container.html(data);
			}
		});
	}
	var index=0;
	$(".leftmenu > li").each(function(i){
		var $this=$(this);
		var $first=$this.children("div").eq(0);
		var $second_ul=$this.find("ul");
		var $second_ul_li=$this.find("li");
		$.each($second_ul_li,function(){
			var k=index++;
			$this_li=$(this);
			var url=$this_li.attr("id");
			var tab_name=$this_li.text();
			$this_li.click(function(){
				if($("#tab"+k).length==0){
					var  tab_li="<li role='presentation'><a href='#tab"+k+"' data-toggle='tab'>"+tab_name+"</a><i class='glyphicon glyphicon-remove'></i></li>";
					var tab_content="<div role='tabpanel' class='tab-pane fade' id='tab"+k+"'>"+""+"</div>";
					$(tab_li).appendTo(".center-tabs");
					$(tab_content).appendTo(".tab-content");
					tabCloseMethod($("a[href='#tab"+k+"']").parent());
					$("a[href='#tab"+k+"']").tab("show");
					
					loadCenterPane(url,$("#tab"+k));
					
				}else{
					$("a[href='#tab"+k+"']").tab("show");
				}
				
			});
			
			$this_li.hover(function(){
				$(this).addClass("activeli");
			},function(){
				$(this).removeClass("activeli");
			});
			
		});
		$second_ul.css({"display":"none"});
		$first.click(function(){
			$(".leftmenu > li").each(function(i){
				$(this).removeClass("active_block");
				$(this).children("ul").css({"display":"none"});
			});
			$second_ul.slideDown()
			$this.addClass("active_block");
		});
	});	
		
})
