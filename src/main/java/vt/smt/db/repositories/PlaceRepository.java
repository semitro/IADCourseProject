package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
