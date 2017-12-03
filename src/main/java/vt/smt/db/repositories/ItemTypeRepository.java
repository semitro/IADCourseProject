package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.ItemType;

public interface ItemTypeRepository extends JpaRepository<ItemType, Integer> {

}
