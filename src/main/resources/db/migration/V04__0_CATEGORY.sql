create table category
(
  id    bigint       auto_increment primary key,
  name  varchar(255) null
)
  engine = MyISAM;

insert into category(name) values ('DEBIT');
insert into category (name) values ('CREDIT');