
insert into course(title, description) values ('Нотная грамота', 'учимся читать и писать'),
('Интервалы и лады', 'всё, что Вы хотели узнать о ладах'), ('Аккорды', 'это интересно');

insert into article(title, subtitle, content, course_id) values
('Интервалы', 'Сочетание двух нот', 'Интервал - это две ноты, звуащие одновременно',
(select course_id from course where title='Интервалы и лады')),
('Трезвучия', 'простейшие аккоды', 'содержание статьи об аккордах',
(select course_id from course where title = 'Аккорды') ),
('Септаккорды', 'четырёхэтажные аккоды', 'содержание статьи о септаккордах', 
	(select course_id from course where title = 'Аккорды') );

-- В скрипт награды просто кладём название абилки, которую мы получим
insert into script(name, script) values ('getGroupOfBloodSkill', 'Узнать группу крови на рукаве');

insert into test(title, description, reward_script_id) values 
('Интервалы', 'Насколько хорошо вы знаете музыкальные интервалы?', 
	(select script_id from script where name = 'getGroupOfBloodSkill'));

insert into question(content, answer, wrong1, wrong2, wrong3, test_id) values
('Что такое интервал?', 'Две нотки, связанные гармонически или мелодически',
	'Это заведомо ошибочный  ответ', 'Стеклянные окуни', 'Ну, это типа аккорд, но не совсем',
	(select test_id from test where title ='Интервалы'));

