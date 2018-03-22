package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Created by semitro on 20.03.18.
 */
public class Battle {
    private GameCharacter gamer;
    private GameCharacter enemy;


    private BattleScriptExecutor gamerAction;
    private BattleScriptExecutor enemyAction;

    private Semaphore gamerStepLock;
    private Semaphore enemyStepLock;

    public enum GAMERS{
        me,
        enemy
    }
    private volatile GAMERS turn;

    public Battle(GameCharacter me, GameCharacter enemy){
        this.gamer = me;
        this.enemy = enemy;
        turn = GAMERS.me;//= Math.random() > 0.25 ? GAMERS.me : GAMERS.enemy;
        gamerStepLock = new Semaphore(0);
        enemyStepLock = new Semaphore(0);

        gamerAction = new BattleScriptExecutor(new GamerCharacterActions());
        enemyAction = new BattleScriptExecutor(new GamerCharacterActions());

        gamerAction.setMe(gamer);
        gamerAction.setEnemy(enemy);
        enemyAction.setMe(enemy); // Для соперника соперник - игрок
        enemyAction.setEnemy(gamer);
        new Thread(this::start).start();
    }

    public String step(String script, GAMERS who){
        if(this.turn != who)
            return "Сейчас Не Ваш ход";

        if(who == GAMERS.me) {
            gamerAction.executeStatement(script);
            gamerStepLock.release();

        }
        else {
            enemyAction.executeStatement(script);
            enemyStepLock.release();
        }
        return "Вы сходили:" + script;
    }

    private boolean itsOver(){
        return  false;
    }

    private void start(){
        while(!itsOver()) {
            while (turn == GAMERS.me)
            {
                try {
                    System.err.println("Сейчас залочусь me");

                    gamerStepLock.acquire(); // it's waiting until step(something, gamer) is invoked
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                turn = GAMERS.enemy;
            }

            while (turn == GAMERS.enemy)
            {
                try {
                    System.err.println("Сейчас залочусь enemy");
                    enemyStepLock.acquire(); // it's waiting until step(something, enemy) is invoked
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                turn = GAMERS.me;
            }

        }
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



}
