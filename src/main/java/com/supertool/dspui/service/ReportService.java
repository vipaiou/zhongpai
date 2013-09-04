package com.supertool.dspui.service;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.util.ExcelUtil;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.util.excel.ImportExecl;
import com.supertool.dspui.vo.DetailFormBasicVO;
import com.supertool.dspui.vo.DetailFormVO;
import com.supertool.dspui.vo.GeneralFormBasicVO;
import com.supertool.dspui.vo.GeneralFormVO;


@Service
public class ReportService {
	Logger  logger = Logger.getLogger(this.getClass());
	public Workbook download(String type,String startTime,String endTime,int dspId,String name) {

		if(type == null || "".equals(type)) {
		} else if(startTime == null || "".equals(startTime)) {
		} else if(endTime == null || "".equals(endTime)) {
		} else {
			if("general".equals(type)) {
				GeneralFormBasicVO gfbVO = getGeneralForm(startTime,endTime);
				GeneralFormVO generalFormVO = new GeneralFormVO();
				generalFormVO.setDspId(dspId);
				generalFormVO.setName(name);
				generalFormVO.setStartTime(startTime);
				generalFormVO.setEndTime(endTime);
				generalFormVO.setBid(gfbVO.getBid());
				generalFormVO.setWinBid(gfbVO.getWinBid());
				generalFormVO.setPv(gfbVO.getPv());
				generalFormVO.setClick(gfbVO.getClick());
				generalFormVO.setCost(gfbVO.getCost());
				return getGeneralFormExcel(generalFormVO);
			} else if("detail".equals(type)) {
				DetailFormBasicVO dfbVO = getDetailForm(startTime,endTime);
				return getDetailFormExcel(dfbVO.getData(),dspId,name,startTime,endTime);
			}
		}
		return null;
	}
	
	
	private Workbook getGeneralFormExcel(GeneralFormVO generalFormVO) {
		ImportExecl poi = new ImportExecl();
		URL url = this.getClass().getResource("/");
		String filePath = url.getFile();
		Workbook wb = poi.read(filePath+"overviewdsp.xlsx");
		Sheet sheet =wb.getSheetAt(0);
		//int totalRows = sheet.getPhysicalNumberOfRows();
		CellStyle centerStyle  = wb.createCellStyle();
		centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		centerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		centerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		centerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		
		sheet.getRow(2).getCell(1).setCellValue(generalFormVO.getStartTime()+"至"+generalFormVO.getEndTime());
		CellStyle leftStyle = wb.createCellStyle();
		leftStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		sheet.getRow(3).getCell(1).setCellStyle(leftStyle);
		sheet.getRow(3).getCell(1).setCellValue((Integer)generalFormVO.getDspId());
		sheet.getRow(4).getCell(1).setCellValue((String)generalFormVO.getName());
		if(null !=sheet.getRow(8)){
			sheet.removeRow(sheet.getRow(8));
		}
		Row  row = sheet.createRow(8);
	    poi.createCellAndValue(row, 0, generalFormVO.getBid(), Integer.class,centerStyle);
	    poi.createCellAndValue(row, 1, generalFormVO.getWinBid(), Integer.class,centerStyle);
	    poi.createCellAndValue(row, 2, generalFormVO.getPv(), Integer.class,centerStyle);
	    poi.createCellAndValue(row, 3, generalFormVO.getClick(), Integer.class,centerStyle);
	    poi.createCellAndValue(row, 4, generalFormVO.getCost(), Double.class,centerStyle);
		return wb;
		
	}
	
