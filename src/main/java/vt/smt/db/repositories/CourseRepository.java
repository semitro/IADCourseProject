package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.theory.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByTitle(String title);
}
