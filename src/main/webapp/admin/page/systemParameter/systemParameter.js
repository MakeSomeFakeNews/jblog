layui.config({
	base : "/admin/js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

 	var systemParameter;
 	form.on("submit(systemParameter)",function(data){
 		$.ajax({
			url : "../../json/systemParameter.json",
			type : "get",
			dataType : "json",
			success : function(data){
				var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
	            layer.close(index);
				layer.msg("系统基本参数修改成功！");
			}
		})
		return false;
 	})


})
