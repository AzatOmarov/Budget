create table wallet
(
  id           bigint       not null auto_increment    primary key,
  currency     varchar(255) null,
  updated_date datetime     not null,
  user_id      bigint       not null
)
  engine = MyISAM;

insert into wallet (currency, updated_date, user_id)
values ('USD', '2019-03-18', 1);