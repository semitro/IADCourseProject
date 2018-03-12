package vt.smt.game;

/**
 * Интерфейс путешествия игрока
 * Возвращает строку-сообщение о том, что собственно произошло
 */

public interface AdventureInterface {
    String go() throws AlreadyInAdventureException;
}
