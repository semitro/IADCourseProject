package vt.smt.ent.game;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
//public class CharacterItemPK implements Serializable {
//    private Item item;
//    private Character character;
//
//    @Column(name = "item_id")
//    @Id
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }
//
//    @Column(name = "character_id")
//    @Id
//    public Integer getCharacterId() {
//        return characterId;
//    }
//
//    public void setCharacterId(Integer characterId) {
//        this.characterId = characterId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CharacterItemPK that = (CharacterItemPK) o;
//
//        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
//        if (characterId != null ? !characterId.equals(that.characterId) : that.characterId != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = itemId != null ? itemId.hashCode() : 0;
//        result = 31 * result + (characterId != null ? characterId.hashCode() : 0);
//        return result;
//    }
//}
public class CharacterItemPK implements Serializable {
    private Integer itemId;
    private Integer characterId;

    @Column(name = "item_id")
    @Id
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name = "character_id")
    @Id
    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterItemPK that = (CharacterItemPK) o;

        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (characterId != null ? !characterId.equals(that.characterId) : that.characterId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (characterId != null ? characterId.hashCode() : 0);
        return result;
    }
}
