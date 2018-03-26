package vt.smt.ent.game;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Item implements Serializable{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return name.equals(((Item)o).getName());
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private ItemType type;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

}
