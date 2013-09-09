<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bean"  uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../include/header.jsp" %>
<div class="ui-tab">
<div class="categories-top">
<a href="http://www.demohour.com/projects/discover/0_0_0_0">浏览项目</a>
<span>/</span>
推荐项目
</div>
</div>
<div class="ui-categories">
<div class="ui-categories-l">
<div class="ui-categories-icon-1">属性：</div>
<div class="ui-categories-l-line"></div>
<div class="ui-categories-icon-1">分类：</div>
<div class="ui-categories-l-line"></div>
<div class="ui-categories-icon-1">地区：</div>
<div class="ui-categories-l-line"></div>
<div class="ui-categories-icon-2">排序：</div>
</div>
<div class="ui-categories-r">
<a href="http://www.demohour.com/projects/discover/0_0_0_6" id="attribute_0">所有项目</a>
<a class="ui-categories-current" href="http://www.demohour.com/projects/discover/1_0_0_6" id="attribute_1">推荐项目</a>
<a href="http://www.demohour.com/projects/discover/2_0_0_6" id="attribute_2">经典项目</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_6" id="attribute_3">预热中</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_6" id="attribute_4">筹资中</a>
<a href="http://www.demohour.com/projects/discover/5_0_0_6" id="attribute_5">筹资成功</a>
<a href="http://www.demohour.com/projects/discover/6_0_0_6" id="attribute_6">筹资失败</a>
<div class="ui-categories-r-line"></div>
<a class="ui-categories-current" href="http://www.demohour.com/projects/discover/1_0_0_6" id="category_0">所有分类</a>
<a href="http://www.demohour.com/projects/discover/1_927151_0_6" id="category_927151">设计</a>
<a href="http://www.demohour.com/projects/discover/1_927158_0_6" id="category_927158">科技</a>
<a href="http://www.demohour.com/projects/discover/1_927159_0_6" id="category_927159">音乐</a>
<a href="http://www.demohour.com/projects/discover/1_927156_0_6" id="category_927156">影视</a>
<a href="http://www.demohour.com/projects/discover/1_927163_0_6" id="category_927163">食品</a>
<a href="http://www.demohour.com/projects/discover/1_927152_0_6" id="category_927152">动漫</a>
<a href="http://www.demohour.com/projects/discover/1_927161_0_6" id="category_927161">出版</a>
<a href="http://www.demohour.com/projects/discover/1_927164_0_6" id="category_927164">游戏</a>
<a href="http://www.demohour.com/projects/discover/1_927157_0_6" id="category_927157">摄影</a>
<a href="http://www.demohour.com/projects/discover/1_927162_0_6" id="category_927162">其他</a>
<div class="ui-categories-r-line"></div>
<a class="ui-categories-current" href="http://www.demohour.com/projects/discover/1_0_0_6" id="location_0">所有地区</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E5%8C%97%E4%BA%AC_6" id="location_北京">北京</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E5%B9%BF%E4%B8%9C_6" id="location_广东">广东</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E4%B8%8A%E6%B5%B7_6" id="location_上海">上海</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E6%B5%99%E6%B1%9F_6" id="location_浙江">浙江</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E6%B1%9F%E8%8B%8F_6" id="location_江苏">江苏</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E5%9B%9B%E5%B7%9D_6" id="location_四川">四川</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E6%B5%B7%E5%A4%96_6" id="location_海外">海外</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E5%B1%B1%E4%B8%9C_6" id="location_山东">山东</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E7%A6%8F%E5%BB%BA_6" id="location_福建">福建</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E6%B9%96%E5%8D%97_6" id="location_湖南">湖南</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E6%B9%96%E5%8C%97_6" id="location_湖北">湖北</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E5%A4%A9%E6%B4%A5_6" id="location_天津">天津</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E9%87%8D%E5%BA%86_6" id="location_重庆">重庆</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E4%BA%91%E5%8D%97_6" id="location_云南">云南</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E9%99%95%E8%A5%BF_6" id="location_陕西">陕西</a>
<a href="http://www.demohour.com/projects/discover/1_0_%E8%BE%BD%E5%AE%81_6" id="location_辽宁">辽宁</a>
<div class="ui-categories-r-line"></div>
<a href="http://www.demohour.com/projects/discover/1_0_0_0" id="sort_0">最近更新</a>
<a href="http://www.demohour.com/projects/discover/1_0_0_1" id="sort_1">金额最高</a>
<a href="http://www.demohour.com/projects/discover/1_0_0_2" id="sort_2">话题最多</a>
<a href="http://www.demohour.com/projects/discover/1_0_0_3" id="sort_3">支持最多</a>
<a href="http://www.demohour.com/projects/discover/1_0_0_4" id="sort_4">关注最多</a>
<a href="http://www.demohour.com/projects/discover/1_0_0_5" id="sort_5">评价最高</a>
<a class="ui-categories-current" href="http://www.demohour.com/projects/discover/1_0_0_6" id="sort_6">最新上线</a>
</div>
</div>

