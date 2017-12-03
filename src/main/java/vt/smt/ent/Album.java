package vt.smt.ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Album implements Serializable {
    private Integer albumId;
    private String name;
    private Boolean isFake;
    private Boolean isSingle;
    private Date releaseDate;
    private Date recordStartDate;
    private Date recordEndDate;
    private Integer labelId;
    private Integer copiesNum;
    private String studio1;
    private String studio2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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
    @Column(name = "is_fake")
    public Boolean getFake() {
        return isFake;
    }

    public void setFake(Boolean fake) {
        isFake = fake;
    }

    @Basic
    @Column(name = "is_single")
    public Boolean getSingle() {
        return isSingle;
    }

    public void setSingle(Boolean single) {
        isSingle = single;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "record_start_date")
    public Date getRecordStartDate() {
        return recordStartDate;
    }

    public void setRecordStartDate(Date recordStartDate) {
        this.recordStartDate = recordStartDate;
    }

    @Basic
    @Column(name = "record_end_date")
    public Date getRecordEndDate() {
        return recordEndDate;
    }

    public void setRecordEndDate(Date recordEndDate) {
        this.recordEndDate = recordEndDate;
    }

    @Basic
    @Column(name = "label_id")
    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    @Basic
    @Column(name = "copies_num")
    public Integer getCopiesNum() {
        return copiesNum;
    }

    public void setCopiesNum(Integer copiesNum) {
        this.copiesNum = copiesNum;
    }

    @Basic
    @Column(name = "studio1")
    public String getStudio1() {
        return studio1;
    }

    public void setStudio1(String studio1) {
        this.studio1 = studio1;
    }

    @Basic
    @Column(name = "studio2")
    public String getStudio2() {
        return studio2;
    }

    public void setStudio2(String studio2) {
        this.studio2 = studio2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (albumId != null ? !albumId.equals(album.albumId) : album.albumId != null) return false;
        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (isFake != null ? !isFake.equals(album.isFake) : album.isFake != null) return false;
        if (isSingle != null ? !isSingle.equals(album.isSingle) : album.isSingle != null) return false;
        if (releaseDate != null ? !releaseDate.equals(album.releaseDate) : album.releaseDate != null) return false;
        if (recordStartDate != null ? !recordStartDate.equals(album.recordStartDate) : album.recordStartDate != null)
            return false;
        if (recordEndDate != null ? !recordEndDate.equals(album.recordEndDate) : album.recordEndDate != null)
            return false;
        if (labelId != null ? !labelId.equals(album.labelId) : album.labelId != null) return false;
        if (copiesNum != null ? !copiesNum.equals(album.copiesNum) : album.copiesNum != null) return false;
        if (studio1 != null ? !studio1.equals(album.studio1) : album.studio1 != null) return false;
        if (studio2 != null ? !studio2.equals(album.studio2) : album.studio2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = albumId != null ? albumId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isFake != null ? isFake.hashCode() : 0);
        result = 31 * result + (isSingle != null ? isSingle.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (recordStartDate != null ? recordStartDate.hashCode() : 0);
        result = 31 * result + (recordEndDate != null ? recordEndDate.hashCode() : 0);
        result = 31 * result + (labelId != null ? labelId.hashCode() : 0);
        result = 31 * result + (copiesNum != null ? copiesNum.hashCode() : 0);
        result = 31 * result + (studio1 != null ? studio1.hashCode() : 0);
        result = 31 * result + (studio2 != null ? studio2.hashCode() : 0);
        return result;
    }
}
