drop table if exists Assist;

drop table if exists Assistant;

drop table if exists selectGrade;
drop table if exists selectCourse;
drop table if exists Teach;
drop table if exists Course;

drop table if exists Student;
drop table if exists Teacher;
drop table if exists Users;
drop table if exists administrator;
drop table if exists Major;



drop view if exists Student;
drop view if exists Teacher;
drop view if exists Administrator;



/*==============================================================*/
/* Table: Course                                                */
/*==============================================================*/
create table Course
(
    courseId             varchar(12) not null,
    courseName           varchar(10) not null,
    courseType           varchar(10) not null,
    theoryHour           int not null,
    labHour              int not null,
    credit               double not null,
    book                 varchar(12),
    courseIntro          varchar(50),
    maxNum				 int not null,
    gradeMeans           varchar(10),
    selectedNum			 int not null,
    teacherId            varchar(12) not null,
    primary key (courseId)
);

/*==============================================================*/
/* Table: Major                                                 */
/*==============================================================*/
create table Major
(
    majorId              varchar(10) not null,
    majorName            varchar(20) not null,
    majorIntro           varchar(100),
    primary key (majorId)
);



/*==============================================================*/
/* Table: Teach                                                 */
/*==============================================================*/
create table Teach
(
    ID                   varchar(12) not null,
    courseId             varchar(12) not null,
    primary key (ID,courseId)
);


/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table Users
(
    username             varchar(20),
    password             varchar(20) not null,
    idCard               varchar(18),
    ID                   varchar(12) not null,
    email                varchar(30),
    name				 varchar(20) not null,
    date                 varchar(20),
    type                 varchar(20) not null,
    majorId              varchar(10) not null,
    primary key (ID)
);

/*==============================================================*/
/* 添加三种用户的视图                                                  */
/*==============================================================*/
create view Student
as
select *
from Users
where Type='student';

create view Teacher
as
select *
from Users
where Type='teacher';

create view Administrator
as
select *
from Users
where Type='administrator';

/*==============================================================*/
/* Table: administrator                                         */
/*==============================================================*/
/*create table administrator
(
    ID                   varchar(12) not null,
    -- admName              varchar(20) not null,
    primary key (ID)
);*/

/*==============================================================*/
/* Table: selectCourse                                          */
/*==============================================================*/
create table selectCourse
(
    ID                   varchar(12) not null,
    courseId             varchar(12) not null,
    primary key (ID, courseId)
);

/*==============================================================*/
/* Table: selectGrade                                           */
/*==============================================================*/
create table selectGrade
(
    ID                   varchar(12) not null,
    courseId             varchar(12) not null,
    grade                varchar(4) not null,
    primary key (ID, courseId)
);

/*alter table Assist add constraint FK_Assist foreign key (ID)
    references Assistant (ID) on delete cascade;*/

/*alter table Assist add constraint FK_Assist2 foreign key (courseId)
    references Course (courseId) on delete cascade;*/

/*alter table Assistant add constraint FK_stu_ass foreign key (ID)
    references Student (ID) on delete cascade;*/

alter table Users add constraint FK_major foreign key (majorId)
    references Major (majorId) on delete cascade;

alter table Teach add constraint FK_Teach foreign key (courseId)
    references Course (courseId) on delete cascade;

alter table Teach add constraint FK_Teach2 foreign key (ID)
    references Users (ID) on delete cascade;

alter table selectCourse add constraint FK_selectCourse foreign key (ID)
    references Users (ID) on delete cascade;

alter table selectCourse add constraint FK_selectCourse2 foreign key (courseId)
    references Course (courseId) on delete cascade;

alter table selectGrade add constraint FK_selectGrade foreign key (ID)
    references Users (ID) on delete cascade;

alter table selectGrade add constraint FK_selectGrade2 foreign key (courseId)
    references Course (courseId) on delete cascade;

