drop table if exists stock_history;
create table stock_history
(
	id bigint not null auto_increment,
    stock_exchange varchar(32) not null,
	stock_code varchar(6) not null,
	date datetime,
	open double,
	close double,
	high double,
	low double,
	volume bigint,
	index (date),
    index (stock_exchange),
	index (stock_code),
	primary key (id)
)
