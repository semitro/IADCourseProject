package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.AlbumBand;

import vt.smt.ent.AlbumBandPK;

public interface AlbumBandRepository extends JpaRepository<AlbumBand, AlbumBandPK> {

}
