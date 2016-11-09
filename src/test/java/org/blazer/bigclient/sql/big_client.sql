/*
Navicat MySQL Data Transfer

Source Server         : ms
Source Server Version : 50713
Source Host           : ms:3306
Source Database       : big_client

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-11-09 15:37:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cl_allot_user
-- ----------------------------
DROP TABLE IF EXISTS `cl_allot_user`;
CREATE TABLE `cl_allot_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `register_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `id_card` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `if_employee` varchar(20) DEFAULT NULL COMMENT '是否员工',
  `assets_amount` varchar(100) DEFAULT NULL COMMENT '资产总额',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `age` varchar(20) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `referrer` varchar(20) DEFAULT NULL COMMENT '扫码推荐人',
  `referrer_phone_number` varchar(20) DEFAULT NULL COMMENT '推荐人手机号',
  `if_referrer_employee` varchar(20) DEFAULT NULL COMMENT '推荐人是否员工',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `if_delete` int(4) DEFAULT '0' COMMENT '是否删除;0:未删除，1:删除',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='平台待分配客户';

-- ----------------------------
-- Records of cl_allot_user
-- ----------------------------

-- ----------------------------
-- Table structure for cl_excel
-- ----------------------------
DROP TABLE IF EXISTS `cl_excel`;
CREATE TABLE `cl_excel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '当前用户ID',
  `excel_name` varchar(100) DEFAULT NULL COMMENT 'Excel源文件名',
  `excel_real_name` varchar(100) DEFAULT NULL COMMENT 'Excel服务器文件名',
  `excel_real_path` varchar(200) DEFAULT NULL COMMENT 'Excel服务器路径',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cl_excel
-- ----------------------------
INSERT INTO `cl_excel` VALUES ('1', '88888888', 'ExtUserUpload_Template_v1.0.xlsx', '127.0.0.1-1478593106609.xlsx', 'F:\\workspace\\intellij2016\\big-client-new\\src\\upload\\', null, '2016-11-08 16:18:27');
INSERT INTO `cl_excel` VALUES ('2', '88888888', 'ExtUserUpload_Template_v1.0.xlsx', '127.0.0.1-1478593249022.xlsx', 'F:\\workspace\\intellij2016\\big-client-new\\src\\upload\\', null, '2016-11-08 16:20:49');

-- ----------------------------
-- Table structure for cl_ext_user
-- ----------------------------
DROP TABLE IF EXISTS `cl_ext_user`;
CREATE TABLE `cl_ext_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `if_register` varchar(20) DEFAULT NULL COMMENT '是否注册',
  `register_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `if_real_name` varchar(20) DEFAULT NULL COMMENT '是否实名',
  `if_bind_card` varchar(20) DEFAULT NULL COMMENT '是否绑卡',
  `if_transaction` varchar(20) DEFAULT NULL COMMENT '是否有过交易',
  `referrer` varchar(20) DEFAULT NULL COMMENT '扫码推荐人',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `if_delete` int(4) DEFAULT '0' COMMENT '是否删除;0:未删除，1:删除',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='外部拓展客户';

-- ----------------------------
-- Records of cl_ext_user
-- ----------------------------

-- ----------------------------
-- Table structure for cl_ext_user_bak
-- ----------------------------
DROP TABLE IF EXISTS `cl_ext_user_bak`;
CREATE TABLE `cl_ext_user_bak` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `excel_id` bigint(20) NOT NULL COMMENT 'excel关联id',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `customer_name` varchar(20) DEFAULT NULL COMMENT '投顾上传的客户姓名（待匹配系统客户姓名）',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `if_effective` int(4) DEFAULT NULL COMMENT '是否有效（1：有效，0：无效）',
  `if_delete` int(4) DEFAULT '0' COMMENT '是否删除，0代表未删除，1代表删除',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注信息(用来记录上报无效的原因）',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `IDX_EXCEL_ID` (`excel_id`) USING BTREE,
  KEY `IDX_PHONE_NUMBER` (`phone_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='外部拓展客户（导入名单）';

-- ----------------------------
-- Records of cl_ext_user_bak
-- ----------------------------
INSERT INTO `cl_ext_user_bak` VALUES ('1', '2', '13802108888', '张三1', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:51');
INSERT INTO `cl_ext_user_bak` VALUES ('2', '2', '13802108889', '张三2', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:51');
INSERT INTO `cl_ext_user_bak` VALUES ('3', '2', '13802108890', '张三3', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:51');
INSERT INTO `cl_ext_user_bak` VALUES ('4', '2', '13802108891', '张三4', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:52');
INSERT INTO `cl_ext_user_bak` VALUES ('5', '2', '13802108892', '张三5', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:52');
INSERT INTO `cl_ext_user_bak` VALUES ('6', '2', '13802108893', '张三6', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:53');
INSERT INTO `cl_ext_user_bak` VALUES ('7', '2', '13802108894', '张三7', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:53');
INSERT INTO `cl_ext_user_bak` VALUES ('8', '2', '13802108895', '张三8', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:54');
INSERT INTO `cl_ext_user_bak` VALUES ('9', '2', '13802108896', '张三9', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:54');
INSERT INTO `cl_ext_user_bak` VALUES ('10', '2', '13802108897', '张三10', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:55');
INSERT INTO `cl_ext_user_bak` VALUES ('11', '2', '13802108898', '张三11', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:55');
INSERT INTO `cl_ext_user_bak` VALUES ('12', '2', '13802108899', '张三12', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:56');
INSERT INTO `cl_ext_user_bak` VALUES ('13', '2', '13802108900', '张三13', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:56');
INSERT INTO `cl_ext_user_bak` VALUES ('14', '2', '13802108901', '张三14', null, '何朵', '1', '0', null, null, '2016-11-08 16:20:57');

-- ----------------------------
-- Table structure for cl_formal_user
-- ----------------------------
DROP TABLE IF EXISTS `cl_formal_user`;
CREATE TABLE `cl_formal_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `report_or_allot` varchar(20) DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` varchar(20) DEFAULT NULL COMMENT '上报/分配时间',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `if_delete` int(4) DEFAULT '0' COMMENT '是否删除;0:未删除，1:删除',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='正式客户名单';

-- ----------------------------
-- Records of cl_formal_user
-- ----------------------------
INSERT INTO `cl_formal_user` VALUES ('1', '13802108888', '上报', '2016-11-08 16:20:50', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:51');
INSERT INTO `cl_formal_user` VALUES ('2', '13802108889', '上报', '2016-11-08 16:20:50', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:51');
INSERT INTO `cl_formal_user` VALUES ('3', '13802108890', '上报', '2016-11-08 16:20:51', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:51');
INSERT INTO `cl_formal_user` VALUES ('4', '13802108891', '上报', '2016-11-08 16:20:51', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:52');
INSERT INTO `cl_formal_user` VALUES ('5', '13802108892', '上报', '2016-11-08 16:20:52', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:52');
INSERT INTO `cl_formal_user` VALUES ('6', '13802108893', '上报', '2016-11-08 16:20:52', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:53');
INSERT INTO `cl_formal_user` VALUES ('7', '13802108894', '上报', '2016-11-08 16:20:53', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:53');
INSERT INTO `cl_formal_user` VALUES ('8', '13802108895', '上报', '2016-11-08 16:20:54', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:54');
INSERT INTO `cl_formal_user` VALUES ('9', '13802108896', '上报', '2016-11-08 16:20:54', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:54');
INSERT INTO `cl_formal_user` VALUES ('10', '13802108897', '上报', '2016-11-08 16:20:54', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:55');
INSERT INTO `cl_formal_user` VALUES ('11', '13802108898', '上报', '2016-11-08 16:20:55', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:55');
INSERT INTO `cl_formal_user` VALUES ('12', '13802108899', '上报', '2016-11-08 16:20:55', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:56');
INSERT INTO `cl_formal_user` VALUES ('13', '13802108900', '上报', '2016-11-08 16:20:56', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:56');
INSERT INTO `cl_formal_user` VALUES ('14', '13802108901', '上报', '2016-11-08 16:20:56', 'DKH000', '何朵', '0', null, '2016-11-08 16:20:57');

-- ----------------------------
-- Table structure for cl_formal_user_version
-- ----------------------------
DROP TABLE IF EXISTS `cl_formal_user_version`;
CREATE TABLE `cl_formal_user_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `advisor_id` bigint(20) DEFAULT NULL COMMENT '投顾ID',
  `version_no` varchar(20) DEFAULT NULL COMMENT '版本号:默认是1，依次递增',
  `start_date` datetime DEFAULT NULL COMMENT '分配起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '分配结束日期，为NULL值表示没有结束日期',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='正式名单的版本表，该表关联user和adviser,记录客户和投顾的对应关系。';

-- ----------------------------
-- Records of cl_formal_user_version
-- ----------------------------
INSERT INTO `cl_formal_user_version` VALUES ('1', '1', '6', '1', '2016-11-08 16:20:51', null, null, '2016-11-08 16:20:51');
INSERT INTO `cl_formal_user_version` VALUES ('2', '2', '6', '1', '2016-11-08 16:20:51', null, null, '2016-11-08 16:20:51');
INSERT INTO `cl_formal_user_version` VALUES ('3', '3', '6', '1', '2016-11-08 16:20:51', null, null, '2016-11-08 16:20:52');
INSERT INTO `cl_formal_user_version` VALUES ('4', '4', '6', '1', '2016-11-08 16:20:52', null, null, '2016-11-08 16:20:52');
INSERT INTO `cl_formal_user_version` VALUES ('5', '5', '6', '1', '2016-11-08 16:20:52', null, null, '2016-11-08 16:20:52');
INSERT INTO `cl_formal_user_version` VALUES ('6', '6', '6', '1', '2016-11-08 16:20:53', null, null, '2016-11-08 16:20:53');
INSERT INTO `cl_formal_user_version` VALUES ('7', '7', '6', '1', '2016-11-08 16:20:53', null, null, '2016-11-08 16:20:53');
INSERT INTO `cl_formal_user_version` VALUES ('8', '8', '6', '1', '2016-11-08 16:20:54', null, null, '2016-11-08 16:20:54');
INSERT INTO `cl_formal_user_version` VALUES ('9', '9', '6', '1', '2016-11-08 16:20:54', null, null, '2016-11-08 16:20:55');
INSERT INTO `cl_formal_user_version` VALUES ('10', '10', '6', '1', '2016-11-08 16:20:55', null, null, '2016-11-08 16:20:55');
INSERT INTO `cl_formal_user_version` VALUES ('11', '11', '6', '1', '2016-11-08 16:20:55', null, null, '2016-11-08 16:20:55');
INSERT INTO `cl_formal_user_version` VALUES ('12', '12', '6', '1', '2016-11-08 16:20:56', null, null, '2016-11-08 16:20:56');
INSERT INTO `cl_formal_user_version` VALUES ('13', '13', '6', '1', '2016-11-08 16:20:56', null, null, '2016-11-08 16:20:56');
INSERT INTO `cl_formal_user_version` VALUES ('14', '14', '6', '1', '2016-11-08 16:20:57', null, null, '2016-11-08 16:20:57');

-- ----------------------------
-- Table structure for kam_advisor
-- ----------------------------
DROP TABLE IF EXISTS `kam_advisor`;
CREATE TABLE `kam_advisor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `tid` bigint(20) DEFAULT NULL COMMENT '所属团队ID（advisor_team.id）',
  `serial_number` varchar(20) DEFAULT NULL COMMENT '投顾编号',
  `level` varchar(20) DEFAULT NULL COMMENT '投顾级别',
  `system_name` varchar(20) DEFAULT NULL COMMENT '系统登录用户名',
  `actual_name` varchar(20) DEFAULT NULL COMMENT '投顾姓名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '投顾手机号码',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注信息',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kam_advisor
-- ----------------------------
INSERT INTO `kam_advisor` VALUES ('1', '1', 'IC0001', '高级投资顾问-高2', 'zhanghuisheng', '张辉胜', '15021435920', 'zhanghuisheng@evergrande.com', '2016-10-27 15:06:39', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('2', '2', 'IC0002', '高级投资顾问-高2', 'maohuifang', '毛慧芳', '13817009890', 'maohuifang@evergrande.com', '2016-10-27 15:06:44', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('3', '3', 'IC0003', '高级投资顾问-高2', 'liuchao', '刘超', '13641892367', 'liuchao@evergrande.com', '2016-10-27 15:06:46', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('4', '1', 'IC0004', '高级投资顾问-高1', 'zhuchengqing', '朱橙青', '13564344405', 'zhuchengqing@evergrande.com', '2016-10-27 15:06:49', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('5', '3', 'IC0005', '高级投资顾问-高1', 'zhaoyan', '赵妍', '18964868810', 'zhaoyan@evergrande.com', '2016-10-27 15:06:54', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('6', '1', 'IC0006', '投资专员-低3', 'heduo', '何朵', '18729531770', 'heduo@evergrande.com', '2016-10-27 15:06:57', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('7', '2', 'IC0007', '投资专员-低1', 'liuyuxiang', '刘宇翔', '15952595321', 'lxy0709@evergrande.com', '2016-10-27 15:07:01', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('8', '4', 'IC0008', '无', 'yushuya', '虞舒雅', '15914316325', 'yushuya@evergrande.com', '2016-10-27 15:07:04', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('9', '4', 'IC0009', '高级投资顾问-高2', 'liweiming', '李伟铭', '18621767183', 'liweiming@evergrande.com', '2016-10-27 15:07:08', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('10', '2', 'IC0010', '投资顾问-中3', 'wangguanlin', '王冠林', '18221655003', 'wangguanlin@evergrande.com', '2016-10-27 15:07:21', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('11', '3', 'IC0011', '高级投资顾问-高1', 'jianglingling', '姜玲玲', '15021435920', 'jianglingling@evergrande.com', '2016-10-27 15:07:18', '2016-10-26 15:23:11');
INSERT INTO `kam_advisor` VALUES ('12', '1', 'IC0012', '投资专员-低1', 'wansongyan', '万松焰', '18720968696', 'wansongyan@evergrande.com', '2016-10-27 15:07:26', '2016-10-26 15:23:11');

-- ----------------------------
-- Table structure for kam_advisor_team
-- ----------------------------
DROP TABLE IF EXISTS `kam_advisor_team`;
CREATE TABLE `kam_advisor_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `team_name` varchar(20) DEFAULT NULL COMMENT '团队名称',
  `team_leader_id` bigint(20) DEFAULT NULL COMMENT '团队长ID（= advisor.id）',
  `total_number` int(10) DEFAULT NULL COMMENT '团队人数',
  `area` varchar(20) DEFAULT NULL COMMENT '区域',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='投资顾问团队';

-- ----------------------------
-- Records of kam_advisor_team
-- ----------------------------
INSERT INTO `kam_advisor_team` VALUES ('1', '恒胜', '1', '4', '上海', '暂无', '2016-10-27 15:02:30', '2016-10-27 14:29:32');
INSERT INTO `kam_advisor_team` VALUES ('2', '恒越', '2', '3', '上海', '暂无', '2016-10-27 15:01:39', '2016-10-27 15:01:17');
INSERT INTO `kam_advisor_team` VALUES ('3', '恒超', '3', '3', '上海', '暂无', '2016-10-27 15:01:41', '2016-10-27 15:01:17');
INSERT INTO `kam_advisor_team` VALUES ('4', '恒赢', '9', '2', '深圳', '暂无', '2016-10-27 15:02:14', '2016-10-27 15:01:17');

-- ----------------------------
-- Table structure for pa_current_sales_scale_accounting
-- ----------------------------
DROP TABLE IF EXISTS `pa_current_sales_scale_accounting`;
CREATE TABLE `pa_current_sales_scale_accounting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `monthly_purchase_amount` double(20,2) DEFAULT '0.00' COMMENT '当月申购金额（万元）',
  `monthly_purchase_amount_10` double(20,2) DEFAULT '0.00' COMMENT '当月申购金额/10（千元）',
  `monthly_investment_target` double(20,2) DEFAULT '0.00' COMMENT '月投资规模目标（万元）',
  `monthly_performance_limit` double(20,2) DEFAULT '0.00' COMMENT '当月活期业绩上限（万元）',
  `effective_current_sales_scale` double(20,2) DEFAULT '0.00' COMMENT '有效活期销售规模（万元）',
  `deferred_next_month` double(20,2) DEFAULT '0.00' COMMENT '递延下月（万元）',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='[业绩核算]--[活期销售规模核算]--current sales scale accounting';

-- ----------------------------
-- Records of pa_current_sales_scale_accounting
-- ----------------------------

-- ----------------------------
-- Table structure for pa_customers_accounting
-- ----------------------------
DROP TABLE IF EXISTS `pa_customers_accounting`;
CREATE TABLE `pa_customers_accounting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `register_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `if_performance_pool` int(4) DEFAULT NULL COMMENT '是否业绩池（0：不计入，1：计入）',
  `ending_balance` varchar(20) DEFAULT NULL COMMENT '期末AUM（资产总额 as a）',
  `ending_not_less_than_fifty` int(4) DEFAULT '0' COMMENT '期末不小于50万（0：不符合条件，1：符合条件）',
  `buy_amount` varchar(100) DEFAULT NULL COMMENT '投资总额（当月定期投资+活期申购  as b）',
  `beginning_balance` varchar(20) DEFAULT NULL COMMENT '期初AUM（= a - b） as c',
  `beginning_no_greater_than_fifty` int(4) DEFAULT '0' COMMENT '期初不大于50万（0：不符合条件，1：符合条件）',
  `matching_period_initial_value` varchar(20) DEFAULT NULL COMMENT '匹配期初值（上月期初值  as d）',
  `beginning_comparison` varchar(20) DEFAULT NULL COMMENT '期初对比(c = d ? TRUE or FALSE)',
  `difference` varchar(20) DEFAULT NULL COMMENT '差异(c - d 有可能负数)',
  `redemption_order` varchar(20) DEFAULT NULL COMMENT '兑付单（关联定期兑付报表）',
  `revise` varchar(20) DEFAULT NULL COMMENT '修正（TRUE or FALSE）',
  `error_query` varchar(20) DEFAULT NULL COMMENT '差错查询（预留字段）',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='[业绩核算]--[获客数核算]--customers accounting';

-- ----------------------------
-- Records of pa_customers_accounting
-- ----------------------------

-- ----------------------------
-- Table structure for pa_regular_sales_scale_accounting
-- ----------------------------
DROP TABLE IF EXISTS `pa_regular_sales_scale_accounting`;
CREATE TABLE `pa_regular_sales_scale_accounting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `referrer` varchar(20) DEFAULT NULL COMMENT '扫码推荐人',
  `rebate_expiration_date` varchar(20) DEFAULT NULL COMMENT '返利失效日期',
  `report_or_allot` varchar(20) DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` varchar(20) DEFAULT NULL COMMENT '上报/分配时间',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `basic_product_name` varchar(50) DEFAULT NULL COMMENT '基础产品名称（定期）',
  `investment_amount` varchar(20) DEFAULT NULL COMMENT '投资金额',
  `regular_assets_total` varchar(20) DEFAULT NULL COMMENT '现有资产---当前定期AUM（资产总额）',
  `investment_date` varchar(20) DEFAULT NULL COMMENT '购买时间 0000-00-00 00:00:00',
  `partition_coefficient` int(4) DEFAULT '0' COMMENT '分配系数',
  `performance_pool_coefficient` int(4) DEFAULT '0' COMMENT '业绩池系数',
  `product_coefficient` int(4) DEFAULT '0' COMMENT '产品系数',
  `effective_sales_amount` double(20,2) DEFAULT '0.00' COMMENT '有效销售金额（单位：元）',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='[业绩核算]--[定期销售规模核算]--regular sales scale accounting';

-- ----------------------------
-- Records of pa_regular_sales_scale_accounting
-- ----------------------------

-- ----------------------------
-- Table structure for sr_assets_balance
-- ----------------------------
DROP TABLE IF EXISTS `sr_assets_balance`;
CREATE TABLE `sr_assets_balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `register_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `regular_assets_total` varchar(20) DEFAULT NULL COMMENT '当前定期AUM（资产总额）',
  `regular_aum_time_point` varchar(20) DEFAULT NULL COMMENT '当前定期AUM时间点',
  `current_assets_total` varchar(20) DEFAULT NULL COMMENT '当前活期AUM（资产总额）',
  `current_aum_time_point` varchar(20) DEFAULT NULL COMMENT '当前活期AUM时间点',
  `aum_total` varchar(20) DEFAULT NULL COMMENT '当前AUM汇总（单位：元）',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='[统计报表]--[资产余额]--assets balance';

-- ----------------------------
-- Records of sr_assets_balance
-- ----------------------------

-- ----------------------------
-- Table structure for sr_current_sales_details
-- ----------------------------
DROP TABLE IF EXISTS `sr_current_sales_details`;
CREATE TABLE `sr_current_sales_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `report_or_allot` varchar(20) DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` varchar(20) DEFAULT NULL COMMENT '上报/分配时间',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `base_product_name` varchar(50) DEFAULT NULL COMMENT '基础产品名称（活期）',
  `purchase_amount` varchar(20) DEFAULT NULL COMMENT '申购金额',
  `current_assets_total` varchar(20) DEFAULT NULL COMMENT '现有资产---当前活期AUM（资产总额）',
  `purchase_date` varchar(20) DEFAULT NULL COMMENT '申购时间 0000-00-00 00:00:00',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='[统计报表]--[活期销售明细]--current sales details';

-- ----------------------------
-- Records of sr_current_sales_details
-- ----------------------------

-- ----------------------------
-- Table structure for sr_regular_sales_details
-- ----------------------------
DROP TABLE IF EXISTS `sr_regular_sales_details`;
CREATE TABLE `sr_regular_sales_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `referrer` varchar(20) DEFAULT NULL COMMENT '扫码推荐人',
  `rebate_expiration_date` varchar(20) DEFAULT NULL COMMENT '返利失效日期',
  `report_or_allot` varchar(20) DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` varchar(20) DEFAULT NULL COMMENT '上报/分配时间',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `basic_product_name` varchar(50) DEFAULT NULL COMMENT '基础产品名称（定期）',
  `investment_amount` varchar(20) DEFAULT NULL COMMENT '投资金额',
  `regular_assets_total` varchar(20) DEFAULT NULL COMMENT '现有资产---当前定期AUM（资产总额）',
  `investment_date` varchar(20) DEFAULT NULL COMMENT '购买时间 0000-00-00 00:00:00',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='[统计报表]--[定期销售明细]--regular sales details';

-- ----------------------------
-- Records of sr_regular_sales_details
-- ----------------------------

-- ----------------------------
-- Table structure for test_user_info
-- ----------------------------
DROP TABLE IF EXISTS `test_user_info`;
CREATE TABLE `test_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `excel_id` bigint(20) NOT NULL COMMENT 'excel关联id(平台分配-1，手动添加0，excel上传正数)',
  `phone_number` bigint(20) NOT NULL COMMENT '手机号码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `age` varchar(20) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `id_card` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `assets_amount` varchar(100) DEFAULT NULL COMMENT '资产总额',
  `if_employee` varchar(20) DEFAULT NULL COMMENT '是否员工',
  `if_register` varchar(20) DEFAULT NULL COMMENT '是否注册',
  `register_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `if_real_name` varchar(20) DEFAULT NULL COMMENT '是否实名',
  `if_bind_card` varchar(20) DEFAULT NULL COMMENT '是否绑卡',
  `if_transaction` varchar(20) DEFAULT NULL COMMENT '是否有过交易',
  `referrer` varchar(20) DEFAULT NULL COMMENT '扫码推荐人',
  `referrer_phone_number` varchar(20) DEFAULT NULL COMMENT '推荐人手机号',
  `if_referrer_employee` varchar(20) DEFAULT NULL COMMENT '推荐人是否员工',
  `rebate_expiration_date` varchar(20) DEFAULT NULL COMMENT '返利失效日期',
  `if_report_or_allot` int(4) DEFAULT '0' COMMENT '是否上报/分配（0未操作，1已操作）',
  `report_or_allot` varchar(20) DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` varchar(20) DEFAULT NULL COMMENT '上报/分配时间',
  `user_identify` varchar(20) DEFAULT NULL COMMENT '客户标识',
  `investment_adviser` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `if_performance_pool` int(4) DEFAULT NULL COMMENT '是否业绩池（0：不计入，1：计入）',
  `if_delete` int(4) DEFAULT '0' COMMENT '是否删除，0代表未删除，1代表删除',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `IDX_EXCEL_ID` (`excel_id`) USING BTREE,
  KEY `IDX_PHONE_NUMBER` (`phone_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of test_user_info
-- ----------------------------
INSERT INTO `test_user_info` VALUES ('1', '1', '13802108888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:34', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:35');
INSERT INTO `test_user_info` VALUES ('2', '1', '13802108889', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:35', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:35');
INSERT INTO `test_user_info` VALUES ('3', '1', '13802108890', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:35', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:36');
INSERT INTO `test_user_info` VALUES ('4', '1', '13802108891', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:35', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:36');
INSERT INTO `test_user_info` VALUES ('5', '1', '13802108892', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:36', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:36');
INSERT INTO `test_user_info` VALUES ('6', '1', '13802108893', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:36', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:37');
INSERT INTO `test_user_info` VALUES ('7', '1', '13802108894', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:37', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:37');
INSERT INTO `test_user_info` VALUES ('8', '1', '13802108895', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:37', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:38');
INSERT INTO `test_user_info` VALUES ('9', '1', '13802108896', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:38', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:38');
INSERT INTO `test_user_info` VALUES ('10', '1', '13802108897', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:38', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:38');
INSERT INTO `test_user_info` VALUES ('11', '1', '13802108898', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:38', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:39');
INSERT INTO `test_user_info` VALUES ('12', '1', '13802108899', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:39', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:39');
INSERT INTO `test_user_info` VALUES ('13', '1', '13802108900', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:40', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:40');
INSERT INTO `test_user_info` VALUES ('14', '1', '13802108901', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 10:50:40', 'DKH000', '何朵', null, '0', null, '2016-11-03 10:50:40');
INSERT INTO `test_user_info` VALUES ('15', '2', '13502100210', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:09', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:10');
INSERT INTO `test_user_info` VALUES ('16', '2', '13502100211', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:10', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:10');
INSERT INTO `test_user_info` VALUES ('17', '2', '13502100212', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:10', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:10');
INSERT INTO `test_user_info` VALUES ('18', '2', '13502100213', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:10', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:11');
INSERT INTO `test_user_info` VALUES ('19', '2', '13502100214', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:11', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:11');
INSERT INTO `test_user_info` VALUES ('20', '2', '13502100215', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:11', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:12');
INSERT INTO `test_user_info` VALUES ('21', '2', '13502100216', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:12', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:12');
INSERT INTO `test_user_info` VALUES ('22', '2', '13502100217', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:12', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:12');
INSERT INTO `test_user_info` VALUES ('23', '2', '13502100218', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:12', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:13');
INSERT INTO `test_user_info` VALUES ('24', '2', '13502100219', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:13', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:13');
INSERT INTO `test_user_info` VALUES ('25', '2', '13502100220', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:13', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:14');
INSERT INTO `test_user_info` VALUES ('26', '2', '13502100221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:14', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:14');
INSERT INTO `test_user_info` VALUES ('27', '2', '13502100222', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:14', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:15');
INSERT INTO `test_user_info` VALUES ('28', '2', '13502100223', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:02:14', 'DKH000', '何朵', null, '0', null, '2016-11-03 11:02:15');
INSERT INTO `test_user_info` VALUES ('29', '3', '15802100000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:15', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:15');
INSERT INTO `test_user_info` VALUES ('30', '3', '15802100001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:15', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:16');
INSERT INTO `test_user_info` VALUES ('31', '3', '15802100002', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:16', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:16');
INSERT INTO `test_user_info` VALUES ('32', '3', '15802100003', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:16', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:17');
INSERT INTO `test_user_info` VALUES ('33', '3', '15802100004', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:16', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:17');
INSERT INTO `test_user_info` VALUES ('34', '3', '15802100005', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:17', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:17');
INSERT INTO `test_user_info` VALUES ('35', '3', '15802100006', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:17', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:18');
INSERT INTO `test_user_info` VALUES ('36', '3', '15802100007', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:18', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:18');
INSERT INTO `test_user_info` VALUES ('37', '3', '15802100008', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:18', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:19');
INSERT INTO `test_user_info` VALUES ('38', '3', '15802100009', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:19', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:19');
INSERT INTO `test_user_info` VALUES ('39', '3', '15802100010', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:19', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:19');
INSERT INTO `test_user_info` VALUES ('40', '3', '15802100011', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:19', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:20');
INSERT INTO `test_user_info` VALUES ('41', '3', '15802100012', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:20', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:20');
INSERT INTO `test_user_info` VALUES ('42', '3', '15802100013', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '上报', '2016-11-03 11:11:20', 'DKH000', '张辉胜', null, '0', null, '2016-11-03 11:11:21');
