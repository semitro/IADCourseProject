package vt.smt.ent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Member {
    private Integer memberId;
    private Integer personId;
    private Integer bandId;
    private Date joinDate;
    private Date leaveDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "band_id")
    public Integer getBandId() {
        return bandId;
    }

    public void setBandId(Integer bandId) {
        this.bandId = bandId;
    }

    @Basic
    @Column(name = "join_date")
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Basic
    @Column(name = "leave_date")
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (memberId != null ? !memberId.equals(member.memberId) : member.memberId != null) return false;
        if (personId != null ? !personId.equals(member.personId) : member.personId != null) return false;
        if (bandId != null ? !bandId.equals(member.bandId) : member.bandId != null) return false;
        if (joinDate != null ? !joinDate.equals(member.joinDate) : member.joinDate != null) return false;
        if (leaveDate != null ? !leaveDate.equals(member.leaveDate) : member.leaveDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = memberId != null ? memberId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (bandId != null ? bandId.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (leaveDate != null ? leaveDate.hashCode() : 0);
        return result;
    }
}
