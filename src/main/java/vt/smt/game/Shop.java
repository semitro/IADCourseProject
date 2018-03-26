package vt.smt.game;

/**
 * Created by semitro on 26.03.18.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.CharacterItemRepository;
import vt.smt.ent.game.CharacterItem;
import vt.smt.ent.game.GameCharacter;
import vt.smt.ent.game.Item;

@Component
public class Shop {

    @Autowired
    private CharacterItemRepository characterItemRepository;

    public void sellItem(GameCharacter character, Item item) throws IllegalArgumentException{

        for (CharacterItem characterItem : character.getItems()) {
            if(characterItem.getItem().equals(item)) {
                character.setRoses(character.getRoses() + item.getPrice());
                if(characterItem.getNumber() == null
                        || characterItem.getNumber() == 1) { // Если -1 не имеет смысла
                    characterItemRepository.delete(characterItem);
                }
                else{
                    characterItem.setNumber(characterItem.getNumber()-1);
                    characterItemRepository.save(characterItem);
                }
            }
        }

        // Нет такого предмета в инвентаре
        throw new IllegalArgumentException("Пользователь " + character +
                " не имеет предмета " + item + ", а потому не может его продать");
    }
}
