package vt.smt.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.*;
import vt.smt.ent.bands.Band;
import vt.smt.ent.game.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Component("adventureProcessor")
@Scope(value = "session")
public class AdventureProcessor implements AdventureInterface {

    private GameCharacter gameCharacter;
    private boolean inAdventure = false;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Override
    public AdventureEvent go(){
        if(inAdventure) throw new AlreadyInAdventureException();
        String ans = makeSomethingWithCharacter();
        try {
            characterRepository.saveAndFlush(gameCharacter);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AdventureEvent(ans, new Date(System.currentTimeMillis()));
    }

    @Autowired
    private BandRepository bandRepository;
    @Autowired
    private Shop itemShop; // Отсюда берём подарки

    // С одной стороны, лучше передавать игрока прямо в метод go:
    // не храним состояние, избегаем ошибок и бла-бла-бла;
    // но такой подход позволяет реализовать некую историю похода,
    // не меняя класса персонажа
    // и потенциально сделать путешествие более интересным
    @Override
    public void setTraveler(GameCharacter character) {
        this.gameCharacter = character;
    }

    private String makeSomethingWithCharacter(){
        Random random = new Random(System.currentTimeMillis());

        switch (random.nextInt(10)){
            case 0: {
                int newRoses = random.nextInt(50);
                gameCharacter.setRoses(gameCharacter.getRoses() + newRoses);
                return "Вы нашли " + newRoses + " роз!";
            }

            case 1:{
                int rhythm = random.nextInt(20);
                int exp = random.nextInt(100);
                gameCharacter.setRhythm(gameCharacter.getRhythm() + rhythm);
                return "Вы наконец-то порепетировали! Опыт +"
                        + exp + ", ритм + " + rhythm + "!";
            }
            case 2:{
                int health = random.nextInt(20);
                int attack = random.nextInt(250);
                gameCharacter.setAttack(gameCharacter.getAttack() + attack);
                gameCharacter.setHealth(gameCharacter.getHealth() - health >= 0?
                        gameCharacter.getHealth() - health : 0);
                return "Вы попали в драку и победили. Атака + " + attack + ", здоровье - " + health;
            }
            case 3:{
                int health = random.nextInt(200);
                int roses  = random.nextInt(32);
                int defence = random.nextInt(200);
                gameCharacter.setDefence(gameCharacter.getDefence() + defence);
                gameCharacter.setHealth(gameCharacter.getHealth() - health >= 0?
                        gameCharacter.getHealth() - health : 0);
                gameCharacter.setRoses(gameCharacter.getRoses() - roses >= 0?
                        gameCharacter.getRoses() - roses : 0);
                return "Вы попали в драку и проиграли.\n Навык защиты + " + defence + ", здоровье -" + health +
                        " роз " + roses + " отжато";
            }
            case 4:{
                int health = random.nextInt(1200);
                gameCharacter.setHealth(gameCharacter.getHealth() + health);
                return "Вы добрались до Бахчисарая. Здоровье +" + health;
            }
            case 5:{
                int exp = random.nextInt(32);
                gameCharacter.setExperience(gameCharacter.getExperience() + exp);
                return "Вы прошли не одну дорогу.. опыт + " + exp;
            }
            case 6:{
                int exp   = random.nextInt(400);
                int roses = random.nextInt(gameCharacter.getRoses() > 50 ? 50 : 0);
                List<Band> bands = bandRepository.findAll();
                int group = random.nextInt(bands.size());
                String bandName = bands.get(group).getName();
                gameCharacter.setExperience(gameCharacter.getExperience() + exp);
                return "Вы попали на концерт " + bandName
                        + " опыт + " + exp + " розы - " + roses;
            }
            case 7:{
                int exp = random.nextInt(12);
                int defence = random.nextInt(15);
                gameCharacter.setDefence(gameCharacter.getDefence() + defence);
                gameCharacter.setExperience(gameCharacter.getExperience() + exp);
                return "Вас подвезли хиппи :) "
                + "опыт + " + exp + ", защита + " + defence;

            }
            case 8:{
                List<ItemType> protoItems = itemTypeRepository.findAll();
                int index = random.nextInt(protoItems.size());
                if(protoItems.size()  == 0)
                    throw new IllegalStateException("Не могу подарить игроку предметов." +
                            "В базе нет записи о itemType");
                itemShop.giftItemToTheCharacter(gameCharacter, protoItems.get(index));
                return "Найден предмет: " + protoItems.get(index).getName();
            }
        }
        characterRepository.save(gameCharacter);
        return "Ничего не произошло";
    }

    public BandRepository getBandRepository() {
    return bandRepository;
}

    public void setBandRepository(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }
}
