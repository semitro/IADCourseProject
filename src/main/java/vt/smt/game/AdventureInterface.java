package vt.smt.game;
import vt.smt.ent.game.GameCharacter;
/**
 * Интерфейс путешествия игрока
 * Возвращает строку-сообщение о том, что собственно произошло
 */

public interface AdventureInterface {
    AdventureEvent go() throws AlreadyInAdventureException;
    void setTraveler(GameCharacter character);
}
