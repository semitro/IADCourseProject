package vt.smt.ent;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "item_type")
public class ItemType implements Serializable {
    private Integer typeId;
    private Integer parentId;
    private String name;
    private Integer imageResourceId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
