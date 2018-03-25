package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "helloPageController" )
@Scope(value = "session")
@ELBeanName(value = "helloPageController")
public class HelloPageController {

    //managedProperty - не нужно! Оно используется для DI с помощью JSF
    private String username;

    private String password;

    public HelloPageController(){
        System.err.println("hello pageContorller constructor");
    }
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

}
