package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.theory.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

}
