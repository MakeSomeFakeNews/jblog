layui.config({
	base : "/admin/js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	//创建一个编辑器
 	var editIndex = layedit.build('news_content');
 	var addNewsArray = [],addNews;
 	form.on("submit(addNews)",function(data){
 		$.post('/admin/article/addArticle',data.field,function(res){
 			var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 			if (res.state==1) {
 				top.layer.close(index);
 	 			top.layer.msg("文章添加成功！");
 	  			layer.closeAll("iframe");
 	 	 		parent.location.reload();
			}else{
				top.layer.msg("文章添加失败！");
			}
 		});
 		return false;
 	})
	
})
