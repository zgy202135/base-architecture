
-- ----------------------------
-- Schema structure for svms_fs
-- ----------------------------
create database IF NOT EXISTS base_organization character set UTF8;
use base_organization;
set character set UTF8;
set character_set_database=UTF8;
set character_set_connection=UTF8;
set character_set_results=UTF8;
set character_set_client=UTF8;
set FOREIGN_KEY_CHECKS=0;
set AUTOCOMMIT=0;
-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
CREATE TABLE IF NOT EXISTS `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE IF NOT EXISTS user_info (
  id int(11) not null auto_increment primary key comment '主键ID',
  uuid varchar(40) not null unique comment '唯一标识',
  name varchar(255) not null comment '用户名',
  nickname varchar(255) default null comment '昵称',
  sex tinyint(4) default 0 comment '性别（0男，1女,2未知）',
  birth_date DATE default null comment '出生日期',
  login_name varchar(255) not null comment '登录名',
  password varchar(255) not null comment '登录密码',
  telephone varchar(40) default null comment '电话',
  mobile varchar(11) default null comment '手机号码',
  address varchar(255) default null comment '家庭住址',
  email varchar(255) default null comment '绑定邮箱',
  token varchar(500) not null comment '令牌',
  photo varchar(255) default null comment '头像',
  department_uuid varchar(40) default null comment '组织唯一标识',
  role_uuid varchar(40) default null comment '角色唯一标识',
  id_card varchar(20) default null comment '身份证号码',
  enable_flag tinyint(4) default 0 comment '启用标记（0启用，1不启用）',
  delete_flag tinyint(4) default 0 comment '删除标记（0正常，1已删除）',
  create_time DATETIME comment '创建时间',
  update_time DATETIME comment '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';

create table IF NOT EXISTS department_info(
  id int(11) not null auto_increment primary key comment '主键ID',
  uuid varchar(40) unique not null comment '唯一标识',
  name varchar(255) default null comment '部门名称',
  alias_name varchar(128) default null comment '部门别称',
  parent_id int(11) default null comment '父ID',
  parent_uuid varchar(40) default null comment '父唯一标识',
  create_time datetime default null comment '创建时间',
  update_time datetime default null comment '更新时间',
  enable_flag tinyint(4) default 0 comment '启用标志（0-启用，1-停用）'
)engine =InnoDB default char set =utf8 comment '部门信息表';


create table IF NOT EXISTS role_info(
  id int(11) not null auto_increment primary key comment '主键ID',
  uuid varchar(40) unique not null comment '唯一标识',
  name varchar(255) default null comment '角色名称',
  alias_name varchar(128) default null comment '角色别名',
  create_time datetime default null comment '创建时间',
  update_time datetime default null comment '更新时间',
  enable_flag tinyint(4) default 0 comment '启用标志（0-启用，1-停用）'
)engine =InnoDB default char set =utf8 comment '角色信息表';