package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedProperty;

@Scope(value = "session")
@Join(path = "/", to = "/index.jsf")
@Component(value = "helloPageController")
@ELBeanName(value = "helloPageController")
public class HelloPageController {

    @ManagedProperty("username")
    private String username;

    @ManagedProperty("password")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // It invoked when user presses Войти button
    public void signIn(){
        System.out.println(username + "-" + password);
    }
}
