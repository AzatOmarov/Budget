create table transaction
(
  id           bigint auto_increment primary key,
  amount       float        not null,
  created_date datetime     not null,
  description  varchar(255) null,
  updated_date datetime     not null,
  wallet_id    bigint       null,
  category_id  bigint       null

)
  engine = MyISAM;

insert into transaction (amount, created_date, description, updated_date, wallet_id, category_id)
values ('15', '2019-03-19', 'Transport', '2019-03-19', 1, 2);

insert into transaction (amount, created_date, description, updated_date, wallet_id, category_id)
values ('100', '2019-03-20', 'SocialLife', '2019-03-20', 1, 2);

insert into transaction (amount, created_date, description, updated_date, wallet_id, category_id)
values ('50', '2019-03-21', 'Food', '2019-03-21', 1, 2);