package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
