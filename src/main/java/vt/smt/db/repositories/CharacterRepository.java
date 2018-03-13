package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.GameCharacter;

public interface CharacterRepository extends JpaRepository<GameCharacter, Integer> {

}
