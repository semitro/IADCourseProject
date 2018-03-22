package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.CharacterAbility;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.Battle;

import javax.faces.context.FacesContext;


@Component(value = "battlePageController")
@Scope(value = "session")
@ELBeanName(value = "battlePageController")
public class BattlePageController {

    private GameCharacter character;

    private CharacterAbility selectedAbility;

    private Battle battle;

    public BattlePageController(){
        character = (GameCharacter) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter");
        battle = new Battle(character, createEnemy());

    }

    public void step(){
        try {
            battle.step(selectedAbility.getAbility().getAbilityScript().getScript(), Battle.GAMERS.me);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        battle.step("me.show(24)", Battle.GAMERS.enemy);
    }

    private GameCharacter createEnemy(){
        return new GameCharacter();
    }
    public CharacterAbility getSelectedAbility() {
        return selectedAbility;
    }

    public void setSelectedAbility(CharacterAbility selectedAbility) {
        this.selectedAbility = selectedAbility;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }
}
