create table user
(
  id           bigint      not null auto_increment primary key,
  created_date datetime    not null,
  email        varchar(50) not null unique,
  name         varchar(50) null,
  password     varchar(50) not null,
  updated_date datetime    not null
)
  engine = MyISAM;

insert into user (created_date, email, name, password, updated_date)
values ('2019-03-18', 'ok@gmail.ru', 'Azat', '123', '2019-03-18');

insert into user (created_date, email, name, password, updated_date)
values ('2019-03-18', 'GGG@gmail.com', 'GGG', '321', '2019-03-18');