<div class="categorieswrap">
<div id="projects" class="project-list">
<c:forEach items="${projects}" var="project" varStatus="s"> 

<ul class="project-one">
<li class="project-thumbnail">
<a href="<%=request.getContextPath()%>/projects/view/${project.id}" title="史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商" target="_blank"><img src="${ imagehost }project-medium-${project.picture}" />"></a></li>
<li class="project-titile"><a href="<%=request.getContextPath()%>/projects/view/${project.id}" title="史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商">${project.name }</a></li>
<li class="project-function">
<a href="<%=request.getContextPath()%>/projects/${project.id}/posts" title="此项目有414个话题" class="project-p-on">话题：414</a>
<a href="<%=request.getContextPath()%>/projects/${project.id}/backers" title="5408用户支持此项目" class="project-g-on">支持：5408</a>
<a href="<%=request.getContextPath()%>/projects/discover/4_0_0_0" class="project-g-running">${project.status }筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>135%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>1,354,394</span></strong>已获支持</p>
<p class="widthc"><strong>
9天
</strong>剩余时间</p>
</div>
</li>
</ul>
</c:forEach>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320816" title="多用途定位器--“找找”让我们不再失去彼此！" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-739-11739-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320816" title="多用途定位器--“找找”让我们不再失去彼此！">多用途定位器--“找找”让我们不再失去彼此！</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320816/posts" title="此项目有26个话题" class="project-p-on">话题：26</a>
<a href="http://www.demohour.com/projects/320816/backers" title="0用户支持此项目" class="project-g-on">支持：0</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:0%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>0%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>0</span></strong>已获支持</p>
<p class="widthc"><strong>
59天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/322531" title="Feltouch magic  革命性的智能电视控制设备" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-486-12486-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/322531" title="Feltouch magic  革命性的智能电视控制设备">Feltouch magic  革命性的智能电视控制设备</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/322531/posts" title="此项目有21个话题" class="project-p-on">话题：21</a>
<a href="http://www.demohour.com/projects/322531/backers" title="1用户支持此项目" class="project-g-on">支持：1</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:0%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>0%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>20</span></strong>已获支持</p>
<p class="widthc"><strong>
29天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320375" title="UShare Music：唤醒你的音箱，让音乐Wi-Fi起来" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-870-11870-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320375" title="UShare Music：唤醒你的音箱，让音乐Wi-Fi起来">UShare Music：唤醒你的音箱，让音乐Wi-Fi起来</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320375/posts" title="此项目有62个话题" class="project-p-on">话题：62</a>
<a href="http://www.demohour.com/projects/320375/backers" title="62用户支持此项目" class="project-g-on">支持：62</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:49%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>49%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>9,880</span></strong>已获支持</p>
<p class="widthc"><strong>
59天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/319150" title="充电器" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-323-12323-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/319150" title="充电器">充电器</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/319150/posts" title="此项目有16个话题" class="project-p-on">话题：16</a>
<a href="http://www.demohour.com/projects/319150/subscribers" title="65用户关注此项目" class="project-g-on">关注：65</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:6%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>6%</strong>热度</p>
<p class="widthb"><strong><span>2624</span></strong>浏览人数</p>
<p class="widthc"><strong>7天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320255" title="纪录片《无尽头之旅》---缅甸金三角的黑色镜头" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-952-11952-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320255" title="纪录片《无尽头之旅》---缅甸金三角的黑色镜头">纪录片《无尽头之旅》---缅甸金三角的黑色镜头</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320255/posts" title="此项目有10个话题" class="project-p-on">话题：10</a>
<a href="http://www.demohour.com/projects/320255/backers" title="23用户支持此项目" class="project-g-on">支持：23</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:4%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>4%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>1,780</span></strong>已获支持</p>
<p class="widthc"><strong>
89天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/322177" title="sciener科技侠智能锁" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-335-12335-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/322177" title="sciener科技侠智能锁">sciener科技侠智能锁</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/322177/posts" title="此项目有18个话题" class="project-p-on">话题：18</a>
<a href="http://www.demohour.com/projects/322177/subscribers" title="138用户关注此项目" class="project-g-on">关注：138</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>197%</strong>热度</p>
<p class="widthb"><strong><span>3466</span></strong>浏览人数</p>
<p class="widthc"><strong>14天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/322072" title="Talking Timer（对讲提示器）" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-287-12287-medium.png"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/322072" title="Talking Timer（对讲提示器）">Talking Timer（对讲提示器）</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/322072/posts" title="此项目有40个话题" class="project-p-on">话题：40</a>
<a href="http://www.demohour.com/projects/322072/subscribers" title="289用户关注此项目" class="project-g-on">关注：289</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:20%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>20%</strong>热度</p>
<p class="widthb"><strong><span>3470</span></strong>浏览人数</p>
<p class="widthc"><strong>15天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321626" title="中美合拍悬疑电影《破镜》 华人电影精英纽约联合制作" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-089-12089-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321626" title="中美合拍悬疑电影《破镜》 华人电影精英纽约联合制作">中美合拍悬疑电影《破镜》 华人电影精英纽约联合制作</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321626/posts" title="此项目有23个话题" class="project-p-on">话题：23</a>
<a href="http://www.demohour.com/projects/321626/backers" title="43用户支持此项目" class="project-g-on">支持：43</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:42%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>42%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>12,800</span></strong>已获支持</p>
<p class="widthc"><strong>
27天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321802" title="狗狗萌器-萌罩（鸭嘴罩and猪崽罩）" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-198-12198-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321802" title="狗狗萌器-萌罩（鸭嘴罩and猪崽罩）">狗狗萌器-萌罩（鸭嘴罩and猪崽罩）</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321802/posts" title="此项目有5个话题" class="project-p-on">话题：5</a>
<a href="http://www.demohour.com/projects/321802/subscribers" title="18用户关注此项目" class="project-g-on">关注：18</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:5%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>5%</strong>热度</p>
<p class="widthb"><strong><span>1619</span></strong>浏览人数</p>
<p class="widthc"><strong>20天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321772" title="复刻经典 Petzval 匹兹瓦镜头 适用尼康佳能单反相机" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-212-12212-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321772" title="复刻经典 Petzval 匹兹瓦镜头 适用尼康佳能单反相机">复刻经典 Petzval 匹兹瓦镜头 适用尼康佳能单反相机</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321772/posts" title="此项目有46个话题" class="project-p-on">话题：46</a>
<a href="http://www.demohour.com/projects/321772/backers" title="82用户支持此项目" class="project-g-on">支持：82</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>1870%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>187,018</span></strong>已获支持</p>
<p class="widthc"><strong>
39天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321583" title="T-EYE， 让智能手机变身google眼镜" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-012-069-12069-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321583" title="T-EYE， 让智能手机变身google眼镜">T-EYE， 让智能手机变身google眼镜</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321583/posts" title="此项目有38个话题" class="project-p-on">话题：38</a>
<a href="http://www.demohour.com/projects/321583/subscribers" title="301用户关注此项目" class="project-g-on">关注：301</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:35%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>35%</strong>热度</p>
<p class="widthb"><strong><span>5470</span></strong>浏览人数</p>
<p class="widthc"><strong>22天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/313451" title="Z-Style Concept Arm 电脑支架" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-008-089-8089-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/313451" title="Z-Style Concept Arm 电脑支架">Z-Style Concept Arm 电脑支架</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/313451/posts" title="此项目有63个话题" class="project-p-on">话题：63</a>
<a href="http://www.demohour.com/projects/313451/backers" title="4用户支持此项目" class="project-g-on">支持：4</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:0%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>0%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>1,010</span></strong>已获支持</p>
<p class="widthc"><strong>
36天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/321070" title="《决战好莱坞》——－让你成为好莱坞的终极英雄的手机游戏！" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-863-11863-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/321070" title="《决战好莱坞》——－让你成为好莱坞的终极英雄的手机游戏！">《决战好莱坞》——－让你成为好莱坞的终极英雄的手机游戏！</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/321070/posts" title="此项目有27个话题" class="project-p-on">话题：27</a>
<a href="http://www.demohour.com/projects/321070/subscribers" title="158用户关注此项目" class="project-g-on">关注：158</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:22%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>22%</strong>热度</p>
<p class="widthb"><strong><span>2987</span></strong>浏览人数</p>
<p class="widthc"><strong>25天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320148" title="股票医生Android版 - 炒股不再是赌博" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-426-11426-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320148" title="股票医生Android版 - 炒股不再是赌博">股票医生Android版 - 炒股不再是赌博</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320148/posts" title="此项目有44个话题" class="project-p-on">话题：44</a>
<a href="http://www.demohour.com/projects/320148/backers" title="7用户支持此项目" class="project-g-on">支持：7</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:30%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>30%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>1,233</span></strong>已获支持</p>
<p class="widthc"><strong>
61天
</strong>剩余时间</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320935" title="Cuball卫星配件" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-785-11785-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320935" title="Cuball卫星配件">Cuball卫星配件</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320935/posts" title="此项目有9个话题" class="project-p-on">话题：9</a>
<a href="http://www.demohour.com/projects/320935/subscribers" title="133用户关注此项目" class="project-g-on">关注：133</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>190%</strong>热度</p>
<p class="widthb"><strong><span>5440</span></strong>浏览人数</p>
<p class="widthc"><strong>36天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320303" title="小魔方——将传统有线音箱变为蓝牙音箱" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-498-11498-medium.gif"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320303" title="小魔方——将传统有线音箱变为蓝牙音箱">小魔方——将传统有线音箱变为蓝牙音箱</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320303/posts" title="此项目有22个话题" class="project-p-on">话题：22</a>
<a href="http://www.demohour.com/projects/320303/subscribers" title="187用户关注此项目" class="project-g-on">关注：187</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>166%</strong>热度</p>
<p class="widthb"><strong><span>4226</span></strong>浏览人数</p>
<p class="widthc"><strong>38天</strong>已经预热</p>
</div>
</li>
</ul>

