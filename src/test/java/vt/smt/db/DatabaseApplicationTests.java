package vt.smt.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vt.smt.db.repositories.AliasRepository;
import vt.smt.ent.Alias;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseApplicationTests {
	@Autowired
	private AliasRepository aliasRepository;

	@Test
	public void contextLoads() {
		Alias a = new Alias();
		a.setPersonId(1);
		a.setAlias("fffa");
		aliasRepository.save(a);
	}

	@Test
	public void test1(){
		System.out.println(aliasRepository.findAll());

	}
}
