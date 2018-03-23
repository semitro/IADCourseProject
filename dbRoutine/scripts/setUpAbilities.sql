insert into resource(name, type, url) values
('bloodGroup', 'img','/img/skills/bloodGroup.png'),
('gainOverload', 'img','/img/skills/gainOverload.png'),
('extrimVocal', 'img','/img/skills/extrimVocal.png'),
('regularAttack', 'img', '/img/skills/regularAttack.png');

insert into script (name, script) values ('emptyScript', ''), ('sayHello', 'me.sayHello()'),
('regularAttack', 'enemy.regularAttack()'),
('extremeVocal', 'enemy.extremeVocal()'),('groupOfBlood', 'me.groupOfBlood()'),('gainOverLoad', 'me.gainOverload()');

insert into ability(name, passive, description, min_exp_to_use, image_resource_id, ability_script_id)
values
('Экстрим вокал', false, 'Пение скримом наносит фиксированный чистый урон по противнику!'
	, 12000, (select resource_id from resource where name = 'extrimVocal'),
	(select script_id from script where name = 'extremeVocal')),
('Узнать группу крови на рукаве', false, 'Знание своей группы крови увеличивает здоровье', 10, (select resource_id from resource where name = 'bloodGroup'),
	(select script_id from script where name = 'groupOfBlood')),
('Выкрутить Gain', false, 'Атака увеличивается в два раза на три хода. Повторное использование обновляет счётчик'
	, 200, (select resource_id from resource where name = 'gainOverload'),
	(select script_id from script where name = 'gainOverLoad')),
('Обычная атака', false, 'Урон зависит от атаки, защиты соперника и ритма', 0, (select resource_id from resource where name = 'regularAttack'),
	(select script_id from script where name = 'regularAttack'));

insert into character_ability(ability_id, character_id, power_level)
values((select ability_id from ability where name = 'Экстрим вокал'), (select character_id from game_character where name = 'репей'), 1),
((select ability_id from ability where name = 'Узнать группу крови на рукаве'), (select character_id from game_character where name = 'репей'), 2),
((select ability_id from ability where name = 'Выкрутить Gain'), (select character_id from game_character where name = 'репей'), 1),
((select ability_id from ability where name = 'Обычная атака'), (select character_id from game_character where name = 'репей'), 1);

--insert into character_ability(ability_id, character_id, power_level)
--values((select ability_id from ability where name = 'Экстрим вокал'),
--	(select character_id from game_character where member_owner_id=7), 1),
--((select ability_id from ability where name = 'Узнать группу крови на рукаве'), (select character_id from game_character where member_owner_id=8), 2),
--((select ability_id from ability where name = 'Выкрутить Gain'), (select character_id from game_character where member_owner_id=8), 1),
--((select ability_id from ability where name = 'Обычная атака'), (select character_id from game_character where member_owner_id=8), 1);
-- ;( Как сделать такой запрос для всех member_owner_id is not null?



