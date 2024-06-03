/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2024/5/23 21:42:37                           */
/*==============================================================*/



drop database if exists scs;
create database scs;
use scs;
drop table if exists Assist;

drop table if exists Assistant;

drop table if exists Course;

drop table if exists Major;

drop table if exists Student;

drop table if exists Teach;

drop table if exists Teacher;

drop table if exists Users;

drop table if exists administrator;

drop table if exists class;

drop table if exists selectCourse;

drop table if exists selectGrade;

/*==============================================================*/
/* Table: Assist                                                */
/*==============================================================*/
create table Assist
(
   ID                   varchar(12) not null,
   courseID             varchar(12) not null,
   primary key (ID, courseID)
);

/*==============================================================*/
/* Table: Assistant                                             */
/*==============================================================*/
create table Assistant
(
   ID                   varchar(12) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: Course                                                */
/*==============================================================*/
create table Course
(
   courseId             varchar(12) not null,
   openSemester         varchar(12) not null,
   classTime            varchar(20) not null,
   firstWeek            int not null,
   primary key (courseId)
);

/*==============================================================*/
/* Table: Major                                                 */
/*==============================================================*/
create table Major
(
   majorID              varchar(10) not null,
   majorName            varchar(20) not null,
   majorIntro           varchar(100),
   primary key (majorID)
);

/*==============================================================*/
/* Table: Student                                               */
/*==============================================================*/
create table Student
(
   ID                   varchar(12) not null,
   majorID              varchar(10) not null,
   stuName              varchar(20) not null,
   studyDate            date not null,
   curSemester          varchar(10) not null,
   stuType              varchar(6) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: Teach                                                 */
/*==============================================================*/
create table Teach
(
   courseID             varchar(12) not null,
   ID                   varchar(12) not null,
   primary key (courseID, ID)
);

/*==============================================================*/
/* Table: Teacher                                               */
/*==============================================================*/
create table Teacher
(
   ID                   varchar(12) not null,
   teaName              varchar(20) not null,
   workDate             date not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table Users
(
   userName             varchar(20) not null,
   password             varchar(20) not null,
   idCard               varchar(18),
   ID                   varchar(12) not null,
   email                varchar(30),
   primary key (ID)
);

/*==============================================================*/
/* Table: administrator                                         */
/*==============================================================*/
create table administrator
(
   ID                   varchar(12) not null,
   admName              varchar(20) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   courseID             varchar(12) not null,
   courseName           varchar(10) not null,
   courseType           varchar(10) not null,
   theoryHour           int not null,
   credit               decimal(2,1) not null,
   book                 varchar(12) not null,
   courseIntro          varchar(50),
   labHour              int not null,
   primary key (courseID, courseName)
);

/*==============================================================*/
/* Table: selectCourse                                          */
/*==============================================================*/
create table selectCourse
(
   ID                   varchar(12) not null,
   courseID             varchar(12) not null,
   maxNum               int not null,
   selectNum			int not null,
   primary key (ID, courseID)
);

/*==============================================================*/
/* Table: selectGrade                                           */
/*==============================================================*/
create table selectGrade
(
   ID                   varchar(12) not null,
   courseID             varchar(12) not null,
   gradeMeans           varchar(10) not null,
   grade                varchar(4) not null,
   primary key (ID, courseID)
);

alter table Assist add constraint FK_Assist foreign key (ID)
      references Assistant (ID) on delete restrict on update restrict;

alter table Assist add constraint FK_Assist2 foreign key (courseID)
      references Course (courseID) on delete restrict on update restrict;

alter table Assistant add constraint FK_stu_ass foreign key (ID)
      references Student (ID) on delete restrict on update restrict;

alter table Student add constraint FK_major foreign key (majorID)
      references Major (majorID) on delete restrict on update restrict;

alter table Student add constraint FK_user_stu foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table Teach add constraint FK_Teach foreign key (courseID)
      references Course (courseID) on delete restrict on update restrict;

alter table Teach add constraint FK_Teach2 foreign key (ID)
      references Teacher (ID) on delete restrict on update restrict;

alter table Teacher add constraint FK_user_teacher foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table administrator add constraint FK_user_administrator foreign key (ID)
      references Users (ID) on delete restrict on update restrict;

alter table class add constraint FK_course_class foreign key (courseID)
      references Course (courseID) on delete restrict on update restrict;

alter table selectCourse add constraint FK_selectCourse foreign key (ID)
      references Student (ID) on delete restrict on update restrict;

alter table selectCourse add constraint FK_selectCourse2 foreign key (courseID)
      references Course (courseID) on delete restrict on update restrict;

alter table selectGrade add constraint FK_selectGrade foreign key (ID)
      references Student (ID) on delete restrict on update restrict;

alter table selectGrade add constraint FK_selectGrade2 foreign key (courseID)
      references Course (courseID) on delete restrict on update restrict;

