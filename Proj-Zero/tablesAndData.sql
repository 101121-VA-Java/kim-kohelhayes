drop table if exists customer_payments;
drop table if exists payments;
drop table if exists customer_bidding;
drop table if exists customer_items;
drop table if exists items;
drop table if exists item_status;
drop table if exists customers;
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
		('Loella',	'lfal0',	'pass', 'ADMIN') ,
		('Malchy',	'mbed1',	'pass', 'EMPLOYEE'),
		('Tris',	'tcours2',	'pass', 'EMPLOYEE'),
		('Mabel',	'mbur3',	'pass', 'CUSTOMER'),
		('Benkta',	'bpeal4',	'pass', 'CUSTOMER'),
		('Kylie',	'khelon5',	'pass', 'CUSTOMER');
	
create table if not exists customers (
	c_id serial unique not null primary key,
	user_id int references users(id),
	amount_owed money 
);

insert into customers (user_id, amount_owed)
	values
		(4,'112.14'),
		(5,'0'),
		(6,'24.56');
		

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
		('metus',	'Aliquam quis turpis eget elit sodales scelerisque.',	'GROCERY',	2),
		('velit',	'In hac habitasse platea dictumst.',	'BABY',	2),
		('nulla',	'Vivamus vestibulum sagittis sapien.',	'GARDEN',	3),
		('fringilla',	'In hac habitasse platea dictumst.', 'PETS',	1);

create table if not exists customer_items (
	cust_id int references customers(c_id),
	item_id int references items(item_id)
);	

insert into customer_items (cust_id, item_id) 
	values 
		(1, 4),
		(1, 6),
		(3, 9);
		
create table if not exists customer_bidding (
	bid_id serial unique not null primary key,
	cust_id int references customers(c_id),
	item_id int references items(item_id),
	bid_amount money not null
);	

insert into customer_bidding (cust_id, item_id, bid_amount) 
	values 
		(2, 2, '4.67'),
		(1, 2, '5.35'),
		(2, 7, '89.09'),
		(3, 7, '91.34'),
		(2, 7, '95.67'),
		(3, 8, '55.88');
	
create table if not exists payments (
	pay_id serial unique not null primary key,
	amount money not null ,
	pay_conf_num VARCHAR(6)
);
insert into payments (pay_id, amount, pay_conf_num) 
	values 
	(1, '10.00', '35699'),
	(2, '15.00', '56022'),
	(3, '15.00', '06046'),
	(4, '10.00', '35510'),
	(5, '20.00', '35607');

create table if not exists customer_payments ( 
	c_id int references customers(c_id),
	p_id int references payments(pay_id)
);
	
insert into customer_payments (c_id, p_id)
	values 
		(1, 1),
		(1, 2),
		(1, 3),
		(3, 4),
		(1, 5);
		
	
	
	
	