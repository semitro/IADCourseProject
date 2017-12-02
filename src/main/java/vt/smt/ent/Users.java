package vt.smt.ent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

/**
 * Created by semitro on 03.12.17.
 */
@Entity
public class Users {
    private Integer userId;
    private String login;
    private String authType;
    private String idExternal;
    private byte[] password;
    private Integer accessLevel;

    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "auth_type")
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Basic
    @Column(name = "id_external")
    public String getIdExternal() {
        return idExternal;
    }

    public void setIdExternal(String idExternal) {
        this.idExternal = idExternal;
    }

    @Basic
    @Column(name = "password")
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Basic
    @Column(name = "access_level")
    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != null ? !userId.equals(users.userId) : users.userId != null) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (authType != null ? !authType.equals(users.authType) : users.authType != null) return false;
        if (idExternal != null ? !idExternal.equals(users.idExternal) : users.idExternal != null) return false;
        if (!Arrays.equals(password, users.password)) return false;
        if (accessLevel != null ? !accessLevel.equals(users.accessLevel) : users.accessLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (authType != null ? authType.hashCode() : 0);
        result = 31 * result + (idExternal != null ? idExternal.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        result = 31 * result + (accessLevel != null ? accessLevel.hashCode() : 0);
        return result;
    }
}
