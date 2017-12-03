package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Label;

public interface LabelRepository extends JpaRepository<Label, Integer> {

}
