package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Place;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
