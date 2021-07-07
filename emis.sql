set foreign_key_checks = 0;

drop database if exists employees;
create database employees;
use employees;

drop table if exists user;
create table `user` (
		`user_id` int unsigned,
		`username` varchar(20),
        `password` varchar(16),
		`type` varchar(3),
        primary key(`user_id`) using btree
) engine=InnoDB auto_increment=125 default charset=utf8;

drop table if exists employee;
create table `employee` (
		`employee_id` int unsigned,
        `edu_id` int unsigned,
        `job_id` int unsigned,
        `salary` decimal(13, 2),
        `marital_status` varchar(3),
        `photo` longblob,
        `name` varchar(20),
        `manager_id` int unsigned,
        primary key(`employee_id`) using btree
) engine=InnoDB auto_increment=500 default charset=utf8;

drop table if exists education;
create table `education` (
		`edu_id` int unsigned,
        `edu_level` varchar(20),
        primary key(`edu_id`) using btree
) engine=InnoDB default charset=utf8;

drop table if exists job;
create table `job` (
		`job_id` int unsigned,
        `job_title` varchar(20),
        `max_salary` decimal(13, 2),
        `min_salary` decimal(13, 2),
        primary key(`job_id`) using btree
) engine=InnoDB default charset=utf8;

drop table if exists department;
create table `department` (
	`department_id` int unsigned,
    `department_name` varchar(20),
    `manager_id` int unsigned,
    primary key(`department_id`) using btree
) engine=InnoDB default charset=utf8;

drop table if exists subjection;
create table `subjection` (
		`subjection_id` int unsigned auto_increment,
		`job_id` int unsigned,
        `department_id` int unsigned,
        `is_lead` varchar(3),
        primary key(`subjection_id`) using btree
) engine=InnoDB default charset=utf8;

set foreign_key_checks = 1;