<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320920" title="WIFI-智能实时视频间谍车" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-805-11805-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320920" title="WIFI-智能实时视频间谍车">WIFI-智能实时视频间谍车</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320920/posts" title="此项目有22个话题" class="project-p-on">话题：22</a>
<a href="http://www.demohour.com/projects/320920/subscribers" title="133用户关注此项目" class="project-g-on">关注：133</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:95%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>95%</strong>热度</p>
<p class="widthb"><strong><span>4851</span></strong>浏览人数</p>
<p class="widthc"><strong>43天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320867" title=" Dr.drinks星球系统征集：无添加纯天然饮料试饮体验者" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-844-11844-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320867" title=" Dr.drinks星球系统征集：无添加纯天然饮料试饮体验者"> Dr.drinks星球系统征集：无添加纯天然饮料试饮体验者</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320867/posts" title="此项目有37个话题" class="project-p-on">话题：37</a>
<a href="http://www.demohour.com/projects/320867/backers" title="45用户支持此项目" class="project-g-on">支持：45</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:75%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>75%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>37,563</span></strong>已获支持</p>
<p class="widthc"><strong>
15天
</strong>剩余时间</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/319091" title="emivi安卓智能手表手机" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-701-11701-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/319091" title="emivi安卓智能手表手机">emivi安卓智能手表手机</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/319091/posts" title="此项目有66个话题" class="project-p-on">话题：66</a>
<a href="http://www.demohour.com/projects/319091/subscribers" title="342用户关注此项目" class="project-g-on">关注：342</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:81%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>81%</strong>热度</p>
<p class="widthb"><strong><span>7798</span></strong>浏览人数</p>
<p class="widthc"><strong>44天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317618" title="鱼菜共生系统" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-940-10940-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317618" title="鱼菜共生系统">鱼菜共生系统</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317618/posts" title="此项目有55个话题" class="project-p-on">话题：55</a>
<a href="http://www.demohour.com/projects/317618/backers" title="38用户支持此项目" class="project-g-on">支持：38</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>134%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>13,482</span></strong>已获支持</p>
<p class="widthc"><strong>
9天
</strong>剩余时间</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/320307" title="无线充电3合一套装，让你的苹果也可以隔空充电" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-500-11500-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/320307" title="无线充电3合一套装，让你的苹果也可以隔空充电">无线充电3合一套装，让你的苹果也可以隔空充电</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/320307/posts" title="此项目有10个话题" class="project-p-on">话题：10</a>
<a href="http://www.demohour.com/projects/320307/subscribers" title="104用户关注此项目" class="project-g-on">关注：104</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:92%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>92%</strong>热度</p>
<p class="widthb"><strong><span>5480</span></strong>浏览人数</p>
<p class="widthc"><strong>51天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/319703" title="Cuball--红外智能家居控制中心" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-404-11404-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/319703" title="Cuball--红外智能家居控制中心">Cuball--红外智能家居控制中心</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/319703/posts" title="此项目有45个话题" class="project-p-on">话题：45</a>
<a href="http://www.demohour.com/projects/319703/backers" title="37用户支持此项目" class="project-g-on">支持：37</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>130%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>13,068</span></strong>已获支持</p>
<p class="widthc"><strong>
7天
</strong>剩余时间</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317996" title="声控 双向 智能家居系统，真正的全宅智能家居！" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-913-10913-medium.gif"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317996" title="声控 双向 智能家居系统，真正的全宅智能家居！">声控 双向 智能家居系统，真正的全宅智能家居！</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317996/posts" title="此项目有61个话题" class="project-p-on">话题：61</a>
<a href="http://www.demohour.com/projects/317996/subscribers" title="678用户关注此项目" class="project-g-on">关注：678</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:48%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>48%</strong>热度</p>
<p class="widthb"><strong><span>11153</span></strong>浏览人数</p>
<p class="widthc"><strong>58天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/319612" title="ppt多能助手（iphone手机外挂设备）" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-344-11344-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/319612" title="ppt多能助手（iphone手机外挂设备）">ppt多能助手（iphone手机外挂设备）</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/319612/posts" title="此项目有18个话题" class="project-p-on">话题：18</a>
<a href="http://www.demohour.com/projects/319612/subscribers" title="108用户关注此项目" class="project-g-on">关注：108</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:77%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>77%</strong>热度</p>
<p class="widthb"><strong><span>4864</span></strong>浏览人数</p>
<p class="widthc"><strong>71天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/318238" title="Leaf - 全球首创的智能冲泡茶饮机" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-011-284-11284-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/318238" title="Leaf - 全球首创的智能冲泡茶饮机">Leaf - 全球首创的智能冲泡茶饮机</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/318238/posts" title="此项目有35个话题" class="project-p-on">话题：35</a>
<a href="http://www.demohour.com/projects/318238/subscribers" title="230用户关注此项目" class="project-g-on">关注：230</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:32%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>32%</strong>热度</p>
<p class="widthb"><strong><span>7436</span></strong>浏览人数</p>
<p class="widthc"><strong>74天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/315708" title="造一架复合材料超轻型飞机" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-009-523-9523-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/315708" title="造一架复合材料超轻型飞机">造一架复合材料超轻型飞机</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/315708/posts" title="此项目有71个话题" class="project-p-on">话题：71</a>
<a href="http://www.demohour.com/projects/315708/backers" title="8用户支持此项目" class="project-g-on">支持：8</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:63%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>63%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>12,600</span></strong>已获支持</p>
<p class="widthc"><strong>
10天
</strong>剩余时间</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/316845" title="超 •手柄革命 多功能蓝牙游戏手柄 Dark Hammer " target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-037-10037-medium.png"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/316845" title="超 •手柄革命 多功能蓝牙游戏手柄 Dark Hammer ">超 •手柄革命 多功能蓝牙游戏手柄 Dark Hammer </a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/316845/posts" title="此项目有24个话题" class="project-p-on">话题：24</a>
<a href="http://www.demohour.com/projects/316845/subscribers" title="115用户关注此项目" class="project-g-on">关注：115</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:3%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>3%</strong>热度</p>
<p class="widthb"><strong><span>3927</span></strong>浏览人数</p>
<p class="widthc"><strong>94天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317437" title="20年无处安放的青春？《茗记-尘封追忆》做给父辈们的一部动画" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-589-10589-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317437" title="20年无处安放的青春？《茗记-尘封追忆》做给父辈们的一部动画">20年无处安放的青春？《茗记-尘封追忆》做给父辈们的一部动画</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317437/posts" title="此项目有28个话题" class="project-p-on">话题：28</a>
<a href="http://www.demohour.com/projects/317437/backers" title="119用户支持此项目" class="project-g-on">支持：119</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:38%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>38%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>19,340</span></strong>已获支持</p>
<p class="widthc"><strong>
24天
</strong>剩余时间</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/318267" title="我们心中的iwatch——@watch智能手表" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-497-10497-medium.JPG"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/318267" title="我们心中的iwatch——@watch智能手表">我们心中的iwatch——@watch智能手表</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/318267/posts" title="此项目有97个话题" class="project-p-on">话题：97</a>
<a href="http://www.demohour.com/projects/318267/subscribers" title="603用户关注此项目" class="project-g-on">关注：603</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:71%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>71%</strong>热度</p>
<p class="widthb"><strong><span>20435</span></strong>浏览人数</p>
<p class="widthc"><strong>121天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317846" title="用TouchFilm来DIY自己的触摸键盘! 或者跳舞毯？" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-298-10298-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317846" title="用TouchFilm来DIY自己的触摸键盘! 或者跳舞毯？">用TouchFilm来DIY自己的触摸键盘! 或者跳舞毯？</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317846/posts" title="此项目有13个话题" class="project-p-on">话题：13</a>
<a href="http://www.demohour.com/projects/317846/subscribers" title="131用户关注此项目" class="project-g-on">关注：131</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>311%</strong>热度</p>
<p class="widthb"><strong><span>5784</span></strong>浏览人数</p>
<p class="widthc"><strong>130天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317195" title="壳的声音—EGG2.0蛋式音箱" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-110-10110-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317195" title="壳的声音—EGG2.0蛋式音箱">壳的声音—EGG2.0蛋式音箱</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317195/posts" title="此项目有18个话题" class="project-p-on">话题：18</a>
<a href="http://www.demohour.com/projects/317195/subscribers" title="85用户关注此项目" class="project-g-on">关注：85</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:50%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>50%</strong>热度</p>
<p class="widthb"><strong><span>5458</span></strong>浏览人数</p>
<p class="widthc"><strong>142天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/317125" title="史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-010-784-10784-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/317125" title="史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商">史上第一部众筹电影《十万个冷笑话》，征求十万个微赞助商</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/317125/posts" title="此项目有417个话题" class="project-p-on">话题：417</a>
<a href="http://www.demohour.com/projects/317125/backers" title="5459用户支持此项目" class="project-g-on">支持：5459</a>
<a href="http://www.demohour.com/projects/discover/4_0_0_0" class="project-g-running">筹资中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged"></div>



