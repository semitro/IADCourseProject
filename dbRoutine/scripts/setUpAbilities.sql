insert into resource(name, type, url) values
('bloodGroup', 'img','/img/skills/bloodGroup.png'),
('gainOverload', 'img','/img/skills/gainOverload.png'),
('extrimVocal', 'img','/img/skills/extrimVocal.png');

insert into script (name, script) values ('emptyScript', '');

insert into ability(name, passive, description, min_exp_to_use, image_resource_id, ability_script_id)
values
('Экстрим вокал', false, 'ГрООООУЛ!', 12000, (select resource_id from resource where name = 'extrimVocal'),
	(select script_id from script where name = 'emptyScript')),
('Кровь на рукаве', false, 'Посмотреть группу крови на рукаве', 10, (select resource_id from resource where name = 'bloodGroup'),
	(select script_id from script where name = 'emptyScript')),
('Выкрутить Gain', false, 'Выкрутить ручку Gain на всю!', 200, (select resource_id from resource where name = 'gainOverload'),
	(select script_id from script where name = 'emptyScript'));
