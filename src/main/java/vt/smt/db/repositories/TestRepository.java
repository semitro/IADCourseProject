package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Test;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {

}
