package vt.smt.controllers;

import vt.smt.ent.game.GameCharacter;

import javax.faces.context.FacesContext;

/**
 * Created by semitro on 20.03.18.
 */

public class BattlePageController {
    private GameCharacter character;


    public BattlePageController(){
        character = (GameCharacter) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter");
    }
}
