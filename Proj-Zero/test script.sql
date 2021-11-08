insert into users 
	(n_me, username, pswrd)
values 
	('Kim', 'kim123', 'qwerty123');

insert into employees (manager, manager_name, user_id) 
	values 
		(true,	'Admin',	7);


select id 
from users 
where 
	n_me = 'Mabel' AND
	username = 'mburmaster3' AND
	pswrd = 'NwTVtez';


select users.id,
	users.n_me ,
	users.username ,
	users.pswrd ,
	employees.id,
	employees.manager ,
	employees.manager_name 
from users 
inner join employees
on users.id = employees.user_id 
where users.id = 4
order by users.id 

select *
	from users