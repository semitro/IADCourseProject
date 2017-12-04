package vt.smt.ent.game;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
public class CharacterAbilityPK implements Serializable {
    private Integer abilityId;
    private Integer characterId;

    @Column(name = "ability_id")
    @Id
    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    @Column(name = "character_id")
    @Id
    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterAbilityPK that = (CharacterAbilityPK) o;

        if (abilityId != null ? !abilityId.equals(that.abilityId) : that.abilityId != null) return false;
        if (characterId != null ? !characterId.equals(that.characterId) : that.characterId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = abilityId != null ? abilityId.hashCode() : 0;
        result = 31 * result + (characterId != null ? characterId.hashCode() : 0);
        return result;
    }
}
