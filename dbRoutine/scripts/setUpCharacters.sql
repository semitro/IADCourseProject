insert into game_character (attack, d_roses, defence, experience, health, name, roses, image_resource_id, owner_id) values
	(47, 0, 14, 603, 600, 'репей', 947, (select resource_id from resource where name ='default character'), (select user_id from users where login='login'));
