

drop table mem

create table mem(
num number, name varchar2(50), age number, loc varchar2(50)
)

create sequence mem_num_seq
start with 1 increment by 1 nocycle nocache;

insert into mem values(mem_num_seq.nextval,'이효리',37,'제주도');
insert into mem values(mem_num_seq.nextval,'최지우',42,'서울');
insert into mem values(mem_num_seq.nextval,'이나영',37,'강원도');
insert into mem values(mem_num_seq.nextval,'김사랑',37,'서울');

select * from mem;

drop sequence mem_num_seq;

DELETE FROM mem
WHERE num=1;
