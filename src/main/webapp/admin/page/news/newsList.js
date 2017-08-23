layui.config({
	base : "/admin/js/"
}).use(['form','layer','jquery','laypage','table'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery,
		table = layui.table;
	
	
	table.on('tool(article)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值
		  var tr = obj.tr; //获得当前行 tr 的DOM对象
		 
		  if(layEvent === 'detail'){ //查看
		    console.log(obj.data.tid);
		  } else if(layEvent === 'del'){ //删除
		    layer.confirm('真的删除行么', function(index){
		      obj.del(); //删除对应行（tr）的DOM结构
		      layer.close(index);
		      //向服务端发送删除指令
		    });
		  } else if(layEvent === 'edit'){ //编辑
		    //do something
		    
		    //同步更新缓存对应的值
		    obj.update({
		      username: '123'
		      ,title: 'xxx'
		    });
		  }
	});
	
	//添加文章
	//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
	$(window).one("resize",function(){
		$(".newsAdd_btn").click(function(){
			var index = layui.layer.open({
				title : "添加文章",
				type : 2,
				content : "/admin/article/addArticlePage",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
			layui.layer.full(index);
		})
	}).resize();
})
