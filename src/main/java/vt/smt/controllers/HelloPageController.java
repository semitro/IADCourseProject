package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.UsersRepository;
import vt.smt.ent.net.Users;

import javax.faces.context.FacesContext;

//@ManagedBean
//@SessionScoped
@Component(value = "helloPageController" )
@Scope(value = "session")
@ELBeanName(value = "helloPageController")

public class HelloPageController {

    //managedProperty - не нужно! Оно используется для DI с помощью JSF
    private String username;

    private String password;

    @Autowired
    private UsersRepository usersRepository;

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

    // It's invoked when user presses Войти button
    public String signIn(){
        FacesContext context = FacesContext.getCurrentInstance();

        Users user = usersRepository.findByLogin(username);
        if(user == null){
            System.err.println("Пользователь " + username + " не найден в базе");
        }
        else {
            try {
                context.getExternalContext().getSessionMap().put("GameCharacter", user.getGameCharacters().get(0));
            }
            catch (RuntimeException e){
                e.printStackTrace();
                System.err.println("У пользователя " + username + " нет персонажей!");
            }
        }

        return "main?faces-redirect=true";
    }
}
