/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : examonline

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-07-12 15:23:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) NOT NULL,
  `admin_gender` enum('女','男') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_email` varchar(255) NOT NULL,
  `admin_password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30000001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('30000000', 'aa', '女', '999@qq.com', '123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(10) NOT NULL,
  `course_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `exam_id` int(10) NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(50) NOT NULL,
  `course_id` int(10) NOT NULL,
  `paper_id` int(10) NOT NULL,
  `total_score` int(3) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `exam_time` int(11) NOT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `course_id2` (`course_id`),
  KEY `paper_id` (`paper_id`),
  CONSTRAINT `course_id2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `paper_id` varchar(255) NOT NULL,
  `course_id` int(11) NOT NULL,
  `question_num` varchar(255) NOT NULL,
  `question_type` enum('c','b','a') NOT NULL,
  `question_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id` (`question_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of paper
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(10) NOT NULL AUTO_INCREMENT,
  `question_type` enum('c','b','a') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  `question_content` varchar(255) NOT NULL,
  `opa` varchar(255) NOT NULL,
  `opb` varchar(255) NOT NULL,
  `opc` varchar(255) DEFAULT NULL,
  `opd` varchar(255) DEFAULT NULL,
  `question_answer` varchar(2) NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `course_id1` (`course_id`),
  CONSTRAINT `course_id1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(20) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) NOT NULL,
  `student_class` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_password` varchar(255) NOT NULL,
  `student_gender` enum('女','男') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('10000000', 'wang', '1', '112@qq.com', '123456', '男');
INSERT INTO `student` VALUES ('10000001', 'sun', '2', '778@qq.com', '123456', '男');
INSERT INTO `student` VALUES ('10000002', 'li', '3', '369@qq.com', '123456', '女');

-- ----------------------------
-- Table structure for student_paper_record
-- ----------------------------
DROP TABLE IF EXISTS `student_paper_record`;
CREATE TABLE `student_paper_record` (
  `record_id` int(11) NOT NULL,
  `exam_id` int(10) NOT NULL,
  `student_id` int(20) NOT NULL,
  `student_answer` varchar(255) DEFAULT NULL,
  `student_mark` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`record_id`),
  KEY `exam_id` (`exam_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `exam_id` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student_paper_record
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_gender` enum('女','男') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_email` varchar(255) NOT NULL,
  `teacher_password` varchar(255) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20000004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('20000000', 'ali', '男', '979@163.com', '123456');
INSERT INTO `teacher` VALUES ('20000001', 'bol', '女', '334@qq.com', '123456');
INSERT INTO `teacher` VALUES ('20000003', 'sl', '女', '324@qq.com', '123456');
