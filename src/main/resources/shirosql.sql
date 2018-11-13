create database shirodemo;

use shirodemo;

drop table if exists `sys_permission`;

CREATE TABLE `sys_permission` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(50) NOT NULL COMMENT '操作名称',
    `permission` varchar(50) NOT NULL COMMENT '权限',
    `url` varchar(50) NOT NULL COMMENT '权限页面跳转链接',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

drop table if exists `sys_role_permission`;

create table `sys_role_permission`(
	`permission_id` int(11) NOT NULL COMMENT '权限id',
    `role_id` int(11) NOT NULL COMMENT '角色id',
    UNIQUE KEY `srp_UNIQUE` (`permission_id`,`role_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限角色表';

drop table if exists `sys_role`;

create table `sys_role`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `available` int(11) NOT NULL COMMENT '是否有效(1.开启,2.禁用)',
    `description` varchar(50) DEFAULT NULL COMMENT '拥有角色描述',
    `role` varchar(50) NOT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

drop table if exists `sys_user_role`;

create table `sys_user_role`(
	`role_id` int(11) NOT NULL COMMENT '角色id',
    `uid` int(11) NOT NULL COMMENT '用户id',
	UNIQUE KEY `sur_UNIQUE` (`role_id`,`uid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

drop table if exists `user_info`;

create table `user_info` (
	`uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name` varchar(50) NOT NULL COMMENT '用户别名',
    `password` varchar(50) NOT NULL COMMENT '用户密码',
	`salt` varchar(50) NOT NULL COMMENT '盐',
	`state` varchar(1) NOT NULL COMMENT '用户可用状态（1-可用，0-禁用）',
    `username` varchar(20) NOT NULL COMMENT '用户名',
    PRIMARY KEY (`uid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `user_info` VALUES ('1', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', 'admin');
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role` VALUES ('1', '1', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '1', 'VIP会员', 'vip');
INSERT INTO `sys_permission` VALUES ('1', '用户管理', 'userInfo:view', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES ('2', '用户添加', 'userInfo:add', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES ('3', '用户删除', 'userInfo:del', 'userInfo/userDel');