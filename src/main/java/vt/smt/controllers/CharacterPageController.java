package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vt.smt.db.repositories.UsersRepository;
import vt.smt.ent.game.CharacterAbility;
import vt.smt.ent.game.GameCharacter;

import javax.annotation.PostConstruct;

/*
 * Бины создаёт Spring, судя по всему (аннотации JSF-бинодела закомменчены)
 */
//@ManagedBean(eager = true)
//@ApplicationScoped - не нужны
@Component(value = "characterPageController") // Indicates that an annotated class is a "component".
@Service
// / Such classes are considered as candidates for auto-detection
// when using annotation-based configuration and classpath scanning. (spring)
@Scope(value = "session")
@ELBeanName(value = "characterPageController")  // EL - expression language - как он зоётся из JSF
public class CharacterPageController {

    private GameCharacter character;

    private CharacterAbility selectedAbility;

    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void CharacterPageController(){
        // take it from the session
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        character = usersRepository.findByLogin(authentication.getName()).getGameCharacters().get(0);
    }

    public GameCharacter getCharacter() {
        return character;
    }


    public void setCharacter(GameCharacter character) {
        this.character = character;
    }

    public CharacterAbility getSelectedAbility() {
        return selectedAbility;
    }

    public void setSelectedAbility(CharacterAbility selectedAbility) {
        this.selectedAbility = selectedAbility;
    }
}
