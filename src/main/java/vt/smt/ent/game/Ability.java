package vt.smt.ent.game;

import javax.persistence.*;
import java.io.Serializable;
import vt.smt.ent.net.Resource;

/**
 *  Ability is a skill that the player can use in the battle
 *  <p>
 *  This class contents params of the ability like a name or cooldown,
 *  but not a behaviour. To get the behaviour, use abilityScriptId.
 *  @Autor Bulantsof A., Oshepkov A.
 *  @Version 0.1
 */
@Entity
public class Ability implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ability_id")
    private Integer abilityId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "ability_script_id")
    private Integer abilityScriptId;
    @Basic
    @Column(name = "for_class")
    private String forClass;
    @Basic
    @Column(name = "min_exp_to_use")
    private Integer minExpToUse;
    @Basic
    @Column(name = "cooldown")
    private Integer cooldown;
    @Basic
    @Column(name = "only_in_battle")
    private Boolean onlyInBattle;
    @Basic
    @Column(name = "passive")
    private Boolean passive;
    @Basic
    @Column(name = "image_resource_id")
    private Integer imageResourceId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "image_resource_id", referencedColumnName = "resource_id",
			nullable = false)
    private Resource imageResource;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ability_script_id", referencedColumnName = "script_id")
    private Script abilityScript;

    public Resource getImageResource() {
		return imageResource;
	}
	
	public void setImageResource(Resource imageResource) {
		this.imageResource = imageResource;
	}
    
    public Script getAbilityScript() {
        return abilityScript;
    }

    public void setAbilityScript(Script abilityScript) {
        this.abilityScript = abilityScript;
    }

    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) {
        this.abilityId = abilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAbilityScriptId() {
        return abilityScriptId;
    }

    public void setAbilityScriptId(Integer abilityScriptId) {
        this.abilityScriptId = abilityScriptId;
    }

    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
    }

    public Integer getMinExpToUse() {
        return minExpToUse;
    }

    public void setMinExpToUse(Integer minExpToUse) {
        this.minExpToUse = minExpToUse;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    public Boolean getOnlyInBattle() {
        return onlyInBattle;
    }

    public void setOnlyInBattle(Boolean onlyInBattle) {
        this.onlyInBattle = onlyInBattle;
    }

    public Boolean getPassive() {
        return passive;
    }

    public void setPassive(Boolean passive) {
        this.passive = passive;
    }

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
