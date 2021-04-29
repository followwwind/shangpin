/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 30/04/2021 07:46:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_company
-- ----------------------------
DROP TABLE IF EXISTS `apply_company`;
CREATE TABLE `apply_company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_batch_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验申请批次号',
  `apply_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验申请编号，全局唯一',
  `company_id` int(11) NOT NULL COMMENT '公司id',
  `status` int(11) NULL DEFAULT NULL COMMENT '申请状态，1:成功 2:失败 3:申请中',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply_company
-- ----------------------------

-- ----------------------------
-- Table structure for apply_person
-- ----------------------------
DROP TABLE IF EXISTS `apply_person`;
CREATE TABLE `apply_person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_batch_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验申请批次号',
  `apply_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验申请编号，全局唯一',
  `person_id` int(11) NOT NULL COMMENT '个人id',
  `status` int(11) NULL DEFAULT NULL COMMENT '申请状态，1:成功 2:失败 3:申请中',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply_person
-- ----------------------------

-- ----------------------------
-- Table structure for business_result
-- ----------------------------
DROP TABLE IF EXISTS `business_result`;
CREATE TABLE `business_result`  (
  `id` bigint(20) NOT NULL,
  `actual_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `actual_capital_currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `approved_time` bigint(20) NOT NULL,
  `base` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bond_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bond_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bond_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cancel_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cancel_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_org_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `estiblish_time` bigint(20) NOT NULL,
  `from_time` bigint(20) NOT NULL,
  `history_name_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `history_names` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_micro_ent` int(11) NOT NULL,
  `legal_person_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `org_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `percentile_score` int(11) NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `property3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_capital_currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_institute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reg_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `revoke_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `revoke_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `social_staff_num` int(11) NOT NULL,
  `staff_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_num_range` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tax_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_time` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `used_bond_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `website_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of business_result
-- ----------------------------

-- ----------------------------
-- Table structure for check_record
-- ----------------------------
DROP TABLE IF EXISTS `check_record`;
CREATE TABLE `check_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业名',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `type` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型个人或企业',
  `credit_score` decimal(5, 2) NULL DEFAULT NULL COMMENT '信用分',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `history` int(11) NULL DEFAULT NULL COMMENT '历史记录',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业code',
  `folk` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '法人',
  `account_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '查验记录表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of check_record
-- ----------------------------
INSERT INTO `check_record` VALUES (5, '厦门铸远集团有限公司', 'admin', '企业', NULL, '2021-04-04 12:38:36', 3, '350206200473664', '蔡丽煌', NULL);
INSERT INTO `check_record` VALUES (6, '浙江节点猫科技有限公司', '1', '企业', NULL, '2021-04-19 00:00:00', 36, '330108000247333', '毛浮沉', NULL);
INSERT INTO `check_record` VALUES (7, '广东高云半导体科技股份有限公司', '2', '企业', NULL, '2021-04-04 20:24:28', 38, '440101000580749', '陈同兴', NULL);
INSERT INTO `check_record` VALUES (8, '北京城建集团有限责任公司', '2', '企业', NULL, '2021-04-04 20:34:10', 1, '110000005019473', '陈代华', NULL);
INSERT INTO `check_record` VALUES (9, '广州农村商业银行股份有限公司', '2', '企业', NULL, '2021-04-06 00:00:00', 5, '914401017083429628', '王继康', NULL);
INSERT INTO `check_record` VALUES (12, '字节跳动有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 9, '91110105MA005AEF36', '张利东', NULL);
INSERT INTO `check_record` VALUES (23, '陕西隆基建设集团有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 5, '610000100457811', '李瑞斌', NULL);
INSERT INTO `check_record` VALUES (24, '范伟', '1', '个人', NULL, '2021-04-06 00:00:00', 3, '622424199706233430', '18409480917', '6217004270013963870');
INSERT INTO `check_record` VALUES (25, '上海乂丫网络科技集团有限公司', '3', '企业', NULL, '2021-04-06 00:00:00', 2, '91310113MA1GNK8554', '班晓玲', NULL);
INSERT INTO `check_record` VALUES (26, '福建领航国际物流有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 1, '91350102574710896H', '阮金桃', NULL);
INSERT INTO `check_record` VALUES (27, '南京欢创文化传媒有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 1, '91320113MA1YTK2722', '方欢', NULL);
INSERT INTO `check_record` VALUES (28, '陕西延长石油（集团）有限责任公司', '1', '企业', NULL, '2021-04-06 00:00:00', 3, '91610000220568570K', '兰建文', NULL);
INSERT INTO `check_record` VALUES (29, '陕西延长石油清洁新能源有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 1, '91610133MAB0MR350K', '封华', NULL);
INSERT INTO `check_record` VALUES (30, '西北化工研究院有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 1, '916100007197430329', '张勇', NULL);
INSERT INTO `check_record` VALUES (31, '陕西延长泾渭新材料科技产业园有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 1, '91610132MA6UQ8TY1P', '何长明', NULL);
INSERT INTO `check_record` VALUES (36, '昆山杰得微电子有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 2, '91320583554697401E', '欧阳合', NULL);
INSERT INTO `check_record` VALUES (37, '江苏云联科技有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 2, '91320583552494643W', 'JEFFREY C ZHU', NULL);
INSERT INTO `check_record` VALUES (38, '苏州鑫宇环检测检验有限公司', '1', '企业', NULL, '2021-04-06 00:00:00', 3, '91320506339207713A', '姚颖方', NULL);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易主体账号',
  `cert_4SUCC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社会统一信用代码',
  `legal_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法定代表人',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记状态，需要列举一下登记状态的所有值及每个值对应的状态码',
  `founding_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成立日期，\r\n格式：yyyyMMdd',
  `registered_capital` int(11) NULL DEFAULT NULL COMMENT '注册资本（单位：万元）',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属行业',
  `period` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业期限',
  `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营范围',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营地址',
  `change_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息变更时间\r\n格式：yyyyMMddHHmmss',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置编号',
  `platform_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易平台编号',
  `checkType` int(10) NULL DEFAULT NULL COMMENT '查验类型 1-个人 2-企业',
  `applyTime` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生效时间，\r\n格式：yyyyMMddHHmmss',
  `pass_line` decimal(10, 2) NULL DEFAULT NULL COMMENT '合格分数线',
  `good_line` decimal(10, 2) NULL DEFAULT NULL COMMENT '良好分数线',
  `excellent_line` decimal(10, 2) NULL DEFAULT NULL COMMENT '优秀分数线',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------

-- ----------------------------
-- Table structure for config_check_item
-- ----------------------------
DROP TABLE IF EXISTS `config_check_item`;
CREATE TABLE `config_check_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_id` int(11) NOT NULL COMMENT '配置id',
  `item_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查项编号',
  `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查项名称',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查项描述',
  `value_type` int(11) NULL DEFAULT NULL COMMENT '检查项值类型\r\n1-数值 2-布尔 3-枚举',
  `allow_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '允许值\r\nvalueType为1时，该项的格式为 最小值;最大值 ',
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '权值系数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_check_item
-- ----------------------------

-- ----------------------------
-- Table structure for config_group_item
-- ----------------------------
DROP TABLE IF EXISTS `config_group_item`;
CREATE TABLE `config_group_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_id` int(11) NOT NULL COMMENT '配置id',
  `group_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `passLine` decimal(10, 2) NULL DEFAULT NULL COMMENT '及格分数线',
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '分组权重',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_group_item
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise_report
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_report`;
CREATE TABLE `enterprise_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enRule` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业规则项',
  `enInfor` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业信息项',
  `user_email` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '归属用户',
  `check_id` int(11) NULL DEFAULT NULL COMMENT '归属检验报告id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `check_id`(`check_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业和个人规则信息项' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of enterprise_report
-- ----------------------------
INSERT INTO `enterprise_report` VALUES (6, '[{\"content\":\"山西阳泉\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"公司所在省市区\"},{\"content\":\"100-200万\",\"dis\":false,\"rate\":\"\",\"selected\":true,\"text\":\"注册资本\"},{\"content\":\"建筑业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"行业分类\"},{\"content\":\"是\",\"dis\":false,\"rate\":\"\",\"selected\":true,\"text\":\"是否微小企业\"},{\"content\":\"企业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"法人类型\"}]', '[{\"selected\":true,\"text\":\"负债与资产总额\"},{\"selected\":true,\"text\":\"人员规模\"},{\"selected\":true,\"text\":\"成立日期\"},{\"selected\":true,\"text\":\"邮箱\"},{\"selected\":true,\"text\":\"主要人员列表\"},{\"selected\":true,\"text\":\"风险评级\"},{\"selected\":true,\"text\":\"企业信用评级\"}]', 'admin', 6);
INSERT INTO `enterprise_report` VALUES (13, '[{\"content\":\"广东广州黄埔区\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"公司所在省市区\"}]', '[{\"selected\":true,\"text\":\"负债与资产总额\"},{\"selected\":true,\"text\":\"历史法律诉讼\"},{\"selected\":true,\"text\":\"失信人(数目)\"},{\"selected\":true,\"text\":\"历史行政处罚(数目)\"},{\"selected\":true,\"text\":\"人员规模\"},{\"selected\":true,\"text\":\"经营开始时间-经营结束时间\"},{\"selected\":true,\"text\":\"成立日期\"},{\"selected\":true,\"text\":\"联系方式\"},{\"selected\":true,\"text\":\"邮箱\"},{\"selected\":true,\"text\":\"网址\"},{\"selected\":true,\"text\":\"吊销日期\"},{\"selected\":true,\"text\":\"吊销原因\"},{\"selected\":true,\"text\":\"注销日期\"},{\"selected\":true,\"text\":\"注销原因\"},{\"selected\":true,\"text\":\"国民经济行业分类(门类、大类、中类、小类)\"},{\"selected\":true,\"text\":\"主要人员列表\"},{\"selected\":true,\"text\":\"税务评级\"},{\"selected\":true,\"text\":\"进出口信用评级\"},{\"selected\":true,\"text\":\"风险评级\"},{\"selected\":true,\"text\":\"企业信用评级\"}]', '1', 7);
INSERT INTO `enterprise_report` VALUES (21, '[{\"content\":\"广东广州增城市\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"公司所在省市区\"},{\"content\":\"200万-500万\",\"dis\":false,\"rate\":\"\",\"selected\":true,\"text\":\"注册资本\"},{\"content\":\"仓储和邮政业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"行业分类\"},{\"content\":\"在业\",\"dis\":false,\"rate\":\"\",\"selected\":true,\"text\":\"企业状态\"}]', '[{\"selected\":true,\"text\":\"负债与资产总额\"},{\"selected\":true,\"text\":\"历史法律诉讼\"},{\"selected\":true,\"text\":\"经营开始时间-经营结束时间\"},{\"selected\":true,\"text\":\"成立日期\"},{\"selected\":true,\"text\":\"注销原因\"},{\"selected\":true,\"text\":\"国民经济行业分类(门类、大类、中类、小类)\"},{\"selected\":true,\"text\":\"主要人员列表\"},{\"selected\":true,\"text\":\"税务评级\"},{\"selected\":true,\"text\":\"进出口信用评级\"},{\"selected\":true,\"text\":\"风险评级\"},{\"selected\":true,\"text\":\"企业信用评级\"}]', '2', 9);
INSERT INTO `enterprise_report` VALUES (43, '[{\"content\":\"200万-500万\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"注册资本\"}]', '[{\"selected\":true,\"text\":\"成立日期\"}]', '1', NULL);
INSERT INTO `enterprise_report` VALUES (44, '[{\"content\":\"200万-500万\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"注册资本\"},{\"content\":\"在业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"企业状态\"}]', '[{\"selected\":true,\"text\":\"成立日期\"}]', '1', NULL);
INSERT INTO `enterprise_report` VALUES (47, '[{\"content\":\"股份有限公司\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"企业类型\"}]', '[{\"selected\":true,\"text\":\"负债与资产总额\"}]', '1', 12);
INSERT INTO `enterprise_report` VALUES (48, '[{\"content\":\"A等级\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"纳税人信用级别\"}]', '[{\"selected\":true,\"text\":\"人员规模\"}]', '1', 12);
INSERT INTO `enterprise_report` VALUES (59, '[{\"content\":\"成立1年内\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"成立时间\"}]', '[{\"selected\":true,\"text\":\"人员规模\"}]', '1', 23);
INSERT INTO `enterprise_report` VALUES (79, '[{\"content\":\"1000万以上\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"注册资本\"},{\"content\":\"建筑业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"行业分类\"},{\"content\":\"成立5-10年\",\"dis\":false,\"rate\":\"\",\"selected\":true,\"text\":\"成立时间\"},{\"content\":\"个人\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"法人类型\"}]', '[{\"selected\":true,\"text\":\"主要人员列表\"}]', '1', NULL);
INSERT INTO `enterprise_report` VALUES (80, '[{\"content\":\"1000万以上\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"注册资本\"},{\"content\":\"建筑业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"行业分类\"},{\"content\":\"成立5-10年\",\"dis\":false,\"rate\":\"\",\"selected\":true,\"text\":\"成立时间\"},{\"content\":\"企业\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"法人类型\"}]', '[{\"selected\":true,\"text\":\"主要人员列表\"}]', '1', 38);
INSERT INTO `enterprise_report` VALUES (81, '[{\"content\":\"个人\",\"dis\":true,\"rate\":\"\",\"selected\":true,\"text\":\"法人类型\"}]', '[]', '1', 38);
INSERT INTO `enterprise_report` VALUES (82, '[]', '[]', '1', NULL);
INSERT INTO `enterprise_report` VALUES (83, '[]', '[]', '2', NULL);
INSERT INTO `enterprise_report` VALUES (84, '[]', '[]', '1', NULL);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for individual_report
-- ----------------------------
DROP TABLE IF EXISTS `individual_report`;
CREATE TABLE `individual_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inRule` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人规则项',
  `inInfor` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人信息项',
  `user_email` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '归属用户',
  `check_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of individual_report
-- ----------------------------
INSERT INTO `individual_report` VALUES (5, 'null', '[]', 'admin', NULL);
INSERT INTO `individual_report` VALUES (6, 'null', '[]', 'admin', NULL);
INSERT INTO `individual_report` VALUES (7, 'null', '[]', '1', NULL);
INSERT INTO `individual_report` VALUES (8, 'null', '[]', '2', NULL);
INSERT INTO `individual_report` VALUES (9, 'null', '[]', '1', NULL);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易主体账号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `cert_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记状态，',
  `bank_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for platform_user
-- ----------------------------
DROP TABLE IF EXISTS `platform_user`;
CREATE TABLE `platform_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台名称',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台邮箱',
  `site` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案网址',
  `domainName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案域名',
  `recordNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案号',
  `businessScope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营范围',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册密码',
  `lockedState` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '锁定状态0锁定(待审核) 1未锁定(同意) 2拒绝',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of platform_user
-- ----------------------------
INSERT INTO `platform_user` VALUES (1, 'admin', 'admin', '186132151', '测试数据1', 'www.baidu.co', '开发', 'adminadmin', '1');
INSERT INTO `platform_user` VALUES (2, 'alibaba', '123456@qq.com', 'slfiojlk', 'alibaba', '002', '电子商务', 'xxx', '0');
INSERT INTO `platform_user` VALUES (3, 'tecent', '9897656@qq.com', 'wefds', 'tecent', '003', 'application', 'xxxxx', '0');
INSERT INTO `platform_user` VALUES (4, '测试平台名', '1603329984@qq.com', 'www.baidu.com', NULL, NULL, NULL, '123321', '2');
INSERT INTO `platform_user` VALUES (5, '测试平台名', '160332998@qq.com', 'www.baidu.com', 'www.baidu.com', '1232131', '经济', '123123', '0');
INSERT INTO `platform_user` VALUES (6, '我我我1啊啊', '15153115@qq0com', '14561sda31a', '15d3s1da5', '325312351869', '不知道', '123456', '1');
INSERT INTO `platform_user` VALUES (7, '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `platform_user` VALUES (8, '2', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO `platform_user` VALUES (9, '3', '3', '3', '3', '3', '3', '3', '1');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验申请编号',
  `check_report_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验报告编号',
  `credit_composite_score` decimal(10, 2) NULL DEFAULT NULL COMMENT '信用综合评分',
  `credit_composite_level` int(11) NULL DEFAULT NULL COMMENT '综合评分等级 \r\n0 不合格\r\n1 合格\r\n2 良好\r\n3 优秀',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for report_detail
-- ----------------------------
DROP TABLE IF EXISTS `report_detail`;
CREATE TABLE `report_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_id` int(11) NULL DEFAULT NULL COMMENT '报告id',
  `check_item_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查验项目编号',
  `check_type` int(11) NULL DEFAULT NULL COMMENT '查验类型 \r\n1-准入配置查验 \r\n2-动态查验',
  `real_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际值\r\n  多个值之间使用英文的分号“;”进行分割',
  `report_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告描述',
  `item_score` decimal(10, 2) NULL DEFAULT NULL COMMENT '该查验项目得分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report_detail
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
