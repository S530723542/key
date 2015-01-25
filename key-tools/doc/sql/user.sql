drop table if exists user;
create table user
(
	id bigint not null auto_increment,
    user_name varchar(128) default null comment "用户登录名，唯一确定一个用户",
    email varchar(128) default null comment "用户邮箱，唯一确定一个用户",
    phone int(11) comment "用户手机号，唯一确定一个用户",
    password varchar(128) default null comment "用户密码",
	create_time datetime,
    motify_time datetime,
    is_delete tinyint,
    index (user_name),
    index (email),
    index (phone),
    primary key (id)
)