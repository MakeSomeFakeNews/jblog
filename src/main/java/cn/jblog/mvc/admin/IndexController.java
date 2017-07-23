package cn.jblog.mvc.admin;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月23日 下午10:55:11 类说明
 */
public class IndexController extends BaseController {
	public void index() {
		render("index.html");
	}

	public void main() {
		render("page/main.html");
	}

	public void upload() {

		renderJsp("utf8-jsp/jsp/controller.jsp");

	}
}
