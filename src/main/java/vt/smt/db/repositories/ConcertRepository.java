package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Concert;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Integer> {

}
