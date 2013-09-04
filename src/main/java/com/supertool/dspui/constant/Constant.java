package com.supertool.dspui.constant;

import java.util.Date;

public class Constant {

	public static String REMOTE_URL="http://123.103.21.19:8080/carbon";
	public static String RTB_ADD_URL = "/rtb/add";
	public static String RTB_RELATION_ADD_URL = "/rtb/relation/add";
	public static String RTB_UPDATE_URL = "/rtb/update";
	public static String RTB_DELETE_URL = "/rtb/delete";
	public static String RTB_RELATION_DELETE_URL = "/rtb/relation/delete";
	public static String RTB_REAL_REPORT_URL = "/report/real/rtb/list";
	public static String RTB_BUDGET_STATUS = "/rtb/budget/status";
	
	public static String DATASOURCE_ADD_URL = "/datasource/add";
	public static String DATASOURCE_UPDATE_URL = "/datasource/update";
	public static String DATASOURCE_DELETE_URL = "/datasource/delete";
	public static String DATASOURCE_UPLOAD_URL = "/datasource/upload";

	public static String RTB_PROGRESS_HAS_NO_RTB = "未添加rtb规则";
	public static int CARBON_RESULT_SUCESS = 1;
	public static int CALL_CARBON__FAIL = 0;
	public static Integer DSPID = 11114;
	
	public static final int CARBON_STATUS_CODE_SUCCESS = 200;
	public static final int CARBON_ADPLACEMENT_NOT_EXIST = 770;
	
	/**
	 * RTB进度
	 */
	// 未开始
	public static final int RTB_PROGRESS_NOT_STARTED = 0;
	// 进行中
	public static final int RTB_PROGRESS_RUNNING = 1;
	// 暂停
	public static final int RTB_PROGRESS_SUSPENDED = 2;
	// 已结束
	public static final int RTB_PROGRESS_ENDED = 3;
	// 整体预算不足
	public static final int RTB_PROGRESS_OVER_BUDGET = 4;
	// 单日预算不足
	public static final int RTB_PROGRESS_OVER_DAILY_BUDGET = 5;
	// 单日曝光已满
	public static final int RTB_PROGRESS_OVER_DAILY_PV = 6;
	
	/**
	 * RTB超预算状态
	 */
	// 未超预算
	public static final Integer RTB_BUDGET_STATUS_OK = 0;
	// 总预算超预算
	public static final Integer RTB_BUDGET_STATUS_OVER_BUDGET = 1;
	// 每日预算超预算
	public static final Integer RTB_BUDGET_STATUS_OVER_DAILY_BUDGET = 2;
	// 每日pv超预算
	public static final Integer RTB_BUDGET_STATUS_OVER_DAILY_PV = 3;
	
	
	public static final String TABLE_USER="st_user";
	public static final String TABLE_AUTHORITY="st_authority";
	public static final String TABLE_RESOURCE="st_resource";
	public static final String TABLE_USER_AUTHORITY="st_user_authority_relation";
	public static final String TABLE_AUTHORITY_RESOURCE="st_authority_resource_relation";
	
	/**
	 *  user operation
	 */
	//不存在
	public static final String USER_UNEXISTS ="0";
	//存在但已删除
	public static final String USER_DELETED ="1";
	//存在但禁用
	public static final String USER_FREEZED="2";
	//存在且正常
	public static final String USER_EXISTS ="3";
	
	//默认密码：
	public static final String DEFAULT_USER_PASSWORD="123456";
	
	/*page size
	 * 
	 */
	public static final int PAGESIZE=20;
	public static final String WATCH_WORD = "miaozhen.supertool.xuezhitu";
	
