<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:wb="http://open.weibo.com/wb" xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>众拍网</title>

<meta name="keywords" content="众拍网"/>
<meta name="description" content="众拍网"/>
<!--上面是title-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/team_files/style.css"/><!--主样式-->
<script src="<%=request.getContextPath()%>/team_files/analytics.js" async="true"></script>
<script src="<%=request.getContextPath()%>/team_files/jquery-1.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/team_files/hebing.js"></script>


</head>

<body>
	<!--side scroll beginning-->
    <div id="hm_code"></div>
	<div id="hm_code_img"></div>
    <a style="display: none;" id="hm_gotop" href="javascript:void(0)"></a>
    <!--side scroll end -->
	<div class="hm_mainBody">
	<!--header wrap beiginning-->
    <div style="height: 6038px;" class="hm_leftNav">
        <h1><a href="http://www.iheima.com/"><img src="<%=request.getContextPath()%>/team_files/logo.png" alt="i黑马" title="点击回到i黑马首页"/></a></h1>
        <ul class="hm_mainNav">
            <li class="hm_navHome current"><a class="hm_current" href="http://www.iheima.com/">首&nbsp;&nbsp;页</a></li>
            <li class="hm_navContribute"><a href="http://www.iheima.com/tougao">出品人</a></li>
            <li class="hm_navIdea"><a href="http://www.iheima.com/archives/category/evaluation">主创团队</a></li>
            <li class="hm_navHeima"><a href="http://www.iheima.com/archives/category/heima">创意设计</a></li>
			<li class="hm_navxsb"><a href="http://www.iheima.com/archives/category/tongxunshe">城市见面会</a></li>
            <li class="hm_navHot"><a href="http://www.iheima.com/archives/category/for-inspiration">预算回报</a></li>
            <li class="hm_navMore"><a href="">更多栏目</a>
				<dl style="display: none;">
					<dt>更多栏目</dt>
					<dd><a href="http://www.iheima.com/archives/category/top10">i黑马TOP10</a></dd><dd><a href="http://www.iheima.com/archives/category/top">头条</a></dd><dd><a href="http://www.iheima.com/archives/category/qnews">快新闻</a></dd><dd><a href="http://www.iheima.com/archives/category/shuzhai">书摘</a></dd><dd><a href="http://www.iheima.com/archives/category/false">败局</a></dd><dd><a href="http://www.iheima.com/archives/category/zhuanlan">专栏</a></dd>
				</dl>
			</li>
		</ul>
<!--         <ul class="hm_magNav">
			<li><a href="http://www.iheima.com/renrenindex" target="_blank" style="color:black;">发现创业优才</a></li>
        </ul>
        <ul class="hm_productsNav">
			<li><a href="http://cywlts.tmall.com/shop/view_shop.htm" rel="nofollow">杂志订阅</a></li>
            <li><a href="http://hmds.iheima.com/" target="_blank">黑马大赛</a></li>
            <li><a href="http://hmy.iheima.com/" target="_blank">黑马成长营</a></li>
            <li><a href="http://www.iheima.com/huawei" target="_blank">黑马-华为特训营</a></li>
			<li class="hm_last"><a href="http://app.iheima.com/" target="_blank">移动客户端</a></li>
        </ul> -->
        <ul class="hm_snsNav">
            <li>
                <a href=""><img src="<%=request.getContextPath()%>/team_files/sns_weixin.png" alt="微信" title="点击关注i黑马官方微信" height="64" width="64"></a>
            </li>
            <li class="no">
                <a href="http://weibo.com/iheimawang" target="_blank"><img src="<%=request.getContextPath()%>/team_files/sns_weibo.png" alt="微博" title="点击关注i黑马官微博" height="64" width="64"></a>
            </li>
        </ul>
    </div>
	<div class="clear"></div>
	<!--轮播-->
	<style>
	#wenchuan{ overflow:hidden; height:80px;}
#wenchuan a:link,#wenchuan a:visited{color:#333;text-decoration:none;}
#wenchuan a:hover,#wenchuan a:active{color:#000;text-decoration:underline;}
#wenchuan li{background:url() no-repeat 5px 8px;overflow:hidden}
	</style>
	<div class="hm_topWrap">
        <div class="hm_topAD">
			<ul id="wenchuan">
				<!--<li onmousedown="javascript:window.open('http://www.iheima.com/go/yiqihao');"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="665" height="80">
				<param name="movie" value="http://www.iheima.com/wp-content/uploads/665-80.swf" />
				<param name="quality" value="high" />
				<param name="wmode" value="transparent" />
				<embed wmode="transparent" src="http://www.iheima.com/wp-content/uploads/665-80.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="665" height="80"></embed>
				</object>
				</li>
				-->
            <li><a href="http://www.iheima.com/huawei" target="_blank"><img src="<%=request.getContextPath()%>/team_files/-.jpg" alt="" title="" height="80" width="665"></a></li>
			<!--<li><a href="http://event.iheima.com/jiaoyu/"  target="_blank"><img src="http://www.iheima.com/wp-content/uploads/2013/08/shitu.jpg" alt="" title="" width="665" height="80"></a></li>-->
			</ul>
		</div>

<script type="text/javascript">
/*
var scrollnews = document.getElementById('wenchuan');
var lis = scrollnews.getElementsByTagName('li');
var ml = 0;
var timer1 = setInterval(function(){
    var liHeight = lis[0].offsetHeight;
    var timer2 = setInterval(function(){
     scrollnews.scrollTop = (++ml);
     if(ml == liHeight){
        clearInterval(timer2);
        scrollnews.scrollTop = 0;
        ml = 0;
        lis[0].parentNode.appendChild(lis[0]);
     }
  },10);
},4000);
*/
</script>

        <div class="hm_login-shareWrap">
            <span class="hm_share"><a href="http://feed.feedsky.com/iheima" class="hm_rssBtn">RSS</a><a href="http://list.qq.com/cgi-bin/qf_invite?id=cf9ad1c0880c1b3a1e5caeff7ad23843de85664a859b34d2" rel="nofollow" class="hm_subscriptionBtn">订阅</a></span>
<!--登陆-->		
		<span class="hm_login">
		<a href="javascript:void(0)" onclick="show('light')" class="hm_loginBtn">登录</a>
<a href="http://www.iheima.com/wp-login.php?action=register" class="hm_registerBtn">注册</a>
			
		</span>
		
		</div>
		 <div class="hm_tagsSearchWrap">
			<div class="hm_tagsColorWrap hm_tagsScroll" id="hm_tagsColorWrap">
            <h5>热门标签</h5>
             <div class="biaoqian">
             <ul>
			<li><a href="http://www.iheima.com/?s=%E5%88%9B%E4%B8%9A">创业</a></li>
        	<li><a href="http://www.iheima.com/?s=%E6%AF%8F%E6%97%A5%E4%B8%80%E9%BB%91%E9%A9%AC">每日一黑马</a></li>
            <li><a href="http://www.iheima.com/?s=i%E9%BB%91%E9%A9%AC%E6%A6%9C">i黑马榜</a></li>
            <li><a href="http://www.iheima.com/?s=%E8%B4%A5%E5%B1%80">败局</a></li>
            <li><a href="http://www.iheima.com/?s=o2o">o2o</a></li>
            <li><a href="http://www.iheima.com/?s=%E7%94%B5%E5%95%86">电商</a></li>
            <li><a href="http://www.iheima.com/?s=%E9%98%BF%E9%87%8C">阿里</a></li>
            <li><a href="http://www.iheima.com/?s=%E8%85%BE%E8%AE%AF">腾讯</a></li>
            <li><a href="http://www.iheima.com/?s=%E7%99%BE%E5%BA%A6">百度</a></li>        </ul>
        </div>

			<div class="hm_searchWrap">
            <form name="formsearch" method="get" action="http://www.iheima.com" class="hm_form form-search">
                <input name="s" class="hm_searchInput" onfocus="if (this.value == '请输入关键字') {this.value = '';}" onblur="if(this.value == '') {this.value = '请输入关键字';}" value="请输入关键字" type="text">
                <button type="submit" class="hm_searchBtn" onmouseout="this.className='select_class'" onmouseover="this.className='select_over'">搜索</button>
            </form>
			</div>
        </div>
        
		</div>
    </div>
    <!--header wrap end-->
	<div id="light" class="white_content">
      <div class="close"><span class="deng">登录</span><a href="javascript:void(0)" onclick="hide('light')">X关闭</a></div>
      <div class="con"> 
      <span></span>
      <form action="http://www.iheima.com/wp-login.php" method="post" id="" class=""><!--input name id most-->
      <p><span>帐号</span><input name="log" id="log" class="name" type="text"></p>
      <p><span>密码</span><input name="pwd" id="pwd" class="psw" value="" type="password"></p>
      <p class="mar"><input name="" class="" id="" value="" type="checkbox"><span>记住密码</span><span><a href="http://www.iheima.com/wp-login.php?action=lostpassword">找回密码</a></span></p>
      <p><input name="" class="" id="login" value="" type="submit">
		 <input name="redirect_to" value="/" type="hidden">
	  <a href="http://www.iheima.com/wp-register.php"><input name="" class="" id="zhuce" value="" type="button"></a></p>
      </form>
      </div>
