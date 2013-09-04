package com.supertool.dspui.util.chinese;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
public class ZHConverter {

	private Properties charMap = new Properties();
	private Set conflictingSets = new HashSet();
	public static final int TRADITIONAL = 0;
	public static final int SIMPLIFIED = 1;
	private static final int NUM_OF_CONVERTERS = 2;
	private static final ZHConverter[] converters = new ZHConverter[NUM_OF_CONVERTERS];
	private static final String[] propertyFiles = new String[2];
	static {
		propertyFiles[TRADITIONAL] = "zh2Hant.properties";
		propertyFiles[SIMPLIFIED] = "zh2Hans.properties";
	}
	/**
	 * 字库里的数据还不是很完善，但已经能够满足绝大多数需求，zh2Hans.properties需要不断的完善
	 * @param converterType
	 *            0 for traditional and 1 for simplified
	 * @return
	 */
	public static ZHConverter getInstance(int converterType) {

		if (converterType >= 0 && converterType < NUM_OF_CONVERTERS) {

			if (converters[converterType] == null) {
				synchronized (ZHConverter.class) {
					if (converters[converterType] == null) {
						converters[converterType] = new ZHConverter(
								propertyFiles[converterType]);
					}
				}
			}
			return converters[converterType];

		} else {
			return null;
		}
	}

	public static String convert(String text, int converterType) {
		ZHConverter instance = getInstance(converterType);
		return instance.convert(text);
	}

	private ZHConverter(String propertyFile) {
		InputStream is = null;
		is = getClass().getResourceAsStream(propertyFile);
		if (is != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(is));
				charMap.load(reader);
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null)
						reader.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
				}
			}
		}
		initializeHelper();
	}

	@SuppressWarnings("unchecked")
	private void initializeHelper() {
		Map stringPossibilities = new HashMap();
		Iterator iter = charMap.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			if (key.length() >= 1) {

				for (int i = 0; i < (key.length()); i++) {
					String keySubstring = key.substring(0, i + 1);
					if (stringPossibilities.containsKey(keySubstring)) {
						Integer integer = (Integer) (stringPossibilities
								.get(keySubstring));
						stringPossibilities.put(keySubstring, new Integer(
								integer.intValue() + 1));

					} else {
						stringPossibilities.put(keySubstring, new Integer(1));
					}

				}
			}
		}

		iter = stringPossibilities.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			if (((Integer) (stringPossibilities.get(key))).intValue() > 1) {
				conflictingSets.add(key);
			}
		}
	}

	public String convert(String in) {
		StringBuilder outString = new StringBuilder();
		StringBuilder stackString = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			String key = "" + c;
			stackString.append(key);

			if (conflictingSets.contains(stackString.toString())) {
			} else if (charMap.containsKey(stackString.toString())) {
				outString.append(charMap.get(stackString.toString()));
				stackString.setLength(0);
			} else {
				CharSequence sequence = stackString.subSequence(0, stackString
						.length() - 1);
				stackString.delete(0, stackString.length() - 1);
				flushStack(outString, new StringBuilder(sequence));
			}
		}

		flushStack(outString, stackString);
		return outString.toString();
	}

	private void flushStack(StringBuilder outString, StringBuilder stackString) {
		while (stackString.length() > 0) {
			if (charMap.containsKey(stackString.toString())) {
				outString.append(charMap.get(stackString.toString()));
				stackString.setLength(0);

			} else {
				outString.append("" + stackString.charAt(0));
				stackString.delete(0, 1);
			}

		}
	}
	String parseOneChar(String c) {
		if (charMap.containsKey(c)) {
			return (String) charMap.get(c);
		}
		return c;
	}
	public static String[] getPortfolioString(String str){
		if(str.length()!=2){
			return new String[]{str};
		}
		int types=2;
		String[] rs=new String[types];
		String[] atoms=new String[2];
		String[] simples=new String[2];
		String[] tranditions=new String[2];
		for(int i=0;i<2;i++){
			atoms[i]=str.substring(i,i+1);
			simples[i]=convert(atoms[i], ZHConverter.SIMPLIFIED);
			tranditions[i]=convert(atoms[i], ZHConverter.TRADITIONAL);
		}
		rs[0]=simples[0]+tranditions[1];
		rs[1]=tranditions[0]+simples[1];
		return rs;
	} 
	public static String[] getPortfolio(String str,int base){
		if(str.length()!=base){
			return new String[]{str};
		}
		int types=base*base;
		String[] rs=new String[types];
		String[] atoms=new String[base];
		String[] simples=new String[base];
		String[] tranditions=new String[base];
		for(int i=0;i<base;i++){
			atoms[i]=str.substring(i,i+1);
			simples[i]=convert(atoms[i], ZHConverter.SIMPLIFIED);
			tranditions[i]=convert(atoms[i], ZHConverter.TRADITIONAL);
		}
		int k=0;
		if(str.length()==base){
	
		}
		return null;
	} 
	public static void main(String[] args){		
		ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
/*		System.out.println(ZHConverter.convert("《夥, 康著, 夢, 連, 見, 天, 渴, 瞞, 拼, 跟, 甜著, heello,", ZHConverter.TRADITIONAL));
		System.out.println(ZHConverter.convert("只", ZHConverter.TRADITIONAL));
		System.out.println(converter.conflictingSets);*/	
		String[]rs =getPortfolioString("机电");
		System.out.println(rs[0]+" "+rs[1]);
	}
}
