package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.MemberRole;

import java.util.List;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer> {

}
