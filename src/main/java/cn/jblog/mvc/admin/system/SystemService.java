package cn.jblog.mvc.admin.system;

import cn.jblog.common.model.SysConfig;

public class SystemService {
	public static final SystemService me = new SystemService();
	final static SysConfig dao = new SysConfig().dao();

	public SysConfig getSysconf() {
		return dao.findFirst("select * from sys_config");
	}
}
