
insert into course(title, description) values ('Нотная грамота', 'учимся читать и писать'),
('Интервалы и лады', 'всё, что Вы хотели узнать о ладах'), ('Аккорды', 'это интересно');

insert into article(title, subtitle, content, course_id) values
('Интервалы', 'Сочетание двух нот', 'Интервал - это две ноты, звуащие одновременно',
(select course_id from course where title='Интервалы и лады')),
('Трезвучия', 'простейшие аккорды', 'содержание статьи об аккордах',
(select course_id from course where title = 'Аккорды') ),
('Септаккорды', 'четырёхэтажные аккорды', 'Ноты в аккорде расоплагаются по терциям. Присатвка септ- означает, что между первой и последней нотой аккорда септима',
	(select course_id from course where title = 'Аккорды') );

-- В скрипт награды (script)  просто кладём название абилки, которую мы получим
insert into script(name, script)
	values  ('getGroupOfBloodSkill', 'Узнать группу крови на рукаве'),
		('getGainOverLoadSkill', 'Выкрутить Gain');

insert into test(title, description, reward_script_id) values
('Интервалы', 'Насколько хорошо вы знаете музыкальные интервалы?',
	(select script_id from script where name = 'getGroupOfBloodSkill')),
('Трезвучия', 'Поговорим об аккордах',
	(select script_id from script where name = 'getGainOverLoadSkill')),
('Септаккорды', 'Кто здесь?',
	(select script_id from script where name = 'getGainOverLoadSkill'));

insert into question(content, answer, wrong1, wrong2, wrong3, test_id) values
('Что такое интервал?', 'Две нотки, связанные гармонически или мелодически',
	'Это заведомо ошибочный  ответ', 'Стеклянные окуни', 'Ну, это типа аккорд, но не совсем',
	(select test_id from test where title = 'Интервалы')),
('T64', 'Тонический секстаккорд', 'Танк', 'Трезвучие от до', 'Квартсекстаккорд',
	(select test_id from test where title = 'Трезвучия')),
('Что такое септаккорд?', 'Аккорд, состоящий из четырёх нот', 'Аккорд из семи частей', 'Седьмая доля аккорда',
	'Полный аккорд',
	(select test_id from test where title = 'Септаккорды')),
('Что означает protected в Java?', 'Доступно в пакете и потомкам', 'Доступно в пакете',
	'Доступно только этому классу', 'Недоступно вообще',
	(select test_id from test where title = 'Септаккорды'));

