package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Author;

import vt.smt.ent.bands.AuthorPK;

public interface AuthorRepository extends JpaRepository<Author, AuthorPK> {

}
