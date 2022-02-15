-- Drop tables if they exist with same name
DROP table account;
DROP table customer;
DROP table transaction;

-- Create a tables
create table customer(customerid int,
    username varchar(50),
    fname varchar(50),
    lname varchar(65),
    street varchar(65),
    street2 varchar(65),
    city varchar(65),
    state varchar(50),
    zip int
);


create table account(
    accountid varchar(10),
    customerid varchar(10),
    description varchar(50)
);


create table transaction(
    transactionid varchar(10),
    trantimestamp varchar(50),
    accountid varchar(10),
     amount(int)
);


-- Populate the tables with csv files
COPY customer(customerid, username, fname, lname, street, street2, city, state,)
From '/home/pi/College/code/CSIC7512X/CUSTOMERS.csv'
DELIMITER ','
CSV HEADER;

COPY account(accountid, customerid, description)
From '/home/pi/College/code/CSIC7512X/ACCOUNTS.csv'
DELIMITER ','
CSV HEADER;

COPY transaction(transactionid, trantimestamp, accountid, amount)
From '/home/pi/College/code/CSIC7512X/TRANSACTIONS.csv'
DELIMITER ','
CSV HEADER;
