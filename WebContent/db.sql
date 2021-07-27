select * from food;





insert into food values(food_seq.nextval,'치킨','food1.jpeg');
insert into food values(food_seq.nextval,'피자','food2.jpeg');
insert into food values(food_seq.nextval,'초밥','food3.jpeg');
insert into food values(food_seq.nextval,'보쌈','food4.jpeg');
insert into food values(food_seq.nextval,'닭갈비','food5.jpeg');
insert into food values(food_seq.nextval,'부대찌개','food6.jpeg');
insert into food values(food_seq.nextval,'파스타','food7.jpeg');
insert into food values(food_seq.nextval,'라면','food8.jpeg');
insert into food values(food_seq.nextval,'삼겹살','food9.jpeg');
insert into food values(food_seq.nextval,'곱창','food10.jpeg');
insert into food values(food_seq.nextval,'돈까스','food11.jpeg');
insert into food values(food_seq.nextval,'쌀국수','food12.jpeg');
insert into food values(food_seq.nextval,'소고기','food13.jpeg');
insert into food values(food_seq.nextval,'스테이크','food14.jpeg');
insert into food values(food_seq.nextval,'떡볶이','food15.jpeg');
insert into food values(food_seq.nextval,'국밥','food16.jpeg');
insert into food values(food_seq.nextval,'햄버거','food17.jpeg');
insert into food values(food_seq.nextval,'육회','food18.jpeg');
insert into food values(food_seq.nextval,'족발','food19.jpeg');
insert into food values(food_seq.nextval,'짬뽕','food20.jpeg');
insert into food values(food_seq.nextval,'짜장면','food21.jpeg');
insert into food values(food_seq.nextval,'탕수육','food22.jpeg');
insert into food values(food_seq.nextval,'라멘','food23.jpeg');
insert into food values(food_seq.nextval,'오코노미야끼','food24.jpeg');
insert into food values(food_seq.nextval,'김치찌개','food25.jpeg');
insert into food values(food_seq.nextval,'된장찌개','food26.jpeg');
insert into food values(food_seq.nextval,'비빔밥','food27.jpeg');
insert into food values(food_seq.nextval,'제육볶음','food28.jpeg');
insert into food values(food_seq.nextval,'카레','food29.jpeg');
insert into food values(food_seq.nextval,'감자탕','food30.jpeg');




create table account(
a_id varchar2(30 char) primary key,
a_pw varchar2(30 char) not null,
a_name varchar2(30 char) not null,
a_birth varchar2(30 char) not null

);



insert into account values ('admin', 'admin', '관리자','210608');
insert into account values ('a1', 'p1', '최주영','960101');
insert into account values ( 'a2', 'p2', '강동준','970101');
insert into account values ( 'a3', 'p3', '김현지','980101');
insert into account values ( 'a4', 'p4', '김진경','990101');
insert into account values ( 'a5', 'p5', '최희웅','930101');


select *from account;

select * from account where a_id= 'hw';




-------------------------------------------------------------------------------



CREATE TABLE board (
b_num NUMBER(3) PRIMARY KEY,
b_subject VARCHAR2(100 char) not null,
b_content VARCHAR2(2000 char) not null,
b_file VARCHAR2(100 char),
b_date date not null,
b_id VARCHAR2(100 char) not null
);


create sequence board_seq;

insert into board values (board_seq.nextval, '시작', '첫번째 공지사항입니다.', 'null', sysdate,'id');

select * from board;






create table userboard(
   ub_no number(3) primary key,
   ub_title varchar2(100 char) not null,
   ub_content varchar2(1000 char) not null,
   ub_file varchar2(100 char),
   ub_date date not null,
   ub_id varchar2(100 char) not null,
   ub_count number(4)not null
);
create sequence userboard_seq;
insert into userboard values (userboard_seq.nextval, 'subject', 'content', 'file', sysdate,'id',0);
select * from userboard;

drop sequence userboard_seq cascade constraint purge;
drop table userboard cascade constraint purge;

---------------------------------------------
create table board_comment (
co_num number primary key,
co_board number not null,
co_id varchar2(15 char),
co_content varchar2 (1000 char),
co_date date not null
);
insert into board_comment values (board_comment_seq.nextval, 23, 'admin', '즐겁다', sysdate);
create sequence board_comment_seq; 

select * from board_comment;
select * from board_comment where co_board = 23;

drop sequence board_comment_seq cascade constraint purge;
drop table board_comment cascade constraint purge;

----------------------------------------------------
create table print(
p_no	number(2)primary key,
p_title	varchar2(20 char)not null,
p_id	varchar2(20 char)not null,
p_ans	varchar2(10 char)not null,
p_hint	varchar2(30 char)not null,
p_date	date not null,
p_img	varchar2(100 char)not null
);

create sequence print_seq;

