package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.*;
import vt.smt.game.AdventureInterface;
import vt.smt.game.AlreadyInAdventureException;

import javax.faces.context.FacesContext;
import java.util.LinkedList;
import java.util.List;



@Join(path = "/", to = "/adventure.jsf")
@Component(value = "adventurePageController")
@Scope(value = "session")
@ELBeanName(value = "adventurePageController")
public class AdventurePageController {

    //@Autowired -- why doesn't it work?! Fix me!
    private AdventureInterface adventure = new AdventureProcessor();

    private List<AdventureEvent> events = new LinkedList<>();

    public AdventurePageController(){
        adventure.setTraveler((GameCharacter)FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter"));
    }

    public void letsTravel(){
        try {
            events.add(adventure.go());
        }catch (AlreadyInAdventureException e){

        }
    }

    public AdventureInterface getAdventure() {
        return adventure;
    }

    public void setAdventure(AdventureInterface adventure) {
        this.adventure = adventure;
    }

    public List<AdventureEvent> getEvents() {
        return events;
    }

    public void setEvents(List<AdventureEvent> events) {
        this.events = events;
    }
}
