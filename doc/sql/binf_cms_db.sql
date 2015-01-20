/*
Navicat MySQL Data Transfer

Source Server         : localhostDB
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : binf_cms_db

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2015-01-21 00:01:04
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
-- Table structure for category_posts
-- ----------------------------
DROP TABLE IF EXISTS `category_posts`;
CREATE TABLE `category_posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL COMMENT '文章类别ID',
  `post_id` int(11) NOT NULL COMMENT '文章ID',
  PRIMARY KEY (`id`),
  KEY `category_post_ibfk_1` (`category_id`),
  KEY `category_post_ibfk_2` (`post_id`),
  CONSTRAINT `category_posts_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `category_posts_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_posts
-- ----------------------------
INSERT INTO `category_posts` VALUES ('1', '8', '1');
INSERT INTO `category_posts` VALUES ('7', '12', '7');
INSERT INTO `category_posts` VALUES ('8', '10', '7');
INSERT INTO `category_posts` VALUES ('9', '12', '8');
INSERT INTO `category_posts` VALUES ('10', '10', '8');
INSERT INTO `category_posts` VALUES ('11', '9', '8');
INSERT INTO `category_posts` VALUES ('22', '12', '9');
INSERT INTO `category_posts` VALUES ('23', '12', '10');
INSERT INTO `category_posts` VALUES ('25', '10', '11');
INSERT INTO `category_posts` VALUES ('27', '12', '12');
INSERT INTO `category_posts` VALUES ('28', '8', '3');

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  `thumbs` varchar(255) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('1', 'images/2014/12/1418137757674.png', null, '2014-12-09 23:09:17');
INSERT INTO `images` VALUES ('2', 'images/2014/12/1418137845422.jpg', null, '2014-12-09 23:10:45');
INSERT INTO `images` VALUES ('3', 'images/2014/12/1418138023570.jpg', null, '2014-12-09 23:13:43');
INSERT INTO `images` VALUES ('4', 'images/2014/12/1418138307902.jpg', null, '2014-12-09 23:18:27');
INSERT INTO `images` VALUES ('5', 'images/2014/12/1418140745137.jpg', null, '2014-12-09 23:59:05');
INSERT INTO `images` VALUES ('6', 'images/2014/12/1418140878586.jpg', null, '2014-12-10 00:01:18');
INSERT INTO `images` VALUES ('7', 'images/2014/12/1418140888185.jpg', null, '2014-12-10 00:01:28');
INSERT INTO `images` VALUES ('8', 'images/2014/12/1418141108879.jpg', null, '2014-12-10 00:05:08');
INSERT INTO `images` VALUES ('9', 'images/2014/12/1418141554896.jpg', null, '2014-12-10 00:12:34');
INSERT INTO `images` VALUES ('10', 'images/2014/12/1418141569033.jpg', null, '2014-12-10 00:12:49');
INSERT INTO `images` VALUES ('11', 'images/2014/12/1418141634128.jpg', null, '2014-12-10 00:13:54');
INSERT INTO `images` VALUES ('12', 'images/2014/12/1418141708440.jpg', null, '2014-12-10 00:15:08');
INSERT INTO `images` VALUES ('13', 'images/2014/12/1418141731725.jpg', null, '2014-12-10 00:15:31');
INSERT INTO `images` VALUES ('14', 'images/2014/12/1418141757582.jpg', null, '2014-12-10 00:15:57');
INSERT INTO `images` VALUES ('15', 'images/2014/12/1418141796456.jpg', null, '2014-12-10 00:16:36');
INSERT INTO `images` VALUES ('16', 'images/2014/12/1418141857520.jpg', null, '2014-12-10 00:17:37');
INSERT INTO `images` VALUES ('17', 'images/2014/12/1418142004776.jpg', null, '2014-12-10 00:20:04');
INSERT INTO `images` VALUES ('18', 'images/2014/12/1418142057011.jpg', null, '2014-12-10 00:20:57');
INSERT INTO `images` VALUES ('19', 'images/2014/12/1418142067399.jpg', null, '2014-12-10 00:21:07');
INSERT INTO `images` VALUES ('20', 'images/2014/12/1418142072948.jpg', null, '2014-12-10 00:21:12');
INSERT INTO `images` VALUES ('21', 'images/2014/12/1418142268028.jpg', null, '2014-12-10 00:24:28');
INSERT INTO `images` VALUES ('22', 'images/2014/12/1418142272952.jpg', null, '2014-12-10 00:24:32');
INSERT INTO `images` VALUES ('23', 'images/2014/12/1418142276440.jpg', null, '2014-12-10 00:24:36');
INSERT INTO `images` VALUES ('24', 'images/2014/12/1418221640479.jpg', null, '2014-12-10 22:27:20');
INSERT INTO `images` VALUES ('25', 'images/2014/12/1418221757639.jpg', null, '2014-12-10 22:29:17');
INSERT INTO `images` VALUES ('26', 'images/2014/12/1418222357091.jpg', null, '2014-12-10 22:39:17');
INSERT INTO `images` VALUES ('27', 'images/2014/12/1418222888719.jpg', null, '2014-12-10 22:48:08');
INSERT INTO `images` VALUES ('28', 'images/2014/12/1418560737566.jpg', null, '2014-12-14 20:38:57');

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
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
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
  KEY `image_id` (`image_id`),
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`create_by`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `posts_ibfk_3` FOREIGN KEY (`update_by`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `posts_ibfk_4` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES ('1', 'xx', null, 'dddd', null, '0', '', '1', '1', '0', '0', '\0', '0', '2014-11-18 00:04:40', '2014-11-18 00:04:40', null);
INSERT INTO `posts` VALUES ('3', 'dd', '27', '<p>ddd</p>', '啊啊,出错', '0', '', '1', '1', '0', '0', '\0', '0', '2014-11-23 15:19:43', '2014-11-23 15:19:43', '2014-12-10 22:48:43');
INSERT INTO `posts` VALUES ('7', 'ccc111', null, '<p>sadsadsad</p>', 's', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-23 16:28:27', '2014-11-23 16:28:27', '2014-12-04 23:38:31');
INSERT INTO `posts` VALUES ('8', 'ccc', null, '<p>sadsadsad</p>', null, '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-23 22:48:50', '2014-11-23 22:48:50', null);
INSERT INTO `posts` VALUES ('9', 'rrr11', null, '<p>sadsad</p>', 'sad', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-24 23:26:23', '2014-11-24 23:26:23', null);
INSERT INTO `posts` VALUES ('10', 'rrr11', null, '<p>sadsad</p>', 'sad', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-24 23:26:35', '2014-11-24 23:26:35', null);
INSERT INTO `posts` VALUES ('11', 'sadsafff', null, '<p>ffffsadas</p>', 'cccc,22', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-11-24 23:27:10', '2014-11-24 23:27:10', '2014-11-24 23:27:36');
INSERT INTO `posts` VALUES ('12', 'fff', '26', '<p>fffff</p>', '', '0', '\0', '1', '1', '0', '0', '\0', '0', '2014-12-10 22:39:27', '2014-12-10 22:39:27', null);

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `stats` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for tags_posts
-- ----------------------------
DROP TABLE IF EXISTS `tags_posts`;
CREATE TABLE `tags_posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tag_id` (`tag_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `tags_posts_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tags_posts_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags_posts
-- ----------------------------
