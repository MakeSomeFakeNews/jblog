package cn.jblog.mvc.admin.login;

import com.jfinal.aop.Clear;
import com.jfinal.plugin.ehcache.CacheKit;

import cn.jblog.common.model.User;
import cn.jblog.mvc.admin.BaseController;
import cn.jblog.utils.EncodeUtil;

@Clear
public class LoginController extends BaseController {
	public void index() {
		render("login.html");
	}

	// 获得图像验证码
	public void getVerifyCode() {
		renderCaptcha();
	}

	public void login() {
		boolean result = validateCaptcha("code");
		System.out.println(result);
		if (result) {
			LoginService service = new LoginService();
			User user = getModel(User.class);
			if (service.verifyPassword(user)) {
				setSessionAttr("userId", user.getUsername());
				renderSuccess();
				return;
			}
			renderError("账号或密码错误！！");
			return;
		}
		renderError("验证码错误！");
	}

	public void setUserSession(String user_name) {
		String key = EncodeUtil.convert(user_name);
		// 设置一个cookie，有效时间 一天
		setCookie("uuid", key, 86400);
		CacheKit.put("userCache", key, user_name);
	}
}
