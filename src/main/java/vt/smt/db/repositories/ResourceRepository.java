package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Resource;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
