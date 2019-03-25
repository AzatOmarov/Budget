create table USER
(
  ID           bigint      not null auto_increment,
  NAME         varchar(50),
  EMAIL        varchar(50) not null,
  PASSWORD     varchar(50) not null,
  CREATED_DATE datetime    not null,
  UPDATED_DATE datetime    not null,
  primary key (ID)
);
create table WALLET
(
  ID       bigint      not null auto_increment,
  USER_ID  bigint,
  CURRENCY varchar(50) not null,
  primary key (ID)
);
create table CATEGORY_TYPE
(
  ID   bigint not null auto_increment,
  NAME varchar(50),
  primary key (ID)
);
create table CATEGORY
(
  ID            bigint      not null auto_increment,
  CATEGORY_TYPE bigint      not null,
  NAME          varchar(50) not null,
  primary key (ID)
);
create table TRANSACTION
(
  ID           bigint   not null auto_increment,
  CUSTOM_DATE  datetime not null,
  AMOUNT       float    not null,
  WALLET_ID    bigint,
  CATEGORY_ID  bigint,
  DESCRIPTION  varchar(255),
  CREATED_DATE datetime not null,
  UPDATED_DATE datetime not null,
  primary key (ID)
);

alter table USER
  add constraint USER_EMAIL unique (EMAIL);
alter table CATEGORY
  add constraint CATEGORY_NAME unique (NAME);
alter table WALLET
  add constraint WALLET_USER_ID_USER_ID foreign key (USER_ID) references USER (ID);
alter table CATEGORY
  add constraint CATEGORY_CATEGORY_TYPE_CATEGORY_TYPE foreign key (CATEGORY_TYPE) references CATEGORY_TYPE (ID);
alter table TRANSACTION
  add constraint TRANSACTION_WALLET_ID_WALLET_ID foreign key (WALLET_ID) references WALLET (ID);
alter table TRANSACTION
  add constraint TRANSACTION_CATEGORY_ID_CATEGORY_ID foreign key (CATEGORY_ID) references CATEGORY (ID);