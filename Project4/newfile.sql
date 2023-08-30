
/* Drop Tables */

DROP TABLE BorrowDB CASCADE CONSTRAINTS;
DROP TABLE BookDB CASCADE CONSTRAINTS;
DROP TABLE MemberDB CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE BookDB
(
	BookNum number NOT NULL,
	BookName varchar2(50),
	BookGun number,
	PRIMARY KEY (BookNum)
);


CREATE TABLE BorrowDB
(
	Bor_Num number NOT NULL,
	Bor_date number,
	Bor_re number,
	Mebnum number NOT NULL,
	BookNum number NOT NULL,
	PRIMARY KEY (Bor_Num)
);


CREATE TABLE MemberDB
(
	Mebnum number NOT NULL,
	MebId varchar2(30),
	MemName varchar2(20),
	PRIMARY KEY (Mebnum)
);



/* Create Foreign Keys */

ALTER TABLE BorrowDB
	ADD FOREIGN KEY (BookNum)
	REFERENCES BookDB (BookNum)
;


ALTER TABLE BorrowDB
	ADD FOREIGN KEY (Mebnum)
	REFERENCES MemberDB (Mebnum)
;