</div>
<div class="projectstats">
<p class="widtha"><strong>136%</strong>达到</p>
<p class="widthb"><strong><span><b>¥</b>1,360,636</span></strong>已获支持</p>
<p class="widthc"><strong>
5天
</strong>剩余时间</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/316214" title="“Sushi”； 移动电源的内涵和品位" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-009-497-9497-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/316214" title="“Sushi”； 移动电源的内涵和品位">“Sushi”； 移动电源的内涵和品位</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/316214/posts" title="此项目有52个话题" class="project-p-on">话题：52</a>
<a href="http://www.demohour.com/projects/316214/subscribers" title="578用户关注此项目" class="project-g-on">关注：578</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>103%</strong>热度</p>
<p class="widthb"><strong><span>14162</span></strong>浏览人数</p>
<p class="widthc"><strong>152天</strong>已经预热</p>
</div>
</li>
</ul>
<ul class="project-one">
<li class="project-thumbnail">
<a href="http://www.demohour.com/projects/316683" title="防弹衣材料的背包" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/project_posters-files-000-009-725-9725-medium.jpg"></a></li>
<li class="project-titile"><a href="http://www.demohour.com/projects/316683" title="防弹衣材料的背包">防弹衣材料的背包</a></li>
<li class="project-function">
<a href="http://www.demohour.com/projects/316683/posts" title="此项目有90个话题" class="project-p-on">话题：90</a>
<a href="http://www.demohour.com/projects/316683/subscribers" title="771用户关注此项目" class="project-g-on">关注：771</a>
<a href="http://www.demohour.com/projects/discover/3_0_0_0" class="project-g-funding">预热中</a>
</li>
<li class="project-list-stats">
<div class="projectpledgedwrap">
<div style="width:100%;" class="projectpledged projectpledged-funding"></div>
</div>
<div class="projectstats">
<p class="widtha"><strong>110%</strong>热度</p>
<p class="widthb"><strong><span>23058</span></strong>浏览人数</p>
<p class="widthc"><strong>158天</strong>已经预热</p>
</div>
</li>
</ul>
</div>

