ues hrm;

create table users(
	id int primary key auto_increment,
	userName varchar(50) not null,
	password varchar(50) not null
);

insert into users(userName,password) value('root','root');

create table depts(
	id int primary key auto_increment,
	name varchar(200) not null,
	notes varchar(500)
);


create table emps(
	id int primary key auto_increment,
	name varchar(20) not null,
	sex varchar(5),
	phone varchar(30),
	email varchar(100),
	address varchar(300),
	idCard varchar(30),
	weChat varchar(30),
	notes varchar(300),
	dept int
);



alter table emps add constraint fk_emp_dept foreign key(dept) references depts(id);

create table groups(
i	d int primary key auto_increment,
	name varchar(200) not null,
	notes varchar(500)
);
create table groups_emps(
	groups int,
	enp int,
);







