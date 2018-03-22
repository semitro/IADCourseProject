package vt.smt.controllers;

import vt.smt.ent.game.GameCharacter;
import vt.smt.game.Battle;

import javax.faces.context.FacesContext;
/**
 * Created by semitro on 20.03.18.
 */

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
