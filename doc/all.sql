DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
    `id` BIGINT NOT NULL COMMENT 'id',
    `name` VARCHAR(50) COMMENT 'name',
    `password` VARCHAR(50) COMMENT 'password',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='test';

insert into `test` (id, name, password) value (1, 'test', 'password');

DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
                        `id` BIGINT NOT NULL COMMENT 'id',
                        `name` VARCHAR(50) COMMENT 'name',
                        PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='test';

insert into `demo` (id, name) value (1, 'test');
