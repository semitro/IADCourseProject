package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.CharacterItem;

import vt.smt.ent.game.CharacterItemPK;

public interface CharacterItemRepository extends JpaRepository<CharacterItem, CharacterItemPK> {

}
