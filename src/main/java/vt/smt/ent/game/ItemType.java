package vt.smt.ent.game;

import javax.persistence.*;
import java.io.Serializable;
import vt.smt.ent.net.Resource;

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
    @Basic
    @Column(name = "parent_id")
    private Integer parentId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "image_resource_id")
    private Integer imageResourceId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "image_resource_id", referencedColumnName = "resource_id",
			nullable = false)
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

        ItemType itemType = (ItemType) o;

        if (typeId != null ? !typeId.equals(itemType.typeId) : itemType.typeId != null) return false;
        if (parentId != null ? !parentId.equals(itemType.parentId) : itemType.parentId != null) return false;
        if (name != null ? !name.equals(itemType.name) : itemType.name != null) return false;
        if (imageResourceId != null ? !imageResourceId.equals(itemType.imageResourceId) : itemType.imageResourceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageResourceId != null ? imageResourceId.hashCode() : 0);
        return result;
    }
}
