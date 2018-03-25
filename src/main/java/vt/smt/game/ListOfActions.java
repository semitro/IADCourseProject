package vt.smt.game;

/**
 * Список действий, которые способен вызвать executor
 * Для добавления новых достаточно создавать публичные методы
 * с соответсвующими названиями
 */

public abstract class ListOfActions {

    // Нужно вести лог
    private ActionResult result;

    public void sayHello(){
        System.err.println("Helllo");
    }

    public void show(Integer a){
        System.err.println(a);
    }

    void sum(Integer a, Integer b){
        System.err.println("sum");
        System.err.println(a + b);
    }

    public ActionResult getResult() {
        return result;
    }

    public void setResult(ActionResult result) {
        this.result = result;
    }

    // Метод будет вызываться, например, каждый ход. @override в потомках
    public void tick(Integer value){

    }
}