	/**
	 * permission name
	 */
	//标准媒体所有权限
	public static final String PERMISSION_STMEDIA="stmedia";
	//查看标准煤体权限
	public static final String PERMISSION_STMEDIA_VIEW="viewStmedia";
	//新建标准煤体权限
	public static final String PERMISSION_STMEDIA_CREATE="createStmedia";
	//编辑标准煤体权限
	public static final String PERMISSION_STMEDIA_EDIT="editStmedia";
	//删除标准煤体权限
	public static final String PERMISSION_STMEDIA_DELETE="deleteStmedia";
	//发布权限
	public static final String PERMISSION_STMEDIA_RELEASE="releaseStmedia";
	//批量修改权限
	public static final String PERMISSION_STMEDIA_BATCH_UPDATE="batchUpdate";
	//复制
	public static final String PERMISSION_STMEDIA_COPY="copyStmedia";
	
	
	//匹配检测点所有权限
	public static final String PERMISSION_MATCHSPOT="matchSpot";
	//查看匹配权限
	public static final String PERMISSION_MATCHSPOT_VIEW="viewMatchspot";
	//匹配权限
	public static final String PERMISSION_MATCHSPOT_MATCH="match";
	//忽略权限
	public static final String PERMISSION_MATCHSPOT_NOMATCH="noMatch";
	//修改匹配权限
	public static final String PERMISSION_MATCHSPOT_CHANGE_MATCH="changeMatch";
	//查看排期权限
	public static final String PERMISSION_MATCHSPOT_VIEW_SCHEDULE="viewSchedule";
	//查看数据对比报表权限
	public static final String PERMISSION_MATCHSPOT_VIEW_DATA_COMPARED_REPORT="viewDataComparedReport";
	
	//属性扩展的全部权限
	public static final String PERMISSION_ATTRIBUTE_EXTEND="attributeExtend";
	//管理媒体分类权限
	public static final String PERMISSION_ATTRIBUTE_EXTEND_CLASSFY_MEDIA="classfyMedia";
	//管理物料类型权限
	public static final String PERMISSION_ATTRIBUTE_EXTEND_MATERIAL_TYPE="materialType";
	//管理展现形式权限
	public static final String PERMISSION_ATTRIBUTE_EXTEND_DISPLAY_FORM="displayForm";
	
	//高级搜索权限
	public static final String PERMISSION_ADVANCED_SEARCH="advancedSearch";
	//高级搜索 下载
	public static final String PERMISSION_ADVANCED_SEARCH_DOWNLOAD="advancedDownload";
	
	//日志管理权限
	public static final String PERMISSION_LOG_MANAGE="logManage";
	
	
	

    public static final String ADADMIN_DB_DIR = "";
    public static final String ADADMIN_DB_NAME_PRE = "";
    public static final String ADADMIN_DB_NAME_POST = "";
    public static String ISGETLATESTCLICKDATE = "";

    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final Date defaultDate = new Date("1970/01/01 08:00:00");
    public static final String REMEMBERED_USER_NAME = "remembered_username";
    public static final String REMEMBERED_PASSWORD = "remembered_password";

    public static String MEDIA_RULE_FILEPATH = "";
    public static String MEDIA_TREE_FILEPATH = "";
    public static String SPOTS_FILEPATH = "";
    public static String MEDIA_DATA_DIR_PREFIX = "";
    public static final String MEDIA_RULE_FILENAME = "UrlMatchRule";
    public static String EMAIL_SERVER = "mail.supertool.net.cn";
    public static String EMAIL_FROM_ADDRESS = "";
    public static String EMAIL_FROM_NAME = "";
    public static String EMAIL_FROM_USERNAME = "";
    public static String EMAIL_FROM_PASSWORD = "";
    public static String EMAIL_TO_ADDRESS = "";
    public static String EMAIL_TO_NAME = "";
    public static String MONITOR_DATA_PATH_M46 = "";
    public static String MONITOR_DATA_PATH_M47 = "";
    public static String COOKIE_DATA_PATH = "";
    public static String ADVANCED_SEARCH_PATH = "";
    public static String RULE_URL_FILEPATH = "";
    public static int BEFORE_DATES = 6;

