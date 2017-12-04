package vt.smt.ent.bands;

import javax.persistence.*;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "album_band")
@IdClass(AlbumBandPK.class)
public class AlbumBand {
    private Integer albumId;
    private Integer bandId;

    @Id
    @Column(name = "album_id")
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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

        AlbumBand albumBand = (AlbumBand) o;

        if (albumId != null ? !albumId.equals(albumBand.albumId) : albumBand.albumId != null) return false;
        if (bandId != null ? !bandId.equals(albumBand.bandId) : albumBand.bandId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = albumId != null ? albumId.hashCode() : 0;
        result = 31 * result + (bandId != null ? bandId.hashCode() : 0);
        return result;
    }
}
