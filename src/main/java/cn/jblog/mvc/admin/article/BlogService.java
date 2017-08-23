package cn.jblog.mvc.admin.article;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import cn.jblog.common.model.ArtType;
import cn.jblog.common.model.User;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月24日 上午3:51:22 类说明
 */
public class BlogService {
	public static final BlogService me = new BlogService();
	private final static ArtType dao = new ArtType().dao();
	private final static User userDao = new User();

	public List<ArtType> getArtType() {
		List<ArtType> list = dao.find("select * from art_type");
		return list;
	}

	public Integer getUserId(String user) {
		User user2 = userDao.findFirst("select user_id from user where username = ?", user);
		return user2.getUserId();
	}

	public List<Record> getArticleList() {
		List<Record> record = Db.find(
				"select * from (blog left join `user` on blog.user_id = `user`.user_id)LEFT JOIN art_type ON blog.type=art_type.id");
		return record;
	}
}
