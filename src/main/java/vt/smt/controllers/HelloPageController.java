package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.GameCharacter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
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
    public String signIn(){
        System.out.println(username + "-" + password);
        FacesContext context = FacesContext.getCurrentInstance();

        GameCharacter gc = new GameCharacter();
        gc.setName("Vasua");
            context.getExternalContext().getSessionMap().put("GameCharacter",gc);
//            return "userhome?faces-redirect=true";
            return "main";
    }
}