</div>
<div class="footer2" style="background:#f2f2f2;">
<div class="h-media-reports-b">
<ul>
<li>
<p>众拍网的运作模式</p>     
每个项目都有目标金额和时间限制，项目必须在发起人预设的时间内达到或超过目标金额才算成功。没有达到目标的项目，支持款项将全额退回给所有支持者。<br><br>所有项目发起人都经过实名认证。项目筹资前都已通过工作人员及大众评委审核。项目发起人会清楚标示项目的潜在风险，以及将采取的补救措施。
</li>
</ul>
<ul>
<li><p>众拍网收费吗？</p>       
众拍网是一个开放，免费的众筹平台，无论项目成功与否众拍网都不收取任何手续费。
<i><span>“</span>这几乎是我现在最需要的平台，并且它兼具了筹款、销售、营销推广的功能！<span>”</span><strong> —— 孙杨《纸品的美好》项目发起人</strong></i>
</li>
</ul>
<ul class="h-media-reports-b-r">
<li><p>为什么需要设置回报？</p>         
众筹具有一定的公益属性，回报是吸引公众支持的重要因素，也是区别于传统公益的主要特征。<br><br>公众基于对项目、发起人和回报的认同，通过资助的方式参与和支持创新。项目发起人在接受支持的同时给予支持者一定的回报（可以是实物，也可以是非实物，但不能涉及资金或股权）作为感谢。
</li>
<li><a href="http://www.demohour.com/intro" target="_blank" class="h-media-reports-b-r-more">查看完整服务介绍</a></li>
</ul>
</div>

