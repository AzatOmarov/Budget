create table category_type
(
  id    bigint       auto_increment primary key,
  name  varchar(255) null
)
  engine = MyISAM;

insert into category_type(name) values ('DEBIT');
insert into category_type (name) values ('CREDIT');