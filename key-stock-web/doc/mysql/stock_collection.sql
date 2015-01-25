create table stock_collect(
	id bigint not null auto_increment,
	user_id bigint not null,
	stock_id bigint not null,
	priority int(11) not null,
	create_time datetime,
    motify_time datetime,
	is_delete tinyint default 0,
	index(user_id),
	unique key (user_id,stock_id),
    primary key (id)
)