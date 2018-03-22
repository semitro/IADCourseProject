package vt.smt.game;

/**
 * Результат выполнения скрипта.
 * Для ведения лога
 */
public class ActionResult {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    @Override
    public String toString() {
        return message;
    }
}
