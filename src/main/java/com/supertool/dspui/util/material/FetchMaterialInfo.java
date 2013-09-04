package com.supertool.dspui.util.material;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.imageio.ImageIO;

import com.supertool.dspui.util.material.swf.SWFHeader;

public class FetchMaterialInfo {
    public static MaterialInfo getMaterialInfo(String url) {
        MaterialInfo materialInfo = new MaterialInfo();
        Integer duration = 0;
        Integer width = null;
        Integer height = null;
        Integer code = 0;
        String type = null;
        try {
            url = encodeURL(url, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            code = 101;
            materialInfo.setCode(code);
            return materialInfo;
        }

        try {
            String ext = url.substring(url.lastIndexOf(".") + 1).toLowerCase().trim();
            if ("flv".equals(ext)) {
                FLVMetaData flv = new FLVMetaData(url, true);
                String du = flv.getDuration();
                String[] durs = du.split(":");
                Integer[] hms = new Integer[durs.length];
                for (int i = 0; i < durs.length; i++) {
                    hms[i] = Integer.parseInt(durs[i]);
                }
                if (3 == hms.length) {
                    duration = hms[0] * 3600 + hms[1] * 60 + hms[2];
                } else if (2 == hms.length) {
                    duration = hms[0] * 60 + hms[1];
                }
                width = (int) flv.getWidth();
                height = (int) flv.getHeight();
            } else if ("swf".equals(ext)) {
                SWFHeader swf = new SWFHeader(new URL(url));
                Integer frameRate = swf.getFrameRate();
                Integer frameCount = swf.getFrameCount();
                if (1 != frameCount && frameRate > 0) {
                    duration = frameCount / frameRate;
                }
                width = swf.getWidth();
                height = swf.getHeight();
            } else if ("jpg".equals(ext) || "gif".equals(ext) || "png".equals(ext)) {
                BufferedImage buff = ImageIO.read(new URL(url));
                width = buff.getWidth();
                height = buff.getHeight();
            } else {
                code = 102;
            }
            type = ext;
        } catch (Exception e) {
            e.printStackTrace();
            code = 101;
        }
        materialInfo.setCode(code);
        materialInfo.setDuration(duration);
        materialInfo.setHeight(height);
        materialInfo.setType(type);
        materialInfo.setWidth(width);
        return materialInfo;
    }

    public static String encodeURL(String url, String encode) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        StringBuilder noAsciiPart = new StringBuilder();
        for (int i = 0; i < url.length(); i++) {
            char c = url.charAt(i);
            if (c > 255) {
                noAsciiPart.append(c);
            } else {
                if (noAsciiPart.length() != 0) {
                    sb.append(URLEncoder.encode(noAsciiPart.toString(), encode));
                    noAsciiPart.delete(0, noAsciiPart.length());
                }
                sb.append(c);
            }
        }
        return sb.toString().replaceAll(" ", "%20");
    }

    public static void main(String[] args) throws Exception {
        // MaterialInfo info = getMaterialInfo("/home/supertool/pm.flv");
        // System.out.println(info.getWidth());
        // SWFHeader swf = new
        // SWFHeader("/home/supertool/a9fcc4211eeeeff1f460de07df906ce5.swf");
        // System.out.println("The width is: " + swf.getWidth());
        // System.out.println("The height is: " + swf.getHeight());
        // FLVMetaData flv = new
        // FLVMetaData("/home/supertool/material/xunlei.flv", false);
        FLVMetaData flv = new FLVMetaData("/home/supertool/pm.flv", false);
        System.out.println("The width is: " + flv.getWidth());
        System.out.println("The height is: " + flv.getHeight());
        System.out.println("The duration is: " + flv.getDuration());
        // String width = "width";
        // byte[] bytes = width.getBytes("utf-8");
        // StringBuilder sb = new StringBuilder();
        // for(byte b : bytes){
        // sb.append(String.format("%02X ", b));
        // }
        // System.out.println("~~~~~~~~~~~~~~~~~" + sb.toString());
    }
}