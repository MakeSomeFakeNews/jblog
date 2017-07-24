package cn.jblog.route;

import com.jfinal.config.Routes;

import cn.jblog.mvc.admin.AdminInterceptor;
import cn.jblog.mvc.admin.IndexController;
import cn.jblog.mvc.admin.article.BlogController;
import cn.jblog.mvc.admin.login.LoginController;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月23日 下午10:59:34 类说明
 */
public class AdminRoutes extends Routes {

	@Override
	public void config() {
		setBaseViewPath("/admin/");
		addInterceptor(new AdminInterceptor());
		add("/admin", IndexController.class, "/");
		add("/admin/article", BlogController.class, "/page/news");
		add("/admin/login", LoginController.class, "/page/login");
	}

}
