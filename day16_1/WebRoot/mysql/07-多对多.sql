## 多对多

use mydb4;
create table student (
sid int primary key auto_increment,
sname varchar(50)
);

create table teacher(
tid int primary key auto_increment,
tname varchar(50)
);

create table student_teacher(
sid int,
tid int,
constraint fk_student foreign key(sid) references student(sid),
constraint fk_teacher foreign key(tid) references teacher(tid)
);