package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
