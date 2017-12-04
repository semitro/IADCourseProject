package vt.smt.ent.bands;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
public class AlbumBandPK implements Serializable {
    private Integer albumId;
    private Integer bandId;

    @Column(name = "album_id")
    @Id
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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

        AlbumBandPK that = (AlbumBandPK) o;

        if (albumId != null ? !albumId.equals(that.albumId) : that.albumId != null) return false;
        if (bandId != null ? !bandId.equals(that.bandId) : that.bandId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = albumId != null ? albumId.hashCode() : 0;
        result = 31 * result + (bandId != null ? bandId.hashCode() : 0);
        return result;
    }
}
