package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.CharacterItem;

public interface CharacterItemRepository extends JpaRepository<CharacterItem, Integer> {

}
