package vt.smt.ent.game;

import javax.persistence.*;


@Entity
@Table(name = "character_item")
public class CharacterItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_item_id")
    private Integer characterItemId;


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
    private GameCharacter gameCharacter;

    public Integer getCharacterItemId() {
        return characterItemId;
    }

    public void setCharacterItemId(Integer characterItemId) {
        this.characterItemId = characterItemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
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

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (slot != null ? !slot.equals(that.slot) : that.slot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (slot != null ? slot.hashCode() : 0);
        return result;
    }
}
