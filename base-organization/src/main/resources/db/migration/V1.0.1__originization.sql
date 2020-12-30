alter table user_info modify mobile varchar(11) not null comment '手机号码';
create unique index user_info_mobile_uindex on user_info (mobile);
alter table user_info modify email varchar(255) not null comment '绑定邮箱';
create unique index user_info_email_uindex on user_info (email);
create unique index user_info_name_uindex on user_info (name);