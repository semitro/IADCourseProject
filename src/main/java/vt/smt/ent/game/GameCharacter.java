package vt.smt.ent.game;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import vt.smt.ent.bands.Member;
import vt.smt.ent.net.Resource;
import vt.smt.ent.net.Users;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
/**
 * It's what the player has
 */
@Entity
public class GameCharacter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Integer characterId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Users owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_owner_id" )  // Если персонаж относится к AI-музыканту
    private Member memberOwner;

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
    @OneToMany(mappedBy="gameCharacter", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<CharacterItem> items;
    /// Двунаправленная связь с ассоциативной таблицей Character_Ability
    @OneToMany(mappedBy="gameCharacter", fetch=FetchType.EAGER)
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

    public Users getOwnerId() {
        return owner;
    }

    public void setOwnerId(Users ownerId) {
        this.owner = ownerId;
    }

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

    @Override
    public String toString() {
        return "GameCharacter{" +
                "characterId=" + characterId +
                ", name='" + name + '\'' +
                ", rhythm=" + rhythm +
                ", experience=" + experience +
                ", adventuringSince=" + adventuringSince +
                ", imageResource=" + imageResource +
                '}';
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

    public Member getMemberOwner() {
        return memberOwner;
    }

    public void setMemberOwner(Member memberOwner) {
        this.memberOwner = memberOwner;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public void setAdventuringSince(Date adventuringSince) {
        this.adventuringSince = adventuringSince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameCharacter gameCharacter = (GameCharacter) o;

        if (characterId != null ? !characterId.equals(gameCharacter.characterId) : gameCharacter.characterId != null)
            return false;
        if (name != null ? !name.equals(gameCharacter.name) : gameCharacter.name != null) return false;
        if (clazz != null ? !clazz.equals(gameCharacter.clazz) : gameCharacter.clazz != null) return false;
        if (health != null ? !health.equals(gameCharacter.health) : gameCharacter.health != null) return false;
        if (roses != null ? !roses.equals(gameCharacter.roses) : gameCharacter.roses != null) return false;
        if (dRoses != null ? !dRoses.equals(gameCharacter.dRoses) : gameCharacter.dRoses != null) return false;
        if (defence != null ? !defence.equals(gameCharacter.defence) : gameCharacter.defence != null) return false;
        if (attack != null ? !attack.equals(gameCharacter.attack) : gameCharacter.attack != null) return false;
        if (rhythm != null ? !rhythm.equals(gameCharacter.rhythm) : gameCharacter.rhythm != null) return false;
        if (experience != null ? !experience.equals(gameCharacter.experience) : gameCharacter.experience != null) return false;
        if (adventuringSince != null ? !adventuringSince.equals(gameCharacter.adventuringSince) : gameCharacter.adventuringSince != null)
            return false;
        if (items != null ? !items.equals(gameCharacter.items) : gameCharacter.items != null) return false;
        if (abilities != null ? !abilities.equals(gameCharacter.abilities) : gameCharacter.abilities != null) return false;
        return imageResource != null ? imageResource.equals(gameCharacter.imageResource) : gameCharacter.imageResource == null;
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
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (abilities != null ? abilities.hashCode() : 0);
        result = 31 * result + (imageResource != null ? imageResource.hashCode() : 0);
        return result;
    }

}
