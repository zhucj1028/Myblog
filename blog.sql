/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 06/04/2021 14:01:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `user_id` int(11) NOT NULL COMMENT '发表用户ID',
  `user_nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `article_id` int(11) NOT NULL COMMENT '评论博文ID',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `parent_comment_id` int(11) NULL DEFAULT NULL COMMENT '父评论ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 9, '小李', 56, 'HAHAHA!!!', NULL, '2021-01-09 11:33:45', NULL);
INSERT INTO `comment` VALUES (2, 9, '小李', 1, '666', NULL, '2021-01-09 11:42:05', NULL);
INSERT INTO `comment` VALUES (3, 9, '小李', 80, 'wqw', NULL, '2021-01-09 12:05:11', NULL);
INSERT INTO `comment` VALUES (4, 9, '小李', 80, 'wqw', NULL, '2021-01-09 12:05:32', NULL);
INSERT INTO `comment` VALUES (25, 9, '小李', 80, '这次行吗', NULL, '2021-01-09 13:01:40', NULL);
INSERT INTO `comment` VALUES (26, 9, '小李', 80, '这次行吗', NULL, '2021-01-09 13:01:42', NULL);
INSERT INTO `comment` VALUES (27, 9, '小李', 80, 'ok?', NULL, '2021-01-09 13:03:14', NULL);
INSERT INTO `comment` VALUES (28, 9, '小李', 80, 'wq', NULL, '2021-01-09 13:07:55', NULL);
INSERT INTO `comment` VALUES (29, 9, '小李', 80, 'wq', NULL, '2021-01-09 13:07:57', NULL);
INSERT INTO `comment` VALUES (30, 11, '阿杰啊', 80, 'qw', NULL, '2021-01-09 13:08:53', NULL);
INSERT INTO `comment` VALUES (31, 9, '小李', 80, '???', NULL, '2021-01-09 13:13:13', NULL);
INSERT INTO `comment` VALUES (32, 9, '小李', 80, '???', NULL, '2021-01-09 13:13:15', NULL);
INSERT INTO `comment` VALUES (33, 9, '小李', 80, '<p>嗯哼？</p>', NULL, '2021-01-09 13:19:17', NULL);
INSERT INTO `comment` VALUES (34, 11, '阿杰啊', 80, 'sasa', NULL, '2021-01-09 13:23:55', NULL);
INSERT INTO `comment` VALUES (35, 11, '阿杰啊', 80, 'sasas', NULL, '2021-01-09 13:24:09', NULL);
INSERT INTO `comment` VALUES (36, 9, '小李', 80, 'sasas', NULL, '2021-01-09 13:26:44', NULL);
INSERT INTO `comment` VALUES (37, 9, '小李', 80, 'dd', NULL, '2021-01-09 13:26:50', NULL);
INSERT INTO `comment` VALUES (38, 9, '小李', 80, 'dd', NULL, '2021-01-09 13:26:52', NULL);
INSERT INTO `comment` VALUES (39, 9, '小李', 80, 'wqwq', NULL, '2021-01-09 13:41:38', NULL);
INSERT INTO `comment` VALUES (40, 9, '小李', 1, '666', NULL, '2021-01-09 14:27:26', NULL);
INSERT INTO `comment` VALUES (41, 9, '小李', 1, '666', NULL, '2021-01-09 17:06:38', NULL);
INSERT INTO `comment` VALUES (42, 9, '小李', 80, '不知道怎么写', NULL, '2021-01-21 18:20:55', NULL);
INSERT INTO `comment` VALUES (43, 9, '小李', 79, '怎么回事啊！', NULL, '2021-01-21 20:18:49', NULL);
INSERT INTO `comment` VALUES (44, 9, '小李', 80, '为什么呢', NULL, '2021-01-22 10:40:50', NULL);
INSERT INTO `comment` VALUES (45, 9, '小李', 80, '到底是为什么', NULL, '2021-01-22 10:42:16', NULL);
INSERT INTO `comment` VALUES (46, 9, '小李', 80, '为什么还是不行啊', NULL, '2021-01-22 11:36:34', NULL);
INSERT INTO `comment` VALUES (47, 9, '小李', 76, '这应该怎么写呢', NULL, '2021-01-22 11:46:41', NULL);
INSERT INTO `comment` VALUES (48, 9, '小李', 56, 'HAHAHA!!!', NULL, '2021-03-09 17:33:11', NULL);
INSERT INTO `comment` VALUES (49, 9, '小李', 56, 'HAHAHA!!!', NULL, '2021-03-09 17:35:59', NULL);
INSERT INTO `comment` VALUES (50, 9, '小李', 56, 'HAHAHA!!!', NULL, '2021-03-09 17:38:15', NULL);

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章封面图',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES (1, 9, '你好世界！', NULL, '2021-01-05 16:36:20', NULL);
INSERT INTO `diary` VALUES (2, 9, '保持理智，相信未来', NULL, '2021-01-05 17:53:28', NULL);
INSERT INTO `diary` VALUES (34, NULL, '<p>很好看的落日<img src=\"http://localhost:8081/2021/01/dec5bb31-7498-4483-93bf-53fb29d5957a.jpg\"><br></p>', NULL, '2021-01-21 14:31:47', NULL);
INSERT INTO `diary` VALUES (35, 9, '今天你在做什么呢', NULL, '2021-03-09 17:33:11', NULL);
INSERT INTO `diary` VALUES (36, 9, '今天你在做什么呢', NULL, '2021-03-09 17:35:59', NULL);
INSERT INTO `diary` VALUES (37, 9, '今天你在做什么呢', NULL, '2021-03-09 17:38:16', NULL);

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '网站链接',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '网站名称',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网站介绍',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES (1, 'http://www.baidu.com', '百度', '百度一下，你就知道', NULL, NULL);
INSERT INTO `link` VALUES (6, 'http://www.csdn.net', 'CSDN', '专业IT技术发表平台', '2021-01-04 10:42:57', NULL);
INSERT INTO `link` VALUES (7, 'http://www.github.com', 'Github', '源代码托管平台，全世界构建软件的地方。', '2021-01-04 10:50:29', NULL);
INSERT INTO `link` VALUES (8, 'https://stackoverflow.com', 'Stackoverflow', 'IT技术问答网站', '2021-01-04 10:54:27', NULL);
INSERT INTO `link` VALUES (9, 'https://leetcode-cn.com/', '力扣', '刷法刷题', '2021-01-06 19:30:11', NULL);
INSERT INTO `link` VALUES (10, 'www.baidu.com', '百度', NULL, NULL, NULL);
INSERT INTO `link` VALUES (11, 'www.aliyun.com', '阿里云', '阿里云服务器,网站搭建', '2021-03-09 17:33:11', NULL);
INSERT INTO `link` VALUES (12, 'www.baidu.com', '百度', NULL, NULL, NULL);
INSERT INTO `link` VALUES (13, 'www.baidu.com', '百度', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `user_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `parent_comment_id` int(11) NULL DEFAULT NULL COMMENT '父评论ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 9, '很不错啊', '小李', NULL, '2021-01-07 12:31:39', NULL);
INSERT INTO `message` VALUES (2, 9, '那肯定的', '小李', 1, '2021-01-07 13:07:38', NULL);
INSERT INTO `message` VALUES (3, 10, '今天你学习了嘛', '阿杰', 2, '2021-01-07 13:18:21', NULL);
INSERT INTO `message` VALUES (11, 10, 'wsas', '阿杰', 10, '2021-01-09 13:43:06', NULL);
INSERT INTO `message` VALUES (13, 9, '15555', '小李', 10, '2021-01-09 17:45:30', NULL);
INSERT INTO `message` VALUES (28, 11, 'saassa', '阿杰啊', NULL, '2021-01-10 10:26:37', NULL);
INSERT INTO `message` VALUES (29, 9, 'assasa', '小李', NULL, '2021-01-10 10:27:44', NULL);
INSERT INTO `message` VALUES (30, 9, 'assa', '小李', 29, '2021-01-10 10:28:43', NULL);
INSERT INTO `message` VALUES (31, 9, 'qwwq', '小李', 30, '2021-01-10 10:28:57', NULL);
INSERT INTO `message` VALUES (32, 9, 'wqqwwq', '小李', 31, '2021-01-10 10:29:06', NULL);
INSERT INTO `message` VALUES (34, 9, 'sas', '小李', 33, '2021-01-10 10:44:53', NULL);
INSERT INTO `message` VALUES (35, 9, 'wqq', '小李', 34, '2021-01-10 11:13:00', NULL);
INSERT INTO `message` VALUES (36, 9, 'wqq', '小李', 34, '2021-01-10 11:13:17', NULL);
INSERT INTO `message` VALUES (37, 9, 'wqw', '小李', 36, '2021-01-10 11:13:34', NULL);
INSERT INTO `message` VALUES (38, 9, 'saSASA', '小李', 37, '2021-01-10 11:33:05', NULL);
INSERT INTO `message` VALUES (40, 9, '', '小李', NULL, '2021-01-25 12:01:08', NULL);
INSERT INTO `message` VALUES (41, 9, '', '小李', NULL, '2021-01-25 12:01:11', NULL);
INSERT INTO `message` VALUES (42, 9, '', '小李', NULL, '2021-01-25 12:03:58', NULL);
INSERT INTO `message` VALUES (43, 9, '嗯哼', '小李', NULL, '2021-01-27 10:19:37', NULL);
INSERT INTO `message` VALUES (44, 9, '嗯哼', '小李', NULL, '2021-01-27 10:54:07', NULL);
INSERT INTO `message` VALUES (45, 9, 'g', '小李', NULL, '2021-01-27 11:53:55', NULL);
INSERT INTO `message` VALUES (46, 9, '不错哦', '小李', NULL, '2021-03-09 17:33:10', NULL);
INSERT INTO `message` VALUES (47, 9, '不错哦', '小李', NULL, '2021-03-09 17:35:58', NULL);
INSERT INTO `message` VALUES (48, 9, '不错哦', '小李', NULL, '2021-03-09 17:38:14', NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标识',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '/web/index', '访问主页', '2020-12-13 21:50:19', NULL);
INSERT INTO `permission` VALUES (2, '/question/create', '提问', '2020-12-13 21:50:16', NULL);
INSERT INTO `permission` VALUES (3, '/question/uploadMultipleFile', '上传图片文件', '2020-12-13 21:51:11', NULL);
INSERT INTO `permission` VALUES (4, '/question/answer', '回答问题', '2020-12-13 21:51:49', NULL);
INSERT INTO `permission` VALUES (5, '/user/get', '测试-访问用户个人信息', '2020-12-13 21:52:25', NULL);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博文ID',
  `user_id` int(11) NOT NULL COMMENT '发表用户ID',
  `user_nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者名称',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '博文标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '博文内容',
  `hits` int(11) NOT NULL COMMENT '浏览量',
  `comment_count` int(11) NOT NULL COMMENT '评论总数',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文章封面图',
  `tag_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (28, 11, '阿杰啊', '怎么写出一个 Hello World', '', 0, 0, '', '2', '2020-12-26 21:29:49', NULL);
INSERT INTO `question` VALUES (29, 9, '小李', '怎么写出一个 Hello World', '', 0, 0, '', '2', '2020-12-26 21:40:31', NULL);
INSERT INTO `question` VALUES (30, 9, '小李', 'Java', 'HelloWorld', 0, 0, '', '2', '2020-12-26 21:40:49', NULL);
INSERT INTO `question` VALUES (31, 11, '阿杰啊', '怎么写出一个 Hello World', '', 0, 0, '', '3', '2020-12-30 14:36:56', NULL);
INSERT INTO `question` VALUES (32, 11, '阿杰啊', '怎么写出一个 Hello World', '这个应该怎么去写呢？', 0, 0, '', '3', '2020-12-30 14:37:03', NULL);
INSERT INTO `question` VALUES (33, 11, '阿杰啊', '怎么写出一个 Hello World', '这个应该怎么去写呢？', 0, 0, '', '3', '2020-12-30 14:38:20', NULL);
INSERT INTO `question` VALUES (34, 11, '阿杰啊', '怎么写出一个 Hello World', '这个应该怎么去写呢？', 0, 0, '', '3', '2020-12-30 14:38:33', NULL);
INSERT INTO `question` VALUES (35, 9, '小李', '怎么写出一个 Hello World', '', 0, 0, '', '1', '2020-12-30 14:42:40', NULL);
INSERT INTO `question` VALUES (36, 9, '小李', '怎么写出一个 Hello World', '<p>qqqq</p>', 0, 0, '', '1', '2020-12-30 14:42:44', NULL);
INSERT INTO `question` VALUES (37, 9, '小李', 'Hello World', '', 0, 0, '', '2', '2020-12-30 21:39:58', NULL);
INSERT INTO `question` VALUES (38, 9, '小李', 'Hello World', '<p>qwqwqw</p>', 0, 0, '', '2', '2020-12-30 21:40:05', NULL);
INSERT INTO `question` VALUES (39, 9, '小李', 'Hello World', '<p>qwqwqw</p>', 0, 0, '', '2, 3', '2020-12-30 21:45:48', NULL);
INSERT INTO `question` VALUES (40, 9, '小李', 'Hello World', '<p>qwqwqwfdsfasdfas</p>', 0, 0, '', '2, 3', '2020-12-30 21:47:29', NULL);
INSERT INTO `question` VALUES (41, 9, '小李', 'Hello World', '', 0, 0, '', '2', '2020-12-30 21:50:50', NULL);
INSERT INTO `question` VALUES (42, 9, '小李', 'Hello World', '[object Object]', 0, 0, '', '3', '2020-12-30 22:18:35', NULL);
INSERT INTO `question` VALUES (43, 9, '小李', 'Hello World', '[object Object]', 0, 0, '', '3', '2020-12-30 22:18:49', NULL);
INSERT INTO `question` VALUES (44, 9, '小李', 'Hello World', '[object Object]', 0, 0, '', '3', '2020-12-30 22:19:12', NULL);
INSERT INTO `question` VALUES (45, 9, '小李', 'eqeq', '[object Object]', 0, 0, '', '5', '2020-12-30 22:19:30', NULL);
INSERT INTO `question` VALUES (46, 9, '小李', 'Hello World', '', 0, 0, '', '2', '2020-12-30 22:26:48', NULL);
INSERT INTO `question` VALUES (47, 9, '小李', 'Hello World', '', 0, 0, '', '2', '2020-12-30 22:27:01', NULL);
INSERT INTO `question` VALUES (48, 9, '小李', 'Hello World', '[object Object]', 0, 0, '', '2', '2020-12-30 22:35:34', NULL);
INSERT INTO `question` VALUES (49, 9, '小李', 'Hello World', '[object Object]', 0, 0, '', '3', '2020-12-30 22:37:16', NULL);
INSERT INTO `question` VALUES (50, 9, '小李', 'eqeq', '[object Object]', 0, 0, '', '3', '2020-12-30 22:43:36', NULL);
INSERT INTO `question` VALUES (51, 9, '小李', 'eqeq', '[object Object]', 0, 0, '', '4', '2020-12-30 22:54:20', NULL);
INSERT INTO `question` VALUES (52, 9, '小李', '怎么写出一个 Hello World', '[object Object]', 0, 0, '', '2', '2020-12-30 23:03:53', NULL);
INSERT INTO `question` VALUES (53, 9, '小李', 'qwqwq', 'sas ', 0, 0, '', '2', '2020-12-30 23:17:01', NULL);
INSERT INTO `question` VALUES (54, 9, '小李', '怎么写出一个 Hello World', '', 0, 0, '', '2', '2020-12-30 23:20:29', NULL);
INSERT INTO `question` VALUES (55, 9, '小李', 'Hello World', 'sas ', 0, 0, '', '2', '2020-12-31 09:39:42', NULL);
INSERT INTO `question` VALUES (56, 9, '小李', 'Hello World', '<p>wwww</p>', 0, 0, '', '2', '2020-12-31 15:17:47', NULL);
INSERT INTO `question` VALUES (65, 9, '小李', 'Hello World', '', 0, 0, '', '3', '2020-12-31 20:08:13', NULL);
INSERT INTO `question` VALUES (66, 9, '小李', 'Hello World', '<p>wqw</p>', 0, 0, '', '2', '2020-12-31 20:09:33', NULL);
INSERT INTO `question` VALUES (67, 9, '小李', 'Hello World', '<p>你在干嘛呢</p>', 0, 0, '', '1', '2021-01-02 18:33:02', NULL);
INSERT INTO `question` VALUES (68, 9, '小李', '《活着》', '<p><span style=\"color: rgb(25, 25, 25); font-family: &quot;PingFang SC&quot;, Arial, 微软雅黑, 宋体, simsun, sans-serif; font-size: 16px;\">做人还是平常点好，争这个争那个，争来争去赔了自己的命。像我这样，说起来是越混越没出息，可寿命长，我认识的人一个挨着一个死去，我还活着。</span><br></p>', 0, 0, '', '1', '2021-01-02 18:37:15', NULL);
INSERT INTO `question` VALUES (69, 9, '小李', '这世界会好吗', '<p>保持理智，相信未来</p>', 0, 0, '', '1', '2021-01-03 10:27:38', NULL);
INSERT INTO `question` VALUES (70, 7, 'spring', '无趣无趣', '好好学习', 0, 0, '', '8', '2021-01-07 15:01:33', NULL);
INSERT INTO `question` VALUES (71, 9, '小李', '《十年》', '<font face=\"Arial\">小学毕业都十年了！！！</font>', 0, 0, '', '1', '2021-01-07 15:51:06', NULL);
INSERT INTO `question` VALUES (72, 7, 'spring', 'Hello World', '如何写出一个 Hello World!', 0, 0, '', '3', '2021-01-07 15:58:18', NULL);
INSERT INTO `question` VALUES (73, 9, '小李', '终于解决了界面显示问题', '<p>太难了我</p><p>解决了心里好舒服啊</p><p>太开心了</p>', 0, 0, '', '15', '2021-01-08 00:10:54', NULL);
INSERT INTO `question` VALUES (74, 9, '小李', 'summernote编辑器', '<p>使用summernote编辑器界面显示不正常。</p>', 0, 0, '', '15', '2021-01-08 10:35:23', NULL);
INSERT INTO `question` VALUES (75, 9, '小李', 'Hello World', '<p><img src=\"http://localhost:8081/1.jpg\"><br></p>', 0, 0, '', '3', '2021-01-08 11:59:41', NULL);
INSERT INTO `question` VALUES (76, 9, '小李', 'SpringMVC', '<p><br><img src=\"http://localhost:8081/1.jpg\"></p>', 0, 0, '', '6', '2021-01-08 12:11:45', NULL);
INSERT INTO `question` VALUES (77, 9, '小李', 'SpringMVC的流程', '<p>这是SpringMVC执行的流程图</p><p><img src=\"http://localhost:8081/1.jpg\"><br></p>', 0, 0, '', '6', '2021-01-08 18:00:04', NULL);
INSERT INTO `question` VALUES (78, 9, '小李', 'SpringMVC的流程', '<p>这是SpringMVC执行的流程图</p><p><img src=\"http://localhost:8081/1.jpg\"><img src=\"http://localhost:8081/2021/01/ec031c25-ccd9-4503-99c2-aa75a186575b.jpeg\"><img src=\"http://localhost:8081/2021/01/25a49c94-bfe6-41d1-892c-e1332a274b68.jpg\"><br></p>', 0, 0, '', '6', '2021-01-08 18:03:08', NULL);
INSERT INTO `question` VALUES (79, 9, '小李', 'SpringMVC的流程', '<p>这是SpringMVC执行的流程图</p><p><img src=\"http://localhost:8081/1.jpg\"></p><p><br></p><p>你的云啊</p><p><br></p><p><img src=\"http://localhost:8081/2021/01/ec031c25-ccd9-4503-99c2-aa75a186575b.jpeg\"></p><p><br></p><p>呀呼</p><p><br></p><p><img src=\"http://localhost:8081/2021/01/25a49c94-bfe6-41d1-892c-e1332a274b68.jpg\"><br></p>', 0, 0, '', '6', '2021-01-08 18:04:28', NULL);
INSERT INTO `question` VALUES (80, 9, '小李', '美文摘抄', '<blockquote>一个<span style=\"background-color: rgb(255, 0, 0);\">人</span>倘若不为自己思考，那就从未思考过。<br><ul><li>A man who does not think for himself does not think at all.</li></ul></blockquote><p><img src=\"http://localhost:8081/2021/01/ad113093-fafd-4f2b-9ec0-31d0bae7348f.jpg\"><br></p>', 0, 0, '', '1', '2021-01-08 18:55:07', NULL);
INSERT INTO `question` VALUES (83, 9, '小李', '是不是这个图', '<p>应该是把</p>', 0, 0, '', '2', '2021-01-22 14:59:30', NULL);
INSERT INTO `question` VALUES (84, 16, 'liminghang', '李明航是傻逼', '<p>李明航是个大傻逼<img src=\"http://localhost:8081/2021/03/1c50cfd3-cace-4eb6-96d9-9e0092220871.png\"></p>', 0, 0, '', '1', '2021-03-09 15:34:35', NULL);
INSERT INTO `question` VALUES (85, 9, '小李', '你学会了吗', '我已经学废了！', 0, 0, '', '1, 2', '2021-03-09 17:33:11', NULL);
INSERT INTO `question` VALUES (86, 9, '小李', '你学会了吗', '我已经学废了！', 0, 0, '', '1, 2', '2021-03-09 17:36:00', NULL);
INSERT INTO `question` VALUES (87, 9, '小李', '你学会了吗', '我已经学废了！', 0, 0, '', '1, 2', '2021-03-09 17:38:16', NULL);

-- ----------------------------
-- Table structure for question_tag
-- ----------------------------
DROP TABLE IF EXISTS `question_tag`;
CREATE TABLE `question_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question_tag
-- ----------------------------
INSERT INTO `question_tag` VALUES (1, 1, 1);
INSERT INTO `question_tag` VALUES (2, 2, 2);
INSERT INTO `question_tag` VALUES (3, 3, 1);
INSERT INTO `question_tag` VALUES (4, 4, 1);
INSERT INTO `question_tag` VALUES (5, 5, 1);
INSERT INTO `question_tag` VALUES (6, 6, 1);
INSERT INTO `question_tag` VALUES (7, 7, 4);
INSERT INTO `question_tag` VALUES (8, 8, 4);
INSERT INTO `question_tag` VALUES (9, 9, 4);
INSERT INTO `question_tag` VALUES (10, 10, 4);
INSERT INTO `question_tag` VALUES (11, 11, 4);
INSERT INTO `question_tag` VALUES (12, 12, 2);
INSERT INTO `question_tag` VALUES (13, 13, 1);
INSERT INTO `question_tag` VALUES (14, 14, 1);
INSERT INTO `question_tag` VALUES (15, 15, 1);
INSERT INTO `question_tag` VALUES (16, 16, 1);
INSERT INTO `question_tag` VALUES (17, 17, 1);
INSERT INTO `question_tag` VALUES (18, 18, 1);
INSERT INTO `question_tag` VALUES (19, 19, 2);
INSERT INTO `question_tag` VALUES (20, 20, 2);
INSERT INTO `question_tag` VALUES (21, 21, 2);
INSERT INTO `question_tag` VALUES (22, 22, 2);
INSERT INTO `question_tag` VALUES (23, 23, 2);
INSERT INTO `question_tag` VALUES (24, 24, 2);
INSERT INTO `question_tag` VALUES (25, 25, 2);
INSERT INTO `question_tag` VALUES (26, 26, 2);
INSERT INTO `question_tag` VALUES (27, 27, 2);
INSERT INTO `question_tag` VALUES (28, 28, 2);
INSERT INTO `question_tag` VALUES (29, 29, 2);
INSERT INTO `question_tag` VALUES (30, 30, 2);
INSERT INTO `question_tag` VALUES (31, 31, 3);
INSERT INTO `question_tag` VALUES (32, 32, 3);
INSERT INTO `question_tag` VALUES (33, 33, 3);
INSERT INTO `question_tag` VALUES (34, 34, 3);
INSERT INTO `question_tag` VALUES (35, 35, 1);
INSERT INTO `question_tag` VALUES (36, 36, 1);
INSERT INTO `question_tag` VALUES (37, 37, 2);
INSERT INTO `question_tag` VALUES (38, 38, 2);
INSERT INTO `question_tag` VALUES (39, 39, 2);
INSERT INTO `question_tag` VALUES (40, 39, 3);
INSERT INTO `question_tag` VALUES (41, 40, 2);
INSERT INTO `question_tag` VALUES (42, 40, 3);
INSERT INTO `question_tag` VALUES (43, 41, 2);
INSERT INTO `question_tag` VALUES (44, 42, 3);
INSERT INTO `question_tag` VALUES (45, 43, 3);
INSERT INTO `question_tag` VALUES (46, 44, 3);
INSERT INTO `question_tag` VALUES (47, 45, 5);
INSERT INTO `question_tag` VALUES (48, 46, 2);
INSERT INTO `question_tag` VALUES (49, 47, 2);
INSERT INTO `question_tag` VALUES (50, 48, 2);
INSERT INTO `question_tag` VALUES (51, 49, 3);
INSERT INTO `question_tag` VALUES (52, 50, 3);
INSERT INTO `question_tag` VALUES (53, 51, 4);
INSERT INTO `question_tag` VALUES (54, 52, 2);
INSERT INTO `question_tag` VALUES (55, 53, 2);
INSERT INTO `question_tag` VALUES (56, 54, 2);
INSERT INTO `question_tag` VALUES (57, 55, 2);
INSERT INTO `question_tag` VALUES (58, 56, 2);
INSERT INTO `question_tag` VALUES (59, 57, 2);
INSERT INTO `question_tag` VALUES (60, 57, 3);
INSERT INTO `question_tag` VALUES (61, 57, 5);
INSERT INTO `question_tag` VALUES (62, 58, 2);
INSERT INTO `question_tag` VALUES (63, 58, 4);
INSERT INTO `question_tag` VALUES (64, 59, 1);
INSERT INTO `question_tag` VALUES (65, 60, 1);
INSERT INTO `question_tag` VALUES (66, 61, 1);
INSERT INTO `question_tag` VALUES (67, 62, 1);
INSERT INTO `question_tag` VALUES (68, 62, 2);
INSERT INTO `question_tag` VALUES (69, 63, 1);
INSERT INTO `question_tag` VALUES (70, 63, 2);
INSERT INTO `question_tag` VALUES (71, 64, 1);
INSERT INTO `question_tag` VALUES (72, 64, 2);
INSERT INTO `question_tag` VALUES (73, 65, 3);
INSERT INTO `question_tag` VALUES (74, 66, 2);
INSERT INTO `question_tag` VALUES (75, 67, 1);
INSERT INTO `question_tag` VALUES (76, 68, 1);
INSERT INTO `question_tag` VALUES (77, 69, 1);
INSERT INTO `question_tag` VALUES (78, 70, 8);
INSERT INTO `question_tag` VALUES (79, 71, 1);
INSERT INTO `question_tag` VALUES (80, 72, 3);
INSERT INTO `question_tag` VALUES (81, 73, 15);
INSERT INTO `question_tag` VALUES (82, 74, 15);
INSERT INTO `question_tag` VALUES (83, 75, 3);
INSERT INTO `question_tag` VALUES (84, 76, 6);
INSERT INTO `question_tag` VALUES (85, 77, 6);
INSERT INTO `question_tag` VALUES (86, 78, 6);
INSERT INTO `question_tag` VALUES (87, 79, 6);
INSERT INTO `question_tag` VALUES (88, 80, 1);
INSERT INTO `question_tag` VALUES (89, 81, 15);
INSERT INTO `question_tag` VALUES (90, 82, 3);
INSERT INTO `question_tag` VALUES (91, 83, 9);
INSERT INTO `question_tag` VALUES (92, 84, 1);
INSERT INTO `question_tag` VALUES (93, 85, 1);
INSERT INTO `question_tag` VALUES (94, 85, 2);
INSERT INTO `question_tag` VALUES (95, 86, 1);
INSERT INTO `question_tag` VALUES (96, 86, 2);
INSERT INTO `question_tag` VALUES (97, 87, 1);
INSERT INTO `question_tag` VALUES (98, 87, 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN', '2020-12-11 14:14:30', NULL);
INSERT INTO `role` VALUES (2, 'ROLE_GENERALUSER', '2020-12-11 14:14:35', NULL);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1, '2020-12-13 21:53:07', NULL);
INSERT INTO `role_permission` VALUES (2, 1, 2, '2020-12-13 21:55:54', NULL);
INSERT INTO `role_permission` VALUES (3, 1, 3, '2020-12-13 21:55:57', NULL);
INSERT INTO `role_permission` VALUES (4, 1, 4, '2020-12-13 21:56:00', NULL);
INSERT INTO `role_permission` VALUES (5, 2, 1, '2020-12-13 21:56:02', NULL);
INSERT INTO `role_permission` VALUES (6, 2, 2, '2020-12-13 21:56:06', NULL);
INSERT INTO `role_permission` VALUES (7, 2, 3, '2020-12-13 21:56:10', NULL);
INSERT INTO `role_permission` VALUES (8, 2, 4, '2020-12-13 21:56:13', NULL);
INSERT INTO `role_permission` VALUES (9, 2, 5, '2020-12-13 21:56:17', NULL);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `created_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '生活琐事', NULL, '2020-12-17 21:18:34', NULL);
INSERT INTO `tag` VALUES (2, 'Spring', NULL, '2020-12-17 21:18:52', NULL);
INSERT INTO `tag` VALUES (3, 'Java基础', NULL, '2020-12-17 21:19:43', NULL);
INSERT INTO `tag` VALUES (4, 'Java面试', NULL, '2020-12-17 21:19:41', NULL);
INSERT INTO `tag` VALUES (5, 'JavaWeb', NULL, '2020-12-17 21:19:38', NULL);
INSERT INTO `tag` VALUES (6, 'SpringMVC', NULL, '2020-12-17 21:20:19', NULL);
INSERT INTO `tag` VALUES (7, 'SpringBoot', NULL, '2020-12-17 21:20:52', NULL);
INSERT INTO `tag` VALUES (8, '学习记录', NULL, '2020-12-17 21:21:34', NULL);
INSERT INTO `tag` VALUES (9, 'Mysql', NULL, '2021-01-02 12:16:19', NULL);
INSERT INTO `tag` VALUES (10, 'Mybatis', NULL, '2021-01-02 12:18:00', NULL);
INSERT INTO `tag` VALUES (11, 'MybatisPlus', NULL, '2021-01-02 12:51:55', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` int(11) NULL DEFAULT NULL COMMENT '用户IP',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户名',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` char(68) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电话号码',
  `type` int(11) NULL DEFAULT NULL COMMENT '0-普通用户，1-管理员',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (7, NULL, '18385244736', 'spring', '{bcrypt}$2a$10$yaPy1hn79MC84bXg.BjQJelfu5BB4UQs7q.7AWVg9huZZhrOzjL4O', '18385244736', 1, '2020-12-10 16:58:22', NULL);
INSERT INTO `user` VALUES (8, NULL, '18385244735', 'springboot', '{bcrypt}$2a$10$reRsA0MpLH5locipxRzEcucgadLf5yFBg4ZMt98ztV4bjR/hwjJpu', '18385244735', 1, '2020-12-10 17:47:24', NULL);
INSERT INTO `user` VALUES (9, NULL, '18388880000', '小李', '{bcrypt}$2a$10$Y/HuWr44D1YSM50KLnKJPeVloiNf1DGbrP8jxX2DAYr1cSXQq3UFG', '18388880000', 0, '2020-12-10 17:49:04', NULL);
INSERT INTO `user` VALUES (10, NULL, '18385244733', '阿杰', '{bcrypt}$2a$10$rdilfZ8G4N0ppjmhda.Sf.ZiHPCGxQ3g1MbC3W7sIfr4QKU92BDrq', '18385244733', 0, '2020-12-10 20:36:37', NULL);
INSERT INTO `user` VALUES (11, NULL, '18388880001', '阿杰啊', '{bcrypt}$2a$10$4rW.pcxK4K0mMbBmt5P5v.DZOMIvMajoTskV6y/OZ6H/2nc62Tr0a', '18388880001', 0, '2020-12-10 22:46:32', NULL);
INSERT INTO `user` VALUES (12, NULL, '13800138008', 'Hello', '{bcrypt}$2a$10$XLN268H.lFrazCQgnXwuZecdJB0BMxrgCoKsvQb45a0psPtJu..KW', '13800138008', 0, '2020-12-30 13:13:41', NULL);
INSERT INTO `user` VALUES (13, NULL, '18388880008', '总要抱点妄想', '{bcrypt}$2a$10$Yy/vhcdFpPem7NNyv2qCf.k44HRnM/Et5GizgCcMbZ11k4RlG4hrK', '18388880008', 0, '2020-12-30 14:34:46', NULL);
INSERT INTO `user` VALUES (14, NULL, '18388880002', '小明', '{bcrypt}$2a$10$PW15iI3oR47tC1UTdDs7POGCgbk8pwRFDsjCPWb6dN7kg.sdnZDgq', '18388880002', 0, '2021-01-22 16:49:39', NULL);
INSERT INTO `user` VALUES (15, NULL, '18385244788', '小苟', '{bcrypt}$2a$10$DjzOek5FXKXv9Cf4ZttBMeYrbLU49vuBcMliwpjLMPnL8XArdeuVy', '18385244788', 0, '2021-01-22 18:33:02', NULL);
INSERT INTO `user` VALUES (16, NULL, '18381122333', 'liminghang', '{bcrypt}$2a$10$WVRT4WkUStZDl2IXNh3gAuF4n.L89.sVvm.V4iRC4g.7il7nbRQha', '18381122333', 0, '2021-03-09 15:31:05', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 9, 1, '2020-12-11 14:20:41', NULL);
INSERT INTO `user_role` VALUES (2, 10, 1, '2020-12-11 14:21:04', NULL);
INSERT INTO `user_role` VALUES (3, 11, 2, '2020-12-13 21:58:25', NULL);
INSERT INTO `user_role` VALUES (4, 12, 2, NULL, NULL);
INSERT INTO `user_role` VALUES (5, 13, 2, NULL, NULL);
INSERT INTO `user_role` VALUES (6, 14, 2, NULL, NULL);
INSERT INTO `user_role` VALUES (7, 15, 2, NULL, NULL);
INSERT INTO `user_role` VALUES (8, 16, 2, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
