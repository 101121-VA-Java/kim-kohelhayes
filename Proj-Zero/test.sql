



-- SELECT a - sum(b) FROM the_table;

SELECT 
	u.n_me AS u_name,
	c.amount_owed AS amt_owed,
	c.amount_owed - SUM(p.amount)
FROM 
	customers c  	
JOIN
	customer_payments cp ON cp.c_id = c.c_id   
JOIN
	payments p ON p.pay_id = cp.p_id 
JOIN
	users u ON c.user_id = u.id
WHERE 
	u.id = 4
GROUP BY u.n_me, c.amount_owed;






SELECT 
	i.item_name AS item_name
FROM 
	customer_items ci
JOIN 
	customers c	ON ci.cust_id = c.c_id
JOIN
	users u ON c.user_id = u.id
JOIN
	items i ON ci.item_id = i.item_id
WHERE u.id = 4;





SELECT 
	u.n_me AS u_name,
	c.amount_owed AS amt_owed
FROM 
	customers c	
JOIN
	users u ON c.user_id = u.id
WHERE 
	u.id = 4;



select id from users where username & pswrd 



SELECT item_id, item_name, description, dept 
	FROM items
	WHERE status_id = 1;



insert into users 
	(n_me, username, pswrd)
values 
	('Kim', 'kim123', 'qwerty123', 'EMPLOYEE');




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
	
	
	
	