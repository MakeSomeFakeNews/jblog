package cn.jblog.mvc.admin;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.ehcache.CacheKit;

public class AdminInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		String user = CacheKit.get("userCache", "userId");
		if (!StrKit.isBlank(user)) {
			inv.invoke();
		} else {
			c.render("/admin/page/login/login.html");
		}
	}

}
