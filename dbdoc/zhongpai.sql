set names utf8;

DROP TABLE IF EXISTS `st_user`;
CREATE TABLE `st_user` (
  `UserId` int(4) NOT NULL auto_increment COMMENT '主键，自增',
  `DspId` int not null default 0 comment 'dsp对应id',
  `ParentUserId` int(4) NOT NULL default '0' COMMENT '父用户Id',
  `isSuperAdmin` char(1) NOT NULL default '0' COMMENT '是否是系统最高管理员，系统初始应该指定1个或多个最高管理员以用来创建用户等；''0''不是系统最高管理员，''1''是最高系统管理员',
  `UserName` varchar(100) NOT NULL default '' COMMENT '用户名',
  `UserFullName` varchar(100) NOT NULL default '' COMMENT '用户全称',
  `Password` varchar(100) NOT NULL default '' COMMENT '密码',
  `Description` text NOT NULL COMMENT '备注',
  `LoginCount` int(4) NOT NULL default '0' COMMENT '登录次数',
  `PhoneNumber` varchar(100) NOT NULL default '' COMMENT '电话号码',
  `Address` varchar(1000) NOT NULL default '' COMMENT '地址',
  `Email` varchar(100) NOT NULL default '' COMMENT '邮件',
  `IsFreezed` char(1) NOT NULL default '0' COMMENT '该用户是否被冻结',
  `CreateUser` int(4) NOT NULL default '0' COMMENT '创建者',
  `CreateDate` datetime NOT NULL default '1970-01-01 08:00:00' COMMENT '创建时间',
  `UpdateUser` int(4) NOT NULL default '0' COMMENT '更新者',
  `UpdateDate` datetime NOT NULL default '1970-01-01 08:00:00' COMMENT '更新时间',
  `IsDeleted` char(1) NOT NULL default '0' COMMENT '删除状态：''0''是未删除；''1''是删除',
  `DeleteUser` int(4) NOT NULL default '0' COMMENT '删除者',
  `DeleteDate` datetime NOT NULL default '1970-01-01 08:00:00' COMMENT '删除时间',
  PRIMARY KEY  (`UserId`),
  KEY `st_user_username` (`UserName`),
  KEY `st_user_parent_user_id` (`ParentUserId`),
  KEY `st_user_user_full_name` (`UserFullName`),
  KEY `st_user_is_freezed` (`IsFreezed`),
  KEY `st_user_create_user` (`CreateUser`),
  KEY `st_user_update_user` (`UpdateUser`),
  KEY `st_user_is_deleted` (`IsDeleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

LOCK TABLES `st_user` WRITE;
insert into `st_user` (dspid,parentUserId,isSuperAdmin,userName,`password`,isFreezed,createUser,updateUser,deleteUser,isDeleted) values ('11114',0,1,'supertool','fh58q2ea6thauof5ikg98fe2ciafh50r',0,1,1,1,0);
UNLOCK TABLES;