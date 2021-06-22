DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
    `id` BIGINT NOT NULL COMMENT 'id',
    `name` VARCHAR(50) COMMENT 'name',
    `password` VARCHAR(50) COMMENT 'password',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='test';

INSERT INTO `test` (id, name, password) VALUES (1, 'test', 'password');

###

DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
                        `id` BIGINT NOT NULL COMMENT 'id',
                        `name` VARCHAR(50) COMMENT 'name',
                        PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='test';

INSERT INTO `demo` (id, name) VALUES (1, 'test');

###

DROP TABLE IF EXISTS `ebook`;
CREATE TABLE `ebook` (
    `id` BIGINT NOT NULL COMMENT 'id',
    `name` varchar(50) COMMENT '名称',
    `category1_id` BIGINT COMMENT '分类 1',
    `category2_id` BIGINT COMMENT '分类 2',
    `description` varchar(200) COMMENT '描述',
    `cover` varchar(200) COMMENT '封面',
    `doc_count` INT COMMENT '文档数',
    `view_count` INT COMMENT '阅读数',
    `vote_count` INT COMMENT '点赞数',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='电子书';

INSERT INTO `ebook` (id, name, description) VALUES (1, 'Spring Boot 入门教程', '零基础入门 Java 开发，企业级应用开发最佳首选框架');
INSERT INTO `ebook` (id, name, description) VALUES (2, 'Vue 入门教程', '零基础入门 Vue 开发，企业级应用开发最佳首选框架');
INSERT INTO `ebook` (id, name, description) VALUES (3, 'Python 入门教程', '零基础入门 Python 开发，企业级应用开发最佳首选框架');
INSERT INTO `ebook` (id, name, description) VALUES (4, 'Mysql 入门教程', '零基础入门 Mysql 开发，企业级应用开发最佳首选框架');
INSERT INTO `ebook` (id, name, description) VALUES (5, 'Oracle 入门教程', '零基础入门 Oracle 开发，企业级应用开发最佳首选框架');
