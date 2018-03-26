insert into script (name, script) values ('emptyScript', ''), ('sayHello', 'me.sayHello()'),
('regularAttack', 'enemy.regularAttack()'),
('extremeVocal', 'enemy.extremeVocal()'),
('groupOfBlood', 'me.groupOfBlood()'),('gainOverLoad', 'me.gainOverload()'),
('admirers', 'me.spendRoses(1000); enemy.regularAttack(); enemy.regularAttack(); enemy.regularAttack(); enemy.regularAttack(); enemy.regularAttack()');

insert into ability(name, passive, description, min_exp_to_use, image_resource_id, ability_script_id, cooldown)
values
('Экстрим вокал', false, 'Пение скримом наносит фиксированный чистый урон по противнику!', 12000, (select resource_id from resource where name = 'extrimVocal'),
	(select script_id from script where name = 'extremeVocal'), 1),
('Узнать группу крови на рукаве', false, 'Знание своей группы крови увеличивает здоровье', 10, (select resource_id from resource where name = 'bloodGroup'),
	(select script_id from script where name = 'groupOfBlood'), 1),
('Выкрутить Gain', false, 'Атака увеличивается в два раза на три хода. Повторное использование обновляет счётчик'
	, 200, (select resource_id from resource where name = 'gainOverload'),
	(select script_id from script where name = 'gainOverLoad'), 1),
('Обычная атака', false, 'Урон зависит от атаки, защиты соперника и ритма', 0, (select resource_id from resource where name = 'regularAttack'),
	(select script_id from script where name = 'regularAttack'), 0),
('Натравить поклонников', false, 'Потрать роз 1000 и натрави поклонников на противника!', 5000, (select resource_id from resource where name = 'admirers'),
	(select script_id from script where name = 'admirers'), 1);

