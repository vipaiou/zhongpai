package com.supertool.dspui.util;

import java.util.*;

public class Lists {

    public static <E> List<E> list(E...data) {
        List<E> list = new ArrayList<E>();
        if (null == data) {
            return list;
        }
        for (E d : data) {
            list.add(d);
        }
        return list;
    }
    
    public static List<Integer> listInt(String dataStr,String ... separator){
        if(null == dataStr){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<Integer>();
        if(dataStr==null||dataStr.trim().equals("")){
        	return list;
          }
        String[] strArray;
        if(null == separator || separator.length <=0){
            strArray = dataStr.split(",");
        }else{
            strArray = dataStr.split(separator[0]);
        }
        for(int i = 0; i < strArray.length;i++){
            if(StringUtil.isNumber(strArray[i])){
                list.add(Integer.parseInt(strArray[i]));
            }
        }
        return list;
    }
    
    public static List<String> listStr(String dataStr,String ... separator){
        List<String> list = new ArrayList<String>();
        String[] strArray;
        if(null == separator || separator.length <=0){
            strArray = dataStr.split(",");
        }else{
            strArray = dataStr.split(separator[0]);
        }
        for(int i = 0; i < strArray.length;i++){
            list.add(strArray[i]);
        }
        return list;
    }
    
    public static <E> String join(final Iterable<E> xs, String start, String end, String sep) {
        if (null == start) {
            start = "";
        }
        if (null == end) {
            end = "";
        }
        if (null == xs) {
            return start + end;
        }
        if (null == sep) {
            sep = ",";
        }
        final String b = sep;
        final StringBuilder sb = new StringBuilder(start);
        final Iterator<E> iter = xs.iterator();
        if (iter.hasNext()) {
            sb.append(iter.next());
        } else {
            return start + end;
        }
        while (iter.hasNext()) {
            sb.append(b);
            sb.append(iter.next());
        }
        if (null != end) {
            sb.append(end);
        }
        return sb.toString();
    }

    public static <E> String join(Iterable<E> data, String sep) {
        return join(data, "", "", sep);
    }

    public static <E> String join(Iterable<E> data) {
        return join(data, "", "", ",");
    }

    public static void main(String[] args) {
        List<String> xs = list("1,2,3,3");
        System.out.println(join(xs));
        Set<Integer> set = new HashSet<Integer>();
    }

    public static <E> boolean isEmpty(List<E> list) {
        return null == list || list.size() == 0;
    }
}
