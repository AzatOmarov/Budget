create table transaction
(
  id           bigint auto_increment primary key,
  amount       float        not null,
  wallet_id    bigint       null,
  description  varchar(255) null,
  category_id  bigint       null,
  created_date datetime     not null,
  updated_date datetime     not null

)
  engine = MyISAM;

insert into transaction (amount, wallet_id, description, category_id, created_date,  updated_date)
values ('15', 1, 2, 'Berlin - Dresden', '2019-03-19', '2019-03-19');

insert into transaction (amount, wallet_id, description, category_id, created_date,  updated_date)
values ('35', 1, 2, 'Dresden - Koln', '2019-03-20', '2019-03-20');

insert into transaction (amount, wallet_id, description, category_id, created_date,  updated_date)
values ('60', 1, 2, 'Koln - Berlin', '2019-03-22', '2019-03-22');
