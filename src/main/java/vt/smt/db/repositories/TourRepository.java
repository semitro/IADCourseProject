package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Tour;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
