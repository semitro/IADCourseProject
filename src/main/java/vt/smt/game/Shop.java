package vt.smt.game;

/**
 * Created by semitro on 26.03.18.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.*;
import vt.smt.ent.game.*;

@Component
public class Shop {

    @Autowired
    private CharacterItemRepository characterItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CharacterRepository characterRepository;

    public void sellItem(CharacterItem ch_item, GameCharacter by){
        if(ch_item == null)
            System.out.println("Попытка продажи null item");
        else
            System.out.println(ch_item);
        by.setRoses(by.getRoses() + ch_item.getItem().getPrice());
        if(ch_item.getNumber() > 1){
            ch_item.setNumber(ch_item.getNumber() - 1);
            characterItemRepository.save(ch_item);
        }
        else{
            characterItemRepository.delete(ch_item);
        }

//        else {
//            System.err.println("Предмет не продан: не найден");
//            throw new IllegalArgumentException("Пользователь " + character +
//                    " не имеет предмета " + ch_item + ", а потому не может его продать");
//          }
    }
//    public void sellItem(GameCharacter character, Item item) throws IllegalArgumentException{
//
//        for (CharacterItem characterItem : character.getItems()) {
//            if(characterItem.getItem().equals(item)) {
//                character.setRoses(character.getRoses() + item.getPrice());
//                if(characterItem.getNumber() == null
//                        || characterItem.getNumber() == 1) { // Если -1 не имеет смысла
//                    characterItemRepository.delete(characterItem);
//                }
//                else{
//                    characterItem.setNumber(characterItem.getNumber()-1);
//                    characterItemRepository.save(characterItem);
//                }
//            }
//        }
//
//        // Нет такого предмета в инвентаре
//        throw new IllegalArgumentException("Пользователь " + character +
//                " не имеет предмета " + item + ", а потому не может его продать");
//    }

    public void giftItemToTheCharacter(GameCharacter character, ItemType itemType){
        // Если предмет есть, количество + 1
        for (CharacterItem characterItem : character.getItems()) {
              if(characterItem.getItem().getType().equals(itemType)) {
                  characterItem.setNumber(characterItem.getNumber() + 1);
                  characterItemRepository.save(characterItem);
                  return;
              }
        }
       // Если нет предмета
        CharacterItem characterItem = new CharacterItem();
        Item item = new Item();
        item.setName(itemType.getName());
        item.setPrice(itemType.getTypeId()*123); // Хи-хи
        item.setType(itemType);
        characterItem.setGameCharacter(character); // owner
        itemRepository.save(item);
        characterItem.setItem(item);
        characterItem.setNumber(1);
        characterItemRepository.save(characterItem);
    }
    private boolean hasItem(GameCharacter character, ItemType item){
        for (CharacterItem characterItem : character.getItems()) {
            if(characterItem.getItem().getType().equals(item))
                return true;
        }
        return  false;
    }
}
