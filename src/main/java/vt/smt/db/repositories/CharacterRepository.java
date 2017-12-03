package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.Character;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

}
