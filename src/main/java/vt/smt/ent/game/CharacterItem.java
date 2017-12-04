package vt.smt.ent.game;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;


@Entity
@Table(name = "character_item")
@IdClass(CharacterItemPK.class)
public class CharacterItem {

    private Integer itemId;
    private Integer characterId;
    private Integer number;
    private Short slot;

    /// many to one
    private Item item;
    private Character character;

    @Id
    @ManyToOne
    @JoinColumn(name="item_id")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Id
    @ManyToOne
    @JoinColumn(name="character_id")
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

    //    @Id
//    @Column(name = "item_id")
//    public Integer getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(Integer itemId) {
//        this.itemId = itemId;
//    }

//    @Id
//    @Column(name = "character_id")
//    public Integer getCharacterId() {
//        return characterId;
//    }
//
//    public void setCharacterId(Integer characterId) {
//        this.characterId = characterId;
//    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "slot")
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

//        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
//        if (characterId != null ? !characterId.equals(that.characterId) : that.characterId != null) return false;
//        if (number != null ? !number.equals(that.number) : that.number != null) return false;
//        if (slot != null ? !slot.equals(that.slot) : that.slot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
//        int result = itemId != null ? itemId.hashCode() : 0;
//        result = 31 * result + (characterId != null ? characterId.hashCode() : 0);
//        result = 31 * result + (number != null ? number.hashCode() : 0);
//        result = 31 * result + (slot != null ? slot.hashCode() : 0);
        int result = (int)Math.random()*1000;
        return result;
    }
}
