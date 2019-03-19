create table category
(
  id                bigint auto_increment primary key,
  category_type_id  int null,
  name              varchar(255) null
)
  engine = MyISAM;

insert into category(category_type_id, name) values (2, 'Food');
insert into category (category_type_id, name) values (1, 'Salary');