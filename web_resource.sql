/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : web_resource

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-08-12 22:45:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) NOT NULL,
  `category_desc` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`category_id`,`category_name`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'IT', 'IT');
INSERT INTO `category` VALUES ('2', 'Java', 'Java');
INSERT INTO `category` VALUES ('3', 'C++', 'C++');
INSERT INTO `category` VALUES ('4', 'PHP', 'PHP');
INSERT INTO `category` VALUES ('5', 'Python', 'Python');
INSERT INTO `category` VALUES ('6', 'Oracle', 'Oracle');
INSERT INTO `category` VALUES ('7', 'Hadoop', 'Hadoop');
INSERT INTO `category` VALUES ('8', 'ASP.NET', 'ASP.NET');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_uid` varchar(20) NOT NULL,
  `collect_rid` int(10) NOT NULL,
  PRIMARY KEY (`collect_uid`,`collect_rid`),
  KEY `collect_ibfk_2` (`collect_rid`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`collect_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collect_ibfk_2` FOREIGN KEY (`collect_rid`) REFERENCES `resource` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('teacher1', '1');
INSERT INTO `collect` VALUES ('zhangwenyu', '1');
INSERT INTO `collect` VALUES ('teacher1', '2');
INSERT INTO `collect` VALUES ('zhangwenyu', '2');
INSERT INTO `collect` VALUES ('teacher1', '4');
INSERT INTO `collect` VALUES ('zhangwenyu', '5');
INSERT INTO `collect` VALUES ('zhangwenyu', '6');
INSERT INTO `collect` VALUES ('zhangwenyu', '10');
INSERT INTO `collect` VALUES ('zhangwenyu', '36');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT,
  `comment_pid` int(10) NOT NULL,
  `comment_uid` varchar(20) NOT NULL,
  `comment_text` varchar(250) NOT NULL,
  `comment_time` date NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_uid` (`comment_uid`),
  KEY `comment_pid` (`comment_pid`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`comment_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`comment_pid`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('4', '5', 'student3', '评论来了！', '2019-01-08');
INSERT INTO `comment` VALUES ('5', '6', 'student3', '踩踩', '2019-01-08');
INSERT INTO `comment` VALUES ('6', '6', 'student3', '评论来了啊', '2019-01-08');
INSERT INTO `comment` VALUES ('7', '6', 'student3', '1111', '2019-01-08');
INSERT INTO `comment` VALUES ('8', '5', 'zhangwenyu', '111', '2019-08-03');
INSERT INTO `comment` VALUES ('9', '3', 'zhangwenyu', 'hahahhaah', '2019-08-06');
INSERT INTO `comment` VALUES ('11', '7', 'zhangwenyu', '哈哈哈哈', '2019-08-10');
INSERT INTO `comment` VALUES ('12', '7', 'zhangwenyu', '哈哈哈哈', '2019-08-10');
INSERT INTO `comment` VALUES ('13', '7', 'zhangwenyu', '哈哈哈哈', '2019-08-10');
INSERT INTO `comment` VALUES ('14', '2', 'zhangwenyu', '啦啦啦', '2019-08-10');
INSERT INTO `comment` VALUES ('15', '9', 'zhangwenyu', 'lalalala', '2019-08-11');
INSERT INTO `comment` VALUES ('16', '9', 'zhangwenyu', 'woqu', '2019-08-11');
INSERT INTO `comment` VALUES ('17', '9', 'zhangwenyu', 'lala', '2019-08-11');
INSERT INTO `comment` VALUES ('18', '9', 'zhangwenyu', 'lallal', '2019-08-11');
INSERT INTO `comment` VALUES ('19', '5', 'zhangwenyu', 'lalala', '2019-08-11');
INSERT INTO `comment` VALUES ('20', '7', 'student1', '牛逼', '2019-08-11');
INSERT INTO `comment` VALUES ('21', '4', 'zhangwenyu', 'lalaal', '2019-08-11');
INSERT INTO `comment` VALUES ('22', '4', 'zhangwenyu', '我是谁？？？', '2019-08-11');
INSERT INTO `comment` VALUES ('23', '5', 'zhangwenyu', '我又来啦！！！！', '2019-08-11');
INSERT INTO `comment` VALUES ('24', '10', 'zhangwenyu', '啦啦啦啦', '2019-08-11');
INSERT INTO `comment` VALUES ('35', '3', 'zhangwenyu', '啦啦啦啦啦啦', '2019-08-12');
INSERT INTO `comment` VALUES ('36', '11', 'zhangwenyu', 'lallala', '2019-08-12');

-- ----------------------------
-- Table structure for `follow`
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `follow_uid` varchar(20) NOT NULL,
  `followed_uid` varchar(20) NOT NULL,
  PRIMARY KEY (`follow_uid`,`followed_uid`),
  KEY `followed_uid` (`followed_uid`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`follow_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`followed_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('student1', 'student1');
INSERT INTO `follow` VALUES ('zhangwenyu', 'student1');
INSERT INTO `follow` VALUES ('student1', 'student2');
INSERT INTO `follow` VALUES ('teacher1', 'student2');
INSERT INTO `follow` VALUES ('zhangwenyu', 'student2');
INSERT INTO `follow` VALUES ('student1', 'teacher1');
INSERT INTO `follow` VALUES ('teacher1', 'teacher1');
INSERT INTO `follow` VALUES ('zhangwenyu', 'teacher1');

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(10) NOT NULL AUTO_INCREMENT,
  `post_uid` varchar(20) NOT NULL,
  `post_title` varchar(100) NOT NULL,
  `post_text` varchar(500) NOT NULL,
  `post_image` varchar(500) DEFAULT NULL,
  `post_time` date NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `post_uid` (`post_uid`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`post_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('2', 'student1', '第二个帖子', '第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子，第二个帖子。', 'upload/images/psb1.jpg', '2019-01-05');
INSERT INTO `post` VALUES ('3', 'teacher1', '第三个帖子', '第三个帖子，第三个帖子，第三个帖子，第三个帖子', 'upload/images/post3.png', '2019-01-08');
INSERT INTO `post` VALUES ('4', 'teacher1', '第四个帖子', '第四个帖子，第四个帖子，第四个帖子，第四个帖子，第四个帖子', 'upload/images/post4.png', '2019-01-08');
INSERT INTO `post` VALUES ('5', 'student2', '第五个帖子', '第五个帖子，第五个帖子，第五个帖子，第五个帖子，第五个帖子', 'upload/images/post5.png', '2019-01-08');
INSERT INTO `post` VALUES ('6', 'student3', '第六个帖子', '第六个帖子，第六个帖子，第六个帖子，第六个帖子，第六个帖子', 'upload/images/post6.png', '2019-01-08');
INSERT INTO `post` VALUES ('7', 'zhangwenyu', '我是哈哈哈哈', '哈哈啊哈哈哈', 'upload/images/10287_123.jpg', '2019-08-10');
INSERT INTO `post` VALUES ('9', 'zhangwenyu', '我要发帖子', '我要发帖子', 'upload/images/0fbf7_160803张文宇2018-2019学年第一学期成绩.png', '2019-08-11');
INSERT INTO `post` VALUES ('10', 'zhangwenyu', '我是谁？', '我是谁？', 'upload/images/02a7c_360截图20180821211132362.jpg', '2019-08-11');
INSERT INTO `post` VALUES ('11', 'zhangwenyu', '111', '1111', 'upload/images/ded10_123.jpg', '2019-08-12');

-- ----------------------------
-- Table structure for `register`
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `register_id` varchar(20) NOT NULL,
  `register_password` varchar(20) NOT NULL,
  `register_name` varchar(20) DEFAULT NULL,
  `register_class` varchar(20) DEFAULT NULL,
  `register_level` varchar(20) NOT NULL DEFAULT 'student',
  `register_check` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('123456', '123456', null, '', '教师', '0');
INSERT INTO `register` VALUES ('1234567', '123456', null, '160803', '学生', '0');
INSERT INTO `register` VALUES ('1234568', '123456', null, '', '教师', '0');
INSERT INTO `register` VALUES ('student', '123456', null, '160803', '学生', '0');
INSERT INTO `register` VALUES ('student2', '123456', 'student2', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student3', '123456', 'student3', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student4', '123456', 'student4', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student5', '123456', 'student5', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student6', '123456', 'student6', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student7', '123456', 'student7', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student8', '123456', 'student8', '160803', '学生', '1');
INSERT INTO `register` VALUES ('student9', '123456', 'student9', '160803', '学生', '1');
INSERT INTO `register` VALUES ('teacher1', '123456', null, '', '教师', '0');
INSERT INTO `register` VALUES ('teacher2', '123456', 'teacher2', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher3', '123456', 'teacher3', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher4', '123456', 'teacher4', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher5', '123456', 'teacher5', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher6', '123456', 'teacher6', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher7', '123456', 'teacher7', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher8', '123456', 'teacher8', '', '教师', '1');
INSERT INTO `register` VALUES ('teacher9', '123456', 'teacher9', '', '教师', '1');
INSERT INTO `register` VALUES ('zhangwenyu', '123456', 'zhangwenyu', '160803', '学生', '1');
INSERT INTO `register` VALUES ('zhangyu', '123456', null, '', '教师', '0');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resource_id` int(10) NOT NULL AUTO_INCREMENT,
  `resource_cid` int(10) NOT NULL,
  `resource_uid` varchar(20) NOT NULL,
  `resource_name` varchar(20) NOT NULL,
  `resource_image` varchar(500) DEFAULT NULL,
  `resource_url` varchar(250) NOT NULL,
  `resource_desc` varchar(250) DEFAULT NULL,
  `resource_level` varchar(10) NOT NULL DEFAULT '初级',
  `resource_time` date NOT NULL,
  `resource_good` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`resource_id`),
  KEY `resource_cid` (`resource_cid`),
  KEY `resource_uid` (`resource_uid`),
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`resource_cid`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE,
  CONSTRAINT `resource_ibfk_2` FOREIGN KEY (`resource_uid`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '2', 'teacher1', '第一个资源', 'upload/images/QQͼƬ20170830115707.jpg', 'upload/resources/web_education.sql', '第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源，第一个资源。', '中级', '2019-01-05', '1');
INSERT INTO `resource` VALUES ('2', '1', 'student1', '第二个资源', 'upload/images/Scan0006.jpg', 'upload/resources/student.doc', '第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源，第二个资源。', '初级', '2019-01-05', '1');
INSERT INTO `resource` VALUES ('4', '3', 'student2', '第三个资源', 'upload/images/student.png', 'upload/resources/student.zip', '第三个资源，第三个资源，第三个资源，第三个资源！', '初级', '2019-01-08', '0');
INSERT INTO `resource` VALUES ('5', '6', 'student2', '第四个资源', 'upload/images/wms.png', 'upload/resources/wms.sql', '第四个资源，第四个资源，第四个资源，第四个资源，第四个资源！', '初级', '2019-01-08', '0');
INSERT INTO `resource` VALUES ('6', '7', 'student2', '第五个资源', 'upload/images/hadoop.png', 'upload/resources/hadoop.doc', '第五个资源，第五个资源，第五个资源，第五个资源第五个资源！', '初级', '2019-01-08', '0');
INSERT INTO `resource` VALUES ('7', '1', 'student3', '第六个资源', 'upload/images/System.png', 'upload/resources/System.zip', '第六个资源，第六个资源，第六个资源，第六个资源', '初级', '2019-01-08', '0');
INSERT INTO `resource` VALUES ('8', '8', 'teacher1', '第七个资源', 'upload/images/web.png', 'upload/resources/Web.zip', '第七个资源，第七个资源，第七个资源，第七个资源，第七个资源', '初级', '2019-01-08', '0');
INSERT INTO `resource` VALUES ('9', '1', 'student3', '第八个资源', 'upload/images/libraryER.png', 'upload/resources/libraryER.vsd', '第八个资源，第八个资源，第八个资源，第八个资源', '初级', '2019-01-08', '0');
INSERT INTO `resource` VALUES ('10', '2', 'student3', '第九个资源', 'upload/images/student_information.png', 'upload/resources/student_information.zip', '第九个资源，第九个资源，第九个资源，第九个资源，第九个资源', '中级', '2019-01-08', '1');
INSERT INTO `resource` VALUES ('36', '1', 'zhangwenyu', '第十个资源', 'upload/images/ad68d_360截图20171125104227197.jpg', 'upload/resources/ad68d_25张文宇.zip', '第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源第十个资源', '初级', '2019-08-11', '0');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(20) NOT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `student_sex` varchar(10) DEFAULT NULL,
  `student_birth` date DEFAULT NULL,
  `student_class` varchar(20) NOT NULL,
  `student_desc` varchar(150) DEFAULT NULL,
  KEY `student_id` (`student_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('student1', 'student1', '男', '2019-01-05', '160803', '我是student1！我是student1！我是student1！我是student1！我是哈哈哈、');
INSERT INTO `student` VALUES ('student2', 'student2', '男', '2019-01-02', '160803', '我是student2！我是student2！我是student2！我是student2！我是student2！');
INSERT INTO `student` VALUES ('student3', 'student3', '男', '2019-01-03', '160803', '我是student3！我是student3！我是student3！我是student3！');
INSERT INTO `student` VALUES ('student4', 'student4', null, null, '160803', null);
INSERT INTO `student` VALUES ('student5', 'student5', null, null, '160803', null);
INSERT INTO `student` VALUES ('student6', 'student6', null, null, '160803', null);
INSERT INTO `student` VALUES ('student7', 'student7', null, null, '160803', null);
INSERT INTO `student` VALUES ('student8', 'student8', null, null, '160803', null);
INSERT INTO `student` VALUES ('student9', 'student9', null, null, '160803', null);
INSERT INTO `student` VALUES ('zhangwenyu', '张文宇', '女', '2019-08-04', '160803', '啦啦啦啦啦啦');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` varchar(20) NOT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `teacher_sex` varchar(10) DEFAULT NULL,
  `teacher_birth` date DEFAULT NULL,
  `teacher_desc` varchar(150) DEFAULT NULL,
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('teacher1', 'teacher1', '女', '2019-01-05', '我是teacher1！我是teacher1！我是teacher1！我是teacher1！我是teacher1！');
INSERT INTO `teacher` VALUES ('teacher2', 'teacher2', '男', '2019-01-01', '我是teacher2！我是teacher2！我是teacher2！我是teacher2！我是teacher2！我是teacher2！');
INSERT INTO `teacher` VALUES ('teacher3', 'teacher3', '女', '2019-01-01', '我是teacher3！我是teacher3！我是teacher3！我是teacher3！我是teacher3！我是teacher3！我是teacher3！');
INSERT INTO `teacher` VALUES ('teacher4', 'teacher4', null, null, null);
INSERT INTO `teacher` VALUES ('teacher5', 'teacher5', null, null, null);
INSERT INTO `teacher` VALUES ('teacher6', 'teacher6', null, null, null);
INSERT INTO `teacher` VALUES ('teacher7', 'teacher7', null, null, null);
INSERT INTO `teacher` VALUES ('teacher8', 'teacher8', null, null, null);
INSERT INTO `teacher` VALUES ('teacher9', 'teacher9', null, null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_level` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', '管理员');
INSERT INTO `user` VALUES ('ethan', '123456', '超级管理员');
INSERT INTO `user` VALUES ('student1', '123456', '学生');
INSERT INTO `user` VALUES ('student2', '123456', '学生');
INSERT INTO `user` VALUES ('student3', '123456', '学生');
INSERT INTO `user` VALUES ('student4', '123456', '学生');
INSERT INTO `user` VALUES ('student5', '123456', '学生');
INSERT INTO `user` VALUES ('student6', '123456', '学生');
INSERT INTO `user` VALUES ('student7', '123456', '学生');
INSERT INTO `user` VALUES ('student8', '123456', '学生');
INSERT INTO `user` VALUES ('student9', '123456', '学生');
INSERT INTO `user` VALUES ('teacher1', '123456', '教师');
INSERT INTO `user` VALUES ('teacher2', '123456', '教师');
INSERT INTO `user` VALUES ('teacher3', '123456', '教师');
INSERT INTO `user` VALUES ('teacher4', '123456', '教师');
INSERT INTO `user` VALUES ('teacher5', '123456', '教师');
INSERT INTO `user` VALUES ('teacher6', '123456', '教师');
INSERT INTO `user` VALUES ('teacher7', '123456', '教师');
INSERT INTO `user` VALUES ('teacher8', '123456', '教师');
INSERT INTO `user` VALUES ('teacher9', '123456', '教师');
INSERT INTO `user` VALUES ('zhangwenyu', '123456', '学生');
