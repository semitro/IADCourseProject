package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Composition;

import java.util.List;

public interface CompositionRepository extends JpaRepository<Composition, Integer> {

}
