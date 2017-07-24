package cn.jblog.mvc.admin;

import cn.jblog.common.model.User;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月23日 下午10:55:11 类说明
 */
public class IndexController extends BaseController {
	public void index() {
		IndexService service = new IndexService();
		User user = service.getUser(getSessionAttr("userId").toString());
		setAttr("user", user);
		render("index.html");
	}

	public void main() {
		render("page/main.html");
	}

	public void upload() {

		renderJsp("utf8-jsp/jsp/controller.jsp");

	}
}
