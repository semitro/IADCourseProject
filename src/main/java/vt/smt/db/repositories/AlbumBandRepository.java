package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.AlbumBand;

import vt.smt.ent.bands.AlbumBandPK;

public interface AlbumBandRepository extends JpaRepository<AlbumBand, AlbumBandPK> {

}
