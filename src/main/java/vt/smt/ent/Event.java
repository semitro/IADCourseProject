package vt.smt.ent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Event {
    private Integer eventId;
    private String name;
    private String description;
    private Integer rewardScriptId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "reward_script_id")
    public Integer getRewardScriptId() {
        return rewardScriptId;
    }

    public void setRewardScriptId(Integer rewardScriptId) {
        this.rewardScriptId = rewardScriptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (eventId != null ? !eventId.equals(event.eventId) : event.eventId != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (rewardScriptId != null ? !rewardScriptId.equals(event.rewardScriptId) : event.rewardScriptId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rewardScriptId != null ? rewardScriptId.hashCode() : 0);
        return result;
    }
}
