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

### 分类
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
    `id` BIGINT NOT NULL COMMENT 'id',
    `parent` BIGINT NOT NULL DEFAULT 0 COMMENT '父 id',
    `name` VARCHAR(50) NOT NULL COMMENT '名称',
    `sort` INT COMMENT '顺序'
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='分类';

INSERT INTO `category` (id, parent, name, sort) VALUES (100, 000, '前端开发', 100);
INSERT INTO `category` (id, parent, name, sort) VALUES (101, 100, 'Vue', 101);
INSERT INTO `category` (id, parent, name, sort) VALUES (102, 100, 'HTML & CSS', 102);
INSERT INTO `category` (id, parent, name, sort) VALUES (200, 000, 'Java', 200);
INSERT INTO `category` (id, parent, name, sort) VALUES (201, 200, '基础应用', 201);
INSERT INTO `category` (id, parent, name, sort) VALUES (202, 200, '框架应用', 202);
INSERT INTO `category` (id, parent, name, sort) VALUES (300, 000, 'Python', 300);
INSERT INTO `category` (id, parent, name, sort) VALUES (301, 300, '基础应用', 301);
INSERT INTO `category` (id, parent, name, sort) VALUES (302, 300, '进阶方向应用', 302);
INSERT INTO `category` (id, parent, name, sort) VALUES (400, 000, '数据库', 400);
INSERT INTO `category` (id, parent, name, sort) VALUES (401, 400, 'MySQL', 401);
INSERT INTO `category` (id, parent, name, sort) VALUES (500, 000, '其它', 500);
INSERT INTO `category` (id, parent, name, sort) VALUES (501, 500, '服务器', 501);
INSERT INTO `category` (id, parent, name, sort) VALUES (502, 500, '开发工具', 502);
INSERT INTO `category` (id, parent, name, sort) VALUES (503, 500, '热门服务端语言', 503);
