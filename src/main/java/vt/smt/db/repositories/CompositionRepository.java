package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Composition;

public interface CompositionRepository extends JpaRepository<Composition, Integer> {

}
