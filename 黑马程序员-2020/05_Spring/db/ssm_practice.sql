/*
 Navicat Premium Data Transfer

 Source Server         : Joseph-Server-MySQL
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 49.235.249.194:3306
 Source Schema         : ssm_practice

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 25/11/2020 17:22:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'aaa', 1000);
INSERT INTO `account` VALUES (2, 'bbb222222', 2000);
INSERT INTO `account` VALUES (3, '隔壁老王', 999999);

SET FOREIGN_KEY_CHECKS = 1;