<div class="h-media-reports">
<p>感谢国内外媒体报道支持</p>
<a href="http://site.douban.com/widget/notes/4422127/note/218531103/" title="新周刊" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-01-04e39a7307d5119ac4df50d9e51dbbbd.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/215977583/" title="南方都市报" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-02-39101939abd2a818f930b2c3f436e38a.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/216279901/" title="南方周刊" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-03-bf5f2628a4a9548b1fd6750de0d8f05e.gif"></a>
<a href="http://finance.cnr.cn/gs/201201/t20120112_509051989.shtml" title="经济之声" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-04-1a732a930611e6960263b399816b0a1a.gif"></a>
<a href="http://news.xinhuanet.com/book/2012-06/25/c_123324750.htm" title="北京青年报" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-05-bd5f1c3bab1f62bd218702c792f4222c.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/217068128/" title="北京晚报" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-06-dbe57a3ff106dfdc5bf5d26734595676.gif"></a>
<a href="http://site.douban.com/widget/notes/4422127/note/213505558/" title="商业周刊/中文版" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/h-media-reports-07-f940ef6cca208ef3e8ca12c58aa4cc7b.gif"></a>
<a href="http://news.xinhuanet.com/2013-04/12/c_115370793.htm" title="新华网" target="_blank"><img src="<%=request.getContextPath()%>/demohour-index_files/new.jpg"></a>



