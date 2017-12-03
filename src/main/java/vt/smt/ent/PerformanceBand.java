package vt.smt.ent;

import javax.persistence.*;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "performance_band")
@IdClass(PerformanceBandPK.class)
public class PerformanceBand {
    private Integer performanceId;
    private Integer bandId;

    @Id
    @Column(name = "performance_id")
    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
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

        PerformanceBand that = (PerformanceBand) o;

        if (performanceId != null ? !performanceId.equals(that.performanceId) : that.performanceId != null)
            return false;
        if (bandId != null ? !bandId.equals(that.bandId) : that.bandId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = performanceId != null ? performanceId.hashCode() : 0;
        result = 31 * result + (bandId != null ? bandId.hashCode() : 0);
        return result;
    }
}
