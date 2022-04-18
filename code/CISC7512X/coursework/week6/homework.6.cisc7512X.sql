--- CISC 7512X Homework #6 Below is a schema for an HR Database
--- employee( empid, fname, lname, managerid. departmentid, employee_rank)


drop table employee;

create table employee (
    empid int,
    fname varchar(20),
    lname varchar(20),
    managerid int,
    departmentid int,
    employee_rank varchar(10)
);

insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(1, 'Battler', 'Ushinomiya', 100, 4000, 'SVP');

insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(2, 'Maria', 'Ushinomiya', 109, 4001, 'staff');
insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(3, 'Kinzo', 'Ushinomiya', 102, 4000, 'CEO');
insert into employee(empid,fname, lname,man3gerid, departmentid, employee_rank)
values(4, 'Rosa', 'Ushinomiya', 100, 4001, 'VP');
insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(5, 'Rudolph', 'Ushinomiya', 100, 4001, 'VP');
insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(6, 'Natsuhi', 'Ushinomiya', 100, 4001, 'SVP');


insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(6, 'Beatrice', '', 129, 4001, 'SVP');

insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(6, 'Bernkastel', '', 999, 4001, 'SVP');


insert into employee(empid,fname, lname,managerid, departmentid, employee_rank)
values(42, 'Chris', 'Samuel', 109, 4001, 'SVP');

--1. Who (empid, fname, lname) is the immediate manger of employee 42;
--- departmentid 4001 AND employee rank must be VP OR staff
select * from employee where empid=42;

-- 2. Who (empid,fanme,lname) reports directly to employee 42?
select * from employee where empid=42 and  departmentid=4001 and employee_rank='VP' OR employee_rank='staff';