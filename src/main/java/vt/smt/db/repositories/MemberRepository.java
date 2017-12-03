package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.bands.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