    public static final String PRODUCT_VISITING_ID = "product_visiting_id";

    public static final int WAIT_TIME = 6000;
    public static final int OP = 1;
    public static final int MONITOR = 2;
    public static final int PLANNER = 3;
    public static final int ACCESS = 4;
    public static final int MM = 5;
    public static final String FREEZED = "1";
    public static final int SESSION_FLUSH_INTERVAL = 50;

    public static final String ALIAS_SPLITER = ";";
    public static final int FREE_VENDING_MODEL_IN_ST_SPOTS = 1;
    /**
     * 操作成功，值为{@value}
     */
    public static final int SUCCESS = 0;
    /**
     * 越界，值为{@value}
     */
    public static final int OUT_OF_RANGE = -1;
    /**
     * 匹配失败，值为{@value}
     */
    public static final int DISMATCH_FAULT = 1;
    /**
     * 添加失败，值为{@value}
     */
    public static final int ADD_FAULT = 2;
    /**
     * 删除失败，值为{@value}
     */
    public static final int DEL_FAULT = 3;
    /**
     * 更新失败，值为{@value}
     */
    public static final int UPDATE_FAULT = 4;
    /**
     * Id已存在，值为{@value}
     */
    public static final int ID_EXISTED = 5;
    /**
     * Id不存在，值为{@value}
     */
    public static final int ID_NOT_EXISTED = 6;
    /**
     * 名称已存在，值为{@value}
     */
    public static final int NAME_EXISTED = 7;
    /**
     * 无权，值为{@value}
     */
    public static final int PERMISSION_DENIED = 8;

    /**
     * 用户名最大长度
     */
    public static int USERNAME_LENGTH_MAX = 12;
    /**
     * 用户名最小长度
     */
    public static int USERNAME_LENGTH_MIN = 1;
    /**
     * 密码最大长度
     */
    public static int PASSWORD_LENGTH_MAX = 16;
    /**
     * 密码最小长度
     */
    public static int PASSWORD_LENGTH_MIN = 6;
    /**
     * 默认密码长度
     */
    public static int PASSWORD_LENGTH_DEFAULT = 6;
    /**
     * CON_MAX_LEGTH，值为{@value}
     */
    public static final int CON_MAX_LEGTH = 20;
    /**
     * 字符串最大长度，值为{@value}
     */
    public static final int STRING_MAX_LEGTH = 100;
    /**
     * Ids最大长度，值为{@value}
     */
    public static final int IDS_MAX_LEGTH = 1000;
    /**
     * Code最大长度，值为{@value}
     */
    public static final int CODE_MAX_LEGTH = 8000;
    /**
     * 文本最大长度，值为{@value}
     */
    public static final int TEXT_MAX_LEGTH = 65535;
    /**
     * 分隔符，值为{@value}
     */
    public static final String SPLITER = ",";
    /**
     * Ready状态，值为{@value}
     */
    public static final int READY_STATUS = 99;
    /**
     * Active状态，值为{@value}
     */
    public static final int ACTIVE_STATUS = 100;
    /**
     * End状态，值为{@value}
     */
    public static final int END_STATUS = 101;

    /**
     * 一天的秒数，值为{@value}
     */
    public static final int ONE_DAY = 86400000;

    /**
     * 2008年1月1日0点0分0秒的时间，值为{@value}
     */
    public static final long DATE_2008_01_01 = 1199116800000l;

    /**
     * 监控数据文件所在文件夹路径
     */
    public static String MONITOR_DB_DIR = "";
    /**
     * 监控数据文件名前缀
     */
    public static String MONITOR_DB_NAME_PRE = "";
    /**
     * 监控数据文件名后缀
     */
    public static String MONITOR_DB_NAME_POST = "";

