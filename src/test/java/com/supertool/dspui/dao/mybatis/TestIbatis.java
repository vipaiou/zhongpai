package com.supertool.dspui.dao.mybatis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.supertool.dspui.dao.mybatis.CampaignMapper;
import com.supertool.dspui.dao.mybatis.CreativeMapper;
import com.supertool.dspui.dao.mybatis.MaterialMapper;
import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.model.Material;
import com.supertool.dspui.model.Rtb;
import com.supertool.dspui.param.Params;
import com.supertool.dspui.param.SelectSQLParam;
import com.supertool.dspui.service.AdvertiserService;
import com.supertool.dspui.service.CampaignService;
import com.supertool.dspui.util.DateUtil;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.CampaignRow;




public class TestIbatis {
	
	private static ApplicationContext context=null;
	private  CampaignService campaignService = (CampaignService) context.getBean("campaignService");
	private  AdvertiserService advertiserService = (AdvertiserService) context.getBean("advertiserService");
	private  CampaignMapper campaignMapper = (CampaignMapper) context.getBean("campaignMapper");
	
	private  CreativeMapper creativeMapper = (CreativeMapper) context.getBean("creativeMapper");
	private  MaterialMapper materialMapper = (MaterialMapper) context.getBean("materialMapper");
	@BeforeClass
	public static void initContext() {
		context=new ClassPathXmlApplicationContext("context-web.xml");
		
	}
	//@Test
	public void getDataSource() throws SQLException {
		DataSource dataSource=(DataSource)context.getBean("dataSource");
		
		System.out.println(dataSource.getConnection());
	}


	public void getCampaignList() {
	
	}

	
	