</div>
</div>

<div id="ui_popup_delete" class="ui-popup ui-popup-blank ui-popup-delete">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<p class="ui-popup-text"></p>
<div class="ui-button-green ui-button"><span><a class="ui-popup-url" href="#" data-method="delete" data-remote="true" rel="nofollow">删除</a></span></div>
<a href="#close" class="ui-popup-close ui-popup-delete-cancel">取消</a>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</div>
</div>
</div>
<div id="ui_popup_message" class="ui-popup ui-popup-textarea">
<div class="ui-popup-background">
<div class="ui-popup-content ui-draggable">
<form accept-charset="UTF-8" action="/messages" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" value="✓" type="hidden"><input name="authenticity_token" value="mXPrIAvBs23PnmOfF1PE+JbSsr4Af0qcf0L0VwNiNsQ=" type="hidden"></div>
<table class="ui-popup-table" align="center" border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td class="ui-popup-top-l" width="25"></td>
<td class="ui-popup-top"><span class="ui-popup-title"></span></td>
<td class="ui-popup-top-r" width="25"><a href="#close" class="ui-popup-close">关闭</a></td></tr>
<tr><td class="ui-popup-mid-l"></td>
<td class="ui-popup-mid">
<div class="ui-textarea">
<div class="ui-textarea-border">
<textarea id="message_content" name="message[content]" class="ui-text-fixed"></textarea>
</div>
</div>
<div class="ui-popup-textarea-b">
<span id="ui_popup_message_url"><a href="http://www.demohour.com/messages">查看私信记录</a></span>
<span id="ui_popup_message_email" style="display:none"><label><input name="message[email_sync]" value="1" type="checkbox"> 同时发送邮件</label></span>
<span id="message_content_error"></span>
<div class="ui-button ui-button-green ui-button-ajax"><span><button type="submit">发送</button></span></div>
</div>
</td>
<td class="ui-popup-mid-r"></td></tr>
<tr><td class="ui-popup-bottom-l"></td><td class="ui-popup-bottom"></td><td class="ui-popup-bottom-r"></td></tr>
</tbody></table>
</form></div>
</div> 
</div>
<div class="footerwrap">
<div class="footer">
<a href="<%=request.getContextPath()%>/projects/new">发起项目</a>
<a href="<%=request.getContextPath()%>/intro">服务介绍</a>
<a href="<%=request.getContextPath()%>/guideline">项目规范</a>
<a href="<%=request.getContextPath()%>/faq">常见问题</a>
<a href="<%=request.getContextPath()%>/terms_of_service">服务条款</a>
<a href="<%=request.getContextPath()%>/privacy_policy">隐私权政策</a>
<a href="<%=request.getContextPath()%>/about">关于我们</a>
<a href="<%=request.getContextPath()%>/projects/313907">建议反馈</a>
<a href="http://weibo.com/demohour" target="_blank">官方微博</a>
<a href="http://blog.demohour.com/" target="_blank">官方博客</a>
<a href="<%=request.getContextPath()%>/?screen=mobile" class="last">手机版</a>
<p>© 2013北京众拍网科技有限公司　Demohour.com 版权所有<br>电信与信息服务业务经营许可证120183号　京ICP备11032157号　京公网安备110105015321</p>
<div id="backtop" class="backtop"><a href="#top"></a></div>
</div>
</div>


