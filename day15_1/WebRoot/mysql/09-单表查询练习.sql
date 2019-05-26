use exam;
select * from emp;
/*
练习：
1. 查询出部门编号为30的所有员工。
2. 所有销售员的姓名、编号和部门编号。
3. 找出奖金高于工资的员工。
4. 找出奖金高于工资60%的员工。
5. 找出部门编号为10中所有经理，和部门编号为20中所有销售员的详细资料。
6. 找出部门编号为10中所有经理，部门编号为20中所有销售员，还有即不是经理又不是销售员但其工资大或等于20000的所有员工详细资料。
7. 有奖金的工种。
8. 无奖金或奖金低于1000的员工。
9. 查询名字由三个字组成的员工。
10.查询2000年入职的员工。
11. 查询所有员工详细信息，用编号升序排序。
12. 查询所有员工详细信息，用工资降序排序，如果工资相同使用入职日期升序排序。
13. 查询每个部门的平均工资。
14. 查询每个部门的雇员数量。 
15. 查询每种工作的最高工资、最低工资、人数。
16. 显示非销售人员工作名称以及从事同一工作雇员的月工资的总和，并且要满足从事同一工作的雇员的月工资合计大于50000，输出结果按月工资的合计升序排列。
*/

/*1. 查询出部门编号为30的所有员工。*/
select * from emp where deptno = 30;
/*2. 所有销售员的姓名、编号和部门编号。*/
select ename, empno, deptno where job = '销售员';
/*3. 找出奖金高于工资的员工。*/
select * from emp where ifnull(comm, 0) > sal;
/*4. 找出奖金高于工资60%的员工。*/
select * from emp where ifnull(comm, 0) > sal * 0.6;
/*5. 找出部门编号为10中所有经理，和部门编号为20中所有销售员的详细资料。*/
select * from emp where (deptno = 10 and job = '经理') or (deptno = 20 and job = '销售员');
/*6. 找出部门编号为10中所有经理，部门编号为20中所有销售员，还有即不是经理又不是销售员但其工资大或等于20000的所有员工详细资料。*/
select * from emp where (deptno = 10 and job = '经理') or (deptno = 20 and job = '销售员') or (job not in ('经理', '销售员') and sal >= 20000);
/*7. 有奖金的工种。*/
select distinct job from emp where comm is not null;
/*8. 无奖金或奖金低于1000的员工。*/
select * from emp where comm is null or comm < 1000;
/*9. 查询名字由三个字组成的员工。*/
select * from emp where ename like '___';
/*10.查询2000年入职的员工。*/
select * from emp where hiredate like '2000-%';
/*11. 查询所有员工详细信息，用编号升序排序。*/
select * from emp order by empno asc;
/*12. 查询所有员工详细信息，用工资降序排序，如果工资相同使用入职日期升序排序。*/
select * from emp order by sal desc, hiredate asc;
/*13. 查询每个部门的平均工资。*/
select deptno, avg(sal) from emp group by deptno;
/*14. 查询每个部门的雇员数量。 */
select deptno, count(*) from emp group by deptno;
/*15. 查询每种工作的最高工资、最低工资、人数。*/
select job, max(sal), min(sal), count(*) from emp group by job;
/*16. 显示非销售人员工作名称以及从事同一工作雇员的月工资的总和，并且要满足从事同一工作的雇员的月工资合计大于50000，输出结果按月工资的合计升序排列。*/
select job, sum(sal) from emp where job != '销售员' having sum(sal) > 50000 order by sum(sal) asc;