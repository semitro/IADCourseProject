package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.GameCharacter;

import java.util.List;


public interface CharacterRepository extends JpaRepository<GameCharacter, Integer> {
    List<GameCharacter> findByMemberOwnerIsNotNull();
    GameCharacter findByName(String name);
}
