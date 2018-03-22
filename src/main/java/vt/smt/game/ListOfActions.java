package vt.smt.game;

/**
 * Created by semitro on 22.03.18.
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
