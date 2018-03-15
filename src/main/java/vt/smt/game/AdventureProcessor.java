package vt.smt.game;

import org.springframework.stereotype.Component;
import vt.smt.ent.game.GameCharacter;

import java.util.Date;
import java.util.Random;

@Component
public class AdventureProcessor implements AdventureInterface {

    private Integer progress = 0;

    private GameCharacter gameCharacter;
    private boolean inAdventure = false;

    @Override
    public AdventureEvent go(){
        if(inAdventure) throw new AlreadyInAdventureException();
        inAdventure = true;
        while(progress < 100) {
            progress += 10;
            int x = 2;
            for(int i = 0; i < 10000; i++){
                x *= 2;
            }
        }
        String ans = makeSomethingWithCharacter();
        inAdventure = false;
        return new AdventureEvent(ans, new Date(System.currentTimeMillis()));
    }

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

        switch (random.nextInt(2)){
            case 0: {
                int newRoses = random.nextInt(50);
                gameCharacter.setRoses(gameCharacter.getRoses() + newRoses);
                return "Вы нашли" + newRoses + "роз!";
            }

            case 1:{
                gameCharacter.setName("репей");
                return "Теперь вас зовут репей!";
            }
        }
        return "Ничего не произошло";
    }

    @Override
    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
