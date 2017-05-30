
create sequence board_no increment by 1 start with 1;
create sequence boardfile_no increment by 1 start with 1;

create table board(
  no        	NUMBER  primary key,
  id        	varchar2(30),
  title     	varchar2(100),
  regdate   	date,
  contents  	varchar2(3000),
  CONSTRAINT fk_board_id FOREIGN KEY(id) REFERENCES member(id)
);


create table boardfile(
  no       		NUMBER primary key,
  rfilename		varchar2(100),
  sfilename     varchar2(100),
  bno           NUMBER,
  CONSTRAINT fk_boardfile_bno foreign key  (bno) references board(no)   on delete cascade
);

insert into board values( board_no.nextval ,'kdg','first board',sysdate,'처음하는 게시판 예제...');
INSERT INTO board VALUES( board_no.nextval , 'kdg','hello world java',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','hello world java',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','hello world java',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','hello world java',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','hello world java',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','hello world java',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','bbbbb',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval , 'kdg','bbbbb',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval, 'kdg','bbbbb',sysdate,'aaa');
INSERT INTO board VALUES( board_no.nextval, 'sjlee','안녕~ 처음하는 ',sysdate,'bbbb');
INSERT INTO board VALUES( board_no.nextval, 'sjlee','안녕~ 처음하는 ',sysdate,'bbbb');
INSERT INTO board VALUES( board_no.nextval, 'sjlee','안녕~ 처음하는 ',sysdate,'bbbb');

INSERT INTO  boardfile VALUES( boardfile_no.nextval, 'a.txt','a.txt',1);
INSERT INTO  boardfile VALUES( boardfile_no.nextval, 'b.txt','b.txt',1);
INSERT INTO  boardfile VALUES( boardfile_no.nextval, 'b.txt','b.txt',5);
INSERT INTO  boardfile VALUES( boardfile_no.nextval, 'b.txt','b.txt',6);
COMMIT;


