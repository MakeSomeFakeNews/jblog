package cn.jblog.mvc.admin.system;

import cn.jblog.common.model.SysConfig;

public class SystemService {
	public SysConfig getSysconf() {
		return SysConfig.dao.findFirst("select * from sys_config");
	}
}
