##  一对一

use mydb4;
## 基于主键的方式
create table husband(
hid int primary key auto_increment,
hname varchar(50)
);
insert into husband values(1, '刘备'), (2, '关羽'), (3, '张飞');
select * from husband;
create table wife(
wid int primary key auto_increment,
wname varchar(50),
constraint fk_wife_husband foreign key(wid) references husband(hid)
);

## 基于外键的方式
create table husband(
hid int primary key auto_increment,
hname varchar(50)
);
insert into husband values(1, '刘备'), (2, '关羽'), (3, '张飞');
select * from husband;
create table wife(
wid int primary key auto_increment,
wname varchar(50),
hid int unique,
constraint fk_wife_husband foreign key(hid) references husband(hid)
);