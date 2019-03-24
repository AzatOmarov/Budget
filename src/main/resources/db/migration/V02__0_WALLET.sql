create table wallet
(
  id           bigint       not null auto_increment    primary key,
  user_id      bigint       null,
  currency     varchar(255) null
)
  engine = MyISAM;

insert into wallet (user_id, currency)
values (1, 'USD');