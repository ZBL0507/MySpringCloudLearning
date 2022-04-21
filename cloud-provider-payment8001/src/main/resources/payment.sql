create table payment(
    id bigint not null auto_increment primary key comment '主键id',
    serial varchar(200) default '' not null comment '支付流水号'
);
create unique index u_idx_serial on payment(serial);


