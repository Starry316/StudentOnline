/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : studentonline

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-12-25 20:34:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ActivityName` varchar(255) DEFAULT NULL,
  `ActivityPlace` varchar(255) DEFAULT NULL,
  `ActivityStartTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ActivityContent` text,
  `ActivityEndTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `AssociationId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for association
-- ----------------------------
DROP TABLE IF EXISTS `association`;
CREATE TABLE `association` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `AssociationName` varchar(255) NOT NULL,
  `ManagerId` bigint(20) unsigned NOT NULL,
  `Introduction` text,
  `FoundedTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `College` int(10) unsigned DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `Member` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of association
-- ----------------------------
INSERT INTO `association` VALUES ('1', 'name', '123', 'introduction', '2017-12-11 14:49:46', null, null, null);
INSERT INTO `association` VALUES ('2', 'name', '123', 'introduction', '2017-12-11 14:50:44', null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) NOT NULL,
  `PassWord` varchar(255) NOT NULL,
  `StudentId` bigint(20) unsigned DEFAULT NULL,
  `Telephone` varchar(13) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '123456', '123456789', null, null);
INSERT INTO `user` VALUES ('2', 'lisi', '111', '131511445', null, null);
SET FOREIGN_KEY_CHECKS=1;
