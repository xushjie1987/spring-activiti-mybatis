/*
Navicat MySQL Data Transfer

Source Server         : activiti-3314
Source Server Version : 50530
Source Host           : localhost:3314
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2016-03-06 19:03:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_c
-- ----------------------------
DROP TABLE IF EXISTS `tbl_c`;
CREATE TABLE `tbl_c` (
  `c1` int(11) NOT NULL DEFAULT '0',
  `c2` char(10) DEFAULT NULL,
  PRIMARY KEY (`c1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_c
-- ----------------------------
