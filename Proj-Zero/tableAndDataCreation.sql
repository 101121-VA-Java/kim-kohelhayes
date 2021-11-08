drop table if exists customer_items;
drop table if exists items;
drop table if exists item_status;
drop table if exists users;

create table if not exists users (
	id serial unique not null primary key,
	n_me varchar(30) not null,
	username varchar(20) unique not null,
	pswrd varchar(15) not null,
	pstn varchar(20) not null
);

insert into users (n_me, username, pswrd, pstn) 
	values 
		('Loella',	'lofallon0',	'cFbtGpQ77K', 'ADMIN') ,
		('Malchy',	'mbeddoes1',	'BfDcgmzs', 'EMPLOYEE'),
		('Tris',	'tcours2',	'yaUWgG7yxZK', 'EMPLOYEE'),
		('Mabel',	'mburmaster3',	'NwTVtez', 'CUSTOMER'),
		('Benedikta',	'bpeal4',	'8F6fllPY', 'CUSTOMER'),
		('Kylie',	'khellsdon5',	'33e1rH5', 'CUSTOMER');
		

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
	dept varchar(20) not null,
	status_id int references item_status(s_id)
);	

insert into items (item_name, description, dept, status_id) 
	values 
		('pretium',	'In sagittis dui vel nisl.', 'GROCERY',	1),
		('rutrum',	'Curabitur convallis.',	'PETS',	2),
		('duis',	'Nulla tellus.', 'PETS', 1),
		('justo',	'Pellentesque at nulla.', 'BABY',	3),
		('posuere',	'Phasellus id sapien in sapien iaculis congue.',	'GARDEN',	1),
		('fringilla',	'Maecenas tincidunt lacus at velit.',	'GROCERY',	3),
		('metus',	'Aliquam quis turpis eget elit sodales scelerisque.',	1,	2),
		('velit',	'In hac habitasse platea dictumst.',	'BABY',	2),
		('nulla',	'Vivamus vestibulum sagittis sapien.',	'GARDEN',	3),
		('fringilla',	'In hac habitasse platea dictumst.', 'PETS',	1);

create table if not exists customer_items (
	cust_id int references users(id),
	item_id int references items(item_id)
);	

insert into customer_items (cust_id, item_id) 
	values 
		(4, 4),
		(5, 6),
		(6, 9);
		
	
	
	