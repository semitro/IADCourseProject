package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
