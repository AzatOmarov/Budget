create table transaction
(
  id           bigint auto_increment primary key,
  custom_date  datetime     not null,
  amount       float        not null,
  wallet_id    bigint       null,
  category_id  bigint       null,
  description  varchar(255) not null,
  created_date datetime     not null,
  updated_date datetime     not null

)
  engine = MyISAM;

insert into transaction (amount, custom_date, wallet_id, category_id, description, created_date, updated_date)
values ('100', '2019-03-19', 1, 4, 'Berlin - Dresden', '2019-03-19', '2019-03-19');