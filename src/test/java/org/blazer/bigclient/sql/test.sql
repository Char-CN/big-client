SELECT a.*,b.*,c.actual_name
FROM
  (SELECT a.user_id,a.version_no,a.advisor_id FROM cl_formal_user_version a
    JOIN (SELECT user_id,max(version_no) AS max_version_no FROM cl_formal_user_version GROUP BY user_id) b
      ON a.user_id = b.user_id
         AND a.version_no = b.max_version_no) a
  LEFT OUTER JOIN cl_formal_user b ON a.user_id = b.id
  LEFT OUTER JOIN kam_advisor c ON a.advisor_id = c.id



##外部拓展客户##
DROP TABLE  IF EXISTS `cl_ext_user`;
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
)
  ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  ROW_FORMAT=DYNAMIC
  COMMENT='外部拓展客户'
;

##平台待分配客户 Platform allocation##
DROP TABLE  IF EXISTS `cl_allot_user`;
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
)
  ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  ROW_FORMAT=DYNAMIC
  COMMENT='平台待分配客户'
;


##正式客户名单 Formal customer list##
DROP TABLE  IF EXISTS `cl_formal_user`;
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
)
  ENGINE=InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  ROW_FORMAT=DYNAMIC
  COMMENT='正式客户名单'
;



CREATE TABLE `kam_user_info` (
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






















###################################################################################################################

DROP TABLE  IF EXISTS `kam_formal_user_version`;
CREATE TABLE `kam_formal_user_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `adviser_id` bigint(20) DEFAULT NULL COMMENT '投资顾问id',
  `formal_user_id` bigint(20) DEFAULT NULL COMMENT '正式客户id',
  `version` bigint(20) DEFAULT '1' COMMENT '版本号，默认是1，依次递增',
  `start_date` datetime DEFAULT NULL COMMENT '分配起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '分配结束日期，为NULL值表示没有结束日期',
  `mtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARSET=utf8
  COMMENT='正式名单的版本表，该表关联bc_formal_user和bc_adviser\r\n将投资顾问和正式名单关联起来。'
;


DROP TABLE  IF EXISTS `kam_user_to_advisor`;
CREATE TABLE `kam_user_to_advisor` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,
  `user_id`  bigint(20) DEFAULT NULL COMMENT '客户ID' ,
  `advisor_id`  bigint(20) DEFAULT NULL COMMENT '投顾ID' ,
  `version_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号:默认是1，依次递增' ,
  `start_date` datetime DEFAULT NULL COMMENT '分配起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '分配结束日期，为NULL值表示没有结束日期',
  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1
  ROW_FORMAT=DYNAMIC
  COMMENT='正式名单的版本表，该表关联user和adviser,记录客户和投顾的对应关系。'
;

##管理员
DROP TABLE  IF EXISTS `kam_admin`;
CREATE TABLE `kam_admin` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,
  `system_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统登录用户名' ,
  `actual_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名' ,
  `phone_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码' ,

  `remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息' ,
  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1
  ROW_FORMAT=DYNAMIC
  COMMENT='大客户系统管理员'
;


##投资顾问团队
DROP TABLE  IF EXISTS `kam_advisor_team`;
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
)
  ENGINE=InnoDB
  AUTO_INCREMENT=100
  DEFAULT CHARSET=utf8
  ROW_FORMAT=DYNAMIC
  COMMENT='投资顾问团队'
;



---统计报表 statistical report

#资产余额		assets balance
DROP TABLE IF EXISTS `sr_assets_balance`;
CREATE TABLE `sr_assets_balance` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,
  `user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
  `phone_number`  bigint(20) NOT NULL COMMENT '手机号码' ,
  `investment_adviser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问' ,
  `register_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册日期' ,
  `regular_assets_total`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前定期AUM（资产总额）' ,
  `regular_aum_time_point`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前定期AUM时间点' ,
  `current_assets_total`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前活期AUM（资产总额）' ,
  `current_aum_time_point`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前活期AUM时间点' ,
  `aum_total`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前AUM汇总（单位：元）' ,

  -- `version_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号',

  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=101
  ROW_FORMAT=DYNAMIC
  COMMENT='[统计报表]--[资产余额]--assets balance'
;



#定期销售明细	regular sales details
DROP TABLE IF EXISTS `sr_regular_sales_details`;
CREATE TABLE `sr_regular_sales_details` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,

  `user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
  `phone_number`  bigint(20) NOT NULL COMMENT '手机号码' ,
  `referrer`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扫码推荐人' ,
  `rebate_expiration_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利失效日期' ,
  `report_or_allot`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配' ,
  `report_or_allot_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配时间' ,
  `investment_adviser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问' ,
  `user_identify`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识' ,

  `basic_product_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础产品名称（定期）' ,
  `investment_amount`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资金额' ,
  `regular_assets_total`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现有资产---当前定期AUM（资产总额）' ,
  `investment_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买时间 0000-00-00 00:00:00' ,

  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=102
  ROW_FORMAT=DYNAMIC
  COMMENT='[统计报表]--[定期销售明细]--regular sales details'
;


#活期销售明细	current sales details
DROP TABLE IF EXISTS `sr_regular_sales_details`;
CREATE TABLE `sr_current_sales_details` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,

  `user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
  `phone_number`  bigint(20) NOT NULL COMMENT '手机号码' ,
  `report_or_allot`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配' ,
  `report_or_allot_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配时间' ,
  `investment_adviser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问' ,
  `user_identify`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识' ,

  `base_product_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础产品名称（活期）' ,
  `purchase_amount`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购金额' ,
  `current_assets_total`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现有资产---当前活期AUM（资产总额）' ,
  `purchase_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购时间 0000-00-00 00:00:00' ,

  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=103
  ROW_FORMAT=DYNAMIC
  COMMENT='[统计报表]--[活期销售明细]--current sales details'
;




--业绩核算		performance accounting


#定期销售规模核算	regular sales scale accounting
DROP TABLE IF EXISTS `sr_regular_sales_details`;
CREATE TABLE `pa_regular_sales_scale_accounting` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,

  `user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
  `phone_number`  bigint(20) NOT NULL COMMENT '手机号码' ,
  `referrer`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扫码推荐人' ,
  `rebate_expiration_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利失效日期' ,
  `report_or_allot`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配' ,
  `report_or_allot_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配时间' ,
  `investment_adviser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问' ,
  `user_identify`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识' ,

  `basic_product_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础产品名称（定期）' ,
  `investment_amount`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资金额' ,
  `regular_assets_total`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现有资产---当前定期AUM（资产总额）' ,
  `investment_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买时间 0000-00-00 00:00:00' ,

  `partition_coefficient`  int(4) NULL DEFAULT 0 COMMENT '分配系数' ,
  `performance_pool_coefficient`  int(4) NULL DEFAULT 0 COMMENT '业绩池系数' ,
  `product_coefficient`  int(4) NULL DEFAULT 0 COMMENT '产品系数' ,
  `effective_sales_amount`  double(20,2) NULL DEFAULT 0.00 COMMENT '有效销售金额（单位：元）' ,

  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=104
  ROW_FORMAT=DYNAMIC
  COMMENT='[业绩核算]--[定期销售规模核算]--regular sales scale accounting'
;



#活期销售规模核算	current sales scale accounting
DROP TABLE IF EXISTS `sr_regular_sales_details`;
CREATE TABLE `pa_current_sales_scale_accounting` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,

  `investment_adviser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问' ,

  `monthly_purchase_amount`  double(20,2) NULL DEFAULT 0.00 COMMENT '当月申购金额（万元）' ,
  `monthly_purchase_amount_10`  double(20,2) NULL DEFAULT 0.00 COMMENT '当月申购金额/10（千元）' ,
  `monthly_investment_target`  double(20,2) NULL DEFAULT 0.00 COMMENT '月投资规模目标（万元）' ,
  `monthly_performance_limit`  double(20,2) NULL DEFAULT 0.00 COMMENT '当月活期业绩上限（万元）' ,
  `effective_current_sales_scale`  double(20,2) NULL DEFAULT 0.00 COMMENT '有效活期销售规模（万元）' ,
  `deferred_next_month`  double(20,2) NULL DEFAULT 0.00 COMMENT '递延下月（万元）' ,

  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=105
  ROW_FORMAT=DYNAMIC
  COMMENT='[业绩核算]--[活期销售规模核算]--current sales scale accounting'
;


#获客数核算			customers accounting
DROP TABLE IF EXISTS `sr_regular_sales_details`;
CREATE TABLE `pa_customers_accounting` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,

  `user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
  `phone_number`  bigint(20) NOT NULL COMMENT '手机号码' ,
  `register_date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册日期' ,
  `investment_adviser`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问' ,
  `user_identify`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识' ,
  `if_performance_pool` int(4) DEFAULT NULL COMMENT '是否业绩池（0：不计入，1：计入）',

  `ending_balance`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期末AUM（资产总额 as a）' ,
  `ending_not_less_than_fifty`  int(4) NULL DEFAULT 0 COMMENT '期末不小于50万（0：不符合条件，1：符合条件）' ,
  `buy_amount`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资总额（当月定期投资+活期申购  as b）' ,
  `beginning_balance`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期初AUM（= a - b） as c' ,
  `beginning_no_greater_than_fifty`  int(4) NULL DEFAULT 0 COMMENT '期初不大于50万（0：不符合条件，1：符合条件）' ,
  `matching_period_initial_value`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '匹配期初值（上月期初值  as d）' ,
  `beginning_comparison`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期初对比(c = d ? TRUE or FALSE)' ,
  `difference`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差异(c - d 有可能负数)' ,
  `redemption_order`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兑付单（关联定期兑付报表）' ,
  `revise`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修正（TRUE or FALSE）' ,
  `error_query`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差错查询（预留字段）' ,

  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=106
  ROW_FORMAT=DYNAMIC
  COMMENT='[业绩核算]--[获客数核算]--customers accounting'
;






--业绩报表		performance report


#业绩报表		performance report
DROP TABLE IF EXISTS `pr_performance_report`;
CREATE TABLE `pr_performance_report` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `advisor_level` VARCHAR (10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投顾级别',
  `investment_advisor` VARCHAR (10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投顾姓名',
  `current_vip_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前vip客户数（人数）',
  `performance_customers_AUM` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计入业绩客户AUM值(亿元)',
  `performance_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计入业绩客户数(人数)',
  `reported_customers_registered_growth_rate` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报客户数注册增长率',
  `reported_customers_transactions_growth_rate` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报客户交易数增长率',
  `last_month_sales_scale` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上月销售规模(万元)',
  `monthly_sales_scale` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月销售规模(万元)',
  `monthly_sales_scale_performance_targets` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月销售规模业绩目标(万元)',
  `sales_completion_rate` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 销售规模完成率',
  `monthly_number_of_get_customers` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月获客数(折算)',
  `monthly_acquisition_target` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月度获客目标(折算)',
  `get_customers_completion_rate` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获客完成率',
  `comprehensive_completion_rate` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '综合完成率',
  `comprehensive_completion_rate_ranking` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '综合完成率排名',
  `team_comprehensive_completion_rate` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资组综合完成率 ',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 1 ROW_FORMAT = DYNAMIC COMMENT = '[业绩报表]--[业绩报表]--performance report';

#获客构成		constitute customer
DROP TABLE IF EXISTS `pr_constitute_customer`;
CREATE TABLE `pr_constitute_customer` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `performance_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计入业绩客户数',
  `pure_new_vip_customers` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纯新增vip客户数',
  /*`increase_vip_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提升vip客户数',*/
  `reported_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报客户数',
  `allot_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分配客户数',
  `weekly_get_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本周获客数',
  `current_vip_customers_number` VARCHAR (20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前vip客户数',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 1 ROW_FORMAT = DYNAMIC COMMENT = '[业绩报表]--[获客构成]--constitute customer';


#客户转换率		customer conversion rate
DROP TABLE IF EXISTS `pr_customer_conversion_rate`;
CREATE TABLE `pr_customer_conversion_rate` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `last_period_customers_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上期客户数',
  `current_period_customers_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本期客户数',
  `last_period_registered_customers_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上期注册客户数',
  `current_period_registered_customers_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本期注册客户数',
  `last_period_transaction_customers_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上期客户交易数',
  `current_period_transaction_customers_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本期客户交易数',
  `current_period_registered_customers_proportion` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本期注册客户占比',
  `customer_registration_growth_rate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户注册增长率',
  `current_period_transactions_customers_proportion` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本期交易客户占比',
  `customer_transaction_conversion_rate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户交易转换率',
  `current_period_customers_aum_growth_rate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本期客户AUM增长率(期末基准)',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 1 ROW_FORMAT = DYNAMIC COMMENT = '[业绩报表]--[客户转换率]--customer conversion rate';




#定期兑付报表	regular payment
DROP TABLE IF EXISTS `pr_regular_payment`;
CREATE TABLE `pr_regular_payment` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `product_name` varchar(20) DEFAULT NULL COMMENT '产品名称',
  `product_period` varchar(20) DEFAULT NULL COMMENT '产品期限',
  `year_days` varchar(20) DEFAULT NULL COMMENT '年天数',
  `principal` varchar(20) DEFAULT NULL COMMENT '本金',
  `product_revenue` varchar(20) DEFAULT NULL COMMENT '产品收益',
  `investment_advisor` varchar(20) DEFAULT NULL COMMENT '投资顾问',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 1 ROW_FORMAT = DYNAMIC COMMENT = '[业绩报表]--[定期兑付报表]--regular payment';



/*
user_name	用户姓名
phone_number 手机号码
product_name 产品名称
product_period 产品期限
year_days 年天数
principal 本金
product_revenue产品收益
investment_advisor 投资顾问

 */

















INSERT INTO `big_client`.`kam_advisor` (
  `serial_number`,
  `level`,
  `system_name`,
  `actual_name`,
  `phone_number`,
  `remark`
)
VALUES
  (
    "IC0001",
    ""高级投资顾问-高2"",
    ""zhanghuisheng"",
    ""张辉胜"",
    ""15021435920"",
    ""zhanghuisheng@evergrande.com""
  );









#资产余额		assets balance
DROP TABLE
IF EXISTS `sr_assets_balance`;

CREATE TABLE `sr_assets_balance` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `phone_number` BIGINT (20) NOT NULL COMMENT '手机号码',
  `investment_adviser` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问',
  `register_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册日期',
  `regular_assets_total` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前定期AUM（资产总额）',
  `regular_aum_time_point` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前定期AUM时间点',
  `current_assets_total` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前活期AUM（资产总额）',
  `current_aum_time_point` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前活期AUM时间点',
  `aum_total` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前AUM汇总（单位：元）',
  -- `version_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 101 ROW_FORMAT = DYNAMIC COMMENT = '[统计报表]--[资产余额]--assets balance';

#定期销售明细	regular sales details
DROP TABLE
IF EXISTS `sr_regular_sales_details`;

CREATE TABLE `sr_regular_sales_details` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `phone_number` BIGINT (20) NOT NULL COMMENT '手机号码',
  `referrer` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扫码推荐人',
  `rebate_expiration_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利失效日期',
  `report_or_allot` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配时间',
  `investment_adviser` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问',
  `user_identify` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识',
  `basic_product_name` VARCHAR (50) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础产品名称（定期）',
  `investment_amount` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资金额',
  `regular_assets_total` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现有资产---当前定期AUM（资产总额）',
  `investment_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买时间 0000-00-00 00:00:00',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 102 ROW_FORMAT = DYNAMIC COMMENT = '[统计报表]--[定期销售明细]--regular sales details';

#活期销售明细	current sales details
DROP TABLE
IF EXISTS `sr_current_sales_details`;

CREATE TABLE `sr_current_sales_details` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `phone_number` BIGINT (20) NOT NULL COMMENT '手机号码',
  `report_or_allot` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配时间',
  `investment_adviser` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问',
  `user_identify` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识',
  `base_product_name` VARCHAR (50) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础产品名称（活期）',
  `purchase_amount` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购金额',
  `current_assets_total` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现有资产---当前活期AUM（资产总额）',
  `purchase_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购时间 0000-00-00 00:00:00',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 103 ROW_FORMAT = DYNAMIC COMMENT = '[统计报表]--[活期销售明细]--current sales details';

#定期销售规模核算	regular sales scale accounting
DROP TABLE
IF EXISTS `pa_regular_sales_scale_accounting`;

CREATE TABLE `pa_regular_sales_scale_accounting` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `phone_number` BIGINT (20) NOT NULL COMMENT '手机号码',
  `referrer` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '扫码推荐人',
  `rebate_expiration_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利失效日期',
  `report_or_allot` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配',
  `report_or_allot_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报/分配时间',
  `investment_adviser` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问',
  `user_identify` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识',
  `basic_product_name` VARCHAR (50) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基础产品名称（定期）',
  `investment_amount` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资金额',
  `regular_assets_total` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现有资产---当前定期AUM（资产总额）',
  `investment_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买时间 0000-00-00 00:00:00',
  `partition_coefficient` INT (4) NULL DEFAULT 0 COMMENT '分配系数',
  `performance_pool_coefficient` INT (4) NULL DEFAULT 0 COMMENT '业绩池系数',
  `product_coefficient` INT (4) NULL DEFAULT 0 COMMENT '产品系数',
  `effective_sales_amount` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '有效销售金额（单位：元）',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 104 ROW_FORMAT = DYNAMIC COMMENT = '[业绩核算]--[定期销售规模核算]--regular sales scale accounting';

#活期销售规模核算	current sales scale accounting
DROP TABLE
IF EXISTS `pa_current_sales_scale_accounting`;

CREATE TABLE `pa_current_sales_scale_accounting` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `investment_adviser` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问',
  `monthly_purchase_amount` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '当月申购金额（万元）',
  `monthly_purchase_amount_10` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '当月申购金额/10（千元）',
  `monthly_investment_target` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '月投资规模目标（万元）',
  `monthly_performance_limit` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '当月活期业绩上限（万元）',
  `effective_current_sales_scale` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '有效活期销售规模（万元）',
  `deferred_next_month` DOUBLE (20, 2) NULL DEFAULT 0.00 COMMENT '递延下月（万元）',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 105 ROW_FORMAT = DYNAMIC COMMENT = '[业绩核算]--[活期销售规模核算]--current sales scale accounting';

#获客数核算			customers accounting
DROP TABLE
IF EXISTS `pa_customers_accounting`;

CREATE TABLE `pa_customers_accounting` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `user_name` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `phone_number` BIGINT (20) NOT NULL COMMENT '手机号码',
  `register_date` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册日期',
  `investment_adviser` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资顾问',
  `user_identify` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户标识',
  `if_performance_pool` INT (4) DEFAULT NULL COMMENT '是否业绩池（0：不计入，1：计入）',
  `ending_balance` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期末AUM（资产总额 as a）',
  `ending_not_less_than_fifty` INT (4) NULL DEFAULT 0 COMMENT '期末不小于50万（0：不符合条件，1：符合条件）',
  `buy_amount` VARCHAR (100) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资总额（当月定期投资+活期申购  as b）',
  `beginning_balance` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期初AUM（= a - b） as c',
  `beginning_no_greater_than_fifty` INT (4) NULL DEFAULT 0 COMMENT '期初不大于50万（0：不符合条件，1：符合条件）',
  `matching_period_initial_value` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '匹配期初值（上月期初值  as d）',
  `beginning_comparison` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期初对比(c = d ? TRUE or FALSE)',
  `difference` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差异(c - d 有可能负数)',
  `redemption_order` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兑付单（关联定期兑付报表）',
  `revise` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修正（TRUE or FALSE）',
  `error_query` VARCHAR (20) CHARACTER
  SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差错查询（预留字段）',
  `mtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ctime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8 COLLATE = utf8_general_ci AUTO_INCREMENT = 106 ROW_FORMAT = DYNAMIC COMMENT = '[业绩核算]--[获客数核算]--customers accounting';








INSERT INTO `big_client`.`cl_allot_user` (`id`, `phone_number`, `user_name`, `register_date`, `id_card`, `if_employee`, `assets_amount`, `sex`, `age`, `birthday`, `referrer`, `referrer_phone_number`, `if_referrer_employee`, `investment_adviser`, `user_identify`, `if_delete`, `mtime`, `ctime`) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

