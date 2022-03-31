-- Chris Samuel
-- 24141468
--- CISC 7512X Databases Homework 6

--- CEO
--- Senior vice president
--- vice president
--- manager
--- associate



--- Who (empid,fname,lname) is the immediate manager of employee 42?
select managerid, fname,lname from employee where empid = 42;


--- who (empid,fname,lname) reports directly to employee 42?
select empid, fname,lname,managerid from employee empid = 42


--- Who (empid, fname, lname) reports directly or indirectly to employee 42?
select *  from employee where managerid = {42 managerid}

--- count all of the employees who report directly to 42?
select count(*)  from employee where managerid = {42 managerid}

--- Who does 42 report to directly or indirectly?
select managerid, fname,lname from employee where empid = 42;

--- Who is employee 42's most immediate SVP manager?
select empid, fname,lname from employee employee_rank = 'SVP' 
--- How many levels up is emplyee 42's most immediate SVP manager?


--- how many levels up is employee 42's most immediate from CEO?

--- Maximum number of employee levels reporting to employees 42?

--- for employee 42, find the path of managers directly to the CEO ?


--- for employee 42, find the path- of- managers directly to the CEO?

-- Employees 42 and 24 most immediate common manager?


--- Employees 42 wants to send employee 24 a message: company policy states that the message must travel
--- up the management chain to the common manager, then down the chain to the appropriate employee.

--- What is the path (empid, fname, lname ) of the message?