    /**
     * 带人群的监控数据文件所在文件夹路径
     */
    public static String COOKIE_DB_DIR = "";
    /**
     * 带人群的监控数据文件名前缀
     */
    public static String COOKIE_DB_NAME_PRE = "";
    /**
     * 带人群的监控数据文件名后缀
     */
    public static String COOKIE_DB_NAME_POST = "";
    /**
     * 小数有效位数，值为{@value}
     */
    public static final int SIG_BITS = 6;// 小数的有效位数

    /**
     * 星期的英文头字母，值为{@value}
     */
    public static final String[] DAYS = { "S", "M", "T", "W", "T", "F", "S" };

    // -------------------column VendingModel of st_spots

    public static final int NORMAL_AND_FREE_VENDING_MODEL_IN_ST_SPOTS = 1;
    public static final int EXTRA_VENDING_MODEL_IN_ST_SPOTS = 2;
    public static final int ALL_VENDING_MODEL_IN_ST_SPOTS = 3;
    public static final int COMMON_ADER_USER_CREATED_BY_PUBLISHER = 0;
    public static final int PAGE_SIZE = 15;

    public static final String isFromAdmin = "1";
    public static final String isNotFromAdmin = "0";

    public static final String isAnswered = "1";
    public static final String isNotAnswered = "0";

    public static final String RESOURCE_ZH = "com.miaozhen.monitor.struts.ApplicationResources_zh_CN";
    public static final String RESOURCE_EN = "com.miaozhen.monitor.struts.ApplicationResources_en_US";

    // 标准媒体实体名常量
    public static final String PARENT_URL = "PARENT_URL";
    public static final String EXPRESSION_TYPE_OPTIONS = "EXPRESSION_TYPE_OPTIONS";
    public static final String PRICE_OPTIONS = "PRICE_OPTIONS";
    public static final String PARENT_ID = "PARENT_ID";
    public static final String PARENT_PATH = "PARENT_PATH";
    public static final String PARENT_TYPE = "PARENT_TYPE";
    public static final String PARENT_CLASS = "PARENT_CLASS";
    public static final String USEAGE_OPTIONS = "USEAGE_OPTIONS";
    public static final String STATUS_OPTIONS = "STATUS_OPTIONS";
    public static final String TYPE_OPTIONS = "TYPE_OPTIONS";
    public static final String MEDIA_BEAN = "MEDIA_BEAN";
    public static final String MEDIA_FORM = "mediaForm";
    public static final String STMEDIA_MEDIA_USAGE = "STMEDIA_MEDIA_USAGE";
    public static final String STMEDIA_NOT_EQUAL_MEDIA_TYPE = "STMEDIA_NOT_EQUAL_MEDIA_TYPE";
    public static final String STMEDIA_MEDIA_TYPE = "STMEDIA_MEDIA_TYPE";
    public static final String STMEDIA_MEDIA_PATH = "STMEDIA_MEDIA_PATH";
    public static final String STMEDIA_MEDIA_NAME = "STMEDIA_MEDIA_NAME";
    public static final String STMEDIA_MEDIA_ID = "STMEDIA_MEDIA_ID";

