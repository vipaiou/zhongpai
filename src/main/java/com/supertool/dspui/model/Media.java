package com.supertool.dspui.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.supertool.dspui.framework.JsonDateSerializer;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name = "st_media")
public class Media implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2042927327308280678L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mediaId;// int(4) NOT NULL auto_increment COMMENT '主键，自增',

	@Column(name="GlobalId")
	private int globalId; // bigint(8) NOT NULL default '0' COMMENT '全局媒体ID',

	@Column(name="MediaName")
	private String mediaName; // varchar(100) NOT NULL default '' COMMENT
								// '名称：注意保持兄弟节点间名称和别名的唯一性；如果输入的长度超过了100，应该有报错提示',

	@Column(name="Type")
	private String type; // char(1) NOT NULL default 'P' COMMENT
							// '类型：''P''表示网站Publisher;''C''表示不可再分频道即原子频道Atom
							// Channel;''N''表示可再分频道即非原子频道Non-atomic
							// Channel;''A''表示广告位AdPosition',

	@Column(name="ParentId")
	private int parentId; // int(4) NOT NULL default '0' COMMENT '所属上级媒体Id',

	@Column(name="MatchedSpotsNum")
	private int matchedSpotsNum; // int(4) default '0' COMMENT '媒体下已匹配监测点数量',

	@Column(name="LastMatchSpotsDate")
	private Date lastMatchSpotsDate; // datetime NOT NULL default '1970-01-01
										// 08:00:00' COMMENT '最近匹配监测点时间',

	@Column(name="Path")
	private String path; // varchar(1000) NOT NULL default '' COMMENT
							// '节点路径：以”::”将各id串起来',

	@Column(name="Domain")
	private String domain; // varchar(1000) NOT NULL COMMENT
							// '域名（URL）：最长为1000，如果输入的长度超过了1000，应该有报错提示',

	@Column(name="Alias")
	private String alias; // varchar(1000) NOT NULL COMMENT
							// '别名：最长为1000，如果输入的长度超过了1000，应该有报错提示。若别名不为空，其必须以“;”进行分割，且前后都带分割符，以便查询。所以别名中不能包含“;”。Example：“;电视;”
							// 或 “;凤凰牛视;牛视专题页;”',

	@Column(name="Useage")
	private String useage; // char(1) NOT NULL default 'P' COMMENT
							// '用途：''P''代表Planner使用；''M''代表Monitor使用；''R''代表研发使用',

	@Column(name="IsApproved")
	private String isApproved; // char(1) NOT NULL default 'P' COMMENT
								// '审核是否通过："0"未通过，"1"通过',

	@Column(name="Source")
	private String source; // char(1) NOT NULL default 'M' COMMENT
							// '媒体来源："M"从标准媒体新建的待审核的媒体；"S"从匹配监测点新建的待审核的媒体；"U"从匹配Url新建的待审核的媒体；"A"从匹配广告位新建的待审核的媒体',

	@Column(name="IsDeployed")
	private String isDeployed; // char(1) NOT NULL default '0' COMMENT
								// '是否已经发布。用途为planner使用的媒体，发布媒体数据后，用途不可修改。：''0''未发布；''1''已经发布',

	@Column(name="Status")
	private String status; // char(1) NOT NULL default '1' COMMENT
							// '状态：''1''代表活动；''0''代表停用。停用的媒体不会出现在匹配监测点的选择媒体中，也不用再匹配url',

	@Column(name="Description")
	private String description; // text NOT NULL COMMENT '备注',

	@Column(name="CreateUser")
	private int createUser; // int(4) NOT NULL default '0' COMMENT '创建者',

	@Column(name="CreateDate")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createDate; // datetime NOT NULL default '1970-01-01
								// 08:00:00' COMMENT '创建时间',

	@Column(name="UpdateUser")
	private int updateUser; // int(4) NOT NULL default '0' COMMENT '更新者',

	@Column(name="UpdateDate")
	private Date updateDate; // datetime NOT NULL default '1970-01-01
								// 08:00:00' COMMENT '更新时间',

	@Column(name="IsDeleted")
	private String isDeleted; // char(1) NOT NULL default '0' COMMENT
								// '删除状态：''0''是未删除；''1''是删除',

	@Column(name="DeleteUser")
	private int deleteUser; // int(4) NOT NULL default '0' COMMENT '删除者',

	@Column(name="DeleteDate")
	private Date deleteDate; // datetime NOT NULL default '1970-01-01
								// 08:00:00' COMMENT '删除时间',

	@Column(name="ExpressionType")
	private int expressionType; // int(4) NOT NULL default '0' COMMENT
									// '广告位的展现形式。关联st_expression_type表中的ExpressionTypeId',

	@Column(name="YCoordinate_Resolution")
	private String yCoordinate_Resolution; // varchar(100) NOT NULL default ''
											// COMMENT
											// 'Y坐标/屏幕分辨率（宽*高）：Y坐标，秒针浏览器的滚轮坐标；屏幕分辨率，即宽*高。示例：1264/1288*972
											// ',

	@Column(name="OnLineTime")
	private String onLineTime; // varchar(5) NOT NULL default '00:00' COMMENT
								// '媒体的上线时间',

	@Column(name="OffLineTime")
	private String offLineTime; // varchar(5) NOT NULL default '24:00' COMMENT
								// '媒体的下线时间',

	@Column(name="IsReleased")
	private String isReleased; // varchar(1) NOT NULL default '0' COMMENT '01',
	
	@Formula("get_class_ids_for_media(mediaId)")
	private String classidstr;

	@Formula("get_class_names_for_media(mediaId)")
	private String classnametr;
	
	@Formula("get_gbk_str(mediaName)")
	private String gbkName;
	
	@Formula("get_username_by_userid(createUser)")
	private String createUserName;
	
	@Formula("get_username_by_userid(updateUser)")
	private String updateUserName;

	@Formula("get_username_by_userid(deleteUser)")
	private String deleteUserName;
	
	@Formula("get_media_path_name(mediaId)")
	private String pathName;
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getDeleteUserName() {
		return deleteUserName;
	}

	public void setDeleteUserName(String deleteUserName) {
		this.deleteUserName = deleteUserName;
	}

	public int getMediaId() {
		return mediaId;
	}

	public int getGlobalId() {
		return globalId;
	}

	public void setGlobalId(int globalId) {
		this.globalId = globalId;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getMatchedSpotsNum() {
		return matchedSpotsNum;
	}

	public void setMatchedSpotsNum(int matchedSpotsNum) {
		this.matchedSpotsNum = matchedSpotsNum;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	public Date getLastMatchSpotsDate() {
		return lastMatchSpotsDate;
	}

	public void setLastMatchSpotsDate(Date lastMatchSpotsDate) {
		this.lastMatchSpotsDate = lastMatchSpotsDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUseage() {
		return useage;
	}

	public void setUseage(String useage) {
		this.useage = useage;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsDeployed() {
		return isDeployed;
	}

	public void setIsDeployed(String isDeployed) {
		this.isDeployed = isDeployed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(int deleteUser) {
		this.deleteUser = deleteUser;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public int getExpressionType() {
		return expressionType;
	}

	public void setExpressionType(int expressionType) {
		this.expressionType = expressionType;
	}

	public String getyCoordinate_Resolution() {
		return yCoordinate_Resolution;
	}

	public void setyCoordinate_Resolution(String yCoordinate_Resolution) {
		this.yCoordinate_Resolution = yCoordinate_Resolution;
	}

	public String getOnLineTime() {
		return onLineTime;
	}

	public void setOnLineTime(String onLineTime) {
		this.onLineTime = onLineTime;
	}

	public String getOffLineTime() {
		return offLineTime;
	}

	public void setOffLineTime(String offLineTime) {
		this.offLineTime = offLineTime;
	}

	public String getIsReleased() {
		return isReleased;
	}

	public void setIsReleased(String isReleased) {
		this.isReleased = isReleased;
	}

	public String getClassidstr() {
		return classidstr;
	}

	public void setClassidstr(String classidstr) {
		this.classidstr = classidstr;
	}

	public String getClassnametr() {
		return classnametr;
	}

	public void setClassnametr(String classnametr) {
		this.classnametr = classnametr;
	}

	public String getGbkName() {
		return gbkName;
	}

	public void setGbkName(String gbkName) {
		this.gbkName = gbkName;
	}
}
