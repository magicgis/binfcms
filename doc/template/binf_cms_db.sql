/*
Navicat MySQL Data Transfer

Source Server         : localhostDB
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : binf_cms_db

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-11-30 11:00:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '类别名称',
  `level` int(11) NOT NULL COMMENT '等级',
  `alias` varchar(50) DEFAULT NULL COMMENT '别名',
  `model_id` int(11) DEFAULT NULL COMMENT '模板id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类id',
  `sort` int(11) NOT NULL COMMENT '排序',
  `count` int(11) DEFAULT NULL COMMENT '文章数量',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_ibfk_1` (`model_id`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('8', '网络', '1', 'net', null, null, '0', '0', '2014-10-31 22:15:22', '2014-10-31 22:16:53');
INSERT INTO `category` VALUES ('9', '相册', '1', 'photo', null, null, '0', '0', '2014-10-31 22:16:11', '2014-10-31 22:17:03');
INSERT INTO `category` VALUES ('10', '数据链路', '2', 'data-link', null, '8', '0', '0', '2014-10-31 22:18:09', null);
INSERT INTO `category` VALUES ('11', '数据链路1', '3', 'net1', null, '10', '0', '0', '2014-11-15 23:30:08', null);
INSERT INTO `category` VALUES ('12', '桥连', '2', 'xx', null, '8', '11', '0', '2014-11-15 23:30:43', null);
INSERT INTO `category` VALUES ('13', '相片', '2', 'xx', null, '9', '0', '0', '2014-11-15 23:30:57', null);

-- ----------------------------
-- Table structure for category_post
-- ----------------------------
DROP TABLE IF EXISTS `category_post`;
CREATE TABLE `category_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL COMMENT '文章类别ID',
  `post_id` int(11) NOT NULL COMMENT '文章ID',
  PRIMARY KEY (`id`),
  KEY `category_post_ibfk_1` (`category_id`),
  KEY `category_post_ibfk_2` (`post_id`),
  CONSTRAINT `category_post_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `category_post_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_post
-- ----------------------------
INSERT INTO `category_post` VALUES ('1', '8', '1');
INSERT INTO `category_post` VALUES ('7', '12', '7');
INSERT INTO `category_post` VALUES ('8', '10', '7');
INSERT INTO `category_post` VALUES ('9', '12', '8');
INSERT INTO `category_post` VALUES ('10', '10', '8');
INSERT INTO `category_post` VALUES ('11', '9', '8');
INSERT INTO `category_post` VALUES ('22', '12', '9');
INSERT INTO `category_post` VALUES ('23', '12', '10');
INSERT INTO `category_post` VALUES ('25', '10', '11');
INSERT INTO `category_post` VALUES ('26', '8', '3');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'sss', 'aa', 'dd', 'd', '2014-10-14 00:35:45', '2014-10-22 00:36:10');
INSERT INTO `member` VALUES ('2', 'sss2', 'aa2', 'dd2', 'd2', '2014-10-14 00:35:45', '2014-10-09 00:36:14');

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '模板名称',
  `path` varchar(50) DEFAULT NULL COMMENT '模板路径',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES ('1', '会展活动列表页', '/资讯库-会展活动-列表', '2014-09-01 09:33:32', '2014-09-01 09:37:02');
INSERT INTO `model` VALUES ('2', '资讯库列表', '/资讯库', '2014-09-01 11:30:41', null);
INSERT INTO `model` VALUES ('3', '前沿资讯列表页', '/资讯库-前沿资讯-列表', '2014-09-01 14:15:07', '2014-09-01 14:19:58');
INSERT INTO `model` VALUES ('4', '文库下载列表页', '/资讯库-文库下载-列表', '2014-09-02 11:45:54', null);
INSERT INTO `model` VALUES ('5', '文库下载详情页', '/资讯库-下载-详情页', '2014-09-02 14:46:39', '2014-09-02 14:47:54');
INSERT INTO `model` VALUES ('6', '资讯详情页', '/资讯库-资讯-详情页', '2014-09-02 14:48:38', null);
INSERT INTO `model` VALUES ('7', '会员中心-常见问题模板', '/会员中心-常见问题模板', '2014-09-13 11:44:23', '2014-09-13 11:44:32');
INSERT INTO `model` VALUES ('8', '会员中心-vip服务模板', '/会员中心-VIP会员服务模板', '2014-09-13 16:29:23', null);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `image_id` int(11) DEFAULT NULL COMMENT '文章缩略图',
  `content` varchar(3000) DEFAULT NULL COMMENT '文章内容',
  `tags` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `stick` bit(1) DEFAULT NULL COMMENT '是否置顶(1:是,0:否)',
  `create_by` int(11) NOT NULL COMMENT '创建人',
  `update_by` int(11) DEFAULT NULL COMMENT '修改人',
  `visits` int(10) DEFAULT '0' COMMENT '点击量',
  `stars` int(10) DEFAULT '0' COMMENT '点赞数量',
  `comment_status` bit(1) DEFAULT b'0' COMMENT '是否开启评论',
  `comment_count` int(10) DEFAULT '0' COMMENT '评论数量',
  `announce_date` datetime NOT NULL COMMENT '发布时间',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `create_by` (`create_by`),
  KEY `update_by` (`update_by`),
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`create_by`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `post_ibfk_3` FOREIGN KEY (`update_by`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', 'xx', null, 'dddd', null, null, null, '1', '1', null, null, null, null, '2014-11-18 00:04:40', '2014-11-18 00:04:40', null);
INSERT INTO `post` VALUES ('3', 'dd', null, '<p>ddd</p>', '啊啊,出错', '0', '', '1', '1', '0', '0', '\0', '0', '2014-11-23 15:19:43', '2014-11-23 15:19:43', '2014-11-25 00:06:16');
INSERT INTO `post` VALUES ('7', 'ccc', null, '<p>sadsadsad</p>', null, '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-23 16:28:27', '2014-11-23 16:28:27', null);
INSERT INTO `post` VALUES ('8', 'ccc', null, '<p>sadsadsad</p>', null, '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-23 22:48:50', '2014-11-23 22:48:50', null);
INSERT INTO `post` VALUES ('9', 'rrr11', null, '<p>sadsad</p>', 'sad', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-24 23:26:23', '2014-11-24 23:26:23', null);
INSERT INTO `post` VALUES ('10', 'rrr11', null, '<p>sadsad</p>', 'sad', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-24 23:26:35', '2014-11-24 23:26:35', null);
INSERT INTO `post` VALUES ('11', 'sadsafff', null, '<p>ffffsadas</p>', 'cccc,22', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-24 23:27:10', '2014-11-24 23:27:10', '2014-11-24 23:27:36');
