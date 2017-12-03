package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
