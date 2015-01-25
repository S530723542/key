drop table if exists qq_login;
create table qq_login
(
	id bigint not null auto_increment,
    user_id bigint not null,
    qq int(11) comment "用户QQ号，唯一确定一个用户",
	create_time datetime,
    motify_time datetime,
    index (qq),
    index (user_id),
    primary key (id)
)
