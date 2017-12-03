package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.CompositionAlbum;

import vt.smt.ent.bands.CompositionAlbumPK;

public interface CompositionAlbumRepository extends JpaRepository<CompositionAlbum, CompositionAlbumPK> {

}
