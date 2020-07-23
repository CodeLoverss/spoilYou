/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : 127.0.0.1:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-07-23 08:30:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adopt
-- ----------------------------
DROP TABLE IF EXISTS `adopt`;
CREATE TABLE `adopt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `pet_id` int(11) DEFAULT NULL,
  `petname` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adopt
-- ----------------------------
INSERT INTO `adopt` VALUES ('1', '1', '123', '6', '狸花猫', '����');
INSERT INTO `adopt` VALUES ('2', '1', '123', '5', '暹罗猫', '申请');
INSERT INTO `adopt` VALUES ('3', '1', '123', '8', '金吉拉猫', '申请');
INSERT INTO `adopt` VALUES ('4', '1', '123', '12', '金毛寻回犬', '申请');
INSERT INTO `adopt` VALUES ('5', '1', '123', '15', '蝴蝶犬', '领养');
INSERT INTO `adopt` VALUES ('6', '1', '123', '19', '贵宾犬', '拒绝');
INSERT INTO `adopt` VALUES ('7', '1', '123', '21', '越南大肚猪', '申请');
