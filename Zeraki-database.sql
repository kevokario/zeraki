-- This is creating the database

create database zeraki_education;

-- this are the tables

-- 1.Table institution

create table institution(
    institutionid int(11) primary key auto_increment,
    name varchar(250) not null
);

-- creating table course
create table course(
    courseid int(11) primary key auto_increment,
    name varchar(250) not null,
    institution int(11)
);

-- creating table student

create table student(
    studentid int(11) primary key auto_increment,
    name varchar(250) not null,
    course int(11)
);

-- defining relationships
alter table course add foreign key(institution) references institution(institutionid) on update cascade on delete restrict;
alter table student add foreign key(course) references course(courseid) on update cascade on delete restrict;

--
-- The query for displaying data query data
select institution.name as "INSTITUTION NAME",course.name as "COURSE NAME", count(student.name) as" NUMBER OF STUDENTS" from student inner join course on student.course = course.courseid inner join institution on institution.institutionid=course.institution group by Course;