-- Автоматическое создание персонажей
insert into game_character (name, member_owner_id, experience, image_resource_id)
select person.name, person.person_id, sum(Album.copies_num), (select resource_id from resource where name='default character')
from album_band natural join album join band on album_band.band_id=band.band_id
                        join member on member.band_id=band.band_id
			join person on member.person_id=person.person_id
		     where Album.copies_num is not null group by person.person_id, person.name;
-- Обновление характеристик на основе опыта для принадлежащих музыкантам персонажей
update game_character set roses=experience/100, rhythm=experience/5500, health = experience/200, attack=experience/2500, defence=experience/2600 where game_character.member_owner_id is not null;
