create table board(
   	num number,
   	writer varchar2(20),
 	email varchar2(30),
	subject varchar2(50),
	reg_date date,
	readcount number default 0, 
	ref number, 
	re_step number, 
	re_level number, 
	content varchar2(100),
	ip varchar2(20),
    upload varchar2(300)
);

select * from board
create sequence board_seq start with 1 increment by 1;
drop sequence board_seq;


insert into board 
values(board_seq.nextval, '홍길동','young@aaaa.com','제목1',sysdate,0,board_seq.nextval,
0,0,'내용 테스트.......','127.0.0.1','sample.txt')

commit

select * from board where subject like '%e%';

select * from board;
delete from board;
commit

select b.* from(select rownum as rm, a.* from(select * from board order by ref desc, re_step asc)a)b  
 where b.rm>=1 and b.rm<=5 

 select num,upload from board where num=65








