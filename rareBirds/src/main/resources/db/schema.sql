CREATE TABLE `user`
(
    `id`       bigint(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`     varchar(32) NOT NULL COMMENT 'name',
    `password` varchar(32) NOT NULL COMMENT 'password',
    `role`     varchar(32) NOT NULL COMMENT 'role',
    PRIMARY KEY (`id`),
    UNIQUE KEY `u_idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bird`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(32) NOT NULL COMMENT 'name',
    `image_id`    bigint(20) DEFAULT '0' COMMENT 'default image',
    `description` longtext    NOT NULL COMMENT 'description',
    PRIMARY KEY (`id`),
    UNIQUE KEY `u_idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `image`
(
    `id`      bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'id',
    `bird_id` bigint(20)   NOT NULL COMMENT 'bird id',
    `url`     varchar(256) NOT NULL COMMENT 'url',
    PRIMARY KEY (`id`),
    KEY       `idx_bird_id` (`bird_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `comment`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint(20) NOT NULL COMMENT 'user id',
    `bird_id` bigint(20) NOT NULL COMMENT 'bird id',
    `comment` longtext   NOT NULL COMMENT 'comment',
    PRIMARY KEY (`id`),
    KEY       `idx_bird_id` (`bird_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;