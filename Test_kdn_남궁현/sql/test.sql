create table member(
	id varchar2(30) primary key,
	password varchar2(30) not null,
	name varchar2(30) not null,
	email varchar2(255) not null,
	address varchar2(100),
	withdraw char(1) default 'N')
	
select * from member

delete member

update member set password='2222', name='홍길동1' email='honghong', address='대전' where id='hong'