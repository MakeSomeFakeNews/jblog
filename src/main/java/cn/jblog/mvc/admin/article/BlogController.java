package cn.jblog.mvc.admin.article;

import java.util.List;

import cn.jblog.common.model.ArtType;
import cn.jblog.common.model.Blog;
import cn.jblog.mvc.admin.BaseController;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月23日 下午10:57:44 类说明
 */
public class BlogController extends BaseController {
	public void index() {
		render("newsList.html");
	}

	public void addArticlePage() {
		BlogService service = new BlogService();
		List<ArtType> artType = service.getArtType();
		setAttr("type", artType);
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
}
