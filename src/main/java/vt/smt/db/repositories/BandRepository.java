package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Band;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Integer> {

}
