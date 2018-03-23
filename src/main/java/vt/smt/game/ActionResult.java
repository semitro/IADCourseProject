package vt.smt.game;

import java.util.LinkedList;
import java.util.List;

/**
 * Результат выполнения скрипта.
 * Для ведения лога
 */
public class ActionResult {

    private final List<String> messages = new LinkedList<>();

    private boolean flag = false;

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    @Override
    public String toString() {
        return messages.toString();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
