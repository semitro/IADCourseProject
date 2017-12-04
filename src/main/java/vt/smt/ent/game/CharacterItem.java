package vt.smt.ent.game;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;


@Entity
@Table(name = "character_item")
@IdClass(CharacterItemPK.class)
public class CharacterItem {
	@Id
	@Column(name = "item_id")
    private Integer itemId;
    @Id
    @Column(name = "character_id")
    private Integer characterId;
    @Basic
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "slot")
    private Short slot;

	@ManyToOne(optional = false)
	@JoinColumn(name = "item_id", nullable = false)
    private Item item;
	@ManyToOne(optional = false)
	@JoinColumn(name = "character_id", nullable = false)
    private Character character;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Short getSlot() {
        return slot;
    }

    public void setSlot(Short slot) {
        this.slot = slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterItem that = (CharacterItem) o;

        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (characterId != null ? !characterId.equals(that.characterId) : that.characterId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (slot != null ? !slot.equals(that.slot) : that.slot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (characterId != null ? characterId.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (slot != null ? slot.hashCode() : 0);
        return result;
    }
}
