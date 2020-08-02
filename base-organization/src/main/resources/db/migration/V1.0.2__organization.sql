create table department_info(
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


create table role_info(
  id int(11) not null auto_increment primary key comment '主键ID',
  uuid varchar(40) unique not null comment '唯一标识',
  name varchar(255) default null comment '角色名称',
  alias_name varchar(128) default null comment '角色别名',
  create_time datetime default null comment '创建时间',
  update_time datetime default null comment '更新时间',
  enable_flag tinyint(4) default 0 comment '启用标志（0-启用，1-停用）'
)engine =InnoDB default char set =utf8 comment '角色信息表';


