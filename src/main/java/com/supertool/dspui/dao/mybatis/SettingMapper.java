package com.supertool.dspui.dao.mybatis;

import com.supertool.dspui.model.Setting;

public interface SettingMapper {
	
	public Setting getSetting(int dspid);
	
	public int updateSetting(Setting setting);

	public int insert(Setting setting);
}
