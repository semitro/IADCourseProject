package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.theory.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
