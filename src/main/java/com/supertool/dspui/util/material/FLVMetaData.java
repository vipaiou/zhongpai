package com.supertool.dspui.util.material;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.net.URL;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;

/**
 * This class will get the FLV meta data information.
 * 
 * @author SANTHOSH REDDY MANDADI
 * @version 1.0
 * @since 10th June 2009
 */
public class FLVMetaData {
    /**
     * Represents the FLV path either a URL or a absolute file path. If it is URL url property should be true to access
     * the file from web
     */
    private String flv = null;

    /**
     * Represents whether the FLV is remote or local, if this is true data will be fetched through the HTTP connection
     * otherwise data will be fetched from the local file.
     */
    private boolean url = true;

    // All the FLV properties
    private String duration;
    private double width;
    private double height;
    private double audioDataRate;
    private double videoDataRate;
    private double fileSize;
    private String createdDate;
    private String mimeType;
    private double frameRate;

    /**
     * Constructs an object with flv as a url
     * 
     * @param flv
     *            represents the web url
     * @since 10-Jun-2009
     */
    public FLVMetaData(String flv) throws Exception {
        this.flv = flv;
        getMetaData();
    }

    /**
     * Constructs an object with flv and boolean value url.
     * 
     * @param flv
     *            represents the FLV path either a URL or a absolute file path.
     * @param url
     *            represents boolean value.
     */
    public FLVMetaData(String flv, boolean url) throws Exception {
        this.flv = flv;
        this.url = url;
        getMetaData();
    }

    /**
     * Extract the metadata for the flv and sets them in the properties. If the property has 0.0 or null, then the
     * information is not available on the target FLV.
     * 
     * @throws Exception
     *             if something goes wrong.
     */
    private void getMetaData() throws Exception {
        InputStream fis = null;
        try {
            if (url) {
                // Creating the URL object
                URL url = new URL(flv);
                // Establishing the connection to the server
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(6000); // 6 sec
                connection.setReadTimeout(10000); // 10 sec
                // Getting the remote input stream
                fis = connection.getInputStream();
            } else {
                fis = new FileInputStream(flv);
            }
            // Creating the bytes array to read the first 400 bytes data from input stream
            byte bytes[] = new byte[1000];
            // Reading the data from the input stream
            fis.read(bytes);

            /*
             * Fetching the properties. If the output shows -1 or null then consider that the FLV doesn't have that info
             * on metadata
             */
//            StringBuilder sb = new StringBuilder();
//            for (byte b : bytes) {
//                sb.append(String.format("%02X ", b));
//            }
//            System.out.println(sb.toString());

            double duration = getDouble(bytes, "duration");
            DecimalFormat f = new DecimalFormat("00");
            setDuration(f.format((int) duration / 60) + ":" + f.format((int) duration % 60));
            setWidth(getDouble(bytes, "width"));
            setHeight(getDouble(bytes, "height"));
            setAudioDataRate(getDouble(bytes, "audiodatarate"));
            setVideoDataRate(getDouble(bytes, "videodatarate"));
            setFileSize(getDouble(bytes, "filesize"));
            setCreatedDate(getString(bytes, "creationdate"));
            setMimeType(getString(bytes, "mimetype"));
            setFrameRate(getDouble(bytes, "framerate"));

            // Closing the remote input stream
            fis.close();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    private double getDouble(byte[] bytes, String property) throws  UnsupportedEncodingException{
        // Creating a string from the bytes
        //String metaData = new String(bytes,"utf-8");
        // Checking whether the property exists on the metadata
        //int offset = metaData.indexOf(property);
    	byte[] pbytes = property.getBytes("utf-8");
    	int offset = findSubArray(bytes, pbytes);
        if (offset != -1) {
            // Calculating the value from the bytes received from getBytes method
//        	byte[] bts = getBytes(bytes, offset + pbytes.length + 1, 8);
//        	if("width".equals(property)){
//        		StringBuilder sb = new StringBuilder();
//                for (byte b : bts) {
//                    sb.append(String.format("%02X ", b));
//                }
//                System.out.println("here " + sb.toString());
//        	}
            return ByteBuffer.wrap(getBytes(bytes, offset + pbytes.length + 1, 8)).getDouble();
        } else {
            // Returning -1 to notify the info not available
            return -1;
        }
    }
    
    private int findSubArray(byte[] bytes, byte[] pbytes){
    	if(bytes.length > pbytes.length){
    		for(int i=0; i<bytes.length; i++){
    			boolean isMatch = true;
    			for(int j=0,k=i; j<pbytes.length && k<bytes.length; j++,k++){
    				if(bytes[k] != pbytes[j]){
    					isMatch = false;
    					break;
    				}
    			}
    			if(isMatch){
    				return i;
    			}
    		}
    	}
    	return -1;
    }

    private String getString(byte[] bytes, String property) {
        // Creating a string from the bytes
        String metaData = new String(bytes);
        // Checking whether the property exists on the metadata
        int offset = metaData.indexOf(property);
        if (offset != -1) {
            // Constructing the string from the bytes received from getBytes method
            return new String(getBytes(bytes, offset + property.length() + 3, 24));
        } else {
            // Returning null to notify the info not available
            return null;
        }
    }

    private byte[] getBytes(byte[] bytes, int offset, int length) {
        // Fetching the required number of bytes from the source and returning
        byte requiredBytes[] = new byte[length];
        for (int i = offset, j = 0; j < length; i++, j++) {
            requiredBytes[j] = bytes[i];
        }
        return requiredBytes;
    }

    public void setFlv(String flv) {
        this.flv = flv;
    }

    public String getFlv() {
        return flv;
    }

    public void setUrl(boolean url) {
        this.url = url;
    }

    public boolean isUrl() {
        return url;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setAudioDataRate(double audioDataRate) {
        this.audioDataRate = audioDataRate;
    }

    public double getAudioDataRate() {
        return audioDataRate;
    }

    public void setVideoDataRate(double videoDataRate) {
        this.videoDataRate = videoDataRate;
    }

    public double getVideoDataRate() {
        return videoDataRate;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFrameRate(double frameRate) {
        this.frameRate = frameRate;
    }

    public double getFrameRate() {
        return frameRate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public static void main(String args[]) throws Exception {
        String url = "http://streaming.stfile.com/c/75/c75c46adb284ea929a0e0c1632e8f3fa.flv";
        System.out.println(url.substring(url.lastIndexOf(".") + 1).toLowerCase());
        //FLVMetaData metaData = new FLVMetaData("/home/supertool/300x250/39.flv", false);
        FLVMetaData metaData = new FLVMetaData("http://plu.pd.mzhen.com/d/2c/d2c4d9f3e8a68636c1a1e18bfc43c4dd.flv", true);
        System.out.println(metaData.getDuration());
//        String.format(format, args);
/*        byte[] bytes = new byte[400];
        FileInputStream in = new FileInputStream("/home/supertool/300x250/18.swf");
        in.read(bytes);
        String metaData = new String(bytes);
        System.out.println(metaData.g);*/
    }
}