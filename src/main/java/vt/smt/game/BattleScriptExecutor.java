package vt.smt.game;

import java.util.LinkedList;
import java.util.List;
import vt.smt.ent.game.GameCharacter;

/**
 * Испольнитель специально для битвы.
 * Поддерживает me.make() и enemy.do()
 */
public class BattleScriptExecutor extends ScriptExecutor {

    private GameCharacter me;
    private GameCharacter enemy;

    public BattleScriptExecutor(GamerCharacterActions listOfActions){
        super(listOfActions);
    }

    @Override
    public ActionResult executeStatement(String script) throws IllegalArgumentException {
        String[] statements = script.split("\\s*;\\s*");
        List<ActionResult> ret = new LinkedList<>();
        try {
            for (String statement: statements) {
                if(script.indexOf('.') == -1 ) throw new IllegalArgumentException("Не могу" +
                        "выполнить script '" + statement + "'. Отсутсвует '.'!");
                ((GamerCharacterActions) getListOfActions()).setCaster(me);

                switch (statement.substring(0,statement.indexOf('.')).toUpperCase()){
                    case "ME":
                    case "SELF":
                    {
                        ((GamerCharacterActions) getListOfActions()).setTarget(me);
                        break;
                    }
                    case "OTHER":
                    case "ENEMY":
                    case "EN":{
                        ((GamerCharacterActions) getListOfActions()).setTarget(enemy);
                        break;
                    }
                }
                ret.add(super.executeStatement(statement));
            }
        } catch (IllegalStateException e) {
            ActionResult result = new ActionResult();
            result.addMessage("ход потрачен впустую");
            ret.add(result);
        }
        ActionResult actualRet = new ActionResult();
        ret.stream().forEach(action -> 
                action.getMessages().stream().forEach(msg -> actualRet.addMessage(msg))
        );
        return actualRet;
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
