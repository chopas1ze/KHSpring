drop table tbl_board;
drop table tbl_reply;
drop sequence board_bno_seq;
drop sequence reply_rno_seq;

create table tbl_board(
bno number,
title varchar2(200),
content varchar2(2000),
writer varchar2(50),
regdate date,
viewcnt number default 0);

create table tbl_reply(
 rno number,
 bno number,
 replytext varchar2(1000),
 replyer varchar2(50),
 regdate date
);

create sequence board_bno_seq 
start with 1
increment by 1
nocache
nocycle;

create sequence reply_rno_seq
start with 1
increment by 1
nocache
nocycle;

insert into TBL_BOARD values(board_bno_seq.nextval,'리스트1','내용1','미상',sysdate,0);
insert into TBL_BOARD values(board_bno_seq.nextval,'리스트2','내용2','미상2',sysdate,0);
select * from tbl_board;

insert into tbl_reply values(reply_rno_seq.nextval,1,'댓글내용1','kim',sysdate);
insert into tbl_reply values(reply_rno_seq.nextval,1,'댓글내용2','park',sysdate);
select * from tbl_reply;

select b.*, r.* from tbl_board b, tbl_reply r where b.bno=r.bno and b.bno=1;    



