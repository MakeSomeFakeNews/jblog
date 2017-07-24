package cn.jblog.mvc.admin;

import cn.jblog.common.model.User;

public class IndexService {
	public User getUser(String user) {
		return User.dao.findFirstByCache("userCache", user, "select * from user where username=?", user);
	}
}
