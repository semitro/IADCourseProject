package vt.smt.ent.theory;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */

@Entity
public class Article implements Serializable {
    private Integer articleId;
    private String title;
    private String subtitle;
    private String content;

    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }


    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (articleId != null ? !articleId.equals(article.articleId) : article.articleId != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (subtitle != null ? !subtitle.equals(article.subtitle) : article.subtitle != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId != null ? articleId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
