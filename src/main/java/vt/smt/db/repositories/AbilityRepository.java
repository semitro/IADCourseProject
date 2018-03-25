package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Integer> {
    Ability findByName(String name);
}
