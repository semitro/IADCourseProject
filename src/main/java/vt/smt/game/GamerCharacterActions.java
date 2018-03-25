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
        int health =  100 + (int)(312*Math.random());
        caster.setHealth(caster.getHealth() + health);
        getResult().addMessage("узнал свою группу крови. Здоровье + " + health);
    }

    // pure damage
    public void extremeVocal(){
        int damage = 100 + (int)(Math.random()*500);
        hit(damage);
        getResult().addMessage("поёт скримом. нанесено " + damage + " чистого урона");
    }

    // Увеличиваем атаку в два раза на три хода.
    private int attackBufSteps = 0;
    private int attackBufValue = 0;
    public void gainOverload(){
        if(attackBufSteps != 0) {
            attackBufSteps = 4; // Если вызываем несколько раз, продлеваем эффект, но не усиливаем
            getResult().addMessage("перегруз накручен на 3 хода");
            return;
        }
        attackBufSteps = 4;
        attackBufValue = caster.getAttack();
        caster.setAttack(caster.getAttack() + attackBufValue);
        getResult().addMessage("выкрутил ручку gain. На три хода атака x2");

    }

    // Каждый ход!
    @Override
    public void tick(Integer value) {
        super.tick(value);

        if(attackBufSteps == 1){
            caster.setAttack(caster.getAttack() - attackBufValue);
            getResult().getMessages().add("закончился эффект от выкручивания gain");
            System.out.println("Атака уменьшена на" + attackBufValue);
        }
        if(attackBufSteps > 0) attackBufSteps--; // Не будет же в битве 2^32 ходов?
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
