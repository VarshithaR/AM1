create table Asset(assetid number primary key,assetname varchar2(25),assetdesc varchar2(25),quantity number,status varchar2(15));
insert into ASSET values(101,'Laptop','HP laptop',10,'Available');
insert into ASSET values(102,'Desktop','HP Desktop',10,'Available');
drop table Asset;
select * from ASSET;
truncate table Asset;
create sequence genAssetID start with 100 increment by 1;
select * from user_masters;
SELECT userid,userpassword,usertype from User_masters where userid='155315' and userpassword='root' and usertype='Admin';
create table Department(dept_id int primary key,dept_name varchar2(50));
insert into Department values(dept_no_seq.nextval,'Learning and development');
create sequence dept_no_seq start with 10 increment by 10;
select * from Department;
insert into Department values(dept_no_seq.nextval,'Human Resources');
create table Employees(empno number(6) primary key,ename varchar2(25),job varchar2(50),mgrnumber number(10),hiredate date,dept_id number references Department(dept_id));
create sequence emp_num_seq start with 155100 increment by 1;
insert into Employees values(emp_num_seq.nextval,'Deepika','Trainer',null,'15-Sep-2014',10);
insert into Employees values(emp_num_seq.nextval,'Mandhara','HR',null,'20-Oct-2015',20);
insert into Employees values(emp_num_seq.nextval,'Lavanya','Analyst',155100,'25-Oct-2016',10);
insert into Employees values(emp_num_seq.nextval,'Vaibhavi','Analyst',155101,'18-Dec-2016',20);
select * from Employees;
truncate table Employees;

