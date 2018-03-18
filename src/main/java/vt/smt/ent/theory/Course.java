package vt.smt.ent.theory;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Course implements Serializable {
    private Integer courseId;
    private String title;
    private String description;

    private List<Article> articles;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    public List<Article> getArticles() {
        return articles;
    }


    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
