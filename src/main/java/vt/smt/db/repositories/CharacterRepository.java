package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.GameCharacter;
import vt.smt.ent.net.Users;

import java.util.List;

public interface CharacterRepository extends JpaRepository<GameCharacter, Integer> {
    List<GameCharacter> findAllGameCharactersByOwner(Users owner);
}
