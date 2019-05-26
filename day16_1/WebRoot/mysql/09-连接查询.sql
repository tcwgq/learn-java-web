##连接查询
use exam;
select * from emp, dept;
##去除重复的笛卡尔积
select * from emp, dept where emp.deptno = dept.deptno;
##查询指定的列
##方言形式
select emp.ename, emp.sal, dept.dname from emp, dept where emp.deptno = dept.deptno;
##标准形式
select emp.ename, emp.sal, dept.dname from emp inner join dept on emp.deptno = dept.deptno;
##使用where也可以，但不推荐
select emp.ename, emp.sal, dept.dname from emp inner join dept where emp.deptno = dept.deptno;
##自然连接，会自动寻找两个表中相同的字段进行比较
select emp.ename, emp.sal, dept.dname from emp natural join dept;
##左外连接，左表不满足条件的记录会出现，不满足的属性用null补位
select emp.ename, emp.sal, dept.dname, emp.deptno, dept.deptno from emp left outer join dept on emp.deptno = dept.deptno;
##右外连接正好与左外连接相反
select emp.ename, emp.sal, dept.dname, emp.deptno, dept.deptno from emp right outer join dept on emp.deptno = dept.deptno;
##全外连接使用合并结果集实现
select emp.ename, emp.sal, dept.dname, emp.deptno, dept.deptno from emp left outer join dept on emp.deptno = dept.deptno
union
select emp.ename, emp.sal, dept.dname, emp.deptno, dept.deptno from emp right outer join dept on emp.deptno = dept.deptno;
##还有左外自然连接，右外自然连接，全外自然连接，可以省略on条件，这里不再赘述