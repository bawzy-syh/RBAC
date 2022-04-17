/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : keychain

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 15/04/2022 14:54:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `uid` int(10) unsigned NOT NULL,
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for aes_key
-- ----------------------------
DROP TABLE IF EXISTS `aes_key`;
CREATE TABLE `aes_key` (
  `key_id` bigint(20) NOT NULL,
  `key` varchar(6400) COLLATE utf8mb4_general_ci NOT NULL,
  `deprecate_time` timestamp NOT NULL,
  `abandon_time` timestamp NOT NULL,
  `create_time` timestamp NOT NULL,
  PRIMARY KEY (`key_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `privilegeID` int(11) NOT NULL,
  `privilege_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `privilege_identifier` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`privilegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleID` int(11) NOT NULL,
  `role_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名（用于展示）',
  `role_identifier` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色标识（用于JWT）',
  `comment` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for role_privilege_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege_relation`;
CREATE TABLE `role_privilege_relation` (
  `privilegeID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`privilegeID`,`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for rsa_key
-- ----------------------------
DROP TABLE IF EXISTS `rsa_key`;
CREATE TABLE `rsa_key` (
  `key_id` bigint(20) NOT NULL,
  `private_key` varchar(6400) COLLATE utf8mb4_general_ci NOT NULL,
  `public_key` varchar(6400) COLLATE utf8mb4_general_ci NOT NULL,
  `deprecate_time` timestamp NOT NULL,
  `abandon_time` timestamp NOT NULL,
  `create_time` timestamp NOT NULL,
  PRIMARY KEY (`key_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation` (
  `userID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`,`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
