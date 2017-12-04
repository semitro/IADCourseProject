package vt.smt.ent.bands;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Person implements Serializable {
    private Integer personId;
    private String name;
    private Date birthDate;

//    @ManyToOne
//    @JoinColumn(name="birth_place")
    private Place birthPlace;
    //private Integer birthPlace;
    private Date deathDate;


    private Place deathPlace;
//    private Integer deathPlace;
    private String sex;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

//    @Basic
//    @Column(name = "birth_place")
//    public Integer getBirthPlace() {
//        return birthPlace;
//    }
//
//    public void setBirthPlace(Integer birthPlace) {
//        this.birthPlace = birthPlace;
//    }

    @Basic
    @Column(name = "death_date")
    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

//    @Basic
//    @Column(name = "death_place")
//    public Integer getDeathPlace() {
//        return deathPlace;
//    }
//
//    public void setDeathPlace(Integer deathPlace) {
//        this.deathPlace = deathPlace;
//    }


    @ManyToOne
    @JoinColumn(name="birth_place")
    public Place getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Place birthPlace) {
        this.birthPlace = birthPlace;
    }

    @ManyToOne
    @JoinColumn(name="death_place")
    public Place getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(Place deathPlace) {
        this.deathPlace = deathPlace;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (personId != null ? !personId.equals(person.personId) : person.personId != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null) return false;
        if (birthPlace != null ? !birthPlace.equals(person.birthPlace) : person.birthPlace != null) return false;
        if (deathDate != null ? !deathDate.equals(person.deathDate) : person.deathDate != null) return false;
        if (deathPlace != null ? !deathPlace.equals(person.deathPlace) : person.deathPlace != null) return false;
        if (sex != null ? !sex.equals(person.sex) : person.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (birthPlace != null ? birthPlace.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + (deathPlace != null ? deathPlace.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
