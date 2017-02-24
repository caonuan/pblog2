/*
Navicat MySQL Data Transfer

Source Server         : 121.42.40.136
Source Server Version : 50714
Source Host           : 121.42.40.136:3306
Source Database       : pblog

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-02-24 19:05:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Album
-- ----------------------------
DROP TABLE IF EXISTS `Album`;
CREATE TABLE `Album` (
  `albumId` int(11) NOT NULL AUTO_INCREMENT,
  `albumName` varchar(255) DEFAULT NULL,
  `albumUrl` varchar(255) DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  PRIMARY KEY (`albumId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for AlbumReply
-- ----------------------------
DROP TABLE IF EXISTS `AlbumReply`;
CREATE TABLE `AlbumReply` (
  `albumReplyId` int(11) NOT NULL AUTO_INCREMENT,
  `albumId` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `receiveId` int(11) DEFAULT NULL,
  `visitorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`albumReplyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Article
-- ----------------------------
DROP TABLE IF EXISTS `Article`;
CREATE TABLE `Article` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `blogClassId` int(11) DEFAULT NULL,
  `content` text,
  `publishDate` datetime DEFAULT NULL,
  `readCount` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `topPost` tinyint(4) DEFAULT '0',
  `hidden` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`articleId`),
  FULLTEXT KEY `fulltext_article` (`content`,`title`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Article_backups
-- ----------------------------
DROP TABLE IF EXISTS `Article_backups`;
CREATE TABLE `Article_backups` (
  `backupId` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) NOT NULL DEFAULT '0',
  `blogClassId` int(11) DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `publishDate` datetime DEFAULT NULL,
  `readCount` int(11) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `topPost` tinyint(4) DEFAULT '0',
  `hidden` tinyint(4) DEFAULT '0',
  `trigger_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `type` tinyint(4) DEFAULT NULL COMMENT '0为插入，1为更新',
  PRIMARY KEY (`backupId`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for ArticleReply
-- ----------------------------
DROP TABLE IF EXISTS `ArticleReply`;
CREATE TABLE `ArticleReply` (
  `articleReplyId` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `publishTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `receiveId` int(11) DEFAULT NULL,
  `visitorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`articleReplyId`)
) ENGINE=InnoDB AUTO_INCREMENT=1299 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for BlogClass
-- ----------------------------
DROP TABLE IF EXISTS `BlogClass`;
CREATE TABLE `BlogClass` (
  `blogClassId` int(11) NOT NULL AUTO_INCREMENT,
  `classNames` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`blogClassId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for IPInfo
-- ----------------------------
DROP TABLE IF EXISTS `IPInfo`;
CREATE TABLE `IPInfo` (
  `ip` varchar(40) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `country_id` varchar(10) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  `area_id` varchar(10) DEFAULT NULL,
  `region` varchar(20) DEFAULT NULL,
  `region_id` varchar(10) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `city_id` varchar(10) DEFAULT NULL,
  `county` varchar(30) DEFAULT NULL,
  `county_id` varchar(10) DEFAULT NULL,
  `isp` varchar(50) DEFAULT NULL,
  `isp_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Note
-- ----------------------------
DROP TABLE IF EXISTS `Note`;
CREATE TABLE `Note` (
  `noteId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  `receiveId` int(11) DEFAULT NULL,
  `visitorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Photo
-- ----------------------------
DROP TABLE IF EXISTS `Photo`;
CREATE TABLE `Photo` (
  `photoId` int(11) NOT NULL AUTO_INCREMENT,
  `albumId` int(11) DEFAULT NULL,
  `photoName` varchar(255) DEFAULT NULL,
  `publishDate` timestamp NULL DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`photoId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Statistics
-- ----------------------------
DROP TABLE IF EXISTS `Statistics`;
CREATE TABLE `Statistics` (
  `statisticsId` int(11) NOT NULL AUTO_INCREMENT,
  `sumAccess` int(11) DEFAULT NULL,
  `todayAccess` int(11) DEFAULT NULL,
  PRIMARY KEY (`statisticsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Visit
-- ----------------------------
DROP TABLE IF EXISTS `Visit`;
CREATE TABLE `Visit` (
  `visitId` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(40) NOT NULL,
  `time` datetime NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`visitId`),
  KEY `FK_2yjxddhbojdl5c6v0i78lqqfi` (`ip`),
  CONSTRAINT `FK_2yjxddhbojdl5c6v0i78lqqfi` FOREIGN KEY (`ip`) REFERENCES `IPInfo` (`ip`)
) ENGINE=InnoDB AUTO_INCREMENT=124330 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Visitor
-- ----------------------------
DROP TABLE IF EXISTS `Visitor`;
CREATE TABLE `Visitor` (
  `visitorId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`visitorId`)
) ENGINE=InnoDB AUTO_INCREMENT=647 DEFAULT CHARSET=utf8;
DROP TRIGGER IF EXISTS `Article_backup_trigger`;
DELIMITER ;;
CREATE TRIGGER `Article_backup_trigger` AFTER INSERT ON `Article` FOR EACH ROW begin
	insert into Article_backups value(null,new.articleId,new.blogClassId,new.content,new.publishDate,new.readCount,
	new.title,new.updateDate,new.topPost,new.hidden,SYSDATE(),0);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `Article_backup_update_trigger`;
DELIMITER ;;
CREATE TRIGGER `Article_backup_update_trigger` AFTER UPDATE ON `Article` FOR EACH ROW BEGIN IF new.articleId != old.articleId
or new.blogClassId != old.blogClassId
or new.content != old.content
or new.publishDate != old.publishDate
or new.title != old.title
or new.updateDate != old.updateDate
or new.topPost != old.topPost
or new.hidden != old.hidden THEN INSERT
    INTO
        Article_backups VALUE(
            NULL,
            new.articleId,
            new.blogClassId,
            new.content,
            new.publishDate,
            new.readCount,
            new.title,
            new.updateDate,
            new.topPost,
            new.hidden,
            SYSDATE(),
            1
        );
END IF;
END
;;
DELIMITER ;
