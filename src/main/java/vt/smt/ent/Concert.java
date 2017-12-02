package vt.smt.ent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Concert {
    private Integer concertId;
    private Integer placeId;
    private Date startDate;
    private Date endDate;
    private Integer attendantsNum;

    @Id
    @Column(name = "concert_id")
    public Integer getConcertId() {
        return concertId;
    }

    public void setConcertId(Integer concertId) {
        this.concertId = concertId;
    }

    @Basic
    @Column(name = "place_id")
    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
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

    @Basic
    @Column(name = "attendants_num")
    public Integer getAttendantsNum() {
        return attendantsNum;
    }

    public void setAttendantsNum(Integer attendantsNum) {
        this.attendantsNum = attendantsNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concert concert = (Concert) o;

        if (concertId != null ? !concertId.equals(concert.concertId) : concert.concertId != null) return false;
        if (placeId != null ? !placeId.equals(concert.placeId) : concert.placeId != null) return false;
        if (startDate != null ? !startDate.equals(concert.startDate) : concert.startDate != null) return false;
        if (endDate != null ? !endDate.equals(concert.endDate) : concert.endDate != null) return false;
        if (attendantsNum != null ? !attendantsNum.equals(concert.attendantsNum) : concert.attendantsNum != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = concertId != null ? concertId.hashCode() : 0;
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (attendantsNum != null ? attendantsNum.hashCode() : 0);
        return result;
    }
}
