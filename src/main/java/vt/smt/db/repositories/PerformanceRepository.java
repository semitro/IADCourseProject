package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

}
