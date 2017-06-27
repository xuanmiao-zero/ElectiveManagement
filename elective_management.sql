-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2017 年 06 月 03 日 02:33
-- 服务器版本: 5.5.53
-- PHP 版本: 5.4.45

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `elective_management`
--

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `class_id` varchar(6) NOT NULL,
  `class_name` varchar(40) NOT NULL,
  `class_hours` int(4) NOT NULL,
  `class_credit` float NOT NULL,
  `class_intro` text NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `class`
--

INSERT INTO `class` (`class_id`, `class_name`, `class_hours`, `class_credit`, `class_intro`) VALUES
('001', 'C语言', 96, 8, '基础课程'),
('002', '数据结构', 64, 6, '巩固提高课程'),
('003', '算法设计与分析', 64, 4, '精品课程'),
('004', 'javaWeb', 64, 4, '综合应用课程');

-- --------------------------------------------------------

--
-- 表的结构 `elective_info`
--

CREATE TABLE IF NOT EXISTS `elective_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` char(13) NOT NULL,
  `student_id` char(6) NOT NULL,
  `score` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_elective_info` (`class_id`),
  KEY `FK_elective_info1` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`id`, `name`, `password`) VALUES
(4, 'xuanmiao', 'xuanmiao'),
(5, '111111', '111111'),
(6, '111111', '111111');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` char(13) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`student_id`, `name`, `password`) VALUES
('', '', ''),
('1002', '轩和', '1234'),
('1004', '欣蓝卡', '1234'),
('1007', '吉萨阿', '4875s'),
('111111', '111111', '111111'),
('1234', '就开了', '1234'),
('4', '5', '4');

--
-- 限制导出的表
--

--
-- 限制表 `elective_info`
--
ALTER TABLE `elective_info`
  ADD CONSTRAINT `FK_elective_info` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `FK_elective_info1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
