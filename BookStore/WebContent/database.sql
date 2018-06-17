drop sequence bid;
drop table BookStore;


create sequence bid increment by 1
start with 101
minvalue 101
cycle
cache 5
maxvalue 9999;



create table BookStore(bookId number, bookName varchar2(20),Author varchar2(20),Prize number);  