insert into print values(print_seq.nextval, 'title','id', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title2','id2', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title3','id3', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title4','id4', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title5','id5', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title6','id6', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title7','id7', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title8','id8', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title9','id9', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title10','id10', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title11','id11', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title12','id12', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title13','id13', 'ans', 'hint', sysdate, 'img');
insert into print values(print_seq.nextval, 'title14','id14', 'ans', 'hint', sysdate, 'img');

drop sequence print_seq;

drop table print cascade constraint purge;

select * from print;

delete from print_comment where c_id = 'a1';


create table print_comment(
c_no	number(38) not null,
c_id	varchar2(10 char) not null,
c_date	date not null,
c_txt	varchar2(100 char) not null,
c_ans	varchar2(20 char) not null
);

insert into print_comment values(1, 'id', sysdate, '댓글내용', '정답');
insert into print_comment values(1, 'id2', sysdate, '댓글내용2', '정답2');
insert into print_comment values(1, 'id3', sysdate, '댓글내용3', '정답3');
insert into print_comment values(2, 'id4', sysdate, '댓글내용4', '정답4');
insert into print_comment values(2, 'id5', sysdate, '댓글내용5', '정답5');
insert into print_comment values(2, 'id6', sysdate, '댓글내용6', '정답6');
insert into print_comment values(2, 'id7', sysdate, '댓글내용7', '정답7');

drop table print_comment cascade constraint purge;
	
select * from print_comment;

delete from print_comment where c_id = 'a1';


------------------------------------------------------
--------------------유명 맛집 검색------------------------


create table famous_shop(
f_no	number(38) primary key,
f_name	varchar2(20 char) not null,
f_place	varchar2(20 char) not null,
f_time	date not null,
f_text	varchar2(100 char) not null,
f_img	varchar2(20 char) not null
);

create sequence shop_seq;

insert into famous_shop values(shop_seq.nextval, '조마루감자탕', '서울 양재역', sysdate, '생각보다 맛있음','감자탕');
insert into famous_shop values(shop_seq.nextval, 'bbq치킨', '서울 종로', sysdate, '나쁘지 않음','치킨');
insert into famous_shop values(shop_seq.nextval, '맛있는족발', '여주 연양동', sysdate, '두 번은 안 갈듯','족발');
insert into famous_shop values(shop_seq.nextval, '평양막국수', '이천 시청', sysdate, '진짜 맛있음','막국수');
insert into famous_shop values(shop_seq.nextval, '양평리백숙', '서울 홍대', sysdate, '왜 감?','백숙');
insert into famous_shop values(shop_seq.nextval, '경양카츠', '부산 달서구', sysdate, '나쁘지않음','돈카츠');
insert into famous_shop values(shop_seq.nextval, '신선한횟집', '부산 영도구', sysdate, '왜 가는지 이해를 못하겠어','회모듬');
insert into famous_shop values(shop_seq.nextval, '물회무한리필', '부산 해운대', sysdate, '해운대에 어울리는 맛','물회');
insert into famous_shop values(shop_seq.nextval, '울엄마손메밀묵', '대구 중구', sysdate, '엄마가 생각나는 맛','메밀묵');
insert into famous_shop values(shop_seq.nextval, '교동 화성', '대구 남구', sysdate, '맛집 인증','짬뽕');
insert into famous_shop values(shop_seq.nextval, '대구 오마카세', '대구 수성구', sysdate, '인스타빨','회 오마카세');
insert into famous_shop values(shop_seq.nextval, '속초생대구', '속초 영라해안길', sysdate, '군대맛','대구');
insert into famous_shop values(shop_seq.nextval, '북청전통아바이순대', '속초 아바이마을길', sysdate, '이름값 보다는 맛이 없음','아바이 순대');
insert into famous_shop values(shop_seq.nextval, '속초붉은대게수산', '속초 중앙시장로', sysdate, '대게 맛집','대게');
insert into famous_shop values(shop_seq.nextval, '뼈대있는 짬뽕', '원주시 봉산로', sysdate, '원주 가면 꼭 가야 하는 곳','짬뽕');
insert into famous_shop values(shop_seq.nextval, '농부가', '원주시 부론면', sysdate, '돌솥밥이 정말 맛있어요','돌솥밥');
insert into famous_shop values(shop_seq.nextval, '신촌 막국수', '원주시 치악로', sysdate, '막국수 전문점 인정','막국수');
insert into famous_shop values(shop_seq.nextval, '영양숱불갈비', '경주시 봉황로', sysdate, '숱불 향에 어울러져서 정말 맛있음','갈비');

select * from famous_shop;

drop sequence shop_seq;
drop table famous_shop cascade constraint purge;

-----------------------------------------------

create table dropOutReasone(
dr_id varchar2(10char) not null,
dr_pw varchar2(10char) not null,
dr_reasone varchar2(500 char) not null,
dr_date date not null
);
—————————————————————————
create table message(
m_messageNo number(38) primary key,
m_fromId varchar2(10char) not null,
m_toId varchar2(10char) not null,
m_text varchar2(500char) not null,
m_date date not null
);

create sequence m_messageNo;

drop table message cascade constraint purge;