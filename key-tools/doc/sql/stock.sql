create table stock
(
	id bigint not null auto_increment,
	name varchar(32) not null,
    stock_exchange varchar(32) not null,
	stock_code varchar(6) not null,
	create_time datetime,
    motify_time datetime,
    index (stock_exchange),
	index (stock_code),
	unique key (stock_exchange,stock_code),
    primary key (id)
)