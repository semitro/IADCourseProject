package vt.smt.ent.bands;

import javax.persistence.*;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "tour_band")
@IdClass(TourBandPK.class)
public class TourBand {
    private Integer tourId;
    private Integer bandId;

    @Id
    @Column(name = "tour_id")
    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Id
    @Column(name = "band_id")
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

        TourBand tourBand = (TourBand) o;

        if (tourId != null ? !tourId.equals(tourBand.tourId) : tourBand.tourId != null) return false;
        if (bandId != null ? !bandId.equals(tourBand.bandId) : tourBand.bandId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId != null ? tourId.hashCode() : 0;
        result = 31 * result + (bandId != null ? bandId.hashCode() : 0);
        return result;
    }
}
