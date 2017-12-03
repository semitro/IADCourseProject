package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
