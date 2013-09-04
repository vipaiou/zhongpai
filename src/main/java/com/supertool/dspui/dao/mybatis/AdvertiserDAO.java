package com.supertool.dspui.dao.mybatis;

import java.util.List;

import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.param.SelectSQLParam;

public interface AdvertiserDAO {
	
	List<Advertiser> getAdvertiserList(SelectSQLParam params);
}
