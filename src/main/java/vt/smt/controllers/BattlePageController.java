package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.Battle;

import javax.faces.context.FacesContext;


@Component(value = "battlePageController")
@Scope(value = "session")
@ELBeanName(value = "battlePageController")
public class BattlePageController {
    private GameCharacter character;

    private Battle battle;

    public BattlePageController(){
        character = (GameCharacter) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter");
        battle = new Battle(character, createEnemy());

    }
    public void step(String command){
        battle.step(command, Battle.GAMERS.me);
        battle.step("me.show(24)", Battle.GAMERS.enemy);
    }
    private GameCharacter createEnemy(){
        return new GameCharacter();
    }
}
