package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.CharacterAbility;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.Battle;
import vt.smt.game.ActionResult;
import vt.smt.db.repositories.CharacterRepository;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.LinkedList;
import java.util.List;

@Component(value = "battlePageController")
@Scope(value = "session")
@ELBeanName(value = "battlePageController")
public class BattlePageController {

    private GameCharacter character;

    private GameCharacter enemy;

    private CharacterAbility selectedAbility;
    private Battle battle;

    @Autowired
    private CharacterRepository characterRepository;

    private List<ActionResult> battleLog = new LinkedList<>();

    @PostConstruct
    public void BattlePageController(){
        character = (GameCharacter) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter");
        enemy = createEnemy();
        battle = new Battle(character, enemy);

    }

    public void step(){
        try {
            battleLog.add(battle.step(selectedAbility.getAbility().getAbilityScript().getScript(),
                    Battle.GAMERS.me));
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        battle.step("me.show(24)", Battle.GAMERS.enemy);

    }

    private GameCharacter createEnemy(){
        enemy = characterRepository.findByMemberOwnerIsNotNull().get(0);
        return enemy;
    }

    public CharacterAbility getSelectedAbility() {
        return selectedAbility;
    }

    public void setSelectedAbility(CharacterAbility selectedAbility) {
        this.selectedAbility = selectedAbility;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }
    public List<ActionResult> getBattleLog() {
        return battleLog;
    }

    public void setBattleLog(List<ActionResult> battleLog) {
        this.battleLog = battleLog;
    }

    public GameCharacter getEnemy() {
        return enemy;
    }

    public void setEnemy(GameCharacter enemy) {
        this.enemy = enemy;
    }


}
