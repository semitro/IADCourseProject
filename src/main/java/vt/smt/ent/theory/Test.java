package vt.smt.ent.theory;

import vt.smt.ent.Script;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Integer testId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reward_script_id", referencedColumnName = "script_id")
    private Script script;

    @OneToMany(mappedBy ="test",fetch=FetchType.EAGER)
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


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

        Test test = (Test) o;

        if (testId != null ? !testId.equals(test.testId) : test.testId != null) return false;
        if (title != null ? !title.equals(test.title) : test.title != null) return false;
        if (description != null ? !description.equals(test.description) : test.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId != null ? testId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", script=" + script +
                ", questions=" + questions +
                '}';
    }
}
