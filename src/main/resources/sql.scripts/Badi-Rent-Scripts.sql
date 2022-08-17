#-------------------------------------------TABLE USERS----------------------------------------------------------------------------

drop table users;

create table users (
id int auto_increment,
username varchar(45) not null,
password varchar(45) not null,
enabled boolean not null,
role varchar(45) not null,
primary key(id));

insert into users values (null, 'ciprian', 'ciprian',true,'ROLE_ADMIN');
insert into users values (null, 'ionut', 'ionut',true,'ROLE_ADMIN');
insert into users values (null, 'guest', 'guest',true,'ROLE_GUEST');

select * from users;

#--------------------------------------------TABLE AUTHORITIES--------------------------------------------------------

drop table authorities;

create table authorities (
id int  auto_increment,
username varchar(45) not null,
authority varchar(45) not null,
primary key (id));

select * from authorities;


insert into authorities values ( null, 'ciprian','write');
insert into authorities values ( null, 'ciprian','read');

#---------------------------------------TABLE CARS-------------------------------------------

drop table cars;

create table cars (
id int auto_increment,
brand varchar(45) not null,
name varchar(45) not null,
engine_type varchar(45) not null CHECK (engine_type IN ('electric','diesel','gas')),
rent_price double not null,
insurance_price double not null,
available boolean not null,
seats int not null check (seats in(2,4,7)),
car_image blob,
primary key (id));

drop table cars;


insert into cars values ( null, 'dacia', 'logan', 'diesel', 200, 500, true, 4 );
insert into cars values ( null, 'dacia', 'dokker', 'diesel', 200, 500, true, 7 );

delete from cars where id = 8;

select * from cars;

#-----------------------------------TABLE MOTOS -----------------------------------------------
drop table motos;

create table motos (
id int auto_increment,
brand varchar(45) not null,
name varchar(45) not null,
engine_type varchar(45) not null CHECK (engine_type IN ('electric','diesel','gas')),
rent_price double not null,
insurance_price double not null,
available boolean not null,
moto_image blob,
primary key (id));

select * from motos;

#-----------------------------------TABLE ATVS-----------------------------------------------
drop table atvs;

create table atvs (
id int auto_increment,
brand varchar(45) not null,
name varchar(45) not null,
engine_type varchar(45) not null CHECK (engine_type IN ('electric','diesel','gas')),
rent_price double not null,
insurance_price double not null,
available boolean not null,
atv_image blob,
primary key (id));

select * from atvs;


