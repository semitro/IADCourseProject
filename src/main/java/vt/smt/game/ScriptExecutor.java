package vt.smt.game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by semitro on 21.03.18.
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

    public void executeStatement(String statement){
        String functionName = "";
        List<Integer> functionArgs = new LinkedList<>();
        //determine action
        // Если действие (), оно особенное
        functionName = statement.substring(
                1+statement.indexOf('.'), statement.indexOf('('));

        for (String arg : statement.substring(1+statement.indexOf('('), statement.indexOf(')')).split(",")) {
            if(arg.equals(""))
                break;
            functionArgs.add(Integer.parseInt(arg.trim()));
        }

        for (Method method : listOfActions.getClass().getMethods()) {
            if(method.getName().equals(functionName)){
                try {
                    method.invoke(listOfActions, functionArgs.toArray());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public ListOfActions getListOfActions() {
        return listOfActions;
    }

    public void setListOfActions(ListOfActions listOfActions) {
        this.listOfActions = listOfActions;
    }
}
