package com.supertool.dspui.dao.mybatis;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.service.AdvertiserService;
import com.supertool.dspui.vo.ResultVO;

public class TestAdvertiserService {

	private static ApplicationContext context=null;
	private  AdvertiserService advertiserService = (AdvertiserService) context.getBean("advertiserService");
	@BeforeClass
	public static void initContext() {
		context=new ClassPathXmlApplicationContext("context-web.xml");
		
	}
	
	public void test(){
		testCreate();
	}
	
	public void testCreate(){
		Advertiser advertiser  = new Advertiser();
		advertiser.setName("junit test");
		advertiser.setDescription("description");
		advertiser.setDspId(1114);
		ResultVO resultVO = advertiserService.create(advertiser );
		assert(resultVO.getResultCode() == 0);
	}
}
