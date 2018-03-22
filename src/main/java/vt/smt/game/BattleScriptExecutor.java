package vt.smt.game;

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
    public ActionResult executeStatement(String statement) throws IllegalArgumentException {

        if(statement.indexOf('.') == -1 ) throw new IllegalArgumentException("Не могу" +
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
        return super.executeStatement(statement);
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
