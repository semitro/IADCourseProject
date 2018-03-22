package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by semitro on 21.03.18.
 */
public class ScriptExecutor {

    private GameCharacter statementTarget; // subject of an action

    private GameCharacter me; // subject of an action

    private GameCharacter enemy; // subject of an action
    public void parseScriptAndDoAction(String script){
        for (String s : script.split(";")) {
            executeStatement(s);
        }
    }


    public void executeStatement(String statement){
        switch (statement.substring(0,statement.indexOf('.')).toUpperCase()){
            case "ME":
            case "SELF":
            {
                statementTarget = me; // Нужно бы по зависимости от чётности хода
                break;
            }
            case "OTHER":
            case "ENEMY":
            case "EN":{
                statementTarget = enemy;
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
            if(method.getName().equals(functionName)){
                try {
                    method.invoke(this, functionArgs.toArray());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void hit(Integer damage){
        statementTarget.setHealth(statementTarget.getHealth() - damage);
    }

    void sayHello(){
        System.err.println("Helllo");
    }


    void show(Integer a){
        System.err.println(a);
    }
    void sum(Integer a, Integer b){
        System.err.println("sum");
        System.err.println(a + b);
    }
    public GameCharacter getMe() {
        return me;
    }

    public void setMe(GameCharacter me) {
        this.me = me;
    }

    public GameCharacter getEnemy() {
        return enemy;
    }

    public void setEnemy(GameCharacter enemy) {
        this.enemy = enemy;
    }
}
