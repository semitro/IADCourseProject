package vt.smt.ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Performance implements Serializable {
    private Integer performanceId;
    private Integer concertId;
    private Integer tourId;
    private Integer albumId;
    private Short length;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "performance_id")
    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    @Basic
    @Column(name = "concert_id")
    public Integer getConcertId() {
        return concertId;
    }

    public void setConcertId(Integer concertId) {
        this.concertId = concertId;
    }

    @Basic
    @Column(name = "tour_id")
    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "album_id")
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "length")
    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Performance that = (Performance) o;

        if (performanceId != null ? !performanceId.equals(that.performanceId) : that.performanceId != null)
            return false;
        if (concertId != null ? !concertId.equals(that.concertId) : that.concertId != null) return false;
        if (tourId != null ? !tourId.equals(that.tourId) : that.tourId != null) return false;
        if (albumId != null ? !albumId.equals(that.albumId) : that.albumId != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = performanceId != null ? performanceId.hashCode() : 0;
        result = 31 * result + (concertId != null ? concertId.hashCode() : 0);
        result = 31 * result + (tourId != null ? tourId.hashCode() : 0);
        result = 31 * result + (albumId != null ? albumId.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        return result;
    }
}
