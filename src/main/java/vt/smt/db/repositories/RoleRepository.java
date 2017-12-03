package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
