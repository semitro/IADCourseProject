package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Alias;

import java.util.List;

public interface AliasRepository extends JpaRepository<Alias, Integer> {

}
