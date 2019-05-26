## 多对一

use mydb4;
show tables;
drop table emp;
create table dept (
deptno int primary key auto_increment,
dname varchar(50) not null unique
);
desc dept;
insert into dept values(10, '财务部'), (20, '研发部'), (30, '人事部');
select * from dept;
create table emp (
empno int primary key auto_increment,
ename varchar(50),
deptno int,
constraint fk_emp_dept foreign key(deptno) references dept(deptno)
);
desc emp;
insert into emp (empno, ename) values (1, '张三');
insert into emp (empno, ename, deptno) values (2, '张三', 10);
insert into emp (empno, ename, deptno) values (3, '李四', 10);
select * from emp;
insert into emp (empno, ename, deptno) values (4, '王五', 20);
select * from emp;
drop table emp;
create table emp (
empno int primary key auto_increment,
ename varchar(50),
deptno int
);
alter table emp add constraint fk_emp_dept foreign key(deptno) references dept(deptno);
alter table emp drop foreign key fk_emp_dept;