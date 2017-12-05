package vt.smt.ent.game;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import vt.smt.ent.net.Resource;
/**
 * It's what the player has
 */
@Entity
public class Character implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Integer characterId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "class")
    private String clazz;
    @Basic
    @Column(name = "health")
    private Integer health;
    @Basic
    @Column(name = "roses")
    private Integer roses;
    @Basic
    @Column(name = "d_roses")
    private Integer dRoses;
    @Basic
    @Column(name = "defence")
    private Integer defence;
    @Basic
    @Column(name = "attack")
    private Integer attack;
    @Basic
    @Column(name = "rhythm")
    private Integer rhythm;
    @Basic
    @Column(name = "experience")
    private Integer experience;
    @Basic
    @Column(name = "adventuring_since")
    private Date adventuringSince;

    /// Двунаправленная связь с ассоциативной таблицей Character_Item
    @OneToMany(mappedBy="character", fetch=FetchType.LAZY)
    private List<CharacterItem> items;
    
    /// Двунаправленная связь с ассоциативной таблицей Character_Ability
    @OneToMany(mappedBy="character", fetch=FetchType.LAZY)
    private List<CharacterAbility> abilities;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "image_resource_id", referencedColumnName = "resource_id",
			nullable = false)
    private Resource imageResource;

    public List<CharacterItem> getItems() {
        return items;
    }

    public void setItems(List<CharacterItem> items) {
        this.items = items;
    }
    
    public List<CharacterAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<CharacterAbility> abilities) {
        this.abilities = abilities;
    }

    public Resource getImageResource() {
		return imageResource;
	}
	
	public void setImageResource(Resource imageResource) {
		this.imageResource = imageResource;
	}
    ///
    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getRoses() {
        return roses;
    }

    public void setRoses(Integer roses) {
        this.roses = roses;
    }

    public Integer getdRoses() {
        return dRoses;
    }

    public void setdRoses(Integer dRoses) {
        this.dRoses = dRoses;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getRhythm() {
        return rhythm;
    }

    public void setRhythm(Integer rhythm) {
        this.rhythm = rhythm;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Date getAdventuringSince() {
        return adventuringSince;
    }

    public void setAdventuringSince(Date adventuringSince) {
        this.adventuringSince = adventuringSince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (characterId != null ? !characterId.equals(character.characterId) : character.characterId != null)
            return false;
        if (name != null ? !name.equals(character.name) : character.name != null) return false;
        if (clazz != null ? !clazz.equals(character.clazz) : character.clazz != null) return false;
        if (health != null ? !health.equals(character.health) : character.health != null) return false;
        if (roses != null ? !roses.equals(character.roses) : character.roses != null) return false;
        if (dRoses != null ? !dRoses.equals(character.dRoses) : character.dRoses != null) return false;
        if (defence != null ? !defence.equals(character.defence) : character.defence != null) return false;
        if (attack != null ? !attack.equals(character.attack) : character.attack != null) return false;
        if (rhythm != null ? !rhythm.equals(character.rhythm) : character.rhythm != null) return false;
        if (experience != null ? !experience.equals(character.experience) : character.experience != null) return false;
        if (adventuringSince != null ? !adventuringSince.equals(character.adventuringSince) : character.adventuringSince != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = characterId != null ? characterId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + (health != null ? health.hashCode() : 0);
        result = 31 * result + (roses != null ? roses.hashCode() : 0);
        result = 31 * result + (dRoses != null ? dRoses.hashCode() : 0);
        result = 31 * result + (defence != null ? defence.hashCode() : 0);
        result = 31 * result + (attack != null ? attack.hashCode() : 0);
        result = 31 * result + (rhythm != null ? rhythm.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (adventuringSince != null ? adventuringSince.hashCode() : 0);
        return result;
    }
}
