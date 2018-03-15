package vt.smt.ent.net;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class keeps url of some resource that you need.
 * Here you can get type and unique name of the resource.
 */
@Entity
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private Integer resourceId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "url")
    private String url; //(

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (resourceId != null ? !resourceId.equals(resource.resourceId) : resource.resourceId != null) return false;
        if (name != null ? !name.equals(resource.name) : resource.name != null) return false;
        if (type != null ? !type.equals(resource.type) : resource.type != null) return false;
        if (url != null ? !url.equals(resource.url) : resource.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId != null ? resourceId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
