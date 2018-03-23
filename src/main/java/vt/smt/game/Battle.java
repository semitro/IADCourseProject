package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

import java.util.Scanner;

/**
 * Created by semitro on 20.03.18.
 */
public class Battle {

    public enum GAMERS{
        enemy,
        me
    }

    private GameCharacter gamer;
    private GameCharacter enemy;
    private BattleScriptExecutor gamerAction;
    private BattleScriptExecutor enemyAction;

    private GAMERS turn;

    private boolean isItGoing;

    public Battle(GameCharacter me, GameCharacter enemy){
        this.gamer = me;
        this.enemy = enemy;
        turn = Math.random() > 0.25 ? GAMERS.me : GAMERS.enemy;
        isItGoing = true;
        gamerAction = new BattleScriptExecutor(new GamerCharacterActions());
        enemyAction = new BattleScriptExecutor(new GamerCharacterActions());

        gamerAction.setMe(gamer);
        gamerAction.setEnemy(enemy);
        enemyAction.setMe(enemy); // Для соперника соперник - игрок
        enemyAction.setEnemy(gamer);
    }

    public ActionResult step(String script, GAMERS who){
        ActionResult result = new ActionResult();
        if(this.turn != who) {
            result.addMessage("Сейчас не Ваш ход!");
            return result;
        }

        if(who == GAMERS.me) {
            result = gamerAction.executeStatement(script);
            turn = GAMERS.enemy;
        }
        else {
            result = enemyAction.executeStatement(script);
            turn = GAMERS.me;
        }

        if(itsOver()) {
            isItGoing = false;
            // flag says battle's over
            result.addMessage(enemy.getHealth() <= 0?
            "Вы попедили!": "Вы проиграли");
        }

        return result;
    }

    private boolean itsOver(){
        return  gamer.getHealth() <= 0 || enemy.getHealth() <= 0;
    }

    public static void main(String[] args) {
        Battle.GAMERS t = Battle.GAMERS.me;
        Battle b = new Battle(new GameCharacter(), new GameCharacter());

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            System.out.println(b.step(sc.nextLine(), t));
            if(t == GAMERS.me)
                t = GAMERS.enemy;
            else
                t = GAMERS.me;
        }

    }


    public boolean isItGoing() {
        return isItGoing;
    }

}