	public void insertCampaign(){
		
	/*	CampaignParam campaignParam = new CampaignParam();
		campaignParam.setAdvertiserId("1");
		campaignParam.setBrand("asd");
		campaignParam.setDspId(1);
		campaignParam.setStart("2012-01-01 00:00:00");
		campaignParam.setEnd("2012-01-01 00:00:00");
		ResultVO vo =  campaignService.save(campaignParam);
		
		System.out.println("---"+vo.getResultCode());*/
		Campaign campaign =new Campaign();
		campaign.setStartTime(DateUtil.getDate(DateUtil.getDateFormatString(),"1970-01-01"));
		campaign.setEndTime(DateUtil.getDate(DateUtil.getDateFormatString(), "1970-01-01"));
		int n = campaignService.insertCampaign(campaign);
		System.out.println("---"+n);
		
	}
	public int getAdvertisers(){
		SelectSQLParam p =new SelectSQLParam();
		List<?> list =this.advertiserService.getPagedAdvertisers(p);
		return list==null ? -1: list.size();
	}
	public void javabean(){
		Campaign campaign = new Campaign();
		/*Method[] methods = campaign.getClass().getMethods();  
        for (int i = 0; i < methods.length; i++) {  
            Method method = methods[i];  
            if (method.getName().startsWith("get") && !method.getName().equalsIgnoreCase("getClass")&&!method.getName().equalsIgnoreCase("getSerialversionuid") ) {  
                try {  
                	System.out.println( method.getName()+":"+method.invoke(campaign));
                } catch (IllegalArgumentException e) {  
                    e.printStackTrace();  
               } catch (IllegalAccessException e) {  
                    e.printStackTrace();  
                } catch (InvocationTargetException e) {  
                    e.printStackTrace();  
                } 
            }  
        }*/
		 Field[] fieldlist = campaign.getClass().getDeclaredFields();
         for (int i = 0; i < fieldlist.length; i++) {
             Field fld = fieldlist[i];
             System.out.println( fld.getName());
            
             
             }
	}
	public void getAdvertiser(){
		Advertiser ad = this.campaignService.getAdvertiserById(1);
		if(null!=ad){
			System.out.println(ad.getName());
		}else{
			System.out.println("-------");
		}
	}
	public void getPagedCampaigns(){
	
		
	}
	public void  getRtbProgressNoStarted(){
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(0);
		ids.add(2);
		ids.add(20018);
		List<Integer> rtbs = this.campaignService.getRtbProgressNoStarted(ids);
		System.out.println(null==rtbs?-1:rtbs.size());
	}
	public void  getRtbProgressFinished(){
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(0);
		ids.add(2);
		ids.add(20018);
		List<Integer> rtbs = this.campaignService.getRtbProgressFinished(ids);
		System.out.println(null==rtbs?-1:rtbs.size());
	}
	public void  getRtbProgressPause(){
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(0);
		ids.add(2);
		ids.add(20018);
		List<Integer> rtbs = this.campaignService.getRtbProgressPause(ids);
		System.out.println(null==rtbs?-1:rtbs.size());
	}
	public void  getRtbProgressOverRun(){
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(0);
		ids.add(2);
		System.out.println(Utils.ListToStr(ids));
		ids.add(20018);
		List<Integer> rtbs = this.campaignService.getRtbProgressOverRun(ids);
		System.out.println(null==rtbs?-1:rtbs.size());
	}
	public void ListOpeartion(){
		List<Integer> ids1 = new LinkedList<Integer>();
		ids1.add(0);
		ids1.add(2);
		ids1.add(3);
		ids1.add(4);
		ids1.add(4);
		List<Integer> ids2 = new LinkedList<Integer>();
		ids2.add(1);
		ids2.add(2);
		ids2.add(3);
		ids2.add(5);
		ids2.remove(1);
		System.out.println(Utils.ListToStr(ids2));
		System.out.println(Utils.ListToStr(ids1));
	}
	public void getCampaignById(){
		Campaign cam = this.campaignService.getCampaignByCarbonId(1);
		System.out.println(null == cam ? null :0);
	}
	public void getCampaignRows(){
		
		SelectSQLParam param = new SelectSQLParam() ;
		List<CampaignRow> rows =this.campaignMapper.getPagedRows(param );
		System.out.println(rows == null?-1:rows.size());
		//System.out.println(rows.get(0).getRtbProgressIds().size());
	}
	public void getCampaignIdsByMaterial(){
		boolean b = this.campaignMapper.getEditable(2);
		boolean a = this.campaignMapper.getDeletable(1);
		System.out.println(a+","+b);
	}
	public void checkName(){
		Map<String,Object> m = new HashMap<String,Object>();
    	m.put("id", null);
    	m.put("campaignId", 3);
    	m.put("name", "tt");
		System.out.println(this.creativeMapper.checkName(m)) ;
	}
	public void getMaterialList(){
		SelectSQLParam param = new SelectSQLParam() ;
		Map<String,Object> userData = new HashMap<String,Object>();
		userData.put("campaignId", 1);
		userData.put("creativeId", 1);
		param.setUserData(userData);
		List<Material> rows =this.materialMapper.getPagedMaterials(param );
		System.out.println(rows == null?-1:rows.size());
	}
	public void getRtbDate(){
		Date d = this.campaignMapper.getRtbMaxEndtime(11);
		System.out.println(d);
	}
	public void getCampaignIdsByRtbStarted(){
		List<Integer> campaignIds2 = new LinkedList<Integer>();
		campaignIds2.add(53);
		this.campaignMapper.getCampaignIdsByRtbStarted(campaignIds2);
	}
	@Test
	 public void testMyFunction(){
		 //getCampaignList();
		//getCampaignCount();
		//insertCampaign();
		//int n = getAdvertisers();
		//System.out.println(this.getClass().getName()+":"+n);
		//javabean();
		//getAdvertiser();
		//getPagedCampaigns();
		//getRtbProgressNoStarted();
		//getRtbProgressFinished();
		//getRtbProgressPause();
		//getRtbProgressOverRun();
		//ListOpeartion();
		//getCampaignById();
		//getCampaignIdsByMaterial();
		//checkName();
		//getRtbDate();
		getCampaignIdsByRtbStarted();
	}
}