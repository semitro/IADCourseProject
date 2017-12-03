package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
