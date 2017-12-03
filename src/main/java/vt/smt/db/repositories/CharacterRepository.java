package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Character;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

}
