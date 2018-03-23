package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

public class GamerCharacterActions extends ListOfActions {
    private GameCharacter target;
    private GameCharacter caster;

    public void hit(Integer damage){
        target.setHealth(target.getHealth() - damage);
    }


    public void regularAttack(){
        int damage = caster.getAttack() - target.getDefence();
        damage = damage > 0 ? damage : 0;
        hit(damage);
        getResult().addMessage("обычная атака: нанесено " + damage + " урона ");
    }

    // Хилка
    public void groupOfBlood(){
        caster.setHealth(caster.getHealth() + 100 + (int)(312*Math.random()));
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
