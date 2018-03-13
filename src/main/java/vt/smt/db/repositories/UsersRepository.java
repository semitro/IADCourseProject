package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.net.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);

}
