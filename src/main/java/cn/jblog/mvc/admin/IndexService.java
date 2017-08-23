package cn.jblog.mvc.admin;

import cn.jblog.common.model.User;

public class IndexService {
	public final static IndexService me = new IndexService();
	private User dao = new User().dao();

	public User getUser(String user) {
		return dao.findFirst("select * from user where username=?", user);
	}
}
