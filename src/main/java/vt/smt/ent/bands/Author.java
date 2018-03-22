package vt.smt.ent.bands;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@IdClass(AuthorPK.class)
public class Author implements Serializable{
    private Integer compositionId;
    private Integer personId;
    private String ofWhat;

    @Id
    @Column(name = "composition_id")
    public Integer getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(Integer compositionId) {
        this.compositionId = compositionId;
    }

    @Id
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "of_what")
    public String getOfWhat() {
        return ofWhat;
    }

    public void setOfWhat(String ofWhat) {
        this.ofWhat = ofWhat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (compositionId != null ? !compositionId.equals(author.compositionId) : author.compositionId != null)
            return false;
        if (personId != null ? !personId.equals(author.personId) : author.personId != null) return false;
        if (ofWhat != null ? !ofWhat.equals(author.ofWhat) : author.ofWhat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compositionId != null ? compositionId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (ofWhat != null ? ofWhat.hashCode() : 0);
        return result;
    }
}
