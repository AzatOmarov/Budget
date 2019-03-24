create table user
(
  id           bigint      not null auto_increment primary key,
  name         varchar(50) null,
  email        varchar(50) not null unique,
  password     varchar(50) not null,
  created_date datetime    not null,
  updated_date datetime    not null
)
  engine = MyISAM;

insert into user (name, email, password, created_date, updated_date)
values ('Azat', 'ok@gmail.ru', '123', '2019-03-18', '2019-03-18');

insert into user (name, email, password, created_date, updated_date)
values ('GGG', 'GGG@gmail.com', '321', '2019-03-18', '2019-03-18');