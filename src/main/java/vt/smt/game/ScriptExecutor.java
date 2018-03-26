package vt.smt.game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Эта штука умеет парсить скрипт:
 * выполнять по очереди все действия, разделённые ';'
 * Вызывает методы переданного класса listOfActions.
 * Можно передавать произвольное число параметров типа Integer или
 * вызывать метод без аргументов
 */
public class ScriptExecutor {

    private ListOfActions listOfActions; // all the methods of this class can be invoked by script

    // Можно будет по имени вызывать любые методы (принимающие int или ничего)
    // из переданного класса
    // ex: something.show(1);
    public ScriptExecutor(ListOfActions listOfActions){
        this.listOfActions = listOfActions;
    }

    public void parseScriptAndDoAction(String script){
        for (String s : script.split(";")) {
            executeStatement(s);
        }
    }

    public ActionResult executeStatement(String statement) throws IllegalArgumentException{
        ActionResult result = new ActionResult();
        getListOfActions().setResult(result);
        String functionName = "";
        List<Integer> functionArgs = new LinkedList<>();
        //determine action
        try {
            if(statement.indexOf('.') == -1)
                functionName = statement.substring(0, statement.indexOf('('));
                        else
                functionName = statement.substring(
                    1 + statement.indexOf('.'), statement.indexOf('('));
        }catch (StringIndexOutOfBoundsException e){
            throw  new IllegalArgumentException("Не могу выделить название метода в script: " + statement
            + " '(' не обнаружена", e);
        }

        try {
            for (String arg : statement.substring(1 + statement.indexOf('('), statement.indexOf(')')).split(",")) {
                if (arg.equals(""))
                    break;
                functionArgs.add(Integer.parseInt(arg.trim()));
            }
        }catch (StringIndexOutOfBoundsException e){
            throw  new IllegalArgumentException("Не могу определить аргументы метода в script '"
            + statement + "' ", e);
        }

        boolean thereIsSuchMethod = false;
        for (Method method : listOfActions.getClass().getMethods()) {
            if(method.getName().equals(functionName)){
                thereIsSuchMethod = true;
                try {
                    Boolean success = (Boolean)method.invoke(listOfActions, functionArgs.toArray());
                    if (!success) {
                        throw new IllegalStateException();
                    }
                } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                    throw new IllegalArgumentException("Не могу вызвать метод " + functionName
                    + " в " + listOfActions.getClass() + " по скрипту '" + statement, e);
                }
            }
        }
        listOfActions.tick(1); // Удобно иметь метод, который вызывается каждый раз. 1 ничего не значит
        if(!thereIsSuchMethod)
            throw new IllegalArgumentException("Метод " + functionName + " не найден. Script: '" +
            statement + "' ");
        return result;
    }


    public ListOfActions getListOfActions() {
        return listOfActions;
    }

    public void setListOfActions(ListOfActions listOfActions) {
        this.listOfActions = listOfActions;
    }
}
