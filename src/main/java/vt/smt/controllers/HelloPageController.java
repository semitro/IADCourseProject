package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.UsersRepository;
import vt.smt.db.repositories.CharacterRepository;

import vt.smt.ent.game.GameCharacter;
import vt.smt.ent.net.Users;

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

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CharacterRepository characterRepository;

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

        Users user = usersRepository.findByLogin(username);
        if(user == null){
            System.err.println("Пользователь " + username + " не найден в базе");
        }
        else {
            try {
                GameCharacter character = characterRepository.findAllGameCharactersByOwner(user).get(0);
                context.getExternalContext().getSessionMap().put("GameCharacter", character);
            }
            catch (RuntimeException e){
                System.err.println("У пользователя " + username + " нет персонажей!");
            }
        }

        return "main?faces-redirect=true";
    }
}