</div>
<div id="fade" class="black_overlay"></div>
    <!--main wrap beginning-->
    <div id="hm_mainContainer">
    	<div class="hm_recommendWrap">
        	<div class="hm_headline">
				<h3 style='font: 28px/1.2em "微软雅黑","黑体",Tahoma,Arial,Geneva,sans-serif;'>众拍出品人&nbsp;&nbsp;</h3>
                <p class="hm_excerpt">我们说阿里巴巴要做生态环境，因此，阿里巴巴必须朝更生态化的组织形态转变。所谓更生态化的组织形态，就是自上而下的管理会减少，而横向之间的主动连接会更多，基于兴趣、靠任务结合起来的项目和自组织的业务会越来...</p>              
                <a href="http://www.iheima.com/archives/49691.html" class="hm_articleFace" title="什么是生态化的组织形态" alt="什么是生态化的组织形态"><img alt="什么是生态化的组织形态" src="<%=request.getContextPath()%>/team_files/157.jpg" align="middle" height="304" width="664"></a>
                <div class="hm_postMeta">
                	<span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49691.html#comments"><span class="ds-thread-count" data-thread-key="49691" data-replace="1">0</span></a>)</span>
                	<span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e7%94%9f%e6%80%81%e7%bb%84%e7%bb%87" rel="tag">生态组织</a>, <a href="http://www.iheima.com/archives/tag/%e9%98%bf%e9%87%8c%e5%b7%b4%e5%b7%b4" rel="tag">阿里巴巴</a></span>
                </div>
                <div class="hm_postInfo hm_right">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/xiaohong">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 08:59:12</span>
                </div>                           
				            </div>
            <div class="hm_roadshow">
            	<h6><a href="http://www.iheima.com/archives/category/heima" style="color:#fff;" alt="黑马路演" title="黑马路演" target="_blank">黑马路演</a></h6>
                <ul class="hm_roadList">
				
            			 
												
                	
			  
												
                	
			  
												
                	
			  
												
                	
			  
												
                	
			  
												
                	
			 				
			
                <li style="margin-top: -20.7014px;" class="hm_roadList">
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49305.html" title="【每日一黑马】福昕：一款“小软件”的逆袭之路 用户超2亿" alt="【每日一黑马】福昕：一款“小软件”的逆袭之路 用户超2亿" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_028.jpg" alt="【每日一黑马】福昕：一款“小软件”的逆袭之路 用户超2亿" height="60" width="60"></a>
               		 </div>
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49305.html" title="【每日一黑马】福昕：一款“小软件”的逆袭之路 用户超2亿" alt="【每日一黑马】福昕：一款“小软件”的逆袭之路 用户超2亿" target="_blank">【每日一黑马】福昕：一款“小软件”的逆袭之路 用户超2亿</a></h4>
                    <div class="hm_postInfo">
                        <span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/08/30 19:37:07</span>
                    </div>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	全球用户超过2亿，间接用户超过7.5亿；年收入近1亿元，其中九成来自海外；获得亚马逊战略投资；与国际...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49305.html#comments"><span class="ds-thread-count" data-thread-key="49305" data-replace="1">3</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/adobe" rel="tag">Adobe</a>, <a href="http://www.iheima.com/archives/tag/pdf" rel="tag">PDF</a>, <a href="http://www.iheima.com/archives/tag/%e7%a6%8f%e6%98%95" rel="tag">福昕</a></span>
                   </div> 
                </div>
                    </li><li style="margin-top: 0px;" class="hm_roadList">
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49888.html" title="【每日一黑马】国维牙医：台湾牙医的内地淘金术" alt="【每日一黑马】国维牙医：台湾牙医的内地淘金术" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_008.jpg" alt="【每日一黑马】国维牙医：台湾牙医的内地淘金术" height="60" width="60"></a>
               		 </div>
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49888.html" title="【每日一黑马】国维牙医：台湾牙医的内地淘金术" alt="【每日一黑马】国维牙医：台湾牙医的内地淘金术" target="_blank">【每日一黑马】国维牙医：台湾牙医的内地淘金术</a></h4>
                    <div class="hm_postInfo">
                        <span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 14:26:53</span>
                    </div>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	国维牙医最初创办于1992年，2005年开始连锁化经营。目前在台湾地区，国维牙医拥有86家连锁门店，...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49888.html#comments"><span class="ds-thread-count" data-thread-key="49888" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%9b%bd%e7%bb%b4%e7%89%99%e5%8c%bb" rel="tag">国维牙医</a>, <a href="http://www.iheima.com/archives/tag/%e7%89%99%e5%8c%bb" rel="tag">牙医</a></span>
                   </div> 
                </div>
                    </li><li style="margin-top: 0px;" class="hm_roadList">
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49821.html" title="【每日一黑马】社会企业乐朗乐读：游走在公益和商业之间" alt="【每日一黑马】社会企业乐朗乐读：游走在公益和商业之间" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_004.jpg" alt="【每日一黑马】社会企业乐朗乐读：游走在公益和商业之间" height="60" width="60"></a>
               		 </div>
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49821.html" title="【每日一黑马】社会企业乐朗乐读：游走在公益和商业之间" alt="【每日一黑马】社会企业乐朗乐读：游走在公益和商业之间" target="_blank">【每日一黑马】社会企业乐朗乐读：游走在公益和商业之间</a></h4>
                    <div class="hm_postInfo">
                        <span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/05 17:39:30</span>
                    </div>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	不同于普通企业的纯商业性，社会企业强调它的社会性;但也不同于慈善机构的非盈利性，社会企业更讲究利润。...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49821.html#comments"><span class="ds-thread-count" data-thread-key="49821" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%b9%90%e6%9c%97%e4%b9%90%e8%af%bb" rel="tag">乐朗乐读</a>, <a href="http://www.iheima.com/archives/tag/%e5%88%9b%e4%b8%9a" rel="tag">创业</a>, <a href="http://www.iheima.com/archives/tag/heima" rel="tag">黑马</a></span>
                   </div> 
                </div>
                    </li><li style="margin-top: 0px;" class="hm_roadList">
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49715.html" title="【每日一黑马】盛诺一家：到国外看大病" alt="【每日一黑马】盛诺一家：到国外看大病" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_002.jpg" alt="【每日一黑马】盛诺一家：到国外看大病" height="60" width="60"></a>
               		 </div>
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49715.html" title="【每日一黑马】盛诺一家：到国外看大病" alt="【每日一黑马】盛诺一家：到国外看大病" target="_blank">【每日一黑马】盛诺一家：到国外看大病</a></h4>
                    <div class="hm_postInfo">
                        <span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/04 18:26:51</span>
                    </div>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	每天，来自中国各地的病人，挤满了协和、301等知名医院。北京、上海等地的大医院是这些病人最后的希望，...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49715.html#comments"><span class="ds-thread-count" data-thread-key="49715" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%8c%bb%e7%96%97" rel="tag">医疗</a>, <a href="http://www.iheima.com/archives/tag/%e7%9b%9b%e8%af%ba%e4%b8%80%e5%ae%b6" rel="tag">盛诺一家</a>, <a href="http://www.iheima.com/archives/tag/heima" rel="tag">黑马</a></span>
                   </div> 
                </div>
                    </li><li style="margin-top: 0px;" class="hm_roadList">
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49606.html" title="【每日一黑马】爱调研：将调研搬到线上 熬出来的大买卖" alt="【每日一黑马】爱调研：将调研搬到线上 熬出来的大买卖" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_041.jpg" alt="【每日一黑马】爱调研：将调研搬到线上 熬出来的大买卖" height="60" width="60"></a>
               		 </div>
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49606.html" title="【每日一黑马】爱调研：将调研搬到线上 熬出来的大买卖" alt="【每日一黑马】爱调研：将调研搬到线上 熬出来的大买卖" target="_blank">【每日一黑马】爱调研：将调研搬到线上 熬出来的大买卖</a></h4>
                    <div class="hm_postInfo">
                        <span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/03 19:58:20</span>
                    </div>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	不同与零点调查和益普索等传统调研公司，爱调研是基于互联网的在线调研平台。爱调研一手抓用户，一手抓客户...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49606.html#comments"><span class="ds-thread-count" data-thread-key="49606" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"></span>
                   </div> 
                </div>
                    </li><li style="margin-top: 0px;" class="hm_roadList">
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49485.html" title="【每日一黑马】拉勾网：用垂直细分颠覆平台巨头？" alt="【每日一黑马】拉勾网：用垂直细分颠覆平台巨头？" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_010.jpg" alt="【每日一黑马】拉勾网：用垂直细分颠覆平台巨头？" height="60" width="60"></a>
               		 </div>
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49485.html" title="【每日一黑马】拉勾网：用垂直细分颠覆平台巨头？" alt="【每日一黑马】拉勾网：用垂直细分颠覆平台巨头？" target="_blank">【每日一黑马】拉勾网：用垂直细分颠覆平台巨头？</a></h4>
                    <div class="hm_postInfo">
                        <span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/02 15:23:02</span>
                    </div>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	虽然专业招聘网站良莠不齐，但市场细分成为未来趋势。涉及互联网领域的细分招聘网站有一些，但要找一家业内...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49485.html#comments"><span class="ds-thread-count" data-thread-key="49485" data-replace="1">2</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%88%9b%e4%b8%9a" rel="tag">创业</a>, <a href="http://www.iheima.com/archives/tag/%e6%8b%89%e5%8b%be%e7%bd%91" rel="tag">拉勾网</a>, <a href="http://www.iheima.com/archives/tag/heima" rel="tag">黑马</a></span>
                   </div> 
                </div>
                    </li></ul>
            </div>
        </div><!--调用sidebar_index-->
				<script>
	var scroll = 1;
	var scrollTimes = 3;
	var IsFlag = false;
	// 给浏览器窗口绑定 scroll 事件
	$(window).bind("scroll",function(){
		// 判断窗口的滚动条是否接近页面底部
		if( $(document).scrollTop() + $(window).height() + 600 > $(".hm_pageNo")[0].offsetTop  && !IsFlag) {
			IsFlag = true;
			if(scroll >scrollTimes){
				$(".hm_pageNo").show();return;
			}
			$(".hm_pageNo").hide();
			$(".loading").show().text("更多精彩内容加载中...");
		    $.ajax({
		        type: "GET",
		        url: '/?scroll='+scroll+'&ajax=1&home=1&paged=1',
		        dataType: 'json',
		        cache: false,
				
		        success: function(data){
			        $(".loading").hide();
					if(data.code == 200){
						$(".hm_pageNo").before(data.result);
						$(".hm_pageNo").show();
						scroll++;
				        IsFlag = false;
					}
		        }
		    });
		}
	});
