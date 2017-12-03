package vt.smt.ent;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Alias implements Serializable {
    private Integer aliasId;
    @ManyToOne
    private Integer personId;
    private String alias;
    private Date startDate;
    private Date endDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alias_id")
    public Integer getAliasId() {
        return aliasId;
    }

    public void setAliasId(Integer aliasId) {
        this.aliasId = aliasId;
    }

    @Basic
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alias alias1 = (Alias) o;

        if (aliasId != null ? !aliasId.equals(alias1.aliasId) : alias1.aliasId != null) return false;
        if (personId != null ? !personId.equals(alias1.personId) : alias1.personId != null) return false;
        if (alias != null ? !alias.equals(alias1.alias) : alias1.alias != null) return false;
        if (startDate != null ? !startDate.equals(alias1.startDate) : alias1.startDate != null) return false;
        if (endDate != null ? !endDate.equals(alias1.endDate) : alias1.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aliasId != null ? aliasId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
