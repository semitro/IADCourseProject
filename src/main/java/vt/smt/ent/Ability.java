package vt.smt.ent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Ability {
    private Integer abilityId;
    private String name;
    private String description;
    private Integer abilityScriptId;
    private String forClass;
    private Integer minExpToUse;
    private Integer cooldown;
    private Boolean onlyInBattle;
    private Boolean passive;
    private Integer imageResourceId;

    @Id
    @Column(name = "ability_id")
    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ability_script_id")
    public Integer getAbilityScriptId() {
        return abilityScriptId;
    }

    public void setAbilityScriptId(Integer abilityScriptId) {
        this.abilityScriptId = abilityScriptId;
    }

    @Basic
    @Column(name = "for_class")
    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
    }

    @Basic
    @Column(name = "min_exp_to_use")
    public Integer getMinExpToUse() {
        return minExpToUse;
    }

    public void setMinExpToUse(Integer minExpToUse) {
        this.minExpToUse = minExpToUse;
    }

    @Basic
    @Column(name = "cooldown")
    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    @Basic
    @Column(name = "only_in_battle")
    public Boolean getOnlyInBattle() {
        return onlyInBattle;
    }

    public void setOnlyInBattle(Boolean onlyInBattle) {
        this.onlyInBattle = onlyInBattle;
    }

    @Basic
    @Column(name = "passive")
    public Boolean getPassive() {
        return passive;
    }

    public void setPassive(Boolean passive) {
        this.passive = passive;
    }

    @Basic
    @Column(name = "image_resource_id")
    public Integer getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(Integer imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ability ability = (Ability) o;

        if (abilityId != null ? !abilityId.equals(ability.abilityId) : ability.abilityId != null) return false;
        if (name != null ? !name.equals(ability.name) : ability.name != null) return false;
        if (description != null ? !description.equals(ability.description) : ability.description != null) return false;
        if (abilityScriptId != null ? !abilityScriptId.equals(ability.abilityScriptId) : ability.abilityScriptId != null)
            return false;
        if (forClass != null ? !forClass.equals(ability.forClass) : ability.forClass != null) return false;
        if (minExpToUse != null ? !minExpToUse.equals(ability.minExpToUse) : ability.minExpToUse != null) return false;
        if (cooldown != null ? !cooldown.equals(ability.cooldown) : ability.cooldown != null) return false;
        if (onlyInBattle != null ? !onlyInBattle.equals(ability.onlyInBattle) : ability.onlyInBattle != null)
            return false;
        if (passive != null ? !passive.equals(ability.passive) : ability.passive != null) return false;
        if (imageResourceId != null ? !imageResourceId.equals(ability.imageResourceId) : ability.imageResourceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = abilityId != null ? abilityId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (abilityScriptId != null ? abilityScriptId.hashCode() : 0);
        result = 31 * result + (forClass != null ? forClass.hashCode() : 0);
        result = 31 * result + (minExpToUse != null ? minExpToUse.hashCode() : 0);
        result = 31 * result + (cooldown != null ? cooldown.hashCode() : 0);
        result = 31 * result + (onlyInBattle != null ? onlyInBattle.hashCode() : 0);
        result = 31 * result + (passive != null ? passive.hashCode() : 0);
        result = 31 * result + (imageResourceId != null ? imageResourceId.hashCode() : 0);
        return result;
    }
}
