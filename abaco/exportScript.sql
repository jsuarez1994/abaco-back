drop table if exists CATEGORY;
drop table if exists PAYMENT;
drop table if exists USERS;
create table CATEGORY (id bigint not null auto_increment, description varchar(255), nature integer, type integer, id_payment bigint, id_user bigint, primary key (id)) type=MyISAM;
create table PAYMENT (id bigint not null auto_increment, description varchar(255), period varchar(6), quantity float, id_user bigint, primary key (id)) type=MyISAM;
create table USERS (id bigint not null auto_increment, email varchar(255), name varchar(255), password varchar(255), porcent_payment_permanent integer, porcent_payment_personal integer, porcent_saving integer, surname varchar(255), primary key (id)) type=MyISAM;
alter table USERS add constraint UK_avh1b2ec82audum2lyjx2p1ws unique (email);
alter table CATEGORY add constraint FK4gmmnhw6vvdpbwtd1wdawe23y foreign key (id_payment) references PAYMENT (id);
alter table CATEGORY add constraint FKig17h40lyp9px44nyey2rxhtj foreign key (id_user) references USERS (id);
alter table PAYMENT add constraint FK3p86n9dw9fmkblnmjlhd2qqfk foreign key (id_user) references USERS (id);
