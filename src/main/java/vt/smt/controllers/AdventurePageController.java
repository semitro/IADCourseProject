package vt.smt.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.UsersRepository;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.AdventureEvent;
import vt.smt.game.AdventureInterface;
import vt.smt.game.AlreadyInAdventureException;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;


@Component(value = "adventurePageController")
@Scope(value = "session")
@ELBeanName(value = "adventurePageController")
public class AdventurePageController {

    @Autowired
    private AdventureInterface adventure;

    @Autowired
    private UsersRepository usersRepository;
    private GameCharacter character;

    private List<AdventureEvent> events = new LinkedList<>();
    
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM hh:mm:ss");

    @PostConstruct
    public void loadCharacterFromSession(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        character = usersRepository.findByLogin(authentication.getName()).getGameCharacters().get(0);
        adventure.setTraveler(character);
    }

    public void letsTravel(){
        try {
            events.add(0, adventure.go());
            if (events.size()>100) {
                events.subList(80, events.size()).clear();
            }
        }catch (AlreadyInAdventureException e){
            System.err.println("Already in an adventure!");
        }
    }
    
    public String formatDate(Date date) {
        return dateFormat.format(date);
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
