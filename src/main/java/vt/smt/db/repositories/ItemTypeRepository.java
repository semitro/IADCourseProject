package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.ItemType;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType, Integer> {

}
