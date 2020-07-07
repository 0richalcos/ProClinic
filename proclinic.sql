/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : proclinic

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 07/07/2020 09:28:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出诊表ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `patient_id` int(11) NULL DEFAULT NULL COMMENT '病人ID',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '科室ID',
  `appointment_date` date NULL DEFAULT NULL COMMENT '出诊日期',
  `time_slot` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间段',
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题',
  `charges` decimal(10, 0) NULL DEFAULT NULL COMMENT '收费',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '等待' COMMENT '状态（等待；活动）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_appointment_id`(`user_id`) USING BTREE,
  INDEX `patient_appointment_id`(`patient_id`) USING BTREE,
  INDEX `department_appointment`(`department_id`) USING BTREE,
  CONSTRAINT `department_appointment` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patient_appointment_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_appointment_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_authorities_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_authorities_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `department` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病人ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名 ',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '等待' COMMENT '状态（等待；治疗中；已治愈）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_patient_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_patient_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '支付表ID',
  `patient_id` int(11) NULL DEFAULT NULL COMMENT '病人ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '科室ID',
  `charges` decimal(10, 0) NULL DEFAULT NULL COMMENT '费用',
  `admission_date` date NULL DEFAULT NULL COMMENT '入院日期',
  `discharge_date` date NULL DEFAULT NULL COMMENT '出院日期',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '等待' COMMENT '支付状态（等待；已支付）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_payment_id`(`user_id`) USING BTREE,
  INDEX `patient_payment_id`(`patient_id`) USING BTREE,
  INDEX `department_payment_id`(`department_id`) USING BTREE,
  CONSTRAINT `department_payment_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patient_payment_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_payment_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病房ID',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病房类型（常规；ICU；监护室）',
  `size` tinyint(4) NULL DEFAULT NULL COMMENT '容量',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未满' COMMENT '状态（满；未满)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room_desc
-- ----------------------------
DROP TABLE IF EXISTS `room_desc`;
CREATE TABLE `room_desc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病房详情ID',
  `patient_id` int(11) NULL DEFAULT NULL COMMENT '病人ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `allotment_date` date NULL DEFAULT NULL COMMENT '收入日期',
  `discharge_date` date NULL DEFAULT NULL COMMENT '出院日期',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '病房ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `patietn_room_id`(`patient_id`) USING BTREE,
  INDEX `user_room_id`(`user_id`) USING BTREE,
  INDEX `room_room_desc_id`(`room_id`) USING BTREE,
  CONSTRAINT `patietn_room_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `room_room_desc_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_room_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务名',
  `money` decimal(10, 0) NULL DEFAULT NULL COMMENT '费用',
  `payment_id` int(11) NULL DEFAULT NULL COMMENT '支付ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `payment_service_id`(`payment_id`) USING BTREE,
  CONSTRAINT `payment_service_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `enabled` tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否可用(1：可用；0：不可用)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_desc
-- ----------------------------
DROP TABLE IF EXISTS `user_desc`;
CREATE TABLE `user_desc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户信息ID',
  `specialization` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `experience` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经验',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生详情',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '可出诊' COMMENT '状态（可出诊；休假；不可出诊）',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '科室ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `department_user_desc_id`(`department_id`) USING BTREE,
  CONSTRAINT `department_user_desc_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_user_desc_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
