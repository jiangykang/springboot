drop table if exists t_student;
create table t_student
(
	id 	int(10) not null auto_increment,
	name 	varchar(20) null,
	age	int(10) null,
	constraint PK_T_STUDENT primary key clustered (id)
);
insert into t_student(name,age) values("zhangsan",25);
insert into t_student(name,age) values("lisi",26);
insert into t_student(name,age) values("wangwu",30);
insert into t_student(name,age) values("Tom",25);
insert into t_student(name,age) values("Jack",24);