package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