</script>
    	<div class="hm_articleListWrap">
		
				
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/50019.html" title="财经委副主任吴晓灵:地方政府高补贴吸引企业上新三板可以休矣！" alt="财经委副主任吴晓灵:地方政府高补贴吸引企业上新三板可以休矣！" target="_blank">财经委副主任吴晓灵:地方政府高补贴吸引企业上新三板可以休矣！</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/jupeng">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 16:40:48</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50019.html" title="财经委副主任吴晓灵:地方政府高补贴吸引企业上新三板可以休矣！" alt="财经委副主任吴晓灵:地方政府高补贴吸引企业上新三板可以休矣！" target="_blank"><img original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/171.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_003.jpg" alt="财经委副主任吴晓灵:地方政府高补贴吸引企业上新三板可以休矣！" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	针对目前各地地方政府高额补贴企业新三板挂牌的现象，第十二届全国人大常委、财经委副主任吴晓灵在5日举行的第二届金融街论坛上，接受媒体专访时特别指出“目前各个地方政府高补贴吸引企业上新三板可以休矣。”</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50019.html#comments"><span class="ds-thread-count" data-thread-key="50019" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e6%96%b0%e4%b8%89%e6%9d%bf" rel="tag">新三板</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/50012.html" title="商业地产玩法:三里屯的好生意和坏生意" alt="商业地产玩法:三里屯的好生意和坏生意" target="_blank">商业地产玩法:三里屯的好生意和坏生意</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/jupeng">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 12:12:57</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50012.html" title="商业地产玩法:三里屯的好生意和坏生意" alt="商业地产玩法:三里屯的好生意和坏生意" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/170.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_024.jpg" alt="商业地产玩法:三里屯的好生意和坏生意" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
从地理位置上说，香港太古地产开发的三里屯VILLAGE和三里屯SOHO很难说孰优孰劣，同处北京时尚中心三里屯商圈。前者邻靠著名的酒吧街，后者拥有
商圈内最大的建筑面积，但如果从工体北路这条分割线为起点分别走进这两个项目，很容易发现太古VILLAGE时尚繁华，而三里屯SOHO门可罗雀。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50012.html#comments"><span class="ds-thread-count" data-thread-key="50012" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%b8%89%e9%87%8c%e5%b1%af" rel="tag">三里屯</a>, <a href="http://www.iheima.com/archives/tag/%e5%95%86%e4%b8%9a%e5%9c%b0%e4%ba%a7" rel="tag">商业地产</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/50008.html" title="张维迎:创新的关键是理解人性" alt="张维迎:创新的关键是理解人性" target="_blank">张维迎:创新的关键是理解人性</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/xiaohong">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 12:02:51</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50008.html" title="张维迎:创新的关键是理解人性" alt="张维迎:创新的关键是理解人性" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/169.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_034.jpg" alt="张维迎:创新的关键是理解人性" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	企业追求基业常青是可以，但是要做到很难，就是因为创新是创造性的破坏。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50008.html#comments"><span class="ds-thread-count" data-thread-key="50008" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%88%9b%e6%96%b0" rel="tag">创新</a>, <a href="http://www.iheima.com/archives/tag/%e5%bc%a0%e7%bb%b4%e8%bf%8e" rel="tag">张维迎</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/50005.html" title="在斯坦福的一堂赌博课：论企业决策的不可确定性" alt="在斯坦福的一堂赌博课：论企业决策的不可确定性" target="_blank">在斯坦福的一堂赌博课：论企业决策的不可确定性</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">硅谷日记</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 11:57:34</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50005.html" title="在斯坦福的一堂赌博课：论企业决策的不可确定性" alt="在斯坦福的一堂赌博课：论企业决策的不可确定性" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/168.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_011.jpg" alt="在斯坦福的一堂赌博课：论企业决策的不可确定性" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	通常情况下，中国企业家往往更看重结果，然而结果常常不可控，企业能控制的只是好决策。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50005.html#comments"><span class="ds-thread-count" data-thread-key="50005" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%bc%81%e4%b8%9a%e7%bb%8f%e8%90%a5" rel="tag">企业经营</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/50003.html" title="创业者，你一定要知道你的产品卖给谁！" alt="创业者，你一定要知道你的产品卖给谁！" target="_blank">创业者，你一定要知道你的产品卖给谁！</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/jupeng">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 11:49:03</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50003.html" title="创业者，你一定要知道你的产品卖给谁！" alt="创业者，你一定要知道你的产品卖给谁！" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/167.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_029.jpg" alt="创业者，你一定要知道你的产品卖给谁！" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	这个年代，已经不是闭门造车的年代了，在造车之前，你要保证车能卖出去;否则你造出来的，也许只是个车模而已。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50003.html#comments"><span class="ds-thread-count" data-thread-key="50003" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%ba%a7%e5%93%81" rel="tag">产品</a>, <a href="http://www.iheima.com/archives/tag/%e5%95%86%e4%b8%9a%e6%a8%a1%e5%bc%8f" rel="tag">商业模式</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49999.html" title="淘宝四金冠店铺的仓储布局术" alt="淘宝四金冠店铺的仓储布局术" target="_blank">淘宝四金冠店铺的仓储布局术</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://i.wshang.com/Post/Default/Index/pid/32762.html?sukey=ef7e87b793e40b4bcbd88ab396f39d3579744e94d452f9e45f831bf0dc5551daf0da92824a111fe87464f5538b7f84e9#wechat_redirect" rel="nofollow">天下网商</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 11:43:30</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49999.html" title="淘宝四金冠店铺的仓储布局术" alt="淘宝四金冠店铺的仓储布局术" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/166.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_012.jpg" alt="淘宝四金冠店铺的仓储布局术" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
过去，投入大量的资金在各地建仓，似乎只是那些电商资本宠儿的资本游戏，而如今，异地建仓开始成为电商竞争的有力武器。随着淘宝红利的逐渐消退，店铺之间
 的竞争早已白热化，在做好产品的前提下，更是进入了速度和后端服务比拼的时代。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49999.html#comments"><span class="ds-thread-count" data-thread-key="49999" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e7%94%b5%e5%95%86" rel="tag">电商</a>, <a href="http://www.iheima.com/archives/tag/%e7%94%b5%e5%95%86%e4%bb%93%e5%82%a8" rel="tag">电商仓储</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49997.html" title="阿里金融正式申请成立“阿里网络银行”" alt="阿里金融正式申请成立“阿里网络银行”" target="_blank">阿里金融正式申请成立“阿里网络银行”</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/jupeng">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 11:04:58</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49997.html" title="阿里金融正式申请成立“阿里网络银行”" alt="阿里金融正式申请成立“阿里网络银行”" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/165.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_013.jpg" alt="阿里金融正式申请成立“阿里网络银行”" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	从2003年设立支付宝到如今正式向金融监管部门提出设立阿里网络银行的申请，马云用了十年时间。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49997.html#comments"><span class="ds-thread-count" data-thread-key="49997" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e7%bd%91%e7%bb%9c%e9%93%b6%e8%a1%8c" rel="tag">网络银行</a>, <a href="http://www.iheima.com/archives/tag/%e9%98%bf%e9%87%8c%e9%87%91%e8%9e%8d" rel="tag">阿里金融</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49995.html" title="APP推广的10大误区" alt="APP推广的10大误区" target="_blank">APP推广的10大误区</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/xiaohong">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 10:54:04</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49995.html" title="APP推广的10大误区" alt="APP推广的10大误区" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/164.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_006.jpg" alt="APP推广的10大误区" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	被应用商店置顶或是有强势媒体关注当然是好事。但是如果不结合明确的推广活动，那只能是白日做梦。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49995.html#comments"><span class="ds-thread-count" data-thread-key="49995" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/app" rel="tag">App</a>, <a href="http://www.iheima.com/archives/tag/app%e6%8e%a8%e5%b9%bf" rel="tag">APP推广</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49991.html" title="口碑营销的6个关键" alt="口碑营销的6个关键" target="_blank">口碑营销的6个关键</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/jupeng">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 10:38:26</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49991.html" title="口碑营销的6个关键" alt="口碑营销的6个关键" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/162.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_032.jpg" alt="口碑营销的6个关键" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	口碑营销大师马克.休斯(Mark 
