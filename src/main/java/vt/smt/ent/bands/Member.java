package vt.smt.ent.bands;

import vt.smt.ent.game.GameCharacter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Member implements Serializable {

    private Integer memberId;

    private List<GameCharacter> gameCharacters;

    private Person person;

    private Band band;

    private Date joinDate;

    private Date leaveDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public Integer getMemberId() {
        return memberId;
    }
    @Basic
    @Column(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    @Basic
    @Column(name = "band_id")
    public Band getBand() {
        return band;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "join_date")
    public Date getJoinDate() {
        return joinDate;
    }



    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "leave_date")
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    @OneToMany(mappedBy = "memberOwner", fetch = FetchType.EAGER)
    public List<GameCharacter> getGameCharacters() {
        return gameCharacters;
    }

    public void setGameCharacters(List<GameCharacter> gameCharacters) {
        this.gameCharacters = gameCharacters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (memberId != null ? !memberId.equals(member.memberId) : member.memberId != null) return false;
        if (joinDate != null ? !joinDate.equals(member.joinDate) : member.joinDate != null) return false;
        if (leaveDate != null ? !leaveDate.equals(member.leaveDate) : member.leaveDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = memberId != null ? memberId.hashCode() : 0;
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (leaveDate != null ? leaveDate.hashCode() : 0);
        return result;
    }
}
