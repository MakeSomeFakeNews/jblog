package cn.jblog.mvc.admin;

import com.jfinal.core.Controller;

import cn.jblog.mvc.vo.Ret;

/** 
* @author 作者 E-mail: 1239181712@qq.com
* @version 创建时间：2017年7月23日 下午10:58:09 
* 类说明 
*/
public class BaseController extends Controller {
	public void renderSuccess(){
		renderJson(new Ret(1,null));
	}
	public void renderError(){
		renderJson(new Ret(1,null));
	}
	public void renderError(String msg){
		renderJson(new Ret(0,msg));
	}
}
 