Hughes)在《三张嘴传遍全世界——口碑行销威力大》书中曾提出，最具威力的营销手法，便是“把大众与媒体一起拖下水;藉由口耳相传，一传十、十传
百，才能让你的品牌与产品讯息传遍全世界。”</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49991.html#comments"><span class="ds-thread-count" data-thread-key="49991" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%8f%a3%e7%a2%91%e8%90%a5%e9%94%80" rel="tag">口碑营销</a>, <a href="http://www.iheima.com/archives/tag/%e8%90%a5%e9%94%80" rel="tag">营销</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49978.html" title="如何设计出一个好Logo" alt="如何设计出一个好Logo" target="_blank">如何设计出一个好Logo</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/xiaohong">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 10:20:19</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49978.html" title="如何设计出一个好Logo" alt="如何设计出一个好Logo" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/161.jpg&amp;q=95&amp;w=210&amp;h=150" src="<%=request.getContextPath()%>/team_files/timthumb_031.jpg" alt="如何设计出一个好Logo" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	细心观察世界500强企业的logo，多是由繁杂到简易的变化过程。很多轻易被山寨的品牌，也有商标过于复杂、不易辨别的原因，偷换了一个地方不会被消费者注意到。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49978.html#comments"><span class="ds-thread-count" data-thread-key="49978" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/logo" rel="tag">LOGO</a>, <a href="http://www.iheima.com/archives/tag/%e5%95%86%e6%a0%87" rel="tag">商标</a>, <a href="http://www.iheima.com/archives/tag/%e8%ae%be%e8%ae%a1" rel="tag">设计</a></span>
                   </div> 
                </div>
            </div>
	    
	    
	  
	   
			
            				
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49970.html" title="【败局】八家传统零售商的电商败局" alt="【败局】八家传统零售商的电商败局" target="_blank">【败局】八家传统零售商的电商败局</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/www.huxiu.com" rel="nofollow">虎嗅</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 09:54:32</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49970.html" title="【败局】八家传统零售商的电商败局" alt="【败局】八家传统零售商的电商败局" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_039.jpg" alt="【败局】八家传统零售商的电商败局" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
从2010年底开始，以纯开始试水电子商务，两年来在天猫和京东两个销售平台取得了不错的业绩，但是线上线下冲突的问题也一直在不断困扰着以纯。2013
年1月，以纯宣布暂停电商业务，以纯在线商城及天猫旗舰店、京东店铺停止运营，原有以纯品牌退出电商渠道。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49970.html#comments"><span class="ds-thread-count" data-thread-key="49970" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%bc%a0%e7%bb%9f%e4%bc%81%e4%b8%9a" rel="tag">传统企业</a>, <a href="http://www.iheima.com/archives/tag/%e7%94%b5%e5%95%86" rel="tag">电商</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49691.html" title="什么是生态化的组织形态" alt="什么是生态化的组织形态" target="_blank">什么是生态化的组织形态</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/xiaohong">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 08:59:12</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49691.html" title="什么是生态化的组织形态" alt="什么是生态化的组织形态" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb.jpg" alt="什么是生态化的组织形态" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
我们说阿里巴巴要做生态环境，因此，阿里巴巴必须朝更生态化的组织形态转变。所谓更生态化的组织形态，就是自上而下的管理会减少，而横向之间的主动连接会
更多，基于兴趣、靠任务结合起来的项目和自组织的业务会越来越多，这跟原来金字塔结构的组织形态大不一样。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49691.html#comments"><span class="ds-thread-count" data-thread-key="49691" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e7%94%9f%e6%80%81%e7%bb%84%e7%bb%87" rel="tag">生态组织</a>, <a href="http://www.iheima.com/archives/tag/%e9%98%bf%e9%87%8c%e5%b7%b4%e5%b7%b4" rel="tag">阿里巴巴</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49949.html" title="农村互联网观察：与城市的割裂还在扩大" alt="农村互联网观察：与城市的割裂还在扩大" target="_blank">农村互联网观察：与城市的割裂还在扩大</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 18:03:06</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49949.html" title="农村互联网观察：与城市的割裂还在扩大" alt="农村互联网观察：与城市的割裂还在扩大" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_019.jpg" alt="农村互联网观察：与城市的割裂还在扩大" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
8月底9月初，沙水请假回了趟老家长沙，认真观察了一下互联网在农村老家的发展状况，最直接的感觉是：无论是互联网还是移动互联网，网络对于农村的影响小
得微不足道，农村传统的生活方式如湘江里的流水一般，保持着固有的节奏和状态，安静而惬意。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49949.html#comments"><span class="ds-thread-count" data-thread-key="49949" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49957.html" title="软件外包CEO讲我为什么选择手游创业" alt="软件外包CEO讲我为什么选择手游创业" target="_blank">软件外包CEO讲我为什么选择手游创业</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 17:52:16</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49957.html" title="软件外包CEO讲我为什么选择手游创业" alt="软件外包CEO讲我为什么选择手游创业" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_020.jpg" alt="软件外包CEO讲我为什么选择手游创业" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
2013年手机游戏火了,2013年手游创业者也跟着火了,2013年下半年成都手游已经弥漫着一股手游不是你死就是我亡的味道。这就是手机游戏一个可以
让资本疯狂的行业，一个让创业者兴奋的行业，一个让整个科技媒体必须关注的行业。手游已经成为众多草根创业者的方向，剑锋有幸跟一位曾经做软件外包CEO
聊聊为什么他要选择手游进行再次创业。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49957.html#comments"><span class="ds-thread-count" data-thread-key="49957" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e6%89%8b%e6%b8%b8%ef%bc%8c%e8%a1%8c%e4%b8%9a" rel="tag">手游，行业</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49955.html" title="当电影碰到大数据该怎么玩？" alt="当电影碰到大数据该怎么玩？" target="_blank">当电影碰到大数据该怎么玩？</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">《中国广播影视》</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 15:39:50</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49955.html" title="当电影碰到大数据该怎么玩？" alt="当电影碰到大数据该怎么玩？" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_021.jpg" alt="当电影碰到大数据该怎么玩？" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
不少电影公司的老板都有这样的习惯，他们会在微博上主动搜索最近上映的自家公司的电影片名，然后转发自己觉得有利的评价。从某种程度上说，他们已经触碰到
了大数据的冰山一角，开始意识到观众的评价对于电影的意义。然而他们搜索到的微博是有限的，看过的微博也是有限的，若想更加客观地了解大家对影片的评价，
指导营销，甚至指导未来的电影策划投资，就要用到大数据分析。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49955.html#comments"><span class="ds-thread-count" data-thread-key="49955" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%a4%a7%e6%95%b0%e6%8d%ae%ef%bc%8c%e8%a7%82%e7%82%b9" rel="tag">大数据，观点</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49952.html" title="微软诺基亚收购交易幕后的故事：四次谈判修成正果" alt="微软诺基亚收购交易幕后的故事：四次谈判修成正果" target="_blank">微软诺基亚收购交易幕后的故事：四次谈判修成正果</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://tech.qq.com/" rel="nofollow">腾讯科技</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 10:37:14</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49952.html" title="微软诺基亚收购交易幕后的故事：四次谈判修成正果" alt="微软诺基亚收购交易幕后的故事：四次谈判修成正果" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_017.jpg" alt="微软诺基亚收购交易幕后的故事：四次谈判修成正果" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	作者：思睿

【导读】美国科技博客网站AllThingsD近日发表文章，披露了微软与诺基亚谈判收购后者手机业务的始末。谈判始于微软CEO史蒂夫•鲍尔默(Steve Ballmer)的一句“我们能谈谈吗”，整个过程经历了四次大型谈判才让微软最终得偿所愿。



以下是文章内容摘要：

“我们能谈谈吗?”

