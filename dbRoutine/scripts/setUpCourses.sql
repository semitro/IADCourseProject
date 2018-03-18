insert into course(title, description) values ('Нотная грамота', 'учимся читать и писать'),
('Интервалы и лады', 'всё, что Вы хотели узнать о ладах'), ('Аккорды', 'это интересно');
insert into article(title, subtitle, content, course_id) values 
('Трезвучия', 'простейшие аккоды', 'содержание статьи об аккордах',
(select course_id from course where title = 'Аккорды') ),
('Септаккорды', 'четырёхэтажные аккоды', 'содержание статьи о септаккордах', 
	(select course_id from course where title = 'Аккорды') );
