package vt.smt.ent.bands;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
public class TourBandPK implements Serializable {
    private Integer tourId;
    private Integer bandId;

    @Column(name = "tour_id")
    @Id
    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Column(name = "band_id")
    @Id
    public Integer getBandId() {
        return bandId;
    }

    public void setBandId(Integer bandId) {
        this.bandId = bandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourBandPK that = (TourBandPK) o;

        if (tourId != null ? !tourId.equals(that.tourId) : that.tourId != null) return false;
        if (bandId != null ? !bandId.equals(that.bandId) : that.bandId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId != null ? tourId.hashCode() : 0;
        result = 31 * result + (bandId != null ? bandId.hashCode() : 0);
        return result;
    }
}
