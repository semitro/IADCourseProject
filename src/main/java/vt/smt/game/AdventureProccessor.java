package vt.smt.game;

import vt.smt.ent.game.GameCharacter;

import java.util.Random;

public class AdventureProccessor implements AdventureInterface {

    public String go(){
        if(inAdventure) throw new AlreadyInAdventureException();

        inAdventure = true;


        //executor.schedule(()->{
            String ans = makeSomethingWithCharacter();
            inAdventure = false;
            return ans;
        // },
         //       (long)(Math.random()*maxDelayToEvent), TimeUnit.SECONDS);
    }

    private String makeSomethingWithCharacter(){
        Random random = new Random(System.currentTimeMillis());

        switch (random.nextInt(1)){
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
    private GameCharacter gameCharacter;
    private boolean inAdventure = false;
//    private ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
//    private int maxDelayToEvent = 100;
}
