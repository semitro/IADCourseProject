package vt.smt.ent.game;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "character_ability")
@IdClass(CharacterAbilityPK.class)
public class CharacterAbility {
    @Id
    @Column(name = "ability_id")
    private Integer abilityId;
    @Id
    @Column(name = "character_id")
    private Integer characterId;
    @Basic
    @Column(name = "power_level")
    private Integer powerLevel;
    @Basic
    @Column(name = "last_useed")
    private Date lastUseed;

	@ManyToOne(optional = false)
	@JoinColumn(name = "character_id", nullable = false)
    private Character character;
	@ManyToOne(optional = false)
	@JoinColumn(name = "ability_id", nullable = false)
    private Ability ability;
    
    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

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
