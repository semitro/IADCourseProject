package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
