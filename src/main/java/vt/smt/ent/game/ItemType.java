package vt.smt.ent.game;

import vt.smt.ent.net.Resource;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "item_type")
public class ItemType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemType itemType = (ItemType) o;

        return name.equals(itemType.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "image_resource_id", referencedColumnName = "resource_id")
    private Resource imageResource;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "parent_id", referencedColumnName = "type_id",
			nullable = true)

	private ItemType parent;
    
    public ItemType getParent() {
		return parent;
	}
	
	public void setParent(ItemType parent) {
		this.parent = parent;
	}

    public Resource getImageResource() {
		return imageResource;
	}
	
	public void setImageResource(Resource imageResource) {
		this.imageResource = imageResource;
	}

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
