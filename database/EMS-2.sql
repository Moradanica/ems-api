create database mydb;
use mydb;

show tables;

-- create table department (
-- 	id INT auto_increment primary KEY, 
--     name varchar(100) not null unique, 
--     description text
-- );
-- insert into department (name, description) values ('Human Resources', 'Handles recruitment and eployee relations'), (
-- 	'IT', 'Handles software development and IT Support'), ('Finance', 'Manage payroll, budgeting and accounts'), 
--     ('Operations', 'Manages daily business processes');
select * from department;
    
-- create table job_level (
-- 		id int auto_increment primary key, 
--         name varchar(100) not null,
--         multiplier decimal (3,2) default 1.00
--     );
-- insert into job_level (name, multiplier) values ('Junior', 1.00), ('Mid', 1.25), ('Senior', 1.50), ('Lead', 1.75);
select * from job_level;
    
-- create table position (
-- 		id int auto_increment primary key, 
--         title varchar(100) not null, 
--         base_salary decimal(10,2),
--         level_id int,
--         foreign key (level_id) references job_level(id)
--         );
-- insert into position (title, base_salary, level_id) values 
-- ('Software Engineer', 40000, 1), 
-- ('Software Engineer', 40000, 2),
-- ('Software Engineer', 40000, 3), 
-- ('Software Engineer', 40000, 4), 
-- ('HR Manager', 45000, 2), 
-- ('Accountant', 42000, 2);
select * from position;
-- DELETE FROM position
-- WHERE id IN (7, 8, 9, 10, 11, 12);
-- drop table position;

-- create table employee(
-- 	id int auto_increment primary key,
--     first_name varchar(100) not null,
--     last_name varchar(100) not null,
--     email varchar(100), 
--     phone varchar(20),
--     hire_date date, 
--     department_id int, 
--     position_id int, 
--     status ENUM('ACTIVE', 'INACTIVE', 'ON_LEAVE'), 
--     foreign key (department_id) references department(id), 
--     foreign key (position_id) references position (id)
-- );
-- insert into employee (first_name, last_name, email, phone, hire_date, department_id, position_id, status) values
-- ('Mark', 'Santos', 'marks@example.com', '09171234567', '2022-06-01', 2, 3, 'ACTIVE'),
-- ('Janice', 'Morales', 'janicem@example.com', '09077654321', '2021-06-01', 2, 1, 'ACTIVE'),
-- ('Mary', 'Gonzales', 'maryg@example.com', '09247654321', '2022-03-01', 1, 5, 'ACTIVE'),
-- ('Janice', 'Morales', 'janicem@example.com', '09187654321', '2021-02-01', 3, 6, 'ACTIVE');
select * from employee;

-- create table user (id int auto_increment primary key, 
-- username varchar(100) not null, 
-- password varchar(100) not null);
-- insert into user (username, password) values ("john", "test123"), ("user", "user123"), ("admin", "admin");

-- all tables
select * from department;
select * from employee;
select * from job_level;
select * from position;
select * from user;

show columns from employee;
    
    