这是微软CEO 史蒂夫•鲍尔默在今...	</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49952.html#comments"><span class="ds-thread-count" data-thread-key="49952" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%b9%b6%e8%b4%ad%ef%bc%8cit" rel="tag">并购，IT</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49950.html" title="民生电商是什么？该怎么走？" alt="民生电商是什么？该怎么走？" target="_blank">民生电商是什么？该怎么走？</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.huxiu.com/article/19863/1.html" rel="nofollow">虎嗅</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 10:04:50</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49950.html" title="民生电商是什么？该怎么走？" alt="民生电商是什么？该怎么走？" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_027.jpg" alt="民生电商是什么？该怎么走？" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
民生电子商务有限责任公司(下称“民生电商”)已于8月29日在深圳注册成立，经营期限为“永续经营”，注册资本30亿元，后又追加10亿。与一般电商企
业不同，民生电商的经营范围除了电子商务外，还包括创业投资、资产管理等金融业务。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49950.html#comments"><span class="ds-thread-count" data-thread-key="49950" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e8%a7%82%e7%82%b9%ef%bc%8c%e7%94%b5%e5%95%86" rel="tag">观点，电商</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49931.html" title="干货：移动分发那些事" alt="干货：移动分发那些事" target="_blank">干货：移动分发那些事</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.leiphone.com/app-distribution.html" rel="nofollow">雷锋网</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 09:55:33</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49931.html" title="干货：移动分发那些事" alt="干货：移动分发那些事" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_015.jpg" alt="干货：移动分发那些事" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	
经过十多年发展，BAT三分中国互联网，几无变数。百度连接人与信息，阿里连接人与商品，腾讯连接人与人，形成了搜索、电商和社交三大生态帝国。从
2008年前后的移动浪潮开始，形势正在逐步变化。移动端入口碎片化的存在,内容被分散到不同的渠道。谁掌握用户获得内容的渠道，谁就具备移动端的入口能
力。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49931.html#comments"><span class="ds-thread-count" data-thread-key="49931" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e7%a7%bb%e5%8a%a8%ef%bc%8c%e8%a7%82%e7%82%b9%ef%bc%8c%e5%90%90%e6%a7%bd" rel="tag">移动，观点，吐槽</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49934.html" title="i黑马投融资市场动态周刊(2013.9.2~9.6)" alt="i黑马投融资市场动态周刊(2013.9.2~9.6)" target="_blank">i黑马投融资市场动态周刊(2013.9.2~9.6)</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/07 09:44:17</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49934.html" title="i黑马投融资市场动态周刊(2013.9.2~9.6)" alt="i黑马投融资市场动态周刊(2013.9.2~9.6)" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_023.jpg" alt="i黑马投融资市场动态周刊(2013.9.2~9.6)" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	黑马哥为你盘点一周以来，那些国内外值得你关注的投融资大事件。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49934.html#comments"><span class="ds-thread-count" data-thread-key="49934" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e8%a7%82%e7%82%b9%ef%bc%8c%e6%8a%a5%e5%91%8a" rel="tag">观点，报告</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49926.html" title="阿里合伙人制度被拒后，马云的三个选择" alt="阿里合伙人制度被拒后，马云的三个选择" target="_blank">阿里合伙人制度被拒后，马云的三个选择</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">第一财经日报</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 17:44:12</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49926.html" title="阿里合伙人制度被拒后，马云的三个选择" alt="阿里合伙人制度被拒后，马云的三个选择" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_007.jpg" alt="阿里合伙人制度被拒后，马云的三个选择" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	日前有消息称，香港证监会已召开董事局会议，对于任何会被视为对阿里巴巴作出豁免，使其不需遵守现行上市规定的改变，证监会都予以否决，其中包括允许阿里巴巴采取合伙人架构上市的建议。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49926.html#comments"><span class="ds-thread-count" data-thread-key="49926" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e6%b8%af%e4%ba%a4%e6%89%80" rel="tag">港交所</a>, <a href="http://www.iheima.com/archives/tag/%e9%98%bf%e9%87%8c%e5%b7%b4%e5%b7%b4" rel="tag">阿里巴巴</a>, <a href="http://www.iheima.com/archives/tag/%e9%a9%ac%e4%ba%91" rel="tag">马云</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49924.html" title="易信推公众平台与自媒体的未来" alt="易信推公众平台与自媒体的未来" target="_blank">易信推公众平台与自媒体的未来</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/chenshao">陈少</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 17:28:34</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49924.html" title="易信推公众平台与自媒体的未来" alt="易信推公众平台与自媒体的未来" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_022.jpg" alt="易信推公众平台与自媒体的未来" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	

当微信5.0弱化公众平台功能，自媒体的菊花随之一紧。今天，易信公众平台开始公测，自媒体的菊花将为之绽放。绽放菊花的自媒体能否找到合适的盈利模式，现在我们来分析几种自媒体的盈利模式。

1、收取广告费：在文章中插入广告还是在广告中插入文章，这是个问题。广告模式的收费对象是企业，这样自媒体作为媒体，用户体验、客观性、独立性必然受到影响。而且，订阅者的...	</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49924.html#comments"><span class="ds-thread-count" data-thread-key="49924" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e8%87%aa%e5%aa%92%e4%bd%93" rel="tag">自媒体</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49915.html" title="【每日移动互联网】易信公共平台今日上线 针对企业开放注册" alt="【每日移动互联网】易信公共平台今日上线 针对企业开放注册" target="_blank">【每日移动互联网】易信公共平台今日上线 针对企业开放注册</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 16:59:34</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49915.html" title="【每日移动互联网】易信公共平台今日上线 针对企业开放注册" alt="【每日移动互联网】易信公共平台今日上线 针对企业开放注册" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_037.jpg" alt="【每日移动互联网】易信公共平台今日上线 针对企业开放注册" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	1、谷歌发布Chrome Apps新应用平台;2、易信公共平台今日上线 
针对企业开放注册;3、外媒称苹果正测试大屏幕手机 
4.8到6英寸;4、福布斯发2013中国最赚钱移动互联网公司：腾讯第一;5、UC优视总裁何小鹏：轻应用是必然趋势</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49915.html#comments"><span class="ds-thread-count" data-thread-key="49915" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e6%98%93%e4%bf%a1" rel="tag">易信</a>, <a href="http://www.iheima.com/archives/tag/%e8%8b%b9%e6%9e%9c" rel="tag">苹果</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49912.html" title="袁记串串香：一个麻辣烫品牌如何开店300家？" alt="袁记串串香：一个麻辣烫品牌如何开店300家？" target="_blank">袁记串串香：一个麻辣烫品牌如何开店300家？</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 15:58:40</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49912.html" title="袁记串串香：一个麻辣烫品牌如何开店300家？" alt="袁记串串香：一个麻辣烫品牌如何开店300家？" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_018.jpg" alt="袁记串串香：一个麻辣烫品牌如何开店300家？" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	作为街边小吃，串串香鲜有登上大雅之堂。不过，成立于1996年、以街边小店起家的“袁记串串香”现在却走起了公司化运营之路，并已经拥有300多家连锁店。在一个准入门槛偏低，竞争白热化的行业中，这家餐饮企业是如何突围的？</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49912.html#comments"><span class="ds-thread-count" data-thread-key="49912" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%b8%b2%e4%b8%b2%e9%a6%99" rel="tag">串串香</a>, <a href="http://www.iheima.com/archives/tag/%e5%88%9b%e4%b8%9a" rel="tag">创业</a>, <a href="http://www.iheima.com/archives/tag/%e9%ba%bb%e8%be%a3%e7%83%ab" rel="tag">麻辣烫</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49909.html" title="天朝PE/VC叫苦：征税征得无厘头！" alt="天朝PE/VC叫苦：征税征得无厘头！" target="_blank">天朝PE/VC叫苦：征税征得无厘头！</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="http://www.iheima.com/archives/author/xiaohong">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 15:27:16</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49909.html" title="天朝PE/VC叫苦：征税征得无厘头！" alt="天朝PE/VC叫苦：征税征得无厘头！" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_005.jpg" alt="天朝PE/VC叫苦：征税征得无厘头！" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	有早期投资人亦指出，对天使、种子期投资来说，项目成功率通常会更低，如果税务部门只着眼于盈利的项目进行征税，那么无疑会出现越是早期投资，税负越重的情况，这无疑抑制了主要服务于小微企业的早期投资基金的投资积极性。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49909.html#comments"><span class="ds-thread-count" data-thread-key="49909" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/pe" rel="tag">PE</a>, <a href="http://www.iheima.com/archives/tag/vc" rel="tag">VC</a></span>
                   </div> 
                </div>
            </div>
	    
	   		
  						        	<div class="hm_articleHome">
            	<h4 class="hm_percent100"><a href="http://www.iheima.com/archives/49888.html" title="【每日一黑马】国维牙医：台湾牙医的内地淘金术" alt="【每日一黑马】国维牙医：台湾牙医的内地淘金术" target="_blank">【每日一黑马】国维牙医：台湾牙医的内地淘金术</a>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
                <div class="hm_postInfo left">
                	<span class="hm_author"><a href="" rel="nofollow">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 14:26:53</span>
                </div>
            	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49888.html" title="【每日一黑马】国维牙医：台湾牙医的内地淘金术" alt="【每日一黑马】国维牙医：台湾牙医的内地淘金术" target="_blank"><img src="<%=request.getContextPath()%>/team_files/timthumb_036.jpg" alt="【每日一黑马】国维牙医：台湾牙医的内地淘金术" height="150" width="210"></a>
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	国维牙医最初创办于1992年，2005年开始连锁化经营。目前在台湾地区，国维牙医拥有86家连锁门店，是最大的牙医连锁机构;而在内地，国维牙医仅拥有3家门店。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49888.html#comments"><span class="ds-thread-count" data-thread-key="49888" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%9b%bd%e7%bb%b4%e7%89%99%e5%8c%bb" rel="tag">国维牙医</a>, <a href="http://www.iheima.com/archives/tag/%e7%89%99%e5%8c%bb" rel="tag">牙医</a></span>
                   </div> 
                </div>
            </div>
	    
	    <div style="display: block;" class="hm_pageNo">
            	<a href="http://www.iheima.com/" style="color:white;background:#2489fb;">1</a><a href="http://www.iheima.com/page/2">2</a><a href="http://www.iheima.com/page/3">3</a><a href="http://www.iheima.com/page/4">4</a><a href="http://www.iheima.com/page/5">5</a><a href="http://www.iheima.com/page/6">6</a><a href="http://www.iheima.com/page/7">7</a><a href="http://www.iheima.com/page/8">8</a><a href="http://www.iheima.com/page/2"> 下一页 </a><a href="http://www.iheima.com/page/11" class="extend" title="跳转到"> 第11页 </a><a href="http://www.iheima.com/page/212" class="extend" title="跳转到最后一页"> 末页第212页 </a> &nbsp;&nbsp;<!--<a href="http://www.iheima.com/scroll-html">所有新闻</a>-->
		   </div>
		   <div class="scroll-height"></div>
		   <div class="loading" style="text-align: center; display: none;">更多精彩内容加载中...</div>
        </div>
		         <div class="hm_sideWrap">
				<div class="hm_ideaPost">
				<div class="hm_sideAD"><center style=" margin-left:17px;"><a href="http://event.iheima.com/jiaoyu/" target="_blank"><img original="/wp-content/uploads/huaweiheima.jpg" src="<%=request.getContextPath()%>/team_files/huaweiheima.jpg" alt="师徒选拔赛" title="师徒选拔赛" height="120" width="293"></a></center></div>
        
            	<h6><span>见解</span></h6>
                <ul>
			
            			  
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50021.html" title="亏损的央企们路在何方？" alt="亏损的央企们路在何方？" target="_blank"><img original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/172.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_040.jpg" alt="亏损的央企们路在何方？" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/50021.html" title="亏损的央企们路在何方？" alt="亏损的央企们路在何方？" target="_blank">亏损的央企们路在何方？</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="http://www.eeo.com.cn/2013/0907/249564.shtml">经济观察网</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 16:51:47</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	警报不只在钢铁业，中国远洋、中国铝业、中冶集团等都在亏损着。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50021.html#comments"><span class="ds-thread-count" data-thread-key="50021" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%9b%bd%e4%bc%81" rel="tag">国企</a>, <a href="http://www.iheima.com/archives/tag/%e5%a4%ae%e4%bc%81" rel="tag">央企</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/50001.html" title="易信需要一个苦大仇深的人!" alt="易信需要一个苦大仇深的人!" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/F200905121830163026221924.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_035.jpg" alt="易信需要一个苦大仇深的人!" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/50001.html" title="易信需要一个苦大仇深的人!" alt="易信需要一个苦大仇深的人!" target="_blank">易信需要一个苦大仇深的人!</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="http://weibo.com/u/2705447542">奥德赛发</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 12:01:03</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	

