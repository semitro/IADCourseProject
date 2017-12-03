package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Performance;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

}
