##子查询
##查询工资最高的员工信息
##单行单列
select * from emp where sal = (select max(sal) from emp);
##多行多列，此时需要给表起别名
select e.empno, e.ename from (select * from emp where deptno=30) e;
##一列多行，即集合的形式
select * from emp where sal > all (select sal from emp where deptno = 30);
select * from emp where sal > any (select sal from emp where deptno = 30);
##单行多列
select * from emp where (deptno, sal) in (select deptno, sal from emp where ename='殷天正');