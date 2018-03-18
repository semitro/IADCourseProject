package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.AdventureEvent;
import vt.smt.game.AdventureInterface;
import vt.smt.game.AlreadyInAdventureException;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.LinkedList;
import java.util.List;


@Component(value = "adventurePageController")
@Scope(value = "session")
@ELBeanName(value = "adventurePageController")
public class AdventurePageController {

    @Autowired
    private AdventureInterface adventure;

    private List<AdventureEvent> events = new LinkedList<>();

    @PostConstruct
    public void loadCharacterFromSession(){
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
