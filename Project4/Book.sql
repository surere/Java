
/* Drop Tables */

DROP TABLE RentalDB CASCADE CONSTRAINTS;
DROP TABLE BookDB CASCADE CONSTRAINTS;
DROP TABLE MemberDB CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE BookDB
(
	BookNum number NOT NULL,
	BookName varchar2(50),
	BookKwon number,
	PRIMARY KEY (BookNum)
);


CREATE TABLE MemberDB
(
	UserNum number NOT NULL,
	UserId varchar2(30),
	UserName varchar2(20),
	UserAge number,
	PRIMARY KEY (UserNum)
);


CREATE TABLE RentalDB
(
	LeaseNo number NOT NULL,
	LeaseDate date,
	returnDate date,
	UserNum number NOT NULL,
	BookNum number NOT NULL,
	PRIMARY KEY (LeaseNo)
);



/* Create Foreign Keys */

ALTER TABLE RentalDB
	ADD FOREIGN KEY (BookNum)
	REFERENCES BookDB (BookNum)
;


ALTER TABLE RentalDB
	ADD FOREIGN KEY (UserNum)
	REFERENCES MemberDB (UserNum)
;

select * from MemberDB;
select * from bookDB;
