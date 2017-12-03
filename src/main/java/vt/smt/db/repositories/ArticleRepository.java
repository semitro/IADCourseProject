package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.theory.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
