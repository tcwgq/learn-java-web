##多表查询练习
/*
1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
2. 列出薪金比关羽高的所有员工。
3. 列出所有员工的姓名及其直接上级的姓名。
4. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
5. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
6. 列出所有文员的姓名及其部门名称，部门的人数。
7. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。
8. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
9. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
10.列出与庞统从事相同工作的所有员工及部门名称。
11.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。
12.列出每个部门的员工数量、平均工资。
13.查出年份、利润、年度增长比。
*/
use exam;
select * from dept;
/*1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。*/
select d.*, count(*) from emp e, dept d where e.deptno = d.deptno group by d.deptno having count(*) > 0;
/*2. 列出薪金比关羽高的所有员工。*/
select * from emp where sal > ( select sal from emp where ename= '关羽');
/*3. 列出所有员工的姓名及其直接上级的姓名。*/
select emp1.ename, ifnull(emp2.ename, 'boss') from emp emp1 left outer join emp emp2 on emp1.mgr = emp2.empno;
/*4. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。*/
select emp1.empno, emp1.ename, dept.dname
from emp emp1, emp emp2, dept where emp1.mgr = emp2.empno and emp1.hiredate < emp2.hiredate and emp1.deptno = dept.deptno;
/*5. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。*/
select * from emp right outer join dept on emp.deptno = dept.deptno;
/*6. 列出所有文员的姓名及其部门名称，部门的人数。*/
select emp.ename, dept.dname, a.count 
from emp, (select deptno, count(*) count from emp group by deptno) a, dept 
where emp.deptno = dept.deptno and emp.job = '文员' and emp.deptno = a.deptno;
/*7. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。*/
select job, count(*) from emp group by job having min(sal) > 15000;
/*8. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。*/
select emp.ename from emp, dept where emp.deptno = dept.deptno and dept.dname= '销售部';
select ename from emp where deptno = (select deptno from dept where dname = '销售部');
/*9. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。*/
select emp1.*, dept.dname, emp2.ename, s.grade
from emp emp1, emp emp2, dept, salgrade s
where emp1.mgr = emp2.empno and emp1.deptno = dept.deptno and emp1.sal > (select avg(sal) from emp) and emp1.sal between s.losal and s.hisal;

select emp1.*, dept.dname, emp2.ename, s.grade
from emp emp1
left outer join dept on emp1.deptno = dept.deptno
left outer join emp emp2 on emp1.mgr = emp2.empno
left outer join salgrade s on emp1.sal between s.losal and s.hisal
where emp1.sal > (select avg(sal) from emp);
/*10.列出与庞统从事相同工作的所有员工及部门名称。*/
select emp.*, dept.dname from emp, dept where emp.deptno = dept.deptno and emp.job = (select job from emp where ename = '庞统');
/*11.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。*/
select emp.ename, emp.sal, dept.dname from emp, dept where emp.deptno = dept.deptno and emp.sal > all (select sal from emp where deptno = 30);
/*12.列出每个部门的员工数量、平均工资。*/
select dept.dname, count(*), avg(sal) from emp, dept where emp.deptno = dept.deptno group by emp.deptno;
select dept.dname, count(*), avg(sal) from emp left outer join dept on emp.deptno = dept.deptno group by emp.deptno;
/*13.查出年份、利润、年度增长比。*/
select y1.*, y2.* from t_year y1, t_year y2;
select	y1.year, y1.zz, concat(ifnull((y1.zz - y2.zz) / y2.zz, 0) * 100, '%') from t_year y1 left outer join t_year y2 on y1.year = y2.year +1;