微信5.0发布以后，赚钱的脚步有点儿急了，我觉得有必要尝试下别的应用，不然下一个10年，还是...	</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/50001.html#comments"><span class="ds-thread-count" data-thread-key="50001" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%b8%81%e7%a3%8a" rel="tag">丁磊</a>, <a href="http://www.iheima.com/archives/tag/%e5%be%ae%e4%bf%a1" rel="tag">微信</a>, <a href="http://www.iheima.com/archives/tag/%e6%98%93%e4%bf%a1" rel="tag">易信</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49976.html" title="得屌丝者得天下:看小米、黄太吉、余额宝如何俘获屌丝用户" alt="得屌丝者得天下:看小米、黄太吉、余额宝如何俘获屌丝用户" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/160.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_025.jpg" alt="得屌丝者得天下:看小米、黄太吉、余额宝如何俘获屌丝用户" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49976.html" title="得屌丝者得天下:看小米、黄太吉、余额宝如何俘获屌丝用户" alt="得屌丝者得天下:看小米、黄太吉、余额宝如何俘获屌丝用户" target="_blank">得屌丝者得天下:看小米、黄太吉、余额宝如何俘获屌丝用户</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="http://www.iheima.com/www.tmtpost.com">钛媒体</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/08 10:10:07</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	今年4月发布的一项调查表明全国“屌丝”人数超5.26亿，“屌丝”一时风光无两，并衍生出“屌丝经济学”...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49976.html#comments"><span class="ds-thread-count" data-thread-key="49976" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%b0%8f%e7%b1%b3" rel="tag">小米</a>, <a href="http://www.iheima.com/archives/tag/%e5%b1%8c%e4%b8%9d" rel="tag">屌丝</a>, <a href="http://www.iheima.com/archives/tag/%e9%bb%84%e5%a4%aa%e6%9e%81" rel="tag">黄太极</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49900.html" title="上海自贸区要跳出政策优惠的传统模式" alt="上海自贸区要跳出政策优惠的传统模式" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/auto_save_image/2013/09/091820ssf.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_014.jpg" alt="上海自贸区要跳出政策优惠的传统模式" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49900.html" title="上海自贸区要跳出政策优惠的传统模式" alt="上海自贸区要跳出政策优惠的传统模式" target="_blank">上海自贸区要跳出政策优惠的传统模式</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="">财经网</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 17:18:19</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	作为一种全新的制度试验，自贸区更重要的应该是一种制度创新，而不是政策优惠。如果未来的自贸区内仍然是以...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49900.html#comments"><span class="ds-thread-count" data-thread-key="49900" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%b8%8a%e6%b5%b7%e8%87%aa%e8%b4%b8%e5%8c%ba" rel="tag">上海自贸区</a>, <a href="http://www.iheima.com/archives/tag/%e4%bc%98%e6%83%a0" rel="tag">优惠</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49886.html" title="淘宝卖车动了谁的奶酪" alt="淘宝卖车动了谁的奶酪" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/151.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_026.jpg" alt="淘宝卖车动了谁的奶酪" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49886.html" title="淘宝卖车动了谁的奶酪" alt="淘宝卖车动了谁的奶酪" target="_blank">淘宝卖车动了谁的奶酪</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="">北京晨报 </a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 13:53:20</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	汽车厂家也明白，就目前而言，互联网很难促成直接销售，为什么多家汽车企业还趋之若鹜热捧网络卖车呢?</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49886.html#comments"><span class="ds-thread-count" data-thread-key="49886" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e6%b7%98%e5%ae%9d%e5%8d%96%e8%bd%a6" rel="tag">淘宝卖车</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49868.html" title="母婴网站SNS化是一个伪命题" alt="母婴网站SNS化是一个伪命题" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/auto_save_image/2013/09/035624pZA.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_038.jpg" alt="母婴网站SNS化是一个伪命题" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49868.html" title="母婴网站SNS化是一个伪命题" alt="母婴网站SNS化是一个伪命题" target="_blank">母婴网站SNS化是一个伪命题</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="">飞天兔子</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/06 11:56:23</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	社交媒体革命浪潮席卷的这些年，SNS模式大热，但SNS并不是互联网媒体转型的更高级别，其挑战传统用户...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49868.html#comments"><span class="ds-thread-count" data-thread-key="49868" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/sns" rel="tag">SNS</a>, <a href="http://www.iheima.com/archives/tag/%e6%af%8d%e5%a9%b4" rel="tag">母婴</a>, <a href="http://www.iheima.com/archives/tag/%e7%a4%be%e4%ba%a4" rel="tag">社交</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49794.html" title="TCL爱奇艺“TV+”的优势与败笔" alt="TCL爱奇艺“TV+”的优势与败笔" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/1110.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_030.jpg" alt="TCL爱奇艺“TV+”的优势与败笔" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49794.html" title="TCL爱奇艺“TV+”的优势与败笔" alt="TCL爱奇艺“TV+”的优势与败笔" target="_blank">TCL爱奇艺“TV+”的优势与败笔</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="http://weibo.com/zhaohuifang">易方寒</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/05 15:22:33</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	互联网公司进军电视领域，让智能电视的价格一路走低，消费者奔走相告。乐视超级电视让60寸智能电视的价格...	</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49794.html#comments"><span class="ds-thread-count" data-thread-key="49794" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49777.html" title="中小企业发展的两种战略管理" alt="中小企业发展的两种战略管理" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/auto_save_image/2013/09/0355098H3.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_016.jpg" alt="中小企业发展的两种战略管理" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49777.html" title="中小企业发展的两种战略管理" alt="中小企业发展的两种战略管理" target="_blank">中小企业发展的两种战略管理</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="">牛津管理评论</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/05 11:55:09</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	中小型企业发展到现在取得了不错的成绩。但面对日益激烈的市场竞争，在国企的压力下，中小企业面临夹缝中生...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49777.html#comments"><span class="ds-thread-count" data-thread-key="49777" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e4%b8%ad%e5%b0%8f%e4%bc%81%e4%b8%9a" rel="tag">中小企业</a>, <a href="http://www.iheima.com/archives/tag/%e6%88%98%e7%95%a5%e7%ae%a1%e7%90%86" rel="tag">战略管理</a>, <a href="http://www.iheima.com/archives/tag/%e7%ae%a1%e7%90%86" rel="tag">管理</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49744.html" title="对话吴刚：火爆的手游为何都急着卖身？" alt="对话吴刚：火爆的手游为何都急着卖身？" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/144.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_033.jpg" alt="对话吴刚：火爆的手游为何都急着卖身？" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49744.html" title="对话吴刚：火爆的手游为何都急着卖身？" alt="对话吴刚：火爆的手游为何都急着卖身？" target="_blank">对话吴刚：火爆的手游为何都急着卖身？</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="">上方网</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/05 08:54:10</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	对于资本玩家们而言，任何能与手机游戏沾上边的机会，都意味着巨额的交易利润。</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49744.html#comments"><span class="ds-thread-count" data-thread-key="49744" data-replace="1">0</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e6%89%8b%e6%b8%b8" rel="tag">手游</a></span>
                   </div> 
                </div>
                    </li>
               
						                	<li>
                <div class="hm_titleWrap">
                	<div class="hm_articleFace">
                	<a href="http://www.iheima.com/archives/49655.html" title="史玉柱：我的失误与教训" alt="史玉柱：我的失误与教训" target="_blank"><img style="display: inline;" original="http://www.iheima.com/wp-content/themes/xinheima/include/timthumb.php?src=http://www.iheima.com/wp-content/uploads/2013/09/99.jpg&amp;q=95&amp;w=60&amp;h=60" src="<%=request.getContextPath()%>/team_files/timthumb_009.jpg" alt="史玉柱：我的失误与教训" height="60" width="60"></a>
               		 </div>
                     <div style="height:60px; width:240px; float:right; position:relative;">
                     
                	<h4 class="hm_articleFace_title"><a href="http://www.iheima.com/archives/49655.html" title="史玉柱：我的失误与教训" alt="史玉柱：我的失误与教训" target="_blank">史玉柱：我的失误与教训</a></h4>
                    <div class="hm_postInfo" style=" position:absolute; bottom:0;">
                        <span class="hm_author"><a href="">i黑马</a></span>&nbsp;|&nbsp;<span class="hm_date">2013/09/04 11:17:19</span>
                    </div>
                    
                    </div>
                    
                </div>
                <div class="hm_summary">
                    <p class="hm_excerpt">
                    	我是一个中国著名的失败者。今天我在这里，总结一下过去失误的地方和教训，希望对大家有所帮助。如果完全地...</p>
                   <div class="hm_postMeta">
                    <span class="hm_comment">评论(<a href="http://www.iheima.com/archives/49655.html#comments"><span class="ds-thread-count" data-thread-key="49655" data-replace="1">5</span></a>)</span>
                    <span class="hm_tags"><a>标签:&nbsp;</a><a href="http://www.iheima.com/archives/tag/%e5%8f%b2%e7%8e%89%e6%9f%b1%ef%bc%8c%e8%87%aa%e8%bf%b0" rel="tag">史玉柱，自述</a></span>
                   </div> 
                </div>
                    </li>
             				
			
                </ul>
            </div>
            <div class="hm_sideAD"><center style=" margin-left:17px;"><a href="http://www.seesang.com/" target="_blank"><img src="<%=request.getContextPath()%>/team_files/240240.jpg" alt="" title=" width=" 293"="" height="240"></a></center></div>
            <div class="hm_productsPost sidebar">
            	<h6><span>融资·趋势·产品</span></h6>
                <ul>
		            			  
                	<li><a href="http://www.iheima.com/archives/47608.html" title="金山云宣布完成A轮融资" alt="金山云宣布完成A轮融资" target="_blank">金山云宣布完成A轮融资..</a></li>
			    
                	<li><a href="http://www.iheima.com/archives/47202.html" title="SimpleLegal用机器学习帮助客户审核法务账单" alt="SimpleLegal用机器学习帮助客户审核法务账单" target="_blank">SimpleLegal用机器学习帮助客户..</a></li>
			    
                	<li><a href="http://www.iheima.com/archives/43856.html" title="网贷资讯网推出平台担保业务" alt="网贷资讯网推出平台担保业务" target="_blank">网贷资讯网推出平台担保业务..</a></li>
			    
                	<li><a href="http://www.iheima.com/archives/43555.html" title="小米电视通过3C认证：或于8月16日发布！" alt="小米电视通过3C认证：或于8月16日发布！" target="_blank">小米电视通过3C认证：或于8月16日发布..</a></li>
			    
                	<li><a href="http://www.iheima.com/archives/43078.html" title="英开售飞行自行车：可飞3小时！" alt="英开售飞行自行车：可飞3小时！" target="_blank">英开售飞行自行车：可飞3小时！..</a></li>
			  				
			        
                </ul>
            </div>
            <div class="hm_sideAD"><a href="http://www.iheima.com/huawei" target="_blank"><img src="<%=request.getContextPath()%>/team_files/huaweihei.jpg" alt="边栏广告2" title="华为黑马特训营"></a></div>
            <div class="hm_magPost sidebar">
            	<h6><span>服务推荐</span></h6>
                <center><a href="http://www.ucloud.cn/act" target="_blank"><img src="<%=request.getContextPath()%>/team_files/sideMag.png" alt="ucloud云主机" title="ucloud云主机"></a></center>
            </div>
            <div class="hm_greatCommentsPost sidebar">
            <h6><span>精彩评论</span></h6>
            	<ul>
                	
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49659.html?spm=29F459A44FEE58C7">【败局】太平洋直购网传销帝国覆灭：骗38亿受害者680万</a></div>
                        <div class="hm_commentBody">
                        	<p>当初在无锡解放北路，我就被一个人拦住，他跟我讲得天花乱缀，公司有多好，董事长唐庆南有多牛，还劝我买本唐董的书看看。</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49659.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/7.png" class="avatar avatar-50 photo avatar-default" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49659.html?spm=29F459A44FEE58C7" class="hm_author">@郝-宗豪</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49794.html?spm=29F459A44FEE58C7">TCL爱奇艺“TV+”的优势与败笔</a></div>
                        <div class="hm_commentBody">
                        	<p>最后一段实在是黑的没水平</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49794.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/4.png" class="avatar avatar-50 photo avatar-default" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49794.html?spm=29F459A44FEE58C7" class="hm_author">@超隐之仕</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49698.html?spm=29F459A44FEE58C7">大话科技：骨传导技术，让女神爱上坐车</a></div>
                        <div class="hm_commentBody">
                        	<p>最后一句好伤感，一篇不错的文章</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49698.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/7.png" class="avatar avatar-50 photo avatar-default" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49698.html?spm=29F459A44FEE58C7" class="hm_author">@柳尚</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49762.html?spm=29F459A44FEE58C7">卖了17.5亿美元的扬基蜡烛是家怎样的公司？</a></div>
                        <div class="hm_commentBody">
                        	<p>很有特色，值得研究，比如相关性的自由品牌，就是很好的策略。</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49762.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/7.png" class="avatar avatar-50 photo" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49762.html?spm=29F459A44FEE58C7" class="hm_author">@jobs-梁敦敏</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49740.html?spm=29F459A44FEE58C7">如何从200万到2个亿：一家传统零售商艰难触电启示录</a></div>
                        <div class="hm_commentBody">
                        	<p>占据年轻人的心才是关键，在看到这篇文章前，我不知道有这家企业，这个品牌，这个淘宝店，这，
