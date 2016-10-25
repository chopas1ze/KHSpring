create table libmap(
mart varchar2(2000),
p_num varchar2(2000),
area varchar2(2000),
address varchar2(2000),
latitude varchar2(2000),
longitude varchar2(2000));

 drop  table libmap

insert into libmap values('서울 도서관','02-2122-0300','서울','서울 중구 세종로 110','37.566134','126.977808');
insert into libmap values('지혜의 숲','031-711-8905','경기','경기도 성남시 분당구 금곡동 206','37.386396','127.101900');
select count(*) from libmap where area='서울'

delete from libbmap where p_num=2