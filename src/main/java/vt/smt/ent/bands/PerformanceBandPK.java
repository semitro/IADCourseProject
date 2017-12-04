package vt.smt.ent.bands;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
public class PerformanceBandPK implements Serializable {
    private Integer performanceId;
    private Integer bandId;

    @Column(name = "performance_id")
    @Id
    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
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

        PerformanceBandPK that = (PerformanceBandPK) o;

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
