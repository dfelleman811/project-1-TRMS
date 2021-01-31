
select * from employees order by employee_id;

create table employees (
    employee_id number(10) PRIMARY KEY,
    first_name varchar2(15) NOT NULL,
    last_name varchar2(15) NOT NULL,
    email varchar2(15) UNIQUE, -- for automated notifications that someone has asked for more information?
    password varchar2(20) NOT NULL,
    department_id number(10) NOT NULL, -- **** FOREIGN KEY TO DEPT_ID ****
    supervisor_id number(10) NOT NULL, -- **** FOREIGN KEY TO EMPI_ID ****
    available_reimbursement number(10) NOT NULL
);


insert into employees values (emp_id_seq.nextval, 'BenCo', 'BenefitsCoordinator', 'benco@example.com', 'admin', 0, 0, 1000);

alter table employees modify last_name varchar2(25);

update employees set email = 'sales.depthead@example.com' where employee_id = 13;

alter table employees
add constraint fk_emp_empsuper
foreign key (supervisor_id) references employees(employee_id);

alter table employees drop constraint fk_emp_empsuper;

alter table employees
add constraint fk_emp_dept
foreign key (department_id) references departments(department_id);

alter table employees drop constraint fk_emp_dept;


create sequence emp_id_seq
start with 1
increment by 1;


create or replace procedure add_employee(f_name varchar2, l_name varchar2, mail varchar2, pword varchar2, dept_id number, avail_reimbursement number) 
is
    sup_id number;
begin
    select department_head into sup_id from departments where dept_id=department_id;
    insert into employees values (emp_id_seq.nextval, f_name, l_name, mail, pword, dept_id, sup_id, avail_reimbursement);
end;

create or replace procedure get_sup_id(department_id number)
is
    supervisor_id number;
begin
    select department_head into supervisor_id from departments where department_id=department_id;
end;

call add_employee('Sales', 'DepartmentHead', 'salesdepthead@example.com', 'saleshead', 1, 12, 1000);
call add_employee('Research', 'DepartmentHead', 'research.depthead@example.com', 'saleshead', 1, 12, 1000);
call add_employee('Design', 'DepartmentHead', 'design.depthead@example.com', 'saleshead', 1, 12, 1000);
call add_employee('Marketing', 'DepartmentHead', 'marketing.depthead@example.com', 'saleshead', 1, 12, 1000);
call add_employee('Relations', 'DepartmentHead', 'relations.depthead@example.com', 'saleshead', 1, 12, 1000);

call add_employee('Basic', 'TestEmployee', 'basic.employee@example.com', 'password', 1, 13, 1000);
call add_employee('test', 'tester', 'test@example.com', 'testing', 2, 1000);

select * from employees;

update employees set department_id = 2 where employee_id=14;
update employees set department_id = 3 where employee_id=15;
update employees set department_id = 4 where employee_id=16;
update employees set department_id = 5 where employee_id=17;

update employees set password = 'researchhead' where employee_id=14;
update employees set password = 'designhead' where employee_id=15;
update employees set password = 'marketinghead' where employee_id=16;
update employees set password = 'relationshead' where employee_id=17;


-- Create the request table -- will figure out late, but what is too much info to put in one table?
-- i.e. should the request simply have id, date, and employee? And then info on the event will be in another table?
-- I think so...that way we can query that table to see what's popular and maybe offer for free/part of training...
create table requests (
    request_id number(10) PRIMARY KEY,
    submit_date timestamp with time zone NOT NULL, -- when request was submitted by employee
    urgent number(1) NOT NULL, -- 1=yes, 0=no
    status varchar2(10) constraint r_status check (status in ('received', 'open', 'additional info requested','approved', 'pending', 'closed')) NOT NULL,
    employee_id number(10) NOT NULL, -- ****FOREIGNK KEY TO EMP TABLE****
    development_resource number(10) NOT NULL -- ****FOREIGN KEY TO DR TABLE****
    -- attachments? or can this just link to the dr table?
);

alter table requests modify last_updated set default current_timestamp;



create or replace trigger on_req_update
after insert or update of urgent, status 
on requests
for each row
declare 
    
    req_id number;

begin
    select request_id into req_id from requests;
    update requests set last_updated = current_timestamp where request_id = req_id;
end;


create or replace trigger on_req_update
after insert or update of urgent, status 
on requests
for each row
begin
    select request_id into last_updated from requests;
    update requests set last_updated = current_timestamp where request_id = req_id;
end;



select * from requests;
alter table requests
add constraint fk_req_emp
foreign key (employee_id) references employees(employee_id);



alter table requests
add constraint fk_req_devres
foreign key (development_resource) references development_resources(resource_id);


-- table for departments
create table departments (
    department_id number(10) PRIMARY KEY, 
    department_name varchar2(20) constraint d_names check (department_name in ('sales', 'research', 'design', 'marketing', 'relations')) NOT NULL,
    department_head number(10) NOT NULL -- **** FOREIGN KEY TO EMP TABLE ****
);

alter table departments drop constraint d_names;
alter table departments add constraint d_names check (department_name in ('sales', 'research', 'design', 'marketing', 'relations', 'benco', 'testAddDept'));

alter table departments
add constraint fk_dept_emp
foreign key (department_head) references employees(employee_id);


select * from departments;
select* from employees;

delete from employees where employee_id=20;

create or replace procedure add_department(dept_id number, dept_name varchar2, dept_head number)
is 
begin
    insert into departments values (dept_id, dept_name, dept_head);
end;

call add_department(6, 'testAddDept', 18);

insert into departments values (1, 'sales', 13);
insert into departments values (2, 'research', 14);
insert into departments values (3, 'design', 15);
insert into departments values (4, 'marketing', 16);
insert into departments values (5, 'relations', 17);
insert into departments values(0, 'benco', 12);

