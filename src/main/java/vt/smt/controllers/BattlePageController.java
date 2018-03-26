package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.CharacterRepository;
import vt.smt.db.repositories.UsersRepository;
import vt.smt.ent.game.CharacterAbility;
import vt.smt.ent.game.GameCharacter;
import vt.smt.game.Battle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component(value = "battlePageController")
@Scope(value = "session")
@ELBeanName(value = "battlePageController")
public class BattlePageController {

    private GameCharacter character;

    private GameCharacter enemy;

    private CharacterAbility selectedAbility;

    @Autowired
    private Battle battle;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UsersRepository usersRepository;

    private List<String> battleLog = new LinkedList<>();

    private Authentication authentication;

    @PostConstruct
    public void BattlePageController(){
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
        authentication =
                SecurityContextHolder.getContext().getAuthentication();
//        character = usersRepository.findByLogin(authentication.getName()).getGameCharacters().get(0);
        restart();
    }

    public void restart(){
        character = characterRepository.findByName(authentication.getName());
        battleLog.clear();
        enemy = createEnemy();
        battle.start(character, enemy);
    }


    public void step(){
        System.out.println(character);
        if(!battle.isItGoing()){
            return;
        }

        List<String> result = new LinkedList<>();
        try {
           result.addAll(battle.step(
                    selectedAbility.getAbility().getAbilityScript().getScript(),
                    Battle.GAMERS.me).getMessages());
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        characterRepository.save(character);
        Collections.reverse(result);
        battleLog.addAll(0, result);
        if(!battle.isItGoing()) { // if battle's over after gamer's step, enemy can't step
            if(battle.getWinner() == Battle.GAMERS.me)
                winRegards(enemy); // Поднимаем статы за победу
            else
                thankForComingRegards(enemy);
            return;
        }
        result.clear();

        String enemyStep = getEnemyStep();
        System.err.println("Соперник ходит cкриптом "  + enemyStep);
        result.addAll(0,battle.step(enemyStep, Battle.GAMERS.enemy).getMessages());
        Collections.reverse(result); // Да, всё в такой странной последовательности
        battleLog.addAll(0, result);
        characterRepository.save(character);
        // Нужно дублирование
        if(!battle.isItGoing()) {
            if (battle.getWinner() == Battle.GAMERS.me)
                winRegards(enemy); // Поднимаем статы за победу
            else
                thankForComingRegards(enemy);
        }
    }

    private void showResult(String msg, int exp, int attack, int roses, int defence){
        FacesContext context = FacesContext.getCurrentInstance();
        String stats = "опыт + " + exp + "\nатака + " + attack  +
                "\nзащита + " + defence + "\nрозы + " + roses;
        context.addMessage(null, new FacesMessage(msg,stats));
        battleLog.add(0, stats);
    }

    private void thankForComingRegards(GameCharacter opponent){
        int exp = opponent.getExperience() /440 + 1;
        int attack = opponent.getAttack() / 80 + 1;
        int roses = opponent.getRoses() / 160 + 10;
        int defence = opponent.getDefence() / 190 + 15;

        character.setExperience(character.getExperience() + exp);
        character.setAttack(character.getAttack() + attack);
        character.setRoses(character.getRoses() + roses);
        character.setDefence(character.getDefence() + defence);
        showResult("Получены характеристики: ",exp, attack, roses,defence);
        characterRepository.save(character);
    }

    private void winRegards(GameCharacter opponent){
        int exp = opponent.getExperience() /10 + 1;
        int attack = opponent.getAttack() / 14 + 1;
        int roses = opponent.getRoses() / 15 + 10;
        int defence = opponent.getDefence() / 8 + 15;

        character.setExperience(character.getExperience() + exp);
        character.setAttack(character.getAttack() + attack);
        character.setRoses(character.getRoses() + roses);
        character.setDefence(character.getDefence() + defence);
        showResult("Это победа!", exp, attack, roses, defence);
        characterRepository.save(character);
    }
    // It's AI!!
    private String getEnemyStep(){
        Random random = new Random();
        if(enemy.getAbilities().size() == 0)
            return "enemy.regularAttack()";
        return enemy.getAbilities().get(random.nextInt(enemy.getAbilities().size()))
                .getAbility().getAbilityScript().getScript();
    }
    private GameCharacter createEnemy(){
        List<GameCharacter> possibleEnemies = characterRepository.findByMemberOwnerIsNotNull();
        Random random = new Random(System.currentTimeMillis());
        enemy = possibleEnemies.get(random.nextInt(possibleEnemies.size()));
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
    public List<String> getBattleLog() {
        return battleLog;
    }

    public void setBattleLog(List<String> battleLog) {
        this.battleLog = battleLog;
    }

    public GameCharacter getEnemy() {
        return enemy;
    }

    public void setEnemy(GameCharacter enemy) {
        this.enemy = enemy;
    }


}
