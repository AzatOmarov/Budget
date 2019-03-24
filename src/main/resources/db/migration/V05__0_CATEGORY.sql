create table category
(
  id                  bigint       auto_increment primary key,
  category_type       bigint       not null,
  name  varchar(255)  null
)
  engine = MyISAM;

insert into category (category_type, name)
values (1, 'Salary');

insert into category (category_type, name)
values (1, 'Bonus');

insert into category (category_type, name)
values (2, 'Food');

insert into category (category_type, name)
values (2, 'Transport');