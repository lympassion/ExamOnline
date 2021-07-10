/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : examonline

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-07-10 10:49:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `A_id` varchar(20) NOT NULL,
  `A_name` varchar(20) NOT NULL,
  `A_password` varchar(20) NOT NULL,
  PRIMARY KEY (`A_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin1', 'boss', '123');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `S_id` varchar(20) NOT NULL COMMENT '主键 自动增长\r\n',
  `S_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `S_password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`S_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('4', '小美', '123456');
INSERT INTO `student` VALUES ('student1', '张三', '123');
INSERT INTO `student` VALUES ('student2', '李四', '1234');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `T_id` varchar(20) NOT NULL,
  `T_name` varchar(20) NOT NULL,
  `T_password` varchar(16) NOT NULL,
  PRIMARY KEY (`T_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('teacher', 'jack', '123');
