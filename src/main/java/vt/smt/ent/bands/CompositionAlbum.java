package vt.smt.ent.bands;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
@Table(name = "composition_album")
@IdClass(CompositionAlbumPK.class)
public class CompositionAlbum implements Serializable {
    private Integer compositionId;
    private Integer albumId;

    @Id
    @Column(name = "composition_id")
    public Integer getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(Integer compositionId) {
        this.compositionId = compositionId;
    }

    @Id
    @Column(name = "album_id")
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositionAlbum that = (CompositionAlbum) o;

        if (compositionId != null ? !compositionId.equals(that.compositionId) : that.compositionId != null)
            return false;
        if (albumId != null ? !albumId.equals(that.albumId) : that.albumId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compositionId != null ? compositionId.hashCode() : 0;
        result = 31 * result + (albumId != null ? albumId.hashCode() : 0);
        return result;
    }
}
