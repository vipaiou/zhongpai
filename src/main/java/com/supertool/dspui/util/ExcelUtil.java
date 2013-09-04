package com.supertool.dspui.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelUtil {
	
	private static HSSFWorkbook wb = null;
	private static HSSFSheet sheet = null;
	private static HSSFRow row = null;
	
	public static void init() {
		wb = new HSSFWorkbook();
	}
	
	public static void createSheet(String sheetName) {
		sheet = wb.createSheet(sheetName);
	}
	
	public static void createRow(int line) {
		row = sheet.createRow(line);
	}
	
	public static void createCellAndValue(int column,Object value,Object type) {
		HSSFCell cell = row.createCell(column);
		if(type == Integer.class)
			cell.setCellValue((Integer)value);
		if(type == Double.class)
			cell.setCellValue((Double) value);
		if(type == String.class)
			cell.setCellValue((String)value);
	}
	
	public static HSSFWorkbook getHSSFWorkbook() {
		return wb;
	}
	public static int  bulidTemplate(List<List<String>> list){
		ExcelUtil.init();
		ExcelUtil.createSheet("new Sheet");
		
		if (list != null && list.size()>0)
		{

			for (int i = 0; i < list.size(); i++)
			{

				System.out.print("第" + (i) + "行");
				ExcelUtil.createRow(i);
				List<String> cellList = list.get(i);

				for (int j = 0; j < cellList.size(); j++)
				{

					// System.out.print("    第" + (j + 1) + "列值：");

					System.out.print("    " + cellList.get(j));
					ExcelUtil.createCellAndValue(j, cellList.get(j), String.class);
					/*ExcelUtil.createCellAndValue(1, "winBid", String.class);
					ExcelUtil.createCellAndValue(2, "pv", String.class);
					ExcelUtil.createCellAndValue(3, "click", String.class);
					ExcelUtil.createCellAndValue(4, "cost", String.class);*/

				}
				System.out.println();

			}
			return  list.size();
		}
		return 0;
	}

	

		/**
		 * 替换Excel模板文件内容
		 * @param datas 文档数据
		 * @param sourceFilePath Excel模板文件路径
		 * @param targetFilePath Excel生成文件路径
		 */
		public static boolean replaceModel(List<ExcelReplaceDataVO> datas, String sourceFilePath, String targetFilePath) {
			boolean bool = true;
			try {

				POIFSFileSystem fs  =new POIFSFileSystem(new FileInputStream(sourceFilePath));   
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFSheet sheet = wb.getSheetAt(0);
				
				for (ExcelReplaceDataVO data : datas) {
					//获取单元格内容
					HSSFRow row = sheet.getRow(data.getRow());   
					HSSFCell cell = row.getCell((short)data.getColumn());
					String str = cell.getStringCellValue();
					
					//替换单元格内容
					str = str.replace(data.getKey(), data.getValue());
					
					//写入单元格内容
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					/*cell.setEncoding(HSSFCell.ENCODING_UTF_16);  */
					cell.setCellValue(str);   
				}

				// 输出文件   
				FileOutputStream fileOut = new FileOutputStream(targetFilePath);   
				wb.write(fileOut);   
				fileOut.close();   

			} catch (Exception e) {
				bool = false;
				e.printStackTrace();
			}
			return bool;
		}

}
