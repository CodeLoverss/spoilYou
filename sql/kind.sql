/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : 127.0.0.1:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-07-23 08:30:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kno` varchar(30) NOT NULL DEFAULT '',
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', 'k001', '猫猫');
INSERT INTO `kind` VALUES ('2', 'k002', '狗狗');
INSERT INTO `kind` VALUES ('3', 'k003', '猪猪');
INSERT INTO `kind` VALUES ('4', 'k004', '仓鼠');
INSERT INTO `kind` VALUES ('5', 'k005', '鹦鹉');
INSERT INTO `kind` VALUES ('6', 'k006', '龟龟');
INSERT INTO `kind` VALUES ('7', 'k007', '鱼鱼');
INSERT INTO `kind` VALUES ('8', '', '老虎');
