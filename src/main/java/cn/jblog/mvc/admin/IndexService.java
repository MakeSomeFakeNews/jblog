package cn.jblog.mvc.admin;

import cn.jblog.common.model.User;

public class IndexService {
	public User getUser(String user) {
		return User.dao.findFirst("select * from user where username=?", user);
	}
}