    public static final String TYPE_VALIDATE_FAILURE = "TYPE_VALIDATE_FAILURE";
    public static final String MEDIA_GROUP_BEAN = "MEDIA_GROUP_BEAN";
    public static final String MEDIA_GROUP_FORM = "MEDIA_GROUP_FORM";
    public static final String MEDIA_GROUP_NAME_NOT_EXCLUSIVE = "MEDIA_GROUP_NEAM_NOT_EXCLUSIVE";
    public static final String MEDIA_GROUP_VIEW_PAGE = "media_group_view_page";
    public static final String MEDIA_GROUP_MODIFY_PAGE = "media_group_modify_page";
    public static final String ST_MEDIA_LIST_PAGE = "ST_MEDIA_LIST_PAGE";
    public static final String ST_MEDIA_CREATE_PAGE = "ST_MEDIA_CREATE_PAGE";
    public static final String ST_MEDIA_MODIFY_PAGE = "ST_MEDIA_MODIFY_PAGE";
    public static final String ST_MEDIA_VIEW_PAGE = "ST_MEDIA_VIEW_PAGE";
    public static final String ST_MEDIA_AUDIT_VIEW_PAGE = "ST_MEDIA_AUDIT_VIEW_PAGE";
    public static final String ST_MEDIA_MATCH_THRESHOLD_PAGE = "ST_MEDIA_MATCH_THRESHOLD_PAGE";
    public static final String SEARCH_COLUMN_MEDIA_ID = "MediaId";
    public static final String SEARCH_COLUMN_MEDIA_NAME = "MediaName";
    // public static final String SEARCH_COLUMN_URL = "url";
    public static final String SEARCH_COLUMN_URL = "Domain";
    public static final String SEARCH_COLUMN_CLASS_ID = "ClassId";
    public static final String SEARCH_COLUMN_CLASS_NAME = "ClassName";
    public static final String ADVANCED_SEARCH_PAGE = "ADVANCED_SEARCH_PAGE";

    public static final String CURRENT_MEDIA_ID = "CURRENT_MEDIA_ID";

    public static final String SEARCH_SCOPE_GLOBAL = "GLOBAL";
    public static final String SEARCH_SCOPE_CURRENT = "CURRENT";
    public static final String PROPERTY_MAP_KEY_NAME = "PROPERTY_NAME";
    public static final String PROPERTY_MAP_KEY_VALUE = "VALUE";
    public static final String PROPERTY_MAP_KEY_RIGOR = "RIGOR";

    public static final String NAVIGATION_LINKS = "NAVIGATION_LINKS";
    public static final String SEARCH_PATH_LINKS = "SEARCH_PATH_LINKS";
    public static final String RULE_LIST = "ruleList";
    public static final String RELEASE_SELECT_LIST_PAGE = "RELEASE_SELECT_LIST_PAGE";
    // 分隔符
    // 路径分隔符
    public static final String PATH_SEPARATOR = "::";

    // 类别ID分隔符
    public static final String CLASS_SEPARATOR = ";";
    // 类别显示分隔符
    public static final String CLASS_SHOW_SEPARATOR = ";";

    // 别名分隔符
    public static final String ALIAS_SEPARATOR = ";";

    // 备注分隔符
    public static final String Description_SEPARATOR = ";";

