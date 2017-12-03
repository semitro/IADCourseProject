package vt.smt.ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Band implements Serializable {
    private Integer bandId;
    private String name;
    private Date formationDate;
    private Integer formationPlace;
    private Date disbandDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "band_id")
    public Integer getBandId() {
        return bandId;
    }

    public void setBandId(Integer bandId) {
        this.bandId = bandId;
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
    @Column(name = "formation_date")
    public Date getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(Date formationDate) {
        this.formationDate = formationDate;
    }

    @Basic
    @Column(name = "formation_place")
    public Integer getFormationPlace() {
        return formationPlace;
    }

    public void setFormationPlace(Integer formationPlace) {
        this.formationPlace = formationPlace;
    }

    @Basic
    @Column(name = "disband_date")
    public Date getDisbandDate() {
        return disbandDate;
    }

    public void setDisbandDate(Date disbandDate) {
        this.disbandDate = disbandDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Band band = (Band) o;

        if (bandId != null ? !bandId.equals(band.bandId) : band.bandId != null) return false;
        if (name != null ? !name.equals(band.name) : band.name != null) return false;
        if (formationDate != null ? !formationDate.equals(band.formationDate) : band.formationDate != null)
            return false;
        if (formationPlace != null ? !formationPlace.equals(band.formationPlace) : band.formationPlace != null)
            return false;
        if (disbandDate != null ? !disbandDate.equals(band.disbandDate) : band.disbandDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bandId != null ? bandId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (formationDate != null ? formationDate.hashCode() : 0);
        result = 31 * result + (formationPlace != null ? formationPlace.hashCode() : 0);
        result = 31 * result + (disbandDate != null ? disbandDate.hashCode() : 0);
        return result;
    }
}
