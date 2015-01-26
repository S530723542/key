drop table if exists Cookie;
create table Cookie(
	user_id bigint not null,
	cookie varchar(4096) not null,
	create_time datetime,
	last_time datetime,
	index (user_id,cookie)
)