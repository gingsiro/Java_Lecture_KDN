select * from boardfile;

create table employee(
	empno varchar2(30) primary key,
	ename varchar2(100) not null,
	salary number default 1000000,
	position varchar2(30),
	address varchar2(100)
);

select * from employee;

update employee set ename="남궁현", salary=3000000, position="사장", address="나주" where empno="1111";

delete employee;

select a.*
from ( select rownum ro, b.*
	   from ( select * 
	   		  from employee 
	   		  where 1=1 
	   		  order by salary desc
	   		  ) b
	 ) a
where ro between 1 and 5;
