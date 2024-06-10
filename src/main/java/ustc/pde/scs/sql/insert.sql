use scs;

/*major insert*/
insert into major(majorId,majorName,majorIntro) values("000","少年班学院","苕皮");
insert into major(majorId,majorName,majorIntro) values("001","数学科学学院","书院大佬");
insert into major(majorId,majorName,majorIntro) values("203","物理学院","头发茂密");
insert into major(majorId,majorName,majorIntro) values("204","管理学院","高绩人士");
insert into major(majorId,majorName,majorIntro) values("206","化学与材料科学学院","四天坑之一");
insert into major(majorId,majorName,majorIntro) values("208","地球和空间科学学院","无敌");
insert into major(majorId,majorName,majorIntro) values("209","工程科学学院","给我干哪来了，这是中科大吗");
insert into major(majorId,majorName,majorIntro) values("211","人文与社会科学学院","美女");
insert into major(majorId,majorName,majorIntro) values("214","核科学技术学院","听着像大专");
insert into major(majorId,majorName,majorIntro) values("240","环境科学与工程学院","没听说过");
insert into major(majorId,majorName,majorIntro) values("207","生命科学学院","出过人才");
insert into major(majorId,majorName,majorIntro) values("210","信息技术学院","小卷");
insert into major(majorId,majorName,majorIntro) values("215","计算机科学与技术学院","卷皮");
insert into major(majorId,majorName,majorIntro) values("219","微电子学院","能否突破卡脖子就靠你了");
insert into major(majorId,majorName,majorIntro) values("221","网络空间安全学院","能偷看色图吗");
insert into major(majorId,majorName,majorIntro) values("229","人工智能与数据科学学院","高级");
insert into major(majorId,majorName,majorIntro) values("913","临床医学院","科大学医，真牛逼");
insert into major(majorId,majorName,majorIntro) values("999","未来技术学院","穿越银河！");

/*course insert*/
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("CS1001A","计算机程序设计A","必修",80,40,4.0,"","","1秋","二四第三四节课",2,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("CS1002A","计算系统概论A","选修",80,40,4.0,"","","2秋","一三五第三四节课",2,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("MATH1006","数学分析B1","必修",120,0,6.0,"","","1秋","一三五第三四节课",1,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("MATH1007","数学分析B2","必修",120,0,6.0,"","","1春","一三五第三四节课",1,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("MATH1009","线性代数B1","必修",80,0,4.0,"","","1秋、1春","二四第三四节课",2,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("PHYS1001B","力学B","必修",60,0,2.5,"","","1春","二四第三四节课",2,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("PHYS1002B","热血B","必修",40,0,1.5,"","","1春","二四第三四节课",10,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("PHYS1004C","电磁学C","必修",100,0,3.0,"","","2秋","二四第三四节课",2,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("011103","袋鼠结构","必修",60,0,3.0,"","","1春","一三五第六七节课",1,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("011040","屠论","必修",60,0,3.0,"","","2秋","二四第三四节课",1,120,"百分制",50);
insert into course(courseId,courseName,courseType,theoryHour,labHour,credit,book,courseIntro,openSemester,classTime,firstWeek,maxNum,gradeMeans,selectednum)
values("011127","数据结构","必修",60,40,4.0,"","","2秋","一三五第三四节课",1,120,"百分制",50);


/*user insert*/
insert into users(id,username,password,name,idcard,email,type,majorId,date,curSemester,stuType)
values("PB21051110","2043529287","houge.0404","侯甲申","4114814564123465","hjs123456@mail.ustc.com","administrator","215","2021-09","2024春季学期","大三本科");
insert into users(id,username,password,name,idcard,email,type,majorId,date,curSemester,stuType)
values("PB21051098","123456777","123456","某原生生物","41148148823465","yssw@mail.ustc.com","student","215","2021-09","2024春季学期","大三本科");
insert into users(id,username,password,name,idcard,email,type,majorId,date,curSemester,stuType)
values("PB21111234","PB21111234","mima","电子人","xxxxxxxxxxx","dzr@mail.ustc.com","student","215","2021-09","2024春季学期","大三本科");
insert into users(id,username,password,name,idcard,email,type,majorId,date,curSemester,stuType)
values("PB21111111","PB21111111","11111111","学号里有很多1","11111111111","111@mail.ustc.com","student","215","2021-09","2024春季学期","大三本科");
insert into users(id,username,password,name,idcard,email,type,date,majorId)
values("TA001","woshilaoshi","teacher","邵老师","4123284567812","sx@mail.ustc.com","teacher","2001-03-04","215");
insert into users(id,username,password,name,idcard,email,type,date,majorId)
values("TA002","lwbyyds","666666","刘老师","1231321312","lwb6666@mail.ustc.com","teacher","2001-03-04","215");
insert into users(id,username,password,name,idcard,email,type,date,majorId)
values("TA003","lsy520","ls5201314","刘神","123456789","ls@mail.ustc.com","teacher","2016-11-25","215");