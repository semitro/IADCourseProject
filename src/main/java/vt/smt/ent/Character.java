package vt.smt.ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Character implements Serializable {
    private Integer characterId;
    private String name;
    private String clazz;
    private Integer health;
    private Integer roses;
    private Integer dRoses;
    private Integer defence;
    private Integer attack;
    private Integer rhythm;
    private Integer experience;
    private Date adventuringSince;
    private Integer imageResourceId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "character_id")
    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
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
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "health")
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Basic
    @Column(name = "roses")
    public Integer getRoses() {
        return roses;
    }

    public void setRoses(Integer roses) {
        this.roses = roses;
    }

    @Basic
    @Column(name = "d_roses")
    public Integer getdRoses() {
        return dRoses;
    }

    public void setdRoses(Integer dRoses) {
        this.dRoses = dRoses;
    }

    @Basic
    @Column(name = "defence")
    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    @Basic
    @Column(name = "attack")
    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Basic
    @Column(name = "rhythm")
    public Integer getRhythm() {
        return rhythm;
    }

    public void setRhythm(Integer rhythm) {
        this.rhythm = rhythm;
    }

    @Basic
    @Column(name = "experience")
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "adventuring_since")
    public Date getAdventuringSince() {
        return adventuringSince;
    }

    public void setAdventuringSince(Date adventuringSince) {
        this.adventuringSince = adventuringSince;
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
        if (imageResourceId != null ? !imageResourceId.equals(character.imageResourceId) : character.imageResourceId != null)
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
        result = 31 * result + (imageResourceId != null ? imageResourceId.hashCode() : 0);
        return result;
    }
}
