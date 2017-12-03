package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.PerformanceBand;

import vt.smt.ent.PerformanceBandPK;

public interface PerformanceBandRepository extends JpaRepository<PerformanceBand, PerformanceBandPK> {

}
