package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
