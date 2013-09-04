package com.supertool.dspui.util;

import java.util.List;  
public class Pagination {  
	 // 数据  
    private List data;  
    // 总共的数据量  
    private int totle;  
    // 每页显示多少条  
    private int pageSize;  
    // 共有多少页  
    private int totlePage;  
    // 当前是第几页  
    private int currentPage;  
   
    // 连接路径  
    private String path;  
    
    
    
    
    
    public Pagination(List data, int pageSize, int currentPage, String path) {
		super();
		this.data = data;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.path = path;
	}
    
    
	public Pagination() {
		super();
		
	}

	public void setTotle(int totle) {
		this.totle = totle;
	}


	public List getData() {  
        return data;  
    }  
    public void setData(List data) {  
        this.data = data;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
 
    public void setPath(String path) {  
        this.path = path;  
    }  
    public int getTotle() {  
        return totle;  
    }  
    public int getPageSize() {  
        return pageSize;  
    }  
    public int getTotlePage() {  
    	if(this.pageSize<0){
    		return 0;
    	}else{
    		return (this.totle + this.pageSize - 1) / this.pageSize;
    	}
    }  
   
    public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getPath() {
		return path;
	}
	
    public String getPageDisplay() {  
        StringBuffer displayInfo = new StringBuffer();  
        if (currentPage == 0 || pageSize == 0) {  
            displayInfo.append("没有分页的信息!");  
        } else {  
            displayInfo.append("<div class=\"pager\">");  
            displayInfo.append("共" + this.totle + "条记录, 每页<span style=\"color:#FF0000\" mce_style=\"color:#FF0000\">" + pageSize  
                    + "</span>条,  ");  
            displayInfo.append("  共"  
                    + this.getTotlePage() + "页,   第<span style=\"color:#FF0000\" mce_style=\"color:#FF0000\">" + currentPage  
                    + "</span>页,");  
            // 判断如果当前是第一页 则“首页”和“第一页”失去链接  
            if (currentPage == 1) {  
                displayInfo.append("  首页 ");  
                displayInfo.append("上一页 ");  
            } else {  
                displayInfo.append("  <a href=\"" + path  
                        + "currentPage=1\"  mce_href=\"" + path  
                        + "currentPage=1\">首页</a> ");  
                displayInfo.append("<a href=\"" + path + "currentPage=" + (currentPage - 1)  
                        + "\" mce_href=\" " + path + "currentPage=" + (currentPage - 1)  
                        + "\">上一页</a> ");  
            }  
            if (currentPage >= this.getTotlePage()) {  
                displayInfo.append("下一页 ");  
                displayInfo.append("最后一页 ");  
            } else {  
                displayInfo.append("<a href=\" " + path + "currentPage=" + (currentPage + 1)  
                        + "\" mce_href=\" " + path + "currentPage=" + (currentPage + 1)  
                        + "\" >下一页</a> ");  
                displayInfo.append("<a href=\" " + path + "currentPage="  
                        + this.getTotlePage() + "\" mce_href=\" " + path + "currentPage="  
                        + this.getTotlePage() + "\">最后一页</a> ");  
            }  
            displayInfo.append("</div>");  
        }  
        return displayInfo.toString();  
    }  
}    