就是问题。传统企业，比如，李宁、特步、安踏，我都是知道的，但这个从200万到2个亿的企业，脑中没有一丁点的印象，叫我无法下笔（无法敲下键盘
了。。。。）可能高端，我没有接触吧。</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49740.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/6.png" class="avatar avatar-50 photo" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49740.html?spm=29F459A44FEE58C7" class="hm_author">@jobs-梁敦敏</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49619.html?spm=29F459A44FEE58C7">100分的输家：一个146年历史的诺基亚为何4年间陨落</a></div>
                        <div class="hm_commentBody">
                        	<p>看了太多落鸡鸭这方面的文章了，都大同小异，没有什么新意。</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49619.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/8.png" class="avatar avatar-50 photo" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49619.html?spm=29F459A44FEE58C7" class="hm_author">@粉红网</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49749.html?spm=29F459A44FEE58C7">“魂斗罗”中的那些操作感、游戏彩蛋、社交：值得现代游戏开发者学习的上古神作</a></div>
                        <div class="hm_commentBody">
                        	<p>"如心使臂"的操控感，这一点说的的确不错</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49749.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/7.png" class="avatar avatar-50 photo avatar-default" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49749.html?spm=29F459A44FEE58C7" class="hm_author">@石破烂夫斯基</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49619.html?spm=29F459A44FEE58C7">100分的输家：一个146年历史的诺基亚为何4年间陨落</a></div>
                        <div class="hm_commentBody">
                        	<p>不管企业，还是个人，都要有危机感！没人要注定打工一辈子，打工不管多努力，都很难得到自己想要的生活，工资的上涨远远跟不上物价的上涨。你还在为生活烦恼吗？你还在为买房子而担忧吗？你还在为未来迷茫吗？欢迎加入我们的平凡人创业俱乐部?</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49619.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/7.png" class="avatar avatar-50 photo avatar-default" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49619.html?spm=29F459A44FEE58C7" class="hm_author">@下班后创业</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49619.html?spm=29F459A44FEE58C7">100分的输家：一个146年历史的诺基亚为何4年间陨落</a></div>
                        <div class="hm_commentBody">
                        	<p>真是有趣， 从呼风唤雨到寄人篱下</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49619.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="" src="<%=request.getContextPath()%>/team_files/2.png" class="avatar avatar-50 photo avatar-default" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49619.html?spm=29F459A44FEE58C7" class="hm_author">@张仕伟</a>
                        </div>
                </li>
				<li>
                    	<div class="hm_original"><span>原文：</span><a href="http://www.iheima.com/archives/49252.html?spm=29F459A44FEE58C7">一个吊丝的自述：我如何用O2O改造了一家公司</a></div>
                        <div class="hm_commentBody">
                        	<p>代理过一段时间富友，针对中小型月流水50W以内的商户来说，最大的需求点还是低费率/封顶以
