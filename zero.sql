-- MySQL dump 10.13  Distrib 5.7.20, for linux-glibc2.12 (x86_64)
--
-- Host: 127.0.0.1    Database: zero
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_organization`
--

DROP TABLE IF EXISTS `base_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_organization` (
  `ID` varchar(32) NOT NULL COMMENT '组织id',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父id',
  `NAME` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `EMAIL` varchar(55) DEFAULT NULL COMMENT '组织邮箱',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `POST_CODE` varchar(50) DEFAULT NULL COMMENT '邮编',
  `DESCRIPTION` longtext COMMENT '描述',
  `IS_ENABLE` varchar(1) DEFAULT '1' COMMENT '是否启用',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `CREATED_USER` varchar(50) DEFAULT NULL COMMENT '创建人',
  `TYPE` varchar(50) DEFAULT NULL COMMENT '类型',
  `TEL` varchar(100) DEFAULT NULL COMMENT '电话',
  `IS_DELETE` varchar(1) DEFAULT '0' COMMENT '是否删除(1:删除  0:未删除)',
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_18` (`PARENT_ID`),
  CONSTRAINT `FK_Reference_Base_Org` FOREIGN KEY (`PARENT_ID`) REFERENCES `base_organization` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_organization`
--

LOCK TABLES `base_organization` WRITE;
/*!40000 ALTER TABLE `base_organization` DISABLE KEYS */;
INSERT INTO `base_organization` VALUES ('0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('201803171801080902248','0','广东工业大学','gdut@gdut.edu.cn','广工','313123','广东工业大学','1','2018-03-17 18:01:08','2018-03-17 18:01:08','彭贵深','公司','0203273220','0'),('201803171812032696173','0','南方医科大学','smu@smu.edu.cn','南医大','311322','南方医科大学','1','2018-03-17 18:12:03','2018-03-17 18:12:03','彭贵深','公司','020362354','0'),('201803171813312372939','201803171801080902248','计算机学院','computer@gdut.edu.cn','计算机','312632','广东工业大学计算机学院','1','2018-03-17 18:13:31','2018-03-17 18:13:31','彭贵深','部门','0203472226','0'),('201803171815158402491','201803171801080902248','外国语学院','foreign@gdut.edu.cn','外国语','132645','广东工业大学外国语学院','1','2018-03-17 18:15:16','2018-03-17 18:15:16','彭贵深','部门','0203472159','0'),('201803171817001625650','201803171812032696173','第一临床医学院','firstclinical@smu.edu.cn','第一临床','132569','南方医科大学第一临床医学院','1','2018-03-17 18:17:00','2018-03-17 18:17:00','彭贵深','部门','0203698754','0'),('201803171818383039788','201803171813312372939','网络工程系','network@gdut.edu.cn','网工','132654','广东工业大学计算机学院网络工程系','1','2018-03-17 18:18:38','2018-03-17 18:26:06','彭贵深','部门','0203742569','0');
/*!40000 ALTER TABLE `base_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `ID` varchar(32) NOT NULL COMMENT '菜单id',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `PATH` longtext COMMENT '菜单path',
  `ICON` varchar(255) DEFAULT NULL COMMENT '图标的url',
  `PERM` varchar(500) DEFAULT NULL COMMENT '菜单授权标识（格式如sys:user:list,sys:user:save）',
  `TYPE` int(11) DEFAULT NULL COMMENT '菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素）',
  `ORDER_NUM` int(11) DEFAULT NULL COMMENT '菜单排序',
  `IS_DELETE` varchar(1) DEFAULT '0' COMMENT '是否删除(1:删除  0:未删除)',
  `IS_ENABLE` varchar(1) DEFAULT '1' COMMENT '是否启用(1:启用  0:不启用)',
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `HIDDEN` varchar(1) DEFAULT '0' COMMENT '是否隐藏菜单(1:隐藏 0:不隐藏)',
  `ALWAYS_SHOW` varchar(1) DEFAULT '0' COMMENT '是否作为子菜单显示(1:是 0:否)',
  `COMPONENT` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `REDIRECT` varchar(255) DEFAULT 'noredirect' COMMENT '是否重定向路径,默认''noredirect''',
  `CREATE_USER` varchar(50) DEFAULT NULL COMMENT '创建者',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '菜单的显示名称',
  `URL` longtext COMMENT '请求后端的URL',
  `METHOD` varchar(20) DEFAULT 'GET' COMMENT '请求的method',
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_13` (`PARENT_ID`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`PARENT_ID`) REFERENCES `sys_menu` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单/页内权限相关按钮按钮';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('0',NULL,'root','/dadashboard','font','admin',0,0,'0','1','2018-03-11 11:09:31','2018-03-11 11:09:31','0','0','layout/Layout','dashboard',NULL,'菜单结构',NULL,'GET'),('1','0','dashboard','/dadashboard','font','admin',0,0,'1','1','2018-03-11 14:56:20','2018-03-11 11:09:31','0','0','dashboard/index','','','首页','/dashboard/page','GET'),('2','0','system','/system','component','admin',0,0,'0','1','2018-03-11 15:26:25','2018-03-11 11:09:31','0','0','layout/Layout','','','系统设置',NULL,'GET'),('201803170956120791559','0','form','/form','form','form',0,0,'0','1','2018-03-17 09:56:12','2018-03-17 09:56:12','0','0','layout/Layout','','彭贵深','表单',NULL,'GET'),('201803170957568903867','201803170956120791559','createForm','create-form','tab','form:create-form',0,0,'0','1','2018-03-17 09:57:57','2018-03-22 16:18:02','0','0','form/create','','彭贵深','创建表单','/form/create/page','GET'),('201803170959149617698','201803170956120791559','editForm','edit-form','table','form:eidt-form',0,0,'1','1','2018-03-17 09:59:15','2018-03-21 20:52:36','0','0','form/edit','','彭贵深','编辑表单','/form/edit/page','GET'),('201803211851293889996','3','menuTree','','','sys:menu:tree',1,0,'0','1','2018-03-21 18:51:30','2018-03-21 18:58:43','','','','','彭贵深','菜单树','/sys/menu/tree','POST'),('201803211916550156871','3','menuDelete','','','sys:menu:delete',2,0,'0','1','2018-03-21 19:16:55','2018-03-21 19:23:45','','','','','彭贵深','菜单删除','/sys/menu/{id}','DELETE'),('201803211919487563455','3','menuUpdate','','','sys:menu:update',2,0,'0','1','2018-03-21 19:19:49','2018-03-21 19:19:49','','','','','彭贵深','菜单更新','/sys/menu','PUT'),('201803211922531859971','3','menuAdd','','','sys:menu:add',2,0,'0','1','2018-03-21 19:22:53','2018-03-21 19:22:53','','','','','彭贵深','菜单添加','/sys/menu','POST'),('201803211925405710206','3','menuById','','','sys:menu:id',2,0,'0','1','2018-03-21 19:25:41','2018-03-21 19:25:41','','','','','彭贵深','按ID搜索菜单','/sys/menu/{id}','GET'),('201803211926512455160','3','menuList','','','sys:menu:list',2,0,'0','1','2018-03-21 19:26:51','2018-03-21 19:43:35','','','','','彭贵深','菜单列表','/sys/menu/list','POST'),('201803211937072403513','7','userList','','','sys:user:list',1,0,'0','1','2018-03-21 19:37:07','2018-03-21 19:37:07','','','','','彭贵深','用户列表','/sys/user/list','POST'),('201803211938026186200','7','userDelete','','','sys:user:delete',2,0,'0','1','2018-03-21 19:38:03','2018-03-21 19:38:03','','','','','彭贵深','用户删除','/sys/user/{id}','DELETE'),('201803211938489378878','7','userAdd','','','sys:user:add',2,0,'0','1','2018-03-21 19:38:49','2018-03-21 19:38:49','','','','','彭贵深','用户新增','/sys/user','POST'),('201803211939279042746','7','userUpdate','','','sys:user:update',2,0,'0','1','2018-03-21 19:39:28','2018-03-21 19:39:28','','','','','彭贵深','用户更新','/sys/user','PUT'),('201803211940553832327','7','userById','','','sys:user:id',2,0,'0','1','2018-03-21 19:40:55','2018-03-21 19:49:11','','','','','彭贵深','按ID搜索用户','/sys/user/{id}','GET'),('201803211945373861000','5','roleList','','','sys:role:list',2,0,'0','1','2018-03-21 19:45:37','2018-03-21 19:45:37','','','','','彭贵深','角色列表','/sys/role/list','POST'),('201803211946251737372','5','roleAdd','','','sys:role:add',2,0,'0','1','2018-03-21 19:46:25','2018-03-21 19:46:25','','','','','彭贵深','角色新增','/sys/role','POST'),('201803211947041954860','5','roleUpdate','','','sys:role:update',2,0,'0','1','2018-03-21 19:47:04','2018-03-21 19:47:04','','','','','彭贵深','角色更新','/sys/role','PUT'),('201803211947462131038','5','roleDelete','','','sys:role:delete',2,0,'0','1','2018-03-21 19:47:46','2018-03-21 19:47:46','','','','','彭贵深','角色删除','/sys/role/{id}','DELETE'),('201803211948288591210','5','roleById','','','sys:role:id',2,0,'0','1','2018-03-21 19:48:29','2018-03-21 19:48:29','','','','','彭贵深','按ID搜索角色','/sys/role/{id}','GET'),('201803211950206329733','4','orgTree','','','base:org:tree',1,0,'0','1','2018-03-21 19:50:21','2018-03-21 19:50:21','','','','','彭贵深','组织树','/base/org/tree','POST'),('201803211951478835834','4','orgAdd','','','base:org:add',2,0,'0','1','2018-03-21 19:51:48','2018-03-21 19:51:48','','','','','彭贵深','组织新增','/base/org','POST'),('201803211952314105127','4','orgDelete','','','base:org:delete',2,0,'0','1','2018-03-21 19:52:31','2018-03-21 19:52:31','','','','','彭贵深','组织删除','/base/org/{id}','DELETE'),('201803211953322739579','4','orgUpdate','','','base:org:update',2,0,'0','1','2018-03-21 19:53:32','2018-03-21 19:53:32','','','','','彭贵深','组织更新','/base/org','PUT'),('201803211954426802764','4','orgByCondition','','','base:org:list',2,0,'0','1','2018-03-21 19:54:43','2018-03-21 19:54:43','','','','','彭贵深','按条件搜索组织','/base/org/list','POST'),('201803212001079429504','5','roleAuth','','','sys:role:auth',2,0,'0','1','2018-03-21 20:01:08','2018-03-21 20:01:08','','','','','彭贵深','角色授权','/sys/role/auth','POST'),('201803212101158270688','201803170956120791559','editForm','edit-form','table','form:edit-form',0,0,'0','1','2018-03-21 21:01:16','2018-03-21 21:01:16','0','0','form/edit','','彭贵深','编辑表单','/form/edit/page','GET'),('201803222102244855656','3','menuBan','','','sys:menu:ban',2,0,'0','1','2018-03-22 21:02:24','2018-03-22 21:02:24','','','','','彭贵深','菜单禁用','/sys/menu/ban','POST'),('201803222103111474880','7','userBan','','','sys:user:ban',2,0,'0','1','2018-03-22 21:03:11','2018-03-22 21:03:11','','','','','彭贵深','用户禁用','/sys/user/ban','POST'),('3','2','menu','menus','menu','admin',0,0,'0','1','2018-03-11 14:58:34','2018-03-17 11:00:08','0','0','system/menus','','','菜单管理','/sys/menu/page','GET'),('4','2','org','orgs','org','admin',0,0,'0','1','2018-03-11 14:59:31','2018-03-17 11:00:19','0','0','system/orgs','','','组织管理','/base/org/page','GET'),('5','2','role','roles','role','admin',0,0,'0','1','2018-03-11 15:00:34','2018-03-17 11:00:32','0','0','system/roles','','','角色管理','/sys/role/page','GET'),('6','2','auth','auths','auth','admin',0,0,'1','1','2018-03-11 15:01:33','2018-03-17 18:28:16','0','0','system/auths','','','授权管理','/sys/auth/page','GET'),('7','2','user','users','user','admin',0,0,'0','1','2018-03-13 16:18:45','2018-03-17 11:00:58','0','0','system/users','','','用户管理','/sys/user/page','GET');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `ID` varchar(32) NOT NULL COMMENT '角色id',
  `NAME` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `ALIAS` varchar(20) DEFAULT NULL COMMENT '别名',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `IS_ENABLE` varchar(1) DEFAULT '1' COMMENT '状态标志（0：禁用  1：启用）',
  `IS_DELETE` varchar(1) DEFAULT '0' COMMENT '删除标志（0：禁用   1：删除）',
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('201803222104212793033','普通角色','不可删除信息','不可删除信息','1','0','2018-03-22 21:04:21','2018-03-22 21:04:21'),('5','超级管理员','SuperAdmin','超级','1','0','2018-02-27 15:13:21','2018-02-27 15:13:21'),('6','测试','测试角色','这个是测试角色','1','0','2018-02-25 16:40:39','2018-02-25 16:40:39');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `ID` varchar(32) NOT NULL COMMENT '角色菜单ID',
  `ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色id（外键）',
  `MENU_ID` varchar(32) DEFAULT NULL COMMENT '菜单id（外键）',
  `IS_DELETE` varchar(1) DEFAULT '0' COMMENT '是否删除标志（所有记录都是假删除）',
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SYS_ROLE_MENU_ROLE` (`ROLE_ID`),
  KEY `FK_SYS_ROLE_MENU_MENU` (`MENU_ID`),
  CONSTRAINT `FK_SYS_ROLE_MENU_MENU` FOREIGN KEY (`MENU_ID`) REFERENCES `sys_menu` (`ID`),
  CONSTRAINT `FK_SYS_ROLE_MENU_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单（实际上是角色权限表）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES ('1','5','1','0','2018-03-14 16:04:37','2018-03-22 21:03:36'),('10','6','1','1','2018-03-14 16:11:54','2018-03-17 21:10:11'),('2','5','2','0','2018-03-14 16:04:37','2018-03-22 21:03:36'),('201803171012378069200','5','201803170956120791559','0','2018-03-17 10:12:38','2018-03-22 21:03:36'),('201803171040436068771','5','201803170957568903867','0','2018-03-17 10:40:44','2018-03-22 21:03:36'),('201803171040436248700','5','201803170959149617698','0','2018-03-17 10:40:44','2018-03-22 21:03:36'),('201803171042179916899','6','201803170956120791559','0','2018-03-17 10:42:18','2018-03-17 21:45:21'),('201803171042179976249','6','201803170957568903867','0','2018-03-17 10:42:18','2018-03-17 21:45:21'),('201803171042180146925','6','201803170959149617698','1','2018-03-17 10:42:18','2018-03-17 21:10:11'),('201803172145207741076','6','201803170959149617698','0','2018-03-17 21:45:21','2018-03-17 21:45:21'),('201803211852107528142','5','201803211851293889996','0','2018-03-21 18:52:11','2018-03-22 21:03:36'),('201803212020495297949','5','201803211916550156871','1','2018-03-21 20:20:50','2018-03-21 20:56:22'),('201803212020497699362','5','201803211919487563455','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020497753866','5','201803211922531859971','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499108300','5','201803211925405710206','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499168448','5','201803211926512455160','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499244903','5','201803211950206329733','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499309550','5','201803211951478835834','1','2018-03-21 20:20:50','2018-03-22 20:49:22'),('201803212020499365910','5','201803211952314105127','1','2018-03-21 20:20:50','2018-03-22 20:41:31'),('201803212020499423496','5','201803211953322739579','1','2018-03-21 20:20:50','2018-03-22 20:49:22'),('201803212020499488182','5','201803211954426802764','1','2018-03-21 20:20:50','2018-03-22 20:49:22'),('201803212020499578311','5','201803211945373861000','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499635394','5','201803211946251737372','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499681989','5','201803211947041954860','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499756735','5','201803211947462131038','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499851387','5','201803211948288591210','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020499950127','5','201803212001079429504','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020500045687','5','201803211937072403513','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020500136728','5','201803211938026186200','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020500247371','5','201803211938489378878','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020500303959','5','201803211939279042746','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212020500371030','5','201803211940553832327','0','2018-03-21 20:20:50','2018-03-22 21:03:36'),('201803212103392906751','5','201803212101158270688','0','2018-03-21 21:03:39','2018-03-22 21:03:36'),('201803222019352099241','5','201803211916550156871','0','2018-03-22 20:19:35','2018-03-22 21:03:36'),('201803222049537090758','5','201803211951478835834','0','2018-03-22 20:49:54','2018-03-22 21:03:36'),('201803222049537147549','5','201803211952314105127','0','2018-03-22 20:49:54','2018-03-22 21:03:36'),('201803222049537182306','5','201803211953322739579','0','2018-03-22 20:49:54','2018-03-22 21:03:36'),('201803222049537222629','5','201803211954426802764','0','2018-03-22 20:49:54','2018-03-22 21:03:36'),('201803222103360278728','5','201803222102244855656','0','2018-03-22 21:03:36','2018-03-22 21:03:36'),('201803222103360890164','5','201803222103111474880','0','2018-03-22 21:03:36','2018-03-22 21:03:36'),('201803222106336621935','201803222104212793033','7','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106336654082','201803222104212793033','201803211937072403513','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106336680251','201803222104212793033','201803211938489378878','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106336720807','201803222104212793033','201803211939279042746','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106336766315','201803222104212793033','201803211940553832327','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106336816352','201803222104212793033','201803222103111474880','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106336855774','201803222104212793033','201803170956120791559','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338071690','201803222104212793033','201803170957568903867','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338138814','201803222104212793033','5','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338199470','201803222104212793033','201803211945373861000','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338230195','201803222104212793033','201803211946251737372','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338263647','201803222104212793033','201803211947041954860','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338293490','201803222104212793033','201803211948288591210','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338335674','201803222104212793033','201803212001079429504','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338363473','201803222104212793033','201803211953322739579','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338395069','201803222104212793033','201803211954426802764','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338434193','201803222104212793033','201803211951478835834','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338486263','201803222104212793033','201803211950206329733','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338523215','201803222104212793033','4','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338578636','201803222104212793033','2','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338616334','201803222104212793033','3','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338661095','201803222104212793033','201803211851293889996','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338704279','201803222104212793033','201803211919487563455','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338742785','201803222104212793033','201803211922531859971','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338776419','201803222104212793033','201803211925405710206','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('201803222106338818487','201803222104212793033','201803211926512455160','0','2018-03-22 21:06:34','2018-03-22 21:06:34'),('3','5','3','0','2018-03-14 16:10:55','2018-03-22 21:03:36'),('4','5','4','0','2018-03-14 16:11:32','2018-03-22 21:03:36'),('5','5','5','0','2018-03-14 16:11:32','2018-03-22 21:03:36'),('6','5','6','0','2018-03-14 16:11:33','2018-03-22 21:03:36'),('7','5','7','0','2018-03-14 16:11:33','2018-03-22 21:03:36');
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL COMMENT '用户id',
  `LOGIN_NAME` varchar(32) NOT NULL,
  `ID_CARD` varchar(32) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL COMMENT '手机号',
  `PASSWORD` varchar(64) NOT NULL COMMENT '密码',
  `NAME` varchar(20) DEFAULT NULL COMMENT '姓名',
  `QQ` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(25) DEFAULT NULL,
  `AVATAR` varchar(255) DEFAULT NULL COMMENT '头像',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `IS_ENABLE` varchar(1) DEFAULT '1' COMMENT '是否禁用',
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `IS_DELETE` varchar(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('1','13543498146','440883199209121212','13543498146','$2a$10$FEdugj.5XbX6CefoCqlHsOQnAMmk2Nte6ldyC/.yROnesyowigM1W','测试','646034022','123456@163.com','http://pic.qqtn.com/up/2017-12/15129608551477048.jpg','hello','1','2018-03-11 09:41:57','2018-03-17 10:41:40','0'),('2','18813293875','441523199511082121','18813293875','$2a$10$FDgsItlwjVpPhpMfue21buwtp56IgT5yItWZ/QTNeNewPYaOE2GjG','pipix','2209899642','2209899642@qq.com','http://pic.qqtn.com/up/2017-12/15129608551477048.jpg','','1','2018-02-26 16:55:21','2018-03-14 19:29:46','0'),('201803222107551464413','18813293878','441523199511087879','18813293878','$2a$10$MW719vMUK1x1XAkwZBorne1SCPsIiz6dL/miDavnusvlSAuujlUca','普通用户','22021220','456@123.com','http://sc3.hao123img.com/data/fd5166d33dba874e15d4f8fb43be485d',NULL,'1','2018-03-22 21:07:55','2018-03-22 21:07:55','0');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户id',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色id',
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `IS_DELETE` varchar(1) DEFAULT '0' COMMENT '假删除',
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`),
  KEY `FK_USERROLE_USER` (`USER_ID`),
  KEY `FK_USERROLE_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_USERROLE_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ID`),
  CONSTRAINT `FK_USERROLE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1','2','5','2018-02-27 09:33:00','2018-02-27 09:32:59','0'),('2','1','6','2018-02-27 09:33:00','2018-02-27 09:33:00','1'),('201803171041395772321','1','6','2018-03-17 10:41:40','2018-03-17 10:41:40','0'),('201803222107552016209','201803222107551464413','201803222104212793033','2018-03-22 21:07:55','2018-03-22 21:07:55','0');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-25 16:32:04
