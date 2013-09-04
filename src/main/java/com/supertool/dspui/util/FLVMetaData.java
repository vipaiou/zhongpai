package com.supertool.dspui.util;

import com.supertool.dspui.framework.jave.Encoder;
import com.supertool.dspui.framework.jave.MultimediaInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;

import com.supertool.dspui.util.Cherry;

public class FLVMetaData {
    private double duration;
    private double width;
    private double height;
    private double audioDataRate;
    private double videoDataRate;
    private double fileSize;
    private double frameRate;

    public  double  getMP4Duration(File file){
        Encoder encoder = new Encoder();
        try {
             MultimediaInfo m = encoder.getInfo(file);
             long ls = m.getDuration();
             double duration=(double) (ls/1000);
             System.out.println("此视频时长为:"+duration+"秒！");
             return duration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public FLVMetaData(File file) throws Exception{
        FileInputStream in = new FileInputStream(file);
        getMetadata(in);
    }
    
    public FLVMetaData() throws Exception{
    	
    }
    
    public FLVMetaData(URL url) throws Exception{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(6000); // 6 sec
        connection.setReadTimeout(10000); // 10 sec
        InputStream in = connection.getInputStream();
        getMetadata(in);
    }
    
    private void getMetadata(InputStream in) throws IOException{
        Tika tika = new Tika();
        Metadata metadata = new Metadata();
        tika.parse(in,metadata);
        duration = Cherry.getDouble(metadata.get("duration"),0.0);
        width = Cherry.getDouble(metadata.get("width"),0.0);
        height = Cherry.getDouble(metadata.get("height"),0.0);
        audioDataRate = Cherry.getDouble(metadata.get("audiodatarate"),0.0);
        System.out.println(metadata.get("audiocodecid"));
        videoDataRate = Cherry.getDouble(metadata.get("videodatarate"),0.0);
        fileSize = Cherry.getDouble(metadata.get("filesize"),0.0);
        frameRate = Cherry.getDouble(metadata.get("framerate"),0.0);
        if(in != null){
            in.close();
        }
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAudioDataRate() {
        return audioDataRate;
    }

    public void setAudioDataRate(double audioDataRate) {
        this.audioDataRate = audioDataRate;
    }

    public double getVideoDataRate() {
        return videoDataRate;
    }

    public void setVideoDataRate(double videoDataRate) {
        this.videoDataRate = videoDataRate;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public double getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(double frameRate) {
        this.frameRate = frameRate;
    }

    public static void main(String[] args) throws Exception{
        FLVMetaData file1 = new FLVMetaData();
        System.out.println(System.getProperty("java.io.tmpdir"));
        double ss=file1.getMP4Duration(new File("C:\\Users\\aeiou\\Desktop\\Sleep Away.mp3"));
        System.out.println(ss);
        System.out.println(file1.getAudioDataRate());
        System.out.println(file1.getFileSize());
        System.out.println(file1.getFrameRate());
        System.out.println(file1.getHeight());
        System.out.println(file1.getVideoDataRate());
        System.out.println(file1.getWidth());
        
        //FLVMetaData file2 = new FLVMetaData(new URL("http://s.tpg.stfile.com/d/c1/dc17c917001b5af82217146473e5166e.flv"));
        /*System.out.println(file2.getDuration());
        System.out.println(file2.getAudioDataRate());
        System.out.println(file2.getFileSize());
        System.out.println(file2.getFrameRate());
        System.out.println(file2.getHeight());
        System.out.println(file2.getVideoDataRate());
        System.out.println(file2.getWidth());*/
    }
}