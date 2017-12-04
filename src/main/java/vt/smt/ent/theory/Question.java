package vt.smt.ent.theory;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Question implements Serializable {
    private Integer questionId;
    private String content;
    private String answer;
    private String wrong1;
    private String wrong2;
    private String wrong3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "wrong1")
    public String getWrong1() {
        return wrong1;
    }

    public void setWrong1(String wrong1) {
        this.wrong1 = wrong1;
    }

    @Basic
    @Column(name = "wrong2")
    public String getWrong2() {
        return wrong2;
    }

    public void setWrong2(String wrong2) {
        this.wrong2 = wrong2;
    }

    @Basic
    @Column(name = "wrong3")
    public String getWrong3() {
        return wrong3;
    }

    public void setWrong3(String wrong3) {
        this.wrong3 = wrong3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != null ? !questionId.equals(question.questionId) : question.questionId != null) return false;
        if (content != null ? !content.equals(question.content) : question.content != null) return false;
        if (answer != null ? !answer.equals(question.answer) : question.answer != null) return false;
        if (wrong1 != null ? !wrong1.equals(question.wrong1) : question.wrong1 != null) return false;
        if (wrong2 != null ? !wrong2.equals(question.wrong2) : question.wrong2 != null) return false;
        if (wrong3 != null ? !wrong3.equals(question.wrong3) : question.wrong3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId != null ? questionId.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (wrong1 != null ? wrong1.hashCode() : 0);
        result = 31 * result + (wrong2 != null ? wrong2.hashCode() : 0);
        result = 31 * result + (wrong3 != null ? wrong3.hashCode() : 0);
        return result;
    }
}
