package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.CompositionAlbum;

import vt.smt.ent.CompositionAlbumPK;

public interface CompositionAlbumRepository extends JpaRepository<CompositionAlbum, CompositionAlbumPK> {

}
