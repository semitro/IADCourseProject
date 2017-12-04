package vt.smt.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vt.smt.db.repositories.*;
import vt.smt.ent.bands.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseApplicationTests {
	@Autowired
	private AliasRepository aliasRepository;

	@Test
	public void contextLoads() {
		Alias a = new Alias();
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
		Place place = new Place();
		place.setName("Там где мы");
		place.setAddr("Фонтанка");
		p.setBirthPlace(place);

		placeReposityory.save(place);
		personRepository.save(p);
	}
}