及宽松的政策，不得不说，富友相比其他支付公司来说，政策比一些所谓的全国支付牌照公司好，而且安全性也比一些低费率走套码的小公司高很多。但是说到
底，POS中小型商户的客户管理系统非常不实用，后台营销系统录入客户信息还是需要手机号输入，配合比短信通道公司还高的短信费用比如随行付这样的业
务，100家也不见得有1家能用。不过富友优势大，铺面较广，现在貌似和平安也在合作了。</p>
                        </div>
                        <div class="hm_userInfo">
                        	<a href="http://www.iheima.com/archives/49252.html/#comment?spm=29F459A44FEE58C7" class="hm_userFace"><img alt="大卫" src="<%=request.getContextPath()%>/team_files/tan77qq_avatar-50x50.jpg" class="avatar avatar-50 photo" height="50" width="50"></a>
                            <a href="http://www.iheima.com/archives/49252.html?spm=29F459A44FEE58C7" class="hm_author">@tan77qq</a>
                        </div>
                </li>                </ul>
            </div>
			<!--阅读历史开始-->
			<!--	<h6><span>我曾经阅读</span></h6>
						<div id="view-history"></div>-->
			<!--阅读历史结束-->
        </div>    </div>
    <!--main wrap end-->
<!--footer wrap beginning-->
    <div id="hm_footer">
    	<div class="hm_footerArticle">
        	<div class="hm_special">
            	<h6>专题</h6>
					<div class="hm_specialFace">
                	<a href="http://www.iheima.com/damaijia/"><img src="<%=request.getContextPath()%>/team_files/maiL.jpg" alt="在过去，并购退出被视为创业失败，成功者只有一条走向IPO的路。但是现在，并购退出成为所有创业者必须思考的新选项。谁是大买家，他们怎么买？身为创业者，你必须了解。" title="在过去，并购退出被视为创业失败，成功者只有一条走向IPO的路。但是现在，并购退出成为所有创业者必须思考的新选项。谁是大买家，他们怎么买？身为创业者，你必须了解。" height="150" width="200"></a>
                </div>
                <h4><a href="http://www.iheima.com/damaijia/">创业者们到了卖公司的创业时代了</a></h4>
                <p class="hm_excerpt">在过去，并购退出被视为创业失败，成功者只有一条走向IPO的路。但是现在，并购退出成为所有创业者必须思考的新选项。谁是大买家，他们怎么买？身为创业者，你必须了解。.</p>
                <a href="http://www.iheima.com/damaijia/" class="hm_readMore">阅读更多</a>               <!-- <div class="hm_specialFace">
                	<a href="" ><img src="http://www.iheima.com/wp-content/themes/xinheima/images/specialFace.jpg" alt="" title="" /></a>
                </div>
                <h4><a href="">2013创业板女富豪Top50榜单</a></h4>
                <p class="hm_excerpt">最近公开过的阿里巴巴投资和收购的对象包括友盟（收购）、微博（投资）、高德地图（投资），不久前增持的有丁丁优惠（投资），今年早些时候收购的有虾米（收购）。前几年投资的明星项目有美团、陌陌、易图通（地图），不久前增持的有丁丁优惠（投资），今年早些时候收购的有虾米...</p>
                <a href="" class="hm_readMore">阅读更多</a>
				-->
            </div>
            <div class="hm_activity">
            	<h6>服务推荐</h6>
				<a href="https://www.upyun.com/?md=chuangyejia" target="_blank"><img src="<%=request.getContextPath()%>/team_files/upyun.png" alt="" title="" height="150" width="170"></a>             <!--   <a href="" ><img src="http://www.iheima.com/wp-content/themes/xinheima/images/activityFace.jpg" alt="" title="" /></a> -->
            </div>
        </div>
        <div class="hm_cooperation">
        	<h6>合作机构</h6>
            <ul>
            	<li><a href="http://hmds.iheima.com/" target="_blank">黑马大赛</a></li>
<li><a href="http://vc.iheima.com/" target="_blank">i黑马投融资平台</a></li>
<li><a href="http://www.huxiu.com/" target="_blank">虎嗅网</a></li>
<li><a href="http://tech.163.com/links" target="_blank">网易科技</a></li>
<li><a href="http://www.leiphone.com/" target="_blank">雷锋网</a></li>
<li><a href="http://news.pconline.com.cn/" target="_blank">品科技</a></li>
<li><a href="http://www.apkbus.com/" target="_blank">移动开发者门户</a></li>
            </ul>
        </div>
        <div class="hm_footerNavWrap">
        	<ul class="hm_footerNav">
                <li><a href="http://www.iheima.com/sitemap.html">站点地图</a>&nbsp;|&nbsp;</li>
                <li><a href="http://www.iheima.com/html/about/contactus/">联系我们</a>&nbsp;|&nbsp;</li>
                <li><a href="http://www.iheima.com/html/about/hr/">招聘信息</a>&nbsp;|&nbsp;</li>
                <li>i黑马读者群：25170814&nbsp;|&nbsp;</li>
                <li>市场合作：market#chuangyejia.com(#换成@)&nbsp;|&nbsp;</li>
		<li>创业家反腐:fanfu@chuangyejia.com</li>
            </ul>
            <div class="hm_follow">
             <!--   <h6>关注我们</h6>
                <a href=""><img src="http://www.iheima.com/wp-content/themes/xinheima/images/follow_fb.png" alt="" title="" /></a><a href=""><img src="http://www.iheima.com/wp-content/themes/xinheima/images/follow_twitter.png" alt="" title="" /></a><a href=""><img src="http://www.iheima.com/wp-content/themes/xinheima/images/follow_google+.png" alt="" title="" /></a><a href=""><img src="http://www.iheima.com/wp-content/themes/xinheima/images/follow_weibo.png" alt="" title="" /></a><a href=""><img src="http://www.iheima.com/wp-content/themes/xinheima/images/follow_qzone.png" alt="" title="" /></a><a href=""><img src="http://www.iheima.com/wp-content/themes/xinheima/images/follow_renren.png" alt="" title="" /></a>
           --> </div>
        </div>
        <div class="hm_copyright">
        	<span>Copyright © 《i黑马网》All Right Reserved 版权所有 复制必究</span>
            <a href="http://www.miitbeian.gov.cn/">京ICP备12006413号</a><script src="<%=request.getContextPath()%>/team_files/stat.php" language="JavaScript"></script><script src="<%=request.getContextPath()%>/team_files/cnzz_core.php" charset="utf-8" type="text/javascript"></script><a href="http://www.cnzz.com/stat/website.php?web_id=5023045" target="_blank" title="站长统计"><img src="<%=request.getContextPath()%>/team_files/pic.gif" border="0" hspace="0" vspace="0"></a>
        </div>
    </div>
    <!--footer warp end-->
	</div>


<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-40906252-1', 'iheima.com');
  ga('send', 'pageview');

</script>

</body></html>