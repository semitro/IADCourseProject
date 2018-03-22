package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

/**
 * Created by semitro on 22.03.18.
 */
public class BattleScriptExecutor extends ScriptExecutor {

    private GameCharacter me;
    private GameCharacter enemy;

    public BattleScriptExecutor(GamerCharacterActions listOfActions){
        super(listOfActions);
    }

    @Override
    public void executeStatement(String statement) {
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
        super.executeStatement(statement);
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
