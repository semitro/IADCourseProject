package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Label;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Integer> {

}
