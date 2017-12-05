package vt.smt.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vt.smt.db.repositories.*;
import vt.smt.ent.bands.Alias;
import vt.smt.ent.bands.Person;
import vt.smt.ent.bands.Place;
import vt.smt.ent.game.Character;
import vt.smt.ent.game.CharacterItem;
import vt.smt.ent.game.Item;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseApplicationTests {
	@Autowired
	private AliasRepository aliasRepository;

	@Test
	public void contextLoads() {
		Alias a = new Alias();
		a.setAlias("Крылатый синеглаз");
		a.setPersonId(1);

		aliasRepository.save(a);
	}

	@Test
	public void test1(){
		System.out.println(aliasRepository.findAll());

	}

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PlaceRepository  placeReposityory;
	@Test
	public void oneToManyViaList(){
		Person 	p = new Person();
		p.setName("Жанна");
		p.setSex("f");
		Place place = new Place();
		place.setName("Там где мы");
		place.setAddr("Фонтанка");
		p.setBirthPlace(place);

		placeReposityory.save(place);
		personRepository.save(p);

	}

	@Autowired
	CharacterRepository characterRepository;
	@Autowired
	CharacterItemRepository characterItemRepository;
	@Autowired
	ItemRepository itemRepository;

	vt.smt.ent.game.Character character;
	vt.smt.ent.game.Item 	  item1;
	vt.smt.ent.game.Item 	  item2;
	vt.smt.ent.game.CharacterItem c_i_relation1;
	vt.smt.ent.game.CharacterItem c_i_relation2;

	@Test
	public void complexManyToManyRelation(){
		character = new Character();
		character.setName("ГРОЗА ВОРОВ");
		character.setdRoses(14);
		// because there are so many not-null constraints
		character.setAttack(12);
		character.setDefence(12);
		character.setExperience(14);
		character.setHealth(14);
		character.setRoses(14);
		character.setRhythm(24);

		item1 = new Item();
		item1.setName("ПАЛКА_КОПАЛКА");
		item2 = new Item();
		item2.setName("ПОВЕЛИТЕЛЬ ЁЖИКОВ");

		c_i_relation1 = new CharacterItem();
		c_i_relation1.setItem(item1);
		c_i_relation1.setSlot((short)1);
		c_i_relation1.setCharacter(character);

		c_i_relation2 = new CharacterItem();
		c_i_relation2.setItem(item2);
		c_i_relation2.setSlot((short)2);
		c_i_relation2.setCharacter(character);
		c_i_relation1.setNumber(1);
		c_i_relation2.setCharacter(character);
		c_i_relation2.setNumber(24);
		item1.setPrice(12);
		item2.setPrice(244);
    	List<CharacterItem> l = new LinkedList<>();
		l.add(c_i_relation1);
		l.add(c_i_relation2);
		character.setItems(l);

		characterRepository.save(character);
		itemRepository.save(item1);
		itemRepository.save(item2);

		characterItemRepository.save(c_i_relation1);
		characterItemRepository.save(c_i_relation2);

	}
}
