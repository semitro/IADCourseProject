package vt.smt.ent;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This thing contains the script in FAFA script language.
 * @see Character
 */
@Entity
public class Script implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "script_id")
    private Integer scriptId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name ="script")
    private String script;

    public Integer getScriptId() {
        return scriptId;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Script script1 = (Script) o;

        if (scriptId != null ? !scriptId.equals(script1.scriptId) : script1.scriptId != null) return false;
        if (name != null ? !name.equals(script1.name) : script1.name != null) return false;
        if (script != null ? !script.equals(script1.script) : script1.script != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scriptId != null ? scriptId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (script != null ? script.hashCode() : 0);
        return result;
    }
}
