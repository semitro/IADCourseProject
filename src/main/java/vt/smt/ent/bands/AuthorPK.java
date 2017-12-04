package vt.smt.ent.bands;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
public class AuthorPK implements Serializable {
    private Integer compositionId;
    private Integer personId;

    @Column(name = "composition_id")
    @Id
    public Integer getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(Integer compositionId) {
        this.compositionId = compositionId;
    }

    @Column(name = "person_id")
    @Id
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorPK authorPK = (AuthorPK) o;

        if (compositionId != null ? !compositionId.equals(authorPK.compositionId) : authorPK.compositionId != null)
            return false;
        if (personId != null ? !personId.equals(authorPK.personId) : authorPK.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compositionId != null ? compositionId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }
}
