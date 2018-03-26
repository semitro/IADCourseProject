package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vt.smt.db.repositories.*;
import vt.smt.ent.game.*;
import vt.smt.ent.net.Resource;
import vt.smt.game.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Бины создаёт Spring, судя по всему (аннотации JSF-бинодела закомменчены)
 */
//@ManagedBean(eager = true)
//@ApplicationScoped - не нужны
@Component(value = "characterPageController") // Indicates that an annotated class is a "component".
@Service
// / Such classes are considered as candidates for auto-detection
// when using annotation-based configuration and classpath scanning. (spring)
@Scope(value = "request")
@ELBeanName(value = "characterPageController")  // EL - expression language - как он зоётся из JSF
public class CharacterPageController {

    private GameCharacter character;
    private CharacterAbility selectedAbility;

    private CharacterItem selectedItem;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private Shop itemShop;

    public void sellSelectedItem(CharacterItem characterItem){
        itemShop.sellItem(characterItem, character);
        characterRepository.save(character);
    }

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

    public List<Resource> getCharacterImages() {
        List<Resource> res = resourceRepository.findByType("img");
        return res.stream()
                .filter(r -> r.getUrl().startsWith("/img/characters"))
                .collect(Collectors.toList());
    }

    public void setImage(Resource image) {
        character.setImageResource(image);
        characterRepository.save(character);
    }

    public Resource getImage() {
        return character.getImageResource();
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }


    public CharacterAbility getSelectedAbility() {
        return selectedAbility;
    }
    
    public String getAbilityAvailable(CharacterAbility ability) {
        System.err.println(character);
        System.err.println(ability);
        if(character.getExperience() >= ability.getAbility().getMinExpToUse()) {
                return "Да";
        }
        else {
            return "Нет";
        }
    }

    public void setSelectedAbility(CharacterAbility selectedAbility) {
        this.selectedAbility = selectedAbility;
    }

    public void setResourceRepository(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(CharacterItem selectedItem) {
        this.selectedItem = selectedItem;
    }

}
