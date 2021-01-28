


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

alter table employees
add constraint fk_emp_empsuper
foreign key (supervisor_id) references employees(employee_id);

alter table employees
add constraint fk_emp_dept
foreign key (department_id) references departments(department_id);


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


alter table development_resources
add constraint fk_devres_gradeform
foreign key (grading_format_id) references grading_references(format_id);

drop table development_resources;


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
    format_id number(10) PRIMARY KEY,
    format_type varchar2(10) constraint grade_format_types check (format_type in ('pass/fail','graded', 'presentation')),
    description varchar2(50)
);




