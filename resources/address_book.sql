/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_Leo
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : address_book

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 05/08/2018 00:15:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sdcard
-- ----------------------------
DROP TABLE IF EXISTS `sdcard`;
CREATE TABLE `sdcard`  (
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sdcard
-- ----------------------------
INSERT INTO `sdcard` VALUES ('张三', '123');
INSERT INTO `sdcard` VALUES ('张二', '456');
INSERT INTO `sdcard` VALUES ('张三', '789');

-- ----------------------------
-- Table structure for sim
-- ----------------------------
DROP TABLE IF EXISTS `sim`;
CREATE TABLE `sim`  (
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qq` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthplace` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sim
-- ----------------------------
INSERT INTO `sim` VALUES ('雷军', '17861500001', '10010', '湖北');
INSERT INTO `sim` VALUES ('任正非', '17861500002', '10011', '北京');
INSERT INTO `sim` VALUES ('马云', '17861500003', '10012', '杭州');

SET FOREIGN_KEY_CHECKS = 1;
