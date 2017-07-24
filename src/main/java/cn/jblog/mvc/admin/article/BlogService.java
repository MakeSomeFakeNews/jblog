package cn.jblog.mvc.admin.article;

import java.util.List;

import cn.jblog.common.model.ArtType;

/**
 * @author 作者 E-mail: 1239181712@qq.com
 * @version 创建时间：2017年7月24日 上午3:51:22 类说明
 */
public class BlogService {
	public List<ArtType> getArtType() {
		List<ArtType> list = ArtType.dao.find("select * from art_type");
		return list;
	}
}
