package cn.jblog.common.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("art_stat", "tid", ArtStat.class);
		arp.addMapping("art_type", "id", ArtType.class);
		arp.addMapping("blog", "tid", Blog.class);
		arp.addMapping("user", "user_id", User.class);
		arp.addMapping("user_info", "user_id", UserInfo.class);
	}
}

