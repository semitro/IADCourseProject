package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.net.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Resource findByName(String name);
}
