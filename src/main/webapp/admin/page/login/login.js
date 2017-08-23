layui.config({
	base : "/resource/lay/modules/"
}).use(['form','layer'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
	//登录按钮事件
	form.on("submit(login)",function(data){
		$.post('/admin/login/login',data.field,function(res){
 			var index = layer.msg('登录中，请稍候',{icon: 16,time:false,shade:0.8});
 			if (res.state==1) {
 	 	 		window.location.href = "/admin/";
			}else{
				$(".codes").attr("src","/admin/login/getVerifyCode?"+ Math.random());
				top.layer.msg("登录失败！"+res.msg);
			}
 		});
		return false;
	})
})
