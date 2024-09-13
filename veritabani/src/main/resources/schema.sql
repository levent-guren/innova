create table department(
	    id int auto_increment primary key,
		name varchar(50));

create table personel(
	    id int auto_increment primary key,
		name varchar(50), 
		lastname varchar(50),
		department_id int,
		constraint per_dept_id_fk foreign key(department_id) references department(id)
);
		
		