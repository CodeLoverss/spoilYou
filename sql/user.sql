/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : 127.0.0.1:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-07-23 08:31:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '阮子恒', '123', '用户');
INSERT INTO `user` VALUES ('2', 'admin', '123', '管理员');
INSERT INTO `user` VALUES ('3', '潘文峰', '123', '管理员');
INSERT INTO `user` VALUES ('4', '张三', '123456', '用户');
INSERT INTO `user` VALUES ('5', '吴梦梦', '12345', '用户');
