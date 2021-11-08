drop table if exists customer_items;
drop table if exists items;
drop table if exists item_status;
drop table if exists departments;
drop table if exists customers;
drop table if exists employees;
drop table if exists users;

create table if not exists users (
	id serial unique not null primary key,
	n_me varchar(30) not null,
	username varchar(20) unique not null,
	pswrd varchar(15) not null
);

insert into users (n_me, username, pswrd) 
	values 
		('Loella',	'lofallon0',	'cFbtGpQ77K'),
		('Malchy',	'mbeddoes1',	'BfDcgmzs'),
		('Tris',	'tcours2',	'yaUWgG7yxZK'),
		('Mabel',	'mburmaster3',	'NwTVtez'),
		('Benedikta',	'bpeal4',	'8F6fllPY'),
		('Kylie',	'khellsdon5',	'33e1rH5');
		
	
create table if not exists employees (
	e_id serial unique not null primary key,
	manager bool ,
	manager_name varchar(30) not null,
	user_id int references users(id)
);	

insert into employees (manager, manager_name, user_id) 
	values 
		(true,	'Admin',	2),
		(false,	'Admin',	1);

create table if not exists customers (
	c_id serial unique not null primary key,
	credit_line money not null,
	amount_due money not null,
	user_id int references users(id)
);	

insert into customers (credit_line, amount_due, user_id) 
	values 
		('1000.00',	'312.55',	6),
		('400.00',	'111.55',	5),
		('900.00',	'547.55',	4),
		('700.00',	'215.55',	3);

create table if not exists departments (
	d_id serial unique not null primary key,
	department varchar(30) not null
);	

insert into departments (department) 
	values 
		('Grocery'),
		('Pets'),
		('Baby'),
		('Garden');

create table if not exists item_status (
	s_id serial unique not null primary key,
	status varchar(30) not null
);	

insert into item_status (status) 
	values 
		('For Sale'),
		('Pending'),
		('Sold');

create table if not exists items (
	item_id serial unique not null primary key,
	item_name varchar(15) not null,
	description varchar(50) not null,
	dept_id int references departments(d_id),
	status_id int references item_status(s_id)
);	

insert into items (item_name, description, dept_id, status_id) 
	values 
		('pretium',	'In sagittis dui vel nisl.',	4,	1),
		('rutrum',	'Curabitur convallis.',	2,	2),
		('duis',	'Nulla tellus.',	2,	1),
		('justo',	'Pellentesque at nulla.',	1,	3),
		('posuere',	'Phasellus id sapien in sapien iaculis congue.',	4,	1),
		('fringilla',	'Maecenas tincidunt lacus at velit.',	3,	3),
		('metus',	'Aliquam quis turpis eget elit sodales scelerisque.',	1,	2),
		('velit',	'In hac habitasse platea dictumst.',	1,	2),
		('nulla',	'Vivamus vestibulum sagittis sapien.',	3,	3),
		('fringilla',	'In hac habitasse platea dictumst.', 1,	1);

create table if not exists customer_items (
	cust_id int references customers(c_id),
	item_id int references items(item_id)
);	

insert into customer_items (cust_id, item_id) 
	values 
		(1, 4),
		(1, 6),
		(3, 9);
		
	
	
	