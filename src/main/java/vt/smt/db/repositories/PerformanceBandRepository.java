package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.PerformanceBand;

import vt.smt.ent.bands.PerformanceBandPK;

public interface PerformanceBandRepository extends JpaRepository<PerformanceBand, PerformanceBandPK> {

}