	private Workbook getDetailFormExcel(Map<String,List<DetailFormVO>> map,int dspId,String name,String startTime,String endTime) {
		
		ImportExecl poi = new ImportExecl();
		URL url = this.getClass().getResource("/");
		String filePath = url.getFile();
		Workbook wb = poi.read(filePath+"dspdetailMedia.xlsx");
		Sheet sheet =wb.getSheetAt(0);
		//int totalRows = sheet.getPhysicalNumberOfRows();
		CellStyle centerStyle  = wb.createCellStyle();
		centerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		centerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		centerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		centerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		centerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		sheet.getRow(2).getCell(1).setCellValue(startTime+"至"+endTime);
		CellStyle leftStyle = wb.createCellStyle();
		leftStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		sheet.getRow(3).getCell(1).setCellStyle(leftStyle);
		sheet.getRow(3).getCell(1).setCellValue((Integer)dspId);
		sheet.getRow(4).getCell(1).setCellValue((String)name);
		if(null !=sheet.getRow(8)){
			sheet.removeRow(sheet.getRow(8));
		}
		
		int i = 8;
		Iterator<Entry<String, List<DetailFormVO>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().getKey().toString();
			List<DetailFormVO> value = map.get(key);
		
			int st = i;
			for(int line = 0;line< value.size();line++) {
			
				Row  rowi = sheet.createRow(i);
				poi.createCellAndValue(rowi,0, null, String.class, centerStyle);				
				poi.createCellAndValue(rowi,1, value.get(line).getAdplacementId(), Integer.class,centerStyle);
				poi.createCellAndValue(rowi,2, value.get(line).getBid(), Integer.class,centerStyle);
				poi.createCellAndValue(rowi,3, value.get(line).getWinBid(), Integer.class,centerStyle);
				poi.createCellAndValue(rowi,4, value.get(line).getPv(), Integer.class,centerStyle);
				poi.createCellAndValue(rowi,5, value.get(line).getClick(), Integer.class,centerStyle);
				poi.createCellAndValue(rowi,6, value.get(line).getCost(), Double.class,centerStyle);
				i++;
			}
			int ed =i-1;
			CellRangeAddress region = new CellRangeAddress(st, ed, 0, 0);
			sheet.addMergedRegion(region);
			sheet.getRow(st).getCell(0).setCellStyle(centerStyle);
			sheet.getRow(st).getCell(0).setCellValue(key);
		}
		return wb;
	}
	
	private GeneralFormBasicVO getGeneralForm(String starttime,String endtime) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dspId", UserContext.getDspId());
		params.put("start", starttime);
		params.put("end", endtime);
		TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
		JSONObject object = talkWithCarbon.getCarbonVOJson(params, Config.getCarbonHost() +"/report/general/list");
		ObjectMapper mapper = new ObjectMapper();
		GeneralFormBasicVO gfbVO = null;
		try {
			gfbVO = mapper.readValue(object.toString(),GeneralFormBasicVO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		if(gfbVO.getStatusCode() != Constant.CARBON_STATUS_CODE_SUCCESS) {
			String message = gfbVO.getMessage();
			throw new CarbonBadResponseException(message);
		}
		return gfbVO;
	}
	
	private DetailFormBasicVO getDetailForm(String starttime,String endtime) {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dspId", UserContext.getDspId());
		params.put("start", starttime);
		params.put("end", endtime);
		TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
		JSONObject object = talkWithCarbon.getCarbonVOJson(params, Config.getCarbonHost() +"/report/detail/list");
		ObjectMapper mapper = new ObjectMapper();
		DetailFormBasicVO dfbVO = null;
		try {
			dfbVO = mapper.readValue(object.toString(),DetailFormBasicVO.class);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		if(dfbVO.getStatusCode() != Constant.CARBON_STATUS_CODE_SUCCESS) {
			String message = dfbVO.getMessage();
			throw new CarbonBadResponseException(message);
		}
		return dfbVO;
	}
	
	@SuppressWarnings("deprecation")
	public String[] getDate() {
		
		String result[] = new String[8];
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date[] date = Utils.getTimeRange(Utils.getYear(d), Utils.getMonth(d));
		int i = d.getDay();
		//上周
		result[0] = getDateByDay(-6 - i);
		result[1] = getDateByDay(0 - i);
		//本周
		if(1-i >-1){
			result[2] = "";
			result[3] = "";
		}else{
			result[2] = getDateByDay(1 - i);
			result[3] = getDateByDay(-1);
		}
		
		//本月
		result[4] = checkLimit(sdf.format(date[0]));
		if("".equals(result[4])){
			result[5] = "";
		}else{
			result[5] = getDateByDay(-1);
		}
		
		//最近七天
		result[6] = getDateByDay(-7);
		result[7] = getDateByDay(-1);
		
		
		return result;
	}
	
	private String getDateByDay(int day){
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date.add(Calendar.DATE, day);
        String dateStr =  sdf.format(date.getTime());
       /* String str =  checkLimit(dateStr);
        System.out.println(str);*/
        
        return dateStr;
	}
	public String checkLimit(String  dateStr){
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  if(StringUtil.isNotBlank(dateStr)){
				
				String yesTodayStr = getDateByDay(-1);
				Date date = null,yesToday;
				
				try {
					 date = sdf2.parse(dateStr+" 00:00:00");
					 yesToday  = sdf2.parse(yesTodayStr +" 00:00:00");
					 if(date.after(yesToday)){
							return "";
					}
					 return dateStr;
				} catch (ParseException e) {
					
					logger.error(e.getMessage());
				}
		  }
		return dateStr;

	  }

}
