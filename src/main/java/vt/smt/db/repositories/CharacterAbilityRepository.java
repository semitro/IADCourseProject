package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.game.CharacterAbility;

import vt.smt.ent.game.CharacterAbilityPK;

public interface CharacterAbilityRepository extends JpaRepository<CharacterAbility, CharacterAbilityPK> {

}
