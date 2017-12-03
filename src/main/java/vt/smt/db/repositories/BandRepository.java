package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Band;

public interface BandRepository extends JpaRepository<Band, Integer> {

}
