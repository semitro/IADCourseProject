package vt.smt.ent;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "character_ability", schema = "public", catalog = "fight")
@IdClass(CharacterAbilityPK.class)
public class CharacterAbility {
    private Integer abilityId;
    private Integer characterId;
    private Integer powerLevel;
    private Date lastUseed;

    @Id
    @Column(name = "ability_id")
    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    @Id
    @Column(name = "character_id")
    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    @Basic
    @Column(name = "power_level")
    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Basic
    @Column(name = "last_useed")
    public Date getLastUseed() {
        return lastUseed;
    }

    public void setLastUseed(Date lastUseed) {
        this.lastUseed = lastUseed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterAbility that = (CharacterAbility) o;

        if (abilityId != null ? !abilityId.equals(that.abilityId) : that.abilityId != null) return false;
        if (characterId != null ? !characterId.equals(that.characterId) : that.characterId != null) return false;
        if (powerLevel != null ? !powerLevel.equals(that.powerLevel) : that.powerLevel != null) return false;
        if (lastUseed != null ? !lastUseed.equals(that.lastUseed) : that.lastUseed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = abilityId != null ? abilityId.hashCode() : 0;
        result = 31 * result + (characterId != null ? characterId.hashCode() : 0);
        result = 31 * result + (powerLevel != null ? powerLevel.hashCode() : 0);
        result = 31 * result + (lastUseed != null ? lastUseed.hashCode() : 0);
        return result;
    }
}
