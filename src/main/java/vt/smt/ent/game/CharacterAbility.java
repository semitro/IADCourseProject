package vt.smt.ent.game;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "character_ability")
public class CharacterAbility implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_ability_id")
    private Integer characterAbilityId;

    @Basic
    @Column(name = "power_level")
    private Integer powerLevel;
    @Basic
    @Column(name = "last_useed")
    private Date lastUsed;


	@ManyToOne(optional = false )
	@JoinColumn(name = "character_id", nullable = false)
    private GameCharacter gameCharacter;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ability_id")
    private Ability ability;

    public Integer getCharacterAbilityId() {
        return characterAbilityId;
    }

    public void setCharacterAbilityId(Integer characterAbilityId) {
        this.characterAbilityId = characterAbilityId;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }


    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterAbility that = (CharacterAbility) o;

        if (powerLevel != null ? !powerLevel.equals(that.powerLevel) : that.powerLevel != null) return false;
        if (lastUsed != null ? !lastUsed.equals(that.lastUsed) : that.lastUsed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (powerLevel != null ? powerLevel.hashCode() : 0);
        result = 31 * result + (lastUsed != null ? lastUsed.hashCode() : 0);
        return result;
    }
}
