package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

public class GamerCharacterActions extends ListOfActions {
    private GameCharacter target;

    public void hit(Integer damage){
        target.setHealth(target.getHealth() - damage);
    }

    public GameCharacter getTarget() {
        return target;
    }

    public void setTarget(GameCharacter target) {
        this.target = target;
    }
}
