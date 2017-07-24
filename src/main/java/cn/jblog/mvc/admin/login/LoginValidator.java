package cn.jblog.mvc.admin.login;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("username", "nameMsg", "请输入用户名");
		validateRequiredString("password", "passMsg", "请输入密码");
	}

	@Override
	protected void handleError(Controller c) {
		c.render("login.html");
	}

}
