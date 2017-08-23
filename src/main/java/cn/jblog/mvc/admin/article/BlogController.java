package cn.jblog.mvc.admin.article;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;

import cn.jblog.common.model.ArtType;
import cn.jblog.common.model.Blog;
import cn.jblog.mvc.admin.BaseController;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月23日 下午10:57:44 类说明
 */
public class BlogController extends BaseController {
	static BlogService service = BlogService.me;

	public void index() {
		List<Record> articleList = service.getArticleList();
		setAttr("article", articleList);
		render("newsList.html");
	}

	public void addArticlePage() {
		List<ArtType> artType = service.getArtType();
		setAttr("type", artType);
		String userId = getSessionAttr("userId");
		Integer id = service.getUserId(userId);
		setAttr("user_id", id);
		render("newsAdd.html");
	}

	public void addArticle() {
		Blog blog = getModel(Blog.class);
		boolean save = blog.save();
		if (save) {
			renderSuccess();
			return;
		}
		renderError();
	}
	
	public void getAtricleList() {
		List<Record> articleList = service.getArticleList();
		setAttr("article", articleList);
		render("newsList.html");
	}
}
