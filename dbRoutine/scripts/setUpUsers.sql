insert into users (login) values ('login'), ('pesec'), ('crocs');
--with t as (select member.member_id, person.name from member natural join person) insert into game_character(name, member_owner_id) values ( (select name from t), (select member_id from t));
-- ЕЕЕЕЕ, я писал этот сраный запрос минут 20. Ставит опыт у game_character-а, принадлежащему музыканту, такой же опыт, как количество проданных альбомов
--with t as (select Album.copies_num, Person.name, Member.mebmer_id from album_band natural join album inner join band on album_band.band_id=band.band_id inner join member on member.band_id = band.band_id inner join person on member.person_id = person.person_id where copies_num is not null ) update game_character set experience=(select copies_num from t) set name=(select name from t);
update game_character set experience=(select Album.copies_num from album_band natural join album inner join band on album_band.band_id=band.band_id inner join member on member.band_id = band.band_id where game_character.member_owner_id is not null and copies_num is not null and game_character.member_owner_id = member.member_id);
-- ERROR: more than 1 row is returned.
--update game_character set name=(select Person.name from game_character inner join member on game_character.member_owner_id = member.member_id 
--	inner join person on member.person_id = person.person_id 
--	where game_character.member_owner_id is not null and game_character.member_owner_id = member.member_id);
update game_character set name=(select Person.name from game_character inner join member on game_character.member_owner_id = member.member_id 
        inner join person on member.person_id = person.person_id 
        where game_character.member_owner_id is not null and game_character.member_owner_id = 9) where member_owner_id = 9;

-- Обновление характеристик на основе опыта для принадлежащих музыкантам персонажей
update game_character set roses=experience*100, rhythm=experience/5500, health = experience/200, attack=experience/2500, defence=experience/2600 where game_character.member_owner_id is not null;
