package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
