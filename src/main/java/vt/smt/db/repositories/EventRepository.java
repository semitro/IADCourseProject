package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
