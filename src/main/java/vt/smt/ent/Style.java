package vt.smt.ent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Style {
    private Integer styleId;
    private String name;

    @Id
    @Column(name = "style_id")
    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Style style = (Style) o;

        if (styleId != null ? !styleId.equals(style.styleId) : style.styleId != null) return false;
        if (name != null ? !name.equals(style.name) : style.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = styleId != null ? styleId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
