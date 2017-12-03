package vt.smt.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import vt.smt.db.repositories.*;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"vt.smt.ent"})
@EnableJpaRepositories(basePackages="vt.smt.db.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="vt.smt.ent")
public class MuzzFightApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MuzzFightApplication.class, args);
		System.out.println("sdds");
		AliasRepository aliasRepository = context.getBean(AliasRepository.class);
		System.out.println(aliasRepository.findAll());
	}
}
