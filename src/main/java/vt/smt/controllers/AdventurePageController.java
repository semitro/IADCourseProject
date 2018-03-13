package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Component;

import vt.smt.ent.game.GameCharacter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
@Join(path = "/", to = "/adventure.jsf")
@Component(value = "adventurePageController")
@ELBeanName(value = "adventurePageController")
public class AdventurePageController {
    public void test(){
        System.out.println(((GameCharacter)FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter")).getName());
    }
}
