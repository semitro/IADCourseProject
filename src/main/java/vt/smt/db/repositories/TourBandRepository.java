package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.TourBand;

import vt.smt.ent.bands.TourBandPK;

public interface TourBandRepository extends JpaRepository<TourBand, TourBandPK> {

}
