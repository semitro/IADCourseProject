package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
