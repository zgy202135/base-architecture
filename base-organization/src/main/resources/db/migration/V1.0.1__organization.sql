CREATE TABLE IF NOT EXISTS user_info (
  id INT (11) not null COMMENT '主键ID',
  uuid varchar (40) not null

  PRIMARY KEY (`path_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';