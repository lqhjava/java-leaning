# java-leaning
This is  I learn java
create database if not exists shop ;
 use shop;
 
 create table goods(
	goods_id int primary key comment '商品编号',
	goods_name varchar(20) not null comment '商品名',
	goods_uniprice float(6,2) default 0 not null comment '单价',
	goods_category varchar(10) not null comment '商品类别',
	goods_providder varchar(20) comment '供应商'
 );
 
 create table custumer(
	custumer_id int not null primary key comment '客户号',
	name varchar(20) not null comment '客户姓名',
	address varchar(20) default 0 comment '客户住址',
	email int unique key not null comment '客户邮箱',
	sex enum('男','女')comment '客户性别',
	card_id int unique key comment'客户身份证'
	);
 
 
 create table purchase(
	order_id int primary key auto_increment comment '订单号',
	custumer_id int comment '客户号',
	goods_id int comment '商品号',
	nums int default 0 comment '购买数量',
	foreign key (custumer_id) references custumer(custumer_id),
	foreign key (goods_id) references goods(goods_id)
 );
