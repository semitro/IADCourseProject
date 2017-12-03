package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Integer> {

}
