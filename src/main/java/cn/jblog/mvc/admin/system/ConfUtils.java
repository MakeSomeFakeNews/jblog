package cn.jblog.mvc.admin.system;

import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;

public class ConfUtils {
	private static Record sys = null;
	public static String title() {
		sys =CacheKit.get("sysCache", "sys");
		return sys.getStr("title");
	}

	public static String author() {
		sys =CacheKit.get("sysCache", "sys");
		return sys.getStr("author");
	}

	public static String keywords() {
		sys =CacheKit.get("sysCache", "sys");
		return sys.getStr("keywords");
	}

	public static String powerby() {
		sys =CacheKit.get("sysCache", "sys");
		return sys.getStr("powerby");
	}

	public static String description() {
		sys =CacheKit.get("sysCache", "sys");
		return sys.getStr("description");
	}

	public static String record() {
		sys =CacheKit.get("sysCache", "sys");
		return sys.getStr("record");
	}
}
