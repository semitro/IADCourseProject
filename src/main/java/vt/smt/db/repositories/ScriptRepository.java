package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Script;

import java.util.List;

public interface ScriptRepository extends JpaRepository<Script, Integer> {

}
