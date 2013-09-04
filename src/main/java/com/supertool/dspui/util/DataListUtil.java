package com.supertool.dspui.util;

import java.util.List;

/*
 * 
 */
public class DataListUtil {

	
	public static List<?> getSubDataList(List<?> datas ,int currentPage,int pageSize){
		if(datas == null || datas.size() ==0 || pageSize <1){
			return null;
		}
		int totalCount = datas.size();
		int totalPage = (totalCount-1) / pageSize +1;
		if(currentPage <1){
			currentPage =1;
		}
		if(currentPage > totalPage){
			currentPage = totalPage;
		}

		int startIndex =  (currentPage-1) * pageSize;
		int endIndex = startIndex + pageSize;
		
		if(startIndex <0){
			startIndex = 0;
		}
		if(startIndex >totalCount-1){
			startIndex = totalCount-1;
		}
		if(endIndex <1){
			endIndex =1;
		}
		if(endIndex >totalCount){
			endIndex = totalCount;
		}
		return datas.subList(startIndex, endIndex);
	}
	
}
