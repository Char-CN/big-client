
###业绩报表		performance report


#业绩报表		performance report
DROP TABLE IF EXISTS `pr_performance_report`;
CREATE TABLE `pr_performance_report` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动编号' ,
  `level`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投顾级别' ,
  `serial_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投顾编号' ,
  `system_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统登录用户名' ,
  `actual_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投顾姓名' ,
  `phone_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投顾手机号码' ,
  `remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息' ,
  `mtime`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `ctime`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=2
  ROW_FORMAT=DYNAMIC
  COMMENT='[统计报表]--[资产余额]--assets balance'
;



#获客构成		constitute customer
DROP TABLE IF EXISTS `sr_regular_sales_details`;
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


#客户转换率		customer conversion rate
DROP TABLE IF EXISTS `sr_regular_sales_details`;




#定期兑付报表	regular payment
DROP TABLE IF EXISTS `sr_regular_sales_details`;
