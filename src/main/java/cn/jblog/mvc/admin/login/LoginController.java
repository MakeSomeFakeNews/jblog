package cn.jblog.mvc.admin.login;

import com.jfinal.aop.Clear;
import com.jfinal.plugin.ehcache.CacheKit;

import cn.jblog.common.model.User;
import cn.jblog.mvc.admin.BaseController;

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
				CacheKit.put("userCache", "userId", user.getUsername());
				renderSuccess();
				return;
			}
			renderError("账号或密码错误！！");
			return;
		}
		renderError("验证码错误！");
	}
}
