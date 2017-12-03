package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.CharacterItem;

import vt.smt.ent.CharacterItemPK;

public interface CharacterItemRepository extends JpaRepository<CharacterItem, CharacterItemPK> {

}
