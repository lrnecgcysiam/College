DROP table patron;
DROP table beer;
DROP table transaction;
DROP table transactionitem;

--- Enter the Patron Table

create table patron(patronid int,
    nickname varchar(50),
    fname varchar(50),
    lname varchar(65)
);

--- Enter the Transaction Table

create table transaction(txid int,
    patronid int,
    event_tim varchar(12)
);

--Enter The Transactionitem table

create table transactionitem(txid int,
    beerid int,
    qty int,
    price int
);

--- beer 
create table beer(beerid int,
    description varchar(255),
    listedprice int
);


COPY patron(patronid, nickname, fname, lname)
From '/home/pi/dbsys/finaldb/patron.MOCK_DATA.csv'
DELIMITER ','
CSV HEADER;

COPY beer(beerid, description, listedprice)
From '/home/pi/dbsys/finaldb/beer.MOCK_DATA.csv'
DELIMITER ','
CSV HEADER;

COPY transaction(txid, patronid, event_tim)
From '/home/pi/dbsys/finaldb/transaction.MOCK_DATA.csv'
DELIMITER ','
CSV HEADER;

COPY transactionitem(txid, beerid, qty, price)
From '/home/pi/dbsys/finaldb/transactionitem.MOCK_DATA.csv'
DELIMITER ','
CSV HEADER;

