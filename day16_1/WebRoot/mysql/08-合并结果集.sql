##合并结果集
use exam;
select * from emp
union all
select * from emp;
##要求被合并的结果集中类的类型和次序相同
select deptno from emp
union all
select deptno from dept;