package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.CharacterAbility;

import vt.smt.ent.CharacterAbilityPK;

public interface CharacterAbilityRepository extends JpaRepository<CharacterAbility, CharacterAbilityPK> {

}
