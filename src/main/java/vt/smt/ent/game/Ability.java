package vt.smt.ent.game;

import vt.smt.ent.Script;
import vt.smt.ent.net.Resource;

import javax.persistence.*;
import java.io.Serializable;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ability ability = (Ability) o;

        if (!name.equals(ability.name)) return false;
        return description.equals(ability.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

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

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", onlyInBattle=" + onlyInBattle +
                ", passive=" + passive +
                ", abilityScript=" + abilityScript +
                '}';
    }

}
