package vt.smt.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vt.smt.ent.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
