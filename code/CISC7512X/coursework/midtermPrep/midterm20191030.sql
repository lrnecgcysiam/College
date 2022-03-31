DROP table customer;
DROP table account;
DROP table product;
DROP table journal;

--- Enter the Customer Table

create table customer(cid int,
    fname varchar(50),
    lname varchar(65),
    ssn varchar(9),
);

--- Enter the Account Table

create table account(aid int,
    cid int,
);

--Enter The product table
-- timestamp 19700131 - 20220401
create table journal(jid int,
    tid int,
    tim varchar(8),
    aid int,
    pid int,
    qty int
);

--- enter the product table
create table product(pid int,
    symbol varchar(6),
    type varchar(6)
);

