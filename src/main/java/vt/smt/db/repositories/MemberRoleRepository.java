package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vt.smt.ent.bands.MemberRole;

@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer> {

}
