package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.TourBand;

import vt.smt.ent.TourBandPK;

public interface TourBandRepository extends JpaRepository<TourBand, TourBandPK> {

}