<script src="<%=request.getContextPath()%>/demohour-index_files/ga.js" async="" type="text/javascript"></script><script src="<%=request.getContextPath()%>/demohour-index_files/application-ffd788692166a3012f8373c435f5c0c2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/demohour-index_files/projects-1ab927eb13eddbb381c44171a7060594.js" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){$.ui_core.ready('dropbox', 'tab', 'popup', 'button', 'checkbox', 'radio', 'text', 'action', 'popup_preview');$('input, textarea').placeholder();$(window).scroll(function(){if($(window).scrollTop() > 48){$('#ui_notification').addClass('layer-message-fixed');}else{$('#ui_notification').removeClass('layer-message-fixed');}});$.ui_notification.ready({url:'http://nf-2.demohour.com',data:{"new_comments_count":0,"new_messages_count":0,"new_notifications_count":0,"new_posts_count":0}});$.ui_core.paginate("#project-list-more"),$("#attribute_1").addClass("ui-categories-current"),$("#category_0").addClass("ui-categories-current"),$("#location_0").addClass("ui-categories-current"),$("#sort_6").addClass("ui-categories-current"),$("#projects_tabs").length>0&&$(window).scroll(function(){$(window).scrollTop()>166?$("#projects_tabs").addClass("scrollon"):$("#projects_tabs").removeClass("scrollon")}),$("body").on("click","a.ui-popup-delete",function(e){$("#ui_popup_delete").find("div.ui-popup-content").css("top",$(window).height()/2-120),$("#ui_popup_delete").find("p.ui-popup-text").html($(e.target).attr("title")),$("#ui_popup_delete").find("a.ui-popup-url").attr("href",$(e.target).attr("href")),$("#ui_popup_delete").toggle(),e.preventDefault()}),$("body").on("click","a.ui-popup-message",function(e){$("#ui_popup_message").find("div.ui-popup-content").css("top",$(window).height()/2-150),$("#ui_popup_message").find("form").attr("action",$(e.target).attr("href")),$("#ui_popup_message").find("span.ui-popup-title").html($(e.target).attr("title")),$("#ui_popup_message").toggle(),$("#ui_popup_message").find("textarea").val($(e.target).attr("data-message-attachment")),$("#ui_popup_message").find("textarea").focus(),$(e.target).attr("href").indexOf("?recipient_id=")>0?($("#ui_popup_message_url").show(),$("#ui_popup_message_email").hide(),$("#ui_popup_message_url").find("a").attr("href",$(e.target).attr("href").replace("?recipient_id=","/"))):($("#ui_popup_message_url").hide(),$("#ui_popup_message_email").show()),e.preventDefault()});;$.ui_core.backtop('#backtop');$.ui_core.distance({now:'2013-08-15 23:38:17 +0800'});});
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-23451409-1']);
_gaq.push(['_trackPageview']);
(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
//]]>
</script>
</body></html>