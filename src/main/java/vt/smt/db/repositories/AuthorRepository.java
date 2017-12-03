package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Author;

import vt.smt.ent.AuthorPK;

public interface AuthorRepository extends JpaRepository<Author, AuthorPK> {

}
