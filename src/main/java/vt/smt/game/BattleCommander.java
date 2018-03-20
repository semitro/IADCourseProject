package vt.smt.game;

/**
 * Возможно заменить игроком или AI.
 * Возвращает Script-ID
 */

public interface BattleCommander {
    String getNextStep();
}
