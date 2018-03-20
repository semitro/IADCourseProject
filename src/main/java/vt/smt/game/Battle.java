package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by semitro on 20.03.18.
 */
public class Battle {
    private GameCharacter gamer;
    private GameCharacter enemy;

    private BattleCommander gamerCommander;
    private BattleCommander enemyCommander;

    public void start(){
        gamerCommander.getNextStep();
        parseScriptAndDoAction("me.health+5;");
    }
    private void parseScriptAndDoAction(String script){
        for (String s : script.split(";")) {
            executeStatement(s);
        }
    }

    public static void main(String[] args) {
        Battle b = new Battle();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            b.parseScriptAndDoAction(sc.nextLine());
        }
    }
    private void executeStatement(String statement){
        GameCharacter target; // subject of an action
        // determine target
        // me.health..

        switch (statement.substring(0,statement.indexOf('.')).toUpperCase()){
            case "ME":
            case "SELF":
                {
                target = gamer; // Нужно бы по зависимости от чётности хода
                    break;
            }
            case "OTHER":
            case "ENEMY":
            case "EN":{
                target = enemy;
                break;
            }
        }
        String functionName = "";
        List<Integer> functionArgs = new LinkedList<>();
        //determine action
        // Если действие (), оно особенное
            functionName = statement.substring(
                    1+statement.indexOf('.'), statement.indexOf('('));

        for (String arg : statement.substring(1+statement.indexOf('('), statement.indexOf(')')).split(",")) {
            if(arg.equals(""))
                break;
            functionArgs.add(Integer.parseInt(arg.trim()));
        }

        for (Method method : this.getClass().getDeclaredMethods()) {
            System.out.println(method.getName() + " - " + functionName);
            if(method.getName().equals(functionName)){
                try {
                    method.invoke(this, functionArgs.toArray());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    void sayHello(){
        System.err.println("Helllo");
    }
    void sum(Integer a, Integer b){
        System.err.println("sum");
        System.err.println(a + b);
    }

}
