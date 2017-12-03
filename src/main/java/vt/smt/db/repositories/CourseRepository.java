package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
