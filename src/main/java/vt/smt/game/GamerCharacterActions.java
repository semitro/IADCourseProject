package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

public class GamerCharacterActions extends ListOfActions {
    private GameCharacter target;
    private GameCharacter caster;

    public void hit(Integer damage){
        target.setHealth(target.getHealth() - damage);
    }

    public void regularAttack(){
        hit(caster.getAttack() - target.getDefence());
        getResult().setMessage("Обычная атака: нанесено" +
                (caster.getAttack() - target.getDefence()) + " урона ");
    }

    public GameCharacter getTarget() {
        return target;
    }

    public void setTarget(GameCharacter target) {
        this.target = target;
    }

    public GameCharacter getCaster() {
        return caster;
    }

    public void setCaster(GameCharacter caster) {
        this.caster = caster;
    }
}
