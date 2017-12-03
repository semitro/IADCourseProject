package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Ability;

import java.util.List;

public interface AbilityRepository extends JpaRepository<Ability, Integer> {

}