    // spots
    public static final String[] MONTH_OF_YEAR_CN = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
            "十一月", "十二月" };
    public static final int SPOT_MATCHED_BLACK = 0;
    public static final int SPOT_UNMATCHED_RED = 1;
    public static final int SPOT_PLAN_DISPLAYED = 1;
    public static final String SPOT_PLAN_UNDISPLAYED = "&nbsp;";
    public static final String SPOT_PLAN_FIRST_GREEN = "td_g";
    public static final String SPOT_PLAN_NOW_RED = "td_r";
    public static final String SPOT_PLAN_LAST_GREEN = "td_g";
    public static final boolean SPOT_UNMATCHED_CAN_BE_PAGING = false;// 未匹配监测点是否可以分页
    public static final boolean SPOT_MATCHED_CAN_BE_PAGING = true;// 已匹配监测点是否可以分页
    public static final boolean SPOT_MISMATCHED_CAN_BE_PAGIN = false;// 不匹配监测点是否可以分页

    public static final String SPOT_UNMATCHED_VIEW_SPOTS_PLAN_PAGE = "spot_view_spots_plan_page";
    public static final String SPOT_UNMATCHED_LIST_PAGE = "spot_unmatched_list_page";
    public static final String SPOT_MISMATCHED_LIST_PAGE = "spot_mismatched_list_page";

    public static final String ADPOSITION_UNMATCHED_LIST_PAGE = "adposition_unmatched_list_page";
    public static final String ADPOSITION_MATCHED_LIST_PAGE = "adposition_matched_list_page";

    public static final String PATH_STRING = "PATH_STRING";
    public static final String PARENT_CLASS_IDS_AND_NAMES = "PARENT_CLASS_IDS_AND_NAMES";
    public static final String ST_MEDIA_AJAX_CREATE_PAGE = "ST_MEDIA_AJAX_CREATE_PAGE";
    public static final String ST_MEDIA_CREATE_PAGE_FOR_URL_MATCH = "ST_MEDIA_CREATE_PAGE_FOR_URL_MATCH";
    public static final String VALIDATE_MEDIA_NAME_FAILURE = "VALIDATE_MEDIA_NAME_FAILURE";
    public static final String VALIDATE_ALIAS_FAILURE = "VALIDATE_ALIAS_FAILURE";
    public static final String VALIDATE_CLASS_IDS_FAILURE = "vALIDATE_CLASS_IDS_FAILURE";
    public static final String VALIDATE_PARENT_CHANGE_FAILURE = "VALIDATE_PARENT_CHANGE_FAILURE";
    public static final int MEDIA_NAME_MAX_LENGTH = 50;
    public static final int ALIAS_MAX_LENGTH = 200;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final int AREA_SIZE_WIDTH_MAX_LENGTH = 5;
    public static final int AREA_SIZE_HEIGHT_MAX_LENGTH = 5;
    public static final int FILE_SIZE_MAX_LENGTH = 3;
    public static final String VALIDATE_DESCRIPTION_MAX_LENGTH = "VALIDATE_DESCRIPTION_MAX_LENGTH";
    public static final String VALIDATE_MEDIA_NAME_NOT_EMPTY = "VALIDATE_MEDIA_NAME_NOT_EMPTY";
    public static final String VALIDATE_MEDIA_NAME_MAX_LENGTH = "VALIDATE_MEDIA_NAME_MAX_LENGTH";
    public static final String VALIDATE_ALIAS_MAX_LENGTH = "VALIDATE_ALIAS_MAX_LENGTH";
    public static final String VALIDATE_PARENT_ID_NOT_EMPTY = "VALIDATE_PARENT_ID_NOT_EMPTY";
    public static final String FORBIDDEN_PAGE = "FORBIDDEN";
    public static final String[] EXPRESSION_TYPES = new String[] { "通栏", "对联", "全屏", "按钮", "文字链", "流媒体", "视频", "矩形",
            "扩展通栏", "焦点图", "翻牌", "视窗", "画中画", "浮层", "背投", "弹出窗口", "贴片", "暂停", "擎天柱", "翻卷", "撕页", "图文" };
    public static final int ADPOSITION_AREA_SIZE_WIDTH_MAX_LENGTH = 5;
    public static final int ADPOSITION_AREA_SIZE_HEIGHT_MAX_LENGTH = 5;
    public static final int ADPOSITION_MAX_FILE_SIZE_MAX_LENGTH = 5;
    public static final String VALIDATE_AREA_SIZE = "VALIDATE_AREA_SIZE";
    public static final String VALIDATE_MAX_FILE_SIZE = "VALIDATE_AREA_SIZE";
    public static final String VALIDATE_PRICE = "VALIDATE_PRICE";
    public static final String MEDIA_TYPE = "MEDIA_TYPE";
    public static final String FILE_TYPE_SEPARACTOR = ";";
    public static final String FILE_TYPE_FLASH = "FILE_TYPE_FLASH";
    public static final String FILE_TYPE_IMAGE = "FILE_TYPE_IMAGE";
    public static final String FILE_TYPE_TEXT = "FILE_TYPE_TEXT";
    public static final String FILE_TYPE_VIDEO = "FILE_TYPE_VIDEO";
    public static final int ROOT_MEDIA_ID = -1;
    public static final String MEDIA_MERGE_OK = "MEDIA_MERGE_OK";
    public static final String MEDIA_MERGE_ERR_SAMEID = "MEDIA_MERGE_ERR_SAMEID";
    public static final String MEDIA_MERGE_ERR_CLASSCONFLICT = "MEDIA_MERGE_ERR_CLASSCONFLICT";
    public static final String MEDIA_MERGE_ERR_OTHER = "MEDIA_MERGE_ERR_OTHER";
    public static final String YCR_STATUS = "YCR_STATUS";
    public static final String OPERATION_FINISHED_MESSAGE = "OPERATION_FINISHED_MESSAGE";

    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String CUSTOMER_MEDIA_SOURCE = "CUSTOMER_MEDIA_SOURCE";
    public static final String CUSTOMER_MEDIA_APID = "CUSTOMER_MEDIA_APID";
    public static final String CUSTOMER_MEDIA_ID = "CUSTOMER_MEDIA_ID";
    public static final String CUSTOMER_MEDIA_NAME = "CUSTOMER_MEDIA_NAME";
    public static final String CUSTOMER_MEDIA_PATH = "CUSTOMER_MEDIA_PATH";
    public static final String CUSTOMER_MEDIA_NOT_EQUAL_ID = "CUSTOMER_MEDIA_NOT_EQUAL_ID";
    public static final String CUSTOMER_MEDIA_COREMEDIA_ID = "CUSTOMER_MEDIA_COREMEDIA_ID";

    public static final String STC_TABLE_RECORDS_TO_ADD = "0";
    public static final String STC_TABLE_RECORDS_TO_REMOVE = "1";
    public static final String STC_TABLE_RECORDS_TO_MODIFY = "2";
    public static final int TIMER_TASK_OPERATE_USER = 208;
    public static final String IS_DELETED = "1";
    public static final String SPOTS_MATCHED_STATE = "H";
    public static final String SPOTS_NOT_MATCHED_STATE = "U";
    public static final String SPOTS_NEED_NOT_MATCHED_STATE = "D";
    public static final int MEDIA_ID_SYNC_DELTA = 15000;
    public static String MONITOR_SYNC_BASE_URL = "http://monitor.d109.mzhen.com:8081/mmInterfaces.do?method=";
    public static String MONITOR_SYNC_CACHE_DATA_PATH = "/home/supertool/monitorDataSync/";
    public static final String RE_ISSUE_RULE_PATH_NAME = "/home/data/data.mm.miaozhen.com/reissue";
    public static final int BATCH_COMMIT_SIZE = 2000;
    public static String SITEDNA_SYNC_MEDIA_PATH = "";
    public static String AD_SYNC_MEDIA_MEMORY_LOCATION = "";
    public static String STUSER_VIEW_PAGE = "STUSER_VIEW_PAGE";
    public static String STUSER_MODIFY_PAGE = "STUSER_MODIFY_PAGE";

    public static String SEARCH_COUNT = "SEARCH_COUNT";
    public static String MEDIA_COUNT = "MEDIA_COUNT";
    public static String ADPOSITION_COUNT = "ADPOSITION_COUNT";
    public static String MATCHED_SPOT_COUNT = "MATCHED_SPOT_COUNT";
    public static String MATCHED_ADPOSITION_COUNT = "MATCHED_ADPOSITION_COUNT";
    public static String CURRENT_LEVEL_MEDIA_COUNT = "CURRENT_LEVEL_MEDIA_COUNT";
    
    public static final int RULE_RECORD_SIZE = 1000;
    public static final int RULE_ID_SIZE = 4;
    public static final int MATCHED_URL_NUM_SIZE = 4;
    public static final int URL_SIZE_SIZE = 4;
    
    /**
     * 已删除
     */
    public static final String DELETED = "1";
    
    /**
     * 未删除
     */
    public static final String UNDELETED = "0";
	public static final int RESULT_FAIL = 0;
	public static final int RESULT_SUCCESS = 1;
}
