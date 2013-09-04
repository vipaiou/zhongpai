package com.supertool.dspui.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.Dsp;
import com.supertool.dspui.service.DspLogicService;
import com.supertool.dspui.service.ReportService;
import com.supertool.dspui.vo.ReportVO;
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@Autowired
	private DspLogicService dspLogicService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String view(Model model) {
		String date[] = reportService.getDate();
		int dspId = UserContext.getDspId();
		Dsp dsp = dspLogicService.getDspLogicByDspId(dspId);
		ReportVO reportVO = new ReportVO();
		reportVO.setLastWeekStart(date[0]);
		reportVO.setLastWeekEnd(date[1]);
		reportVO.setThisWeekStart(date[2]);
		reportVO.setThisWeekEnd(date[3]);
		reportVO.setThisMonthStart(date[4]);
		reportVO.setThisMonthEnd(date[5]);
		reportVO.setLastSevenDaysStart(date[6]);
		reportVO.setLastSevenDaysEnd(date[7]);
		model.addAttribute("reportVO", reportVO);
		model.addAttribute("dsp", dsp);
		return "report/index";
	}

	@RequestMapping(value = "/download")
	public void download(String type, String startTime, String endTime,int dspId,String name,
			HttpServletResponse response) {
		
		Workbook wb = reportService.download(type, startTime, endTime,dspId,name);
		if(wb != null) {
			int dspid = UserContext.getDspId();
			String filename = "DSP" + dspid + "-" + type + "-" + startTime + "-" + endTime +".xls";
			response.setContentType("application/vnd.ms-excel");
			response.addHeader("Content-Disposition", "attachment;filename="+filename);
			try {
				wb.write(response.getOutputStream());
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}
	}

}
