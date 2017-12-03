package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
