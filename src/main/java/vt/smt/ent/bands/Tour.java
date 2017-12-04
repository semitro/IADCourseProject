package vt.smt.ent.bands;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Tour implements Serializable {
    private Integer tourId;
    private String name;
    private Date startDate;
    private Date endDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
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

        Tour tour = (Tour) o;

        if (tourId != null ? !tourId.equals(tour.tourId) : tour.tourId != null) return false;
        if (name != null ? !name.equals(tour.name) : tour.name != null) return false;
        if (startDate != null ? !startDate.equals(tour.startDate) : tour.startDate != null) return false;
        if (endDate != null ? !endDate.equals(tour.endDate) : tour.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId != null ? tourId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
