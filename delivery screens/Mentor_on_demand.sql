/*
 Navicat Premium Data Transfer

 Source Server         : FSD
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 49.235.99.9
 Source Database       : Mentor_on_demand

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : utf-8

 Date: 11/14/2019 22:54:19 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `account`
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('1', 'weiliu', 'weiliu', '{bcrypt}$2a$10$AMrL1WA3b5oVIUfwvqiD3OlxpXNt2QmzVNbnQyOgsUmmvrLbtzX82', 'mentor', '0'), ('2', 'wayne', 'wayne', '{bcrypt}$2a$10$5PTBx9oMwkqt3iVsIZeng.NtwJEgvyxhtSJqV1nwE/ippGLJhq2Vu', 'mentor', '0'), ('3', 'wayne01', 'wayne01', '{bcrypt}$2a$10$CVFFh927wGyBL5LTPKX1iulOnnZiMP3ACWL/EDViXNrtA6MJn2F/.', 'user', '0');
COMMIT;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `mentorName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `skill` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `startDate` datetime(6) DEFAULT NULL,
  `endDate` datetime(6) DEFAULT NULL,
  `fee` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `progress` varchar(50) DEFAULT NULL,
  `enabelTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', 'java foundation', 'weiliu', 'javaee', '2019-11-04 18:29:04.000000', '2022-01-27 18:29:06.000000', '10', null, 'wayne01', 'available', '1', '2019-11-24 07:00:30.954000'), ('2', 'frontend', 'weiliu', 'css', '2019-11-06 10:45:19.000000', '2020-05-22 10:45:22.000000', '100', null, 'weiliu', 'available', '0', null), ('3', 'aytomation test', 'wayne', 'test', '2019-11-20 00:00:00.000000', '2019-11-26 00:00:00.000000', '100.0', '1', 'wayne01', 'available', '1', null), ('4', 'spring', 'wayne', 'java', '2019-11-12 00:00:00.000000', '2019-11-19 00:00:00.000000', '1111.0', '', 'wayne01', 'available', '1', null), ('5', 'java foundation', 'weiliu', 'java', '2019-11-04 18:29:04.000000', '2022-01-27 18:29:06.000000', '10', null, '', 'available', '0', null), ('6', 'frontend', 'weiliu', 'css', '2019-11-06 10:45:19.000000', '2020-05-22 10:45:22.000000', '100', null, '', 'available', '0', null), ('7', 'aytomation test', 'wayne', 'test', '2019-11-20 00:00:00.000000', '2019-11-26 00:00:00.000000', '100.0', '1', '', 'available', '1', null), ('8', 'spring', 'wayne', 'java', '2019-11-12 00:00:00.000000', '2019-11-19 00:00:00.000000', '1111.0', '', '', 'available', '2', null);
COMMIT;

-- ----------------------------
--  Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `courseId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `mentorName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `payment`
-- ----------------------------
BEGIN;
INSERT INTO `payment` VALUES ('1', 'Wyane', 'wei liu'), ('3', 'wayne01', 'wayne'), ('4', 'wayne01', 'wayne');
COMMIT;

-- ----------------------------
--  Table structure for `rate`
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `mentorId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `rating` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `courseId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `rate`
-- ----------------------------
BEGIN;
INSERT INTO `rate` VALUES ('1', '1', '100', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
