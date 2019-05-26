## 主键约束

show databases;
use mydb4;
show tables;
create table emp(
empno int primary key,
ename varchar(50)
);
show tables;
desc emp;
drop table emp;
create table emp(
empno int,
ename varchar(50),
primary key(empno)
);
desc emp;
drop table emp;
create table emp(
empno int,
ename varchar(50)
);
alter table emp add primary key(empno);
desc emp;
alter table emp drop primary key;
desc emp;

create table student (
sid int primary key auto_increment,
sname varchar(50)
);
desc student;
insert into student values (0, 'zhangsan'), (null, 'lisi');
select * from student;
delete from student;
insert into student values (0, 'zhangsan'), (null, 'lisi');
select * from student;
truncate table student;
insert into student values (0, 'zhangsan'), (null, 'lisi');
select * from student;
create table table1 (
id int primary key auto_increment,
name varchar(50) not null unique
);
desc table1;