update departments set department_name = 'research' where department_id = 2;
update departments set department_name = 'design' where department_id = 3;
update departments set department_name = 'marketing' where department_id = 4;
update departments set department_name = 'relations' where department_id = 5;


-- create a table for archived requests (closed requests that have been reimbursed and will no longer need to be referenced except for reporting)
create table archived_requests (
    request_id number(10) PRIMARY KEY,
    archive_date date,
    submit_date timestamp with time zone,
    urgent number(1),
    status varchar2(10),
    employee_id number(10), -- does this still need to be linked to employee table? Or can it work through the open request table? Probably should still be linked
    development_resource number(10)
);

-- development resource table with all details
create table development_resources (
    resource_id number(10) PRIMARY KEY,
    start_date date NOT NULL, -- when the actual 'event' begins
    resource_time date NOT NULL, -- but what if it's a repeating event? i.e. a class that meets twice a week for a semester?
    resource_location varchar2(20) NOT NULL, -- where the event is taking place
    resource_cost number(10) NOT NULL, -- how much the 'event' costs
    grading_format_id number(10), 
    pd_type varchar2(20), -- in('course', 'workshop', 'seminar', 'certification prep', 'certification', 'training', 'other')
    pd_description varchar2(20), -- hmmmm how do I make this long? Can I have a long description? Maybe link it to something else?
    justification varchar2(20), -- ditto above
    attachments blob -- think I need to link this to another table?
);

select * from development_resources;

alter table development_resources rename column pd_type to res_type;
alter table development_resources rename column pd_description to res_description;

alter table development_resources modify start_date null;
alter table development_resources modify resource_time null;
alter table development_resources modify resource_location null;
alter table development_resources modify resource_cost null;


alter table development_resources
add constraint fk_devres_gradeform
foreign key (grading_format_id) references grading_references(grade_id);

alter table development_resources drop constraint fk_devres_gradeform;

select * from grading_references;

select * from development_resources;


-- Will need a table (maybe?) for company relations- i.e. who reports to who...something like FTS but for people?

drop table emp_accounts;
/*
-- table for accounts with which employees interact with trms
create table emp_accounts (
    account_id number(10) PRIMARY KEY,
    username varchar2(20),
    password varchar2(20),
    employee_id number(10) -- ****FOREIGN KEY TO EMP TABLE****
);

alter table emp_accounts
add constraint fk_empacc_emps
foreign key (employee_id) references employees(employee_id);
*/
 

/*
-- employee hierarchy table - this isn't very 'normalized' since I'm repeating info...maybe keep this in the employee table?
create table emp_hier (
    employee_id number(10) PRIMARY KEY,
    first_name varchar2(15),
    last_name varchar2(15),
    department varchar2(15),
    manager_id number(10) -- this key references the id of the employee who is this records direct manager
);

alter table emp_hier
add constraint fk_emphier_emps
foreign key (employee_id) references employees(employee_id);
*/

alter table emp_hier drop constraint fk_emphier_emps;
drop table emp_hier;
-- grading format reference table

create table grading_references (
    grade_id number(10) PRIMARY KEY,
    grade_type varchar2(20),
    passing varchar2(1)
);

alter table grading_references modify grade_type varchar2(20);




drop table grading_references;

select * from grading_references;

insert all
    into grading_references (grade_id, grade_type, passing) values (1, 'A', 1)
    into grading_references (grade_id, grade_type, passing) values (2, 'B', 1)
    into grading_references (grade_id, grade_type, passing) values (3, 'C', 1)
    into grading_references (grade_id, grade_type, passing) values (4, 'D', 0)
    into grading_references (grade_id, grade_type, passing) values (5, 'F', 0)
    into grading_references (grade_id, grade_type, passing) values (6, 'pass', 1)
    into grading_references (grade_id, grade_type, passing) values (7, 'fail', 0)
    into grading_references (grade_id, grade_type, passing) values (8, 'presentation_pass', 1)
    into grading_references (grade_id, grade_type, passing) values (9, 'presentation_fail', 0)
select 1 from dual;


select * from requests;

create sequence req_id_seq
start with 1
increment by 1;

create sequence dev_res_id_seq
start with 1
increment by 1;

create or replace procedure add_request(e_id number, urgency number) 
is
begin
    insert into requests values(req_id_seq.nextval, current_date, urgency, 'open', e_id, dev_res_id_seq.nextval, current_date);
end;

select * from requests;
alter table requests drop constraint fk_req_devres;
/*
create or replace trigger gen_devres_id
before insert on requests
for each row
    declare 
        dev_res_id number := dev_res_id_seq.nextval;
begin
    insert into development_resources values(dev_res_id, null, null, null, null, null, null, null, null, null); 
end;
*/

drop trigger gen_devres_id;

call add_request(18, 1);

alter trigger on_req_update disable;

select * from requests order by last_updated desc;



update requests set status = 'closed' where request_id = 5;



select * from development_resources;
select * from departments;


create or replace procedure add_dev_resource(starting date, time date, location varchar2, cost number, grade_format_id number, res_type varchar2, res_description varchar2, res_just varchar2) 
is
    res_id number := DEV_RES_ID_SEQ.currval;
begin
    
    insert into development_resources values (res_id, starting, time, location, cost, grade_format_id, res_type, res_description, res_just, null);
end;

call add_dev_resource(current_date, current_date, 'NYU', 500, 1, 'course', 'management', 'improvement');

select * from employees;
update employees set supervisor_id = 14 where employee_id = 18;

delete employees where employee_id = 23; -- will have to think about what data will be lost if employee is fired...will all other tables remain the same?


delete employees where employee_id = 21 OR employee_id = 23;
