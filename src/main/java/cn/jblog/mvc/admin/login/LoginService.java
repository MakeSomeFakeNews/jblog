package cn.jblog.mvc.admin.login;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import cn.jblog.common.model.User;
import cn.jblog.utils.PasswordUtil;

public class LoginService {
	public boolean verifyPassword(User user) {
		String encodePassword = PasswordUtil.encodePassword(user.getPassword());
		Record u = Db.findFirst("select * from user where username=?", user.getUsername());
		String userpassword = u.getStr("password");
		return userpassword.equals(encodePassword);
	}
}
