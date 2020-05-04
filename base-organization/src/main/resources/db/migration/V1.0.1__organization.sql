CREATE TABLE IF NOT EXISTS user_info (
  id int(11) not null auto_increment primary key comment '主键ID',
  uuid varchar(40) not null unique comment '唯一标识',
  name varchar(255) not null comment '用户名',
  sex tinyint(4) default 0 comment '性别（0男，1女）',
  birth_date DATE default null comment '出生日期',
  login_name varchar(255) not null comment '登录名',
  password varchar(255) not null comment '登录密码',
  telephone varchar(40) default null comment '电话',
  mobile varchar(11) default null comment '手机号码',
  address varchar(255) default null comment '家庭住址',
  email varchar(255) default null comment '绑定邮箱',
  create_time DATETIME comment '创建时间',
  update_time DATETIME comment '修改时间',
  delete_flag tinyint(4) default 0 comment '删除标记（0正常，1已删除）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';