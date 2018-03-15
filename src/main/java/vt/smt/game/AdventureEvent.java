package vt.smt.game;

import java.util.Date;

/**
 * Что и когда произошло во время путешествия?
 */
public class AdventureEvent {

    private String info;
    private Date   date;

    public AdventureEvent(String info, Date date) {
        this.info = info;
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
