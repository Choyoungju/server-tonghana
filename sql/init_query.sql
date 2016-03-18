
--drop table member;
--drop sequence member_no_seq;


--drop table product;
--drop sequence product_no_seq;


--member

CREATE TABLE member
( 
no        NUMBER(8),
name      VARCHAR2(30),
email     VARCHAR2(80),
password  VARCHAR2(30),
point	  NUMBER(10)
) ;

ALTER TABLE member
ADD ( CONSTRAINT member_no_pk PRIMARY KEY ( no ) );

CREATE SEQUENCE member_no_seq
 START WITH     1
 INCREMENT BY   1
 MAXVALUE       99999999
 NOCACHE
 NOCYCLE;
 
 --product
 
 CREATE TABLE product
( 
no           NUMBER(8),
url        VARCHAR2(4000),
loc1      VARCHAR2(4000),
loc2    VARCHAR2(4000),
point     NUMBER(10),
sdate     VARCHAR2(200),
fdate   VARCHAR2(200),
title   VARCHAR2(200),
descr      VARCHAR2(4000),
type   VARCHAR2(300)
) ;

ALTER TABLE product
ADD ( CONSTRAINT product_no_pk PRIMARY KEY ( no ) );

CREATE SEQUENCE product_no_seq
 START WITH     1
 INCREMENT BY   1
 MAXVALUE       99999999
 NOCACHE
 NOCYCLE;