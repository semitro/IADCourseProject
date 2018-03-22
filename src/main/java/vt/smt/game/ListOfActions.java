package vt.smt.game;

/**
 * Список действий, которые способен вызвать executor
 * Для добавления новых достаточно создавать публичные методы
 * с соответсвующими названиями
 */

public abstract class ListOfActions {

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
}
