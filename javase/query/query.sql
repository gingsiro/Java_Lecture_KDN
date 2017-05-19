

create table employee(
	empno varchar2(30) primary key,
	ename varchar2(100) not null,
	salary number default 1000000,
	position carchar2(30),
	address varchar2(100)
);

select * from employee;

select a.*
from ( select rownum ro, b.*
	   from ( select * 
	   		  from employee 
	   		  where 1=1 
	   		  order by salary desc
	   		  ) b
	 ) a
where ro between 1 and 5;

select * from boardfile;
select * from board;

insert into boardfile(no, rfilename, sfilename, bno)
values (boardfile_no.nextval, 'b.txt', 'b.txt', 41)

select a.*
from ( select rownum ro, b.*
	   from ( select no, id, title
	   		  from board 
	   		  where 1=1 
	   		  order by no desc
	   		  ) b
	 ) a
where ro between 6 and 10;

no, id, title, regdate, contents;

no, rfilename, sfilename, bno;

drop table book

create table book(
	isbn varchar2(15) primary key,
	title varchar2(100),
	author varchar2(30),
	publisher varchar2(50),
	pubDate date,
	price number,
	info varchar2(4000)
)s

select * from book
delete book



