package gof.behavioural;

import java.util.ArrayList;

/**
 * Created by sgovil on 5/9/17.
 */
public class MementoPattern {

    public static void main(String [] args){
        Caretaker c = new Caretaker();
        Originator o = new Originator();
        System.out.println(o.getState());
        o.setState("1");
        System.out.println(o.getState());
        o.setState("2");
        System.out.println(o.getState());
        c.addMementos(o.setMemento());
        o.setState("3");
        System.out.println(o.getState());
        c.addMementos(o.setMemento());
        System.out.println(o.getState());
        o.getMemento(c.getMemento());
        System.out.println(o.getState());

    }
}

class Memento {
    private String state;

    public Memento(String state)
    {
        this.state = state;
    }

    public String getMemento() {
        return this.state;
    }
}

class Originator{

    private String state;

    public void setState(String state)
    {
        this.state = state;
    }

    public String getState(){
        return this.state;
    }
    public Memento setMemento()
    {
        return new Memento(state);
    }

    public void getMemento(Memento m)
    {
        state =  m.getMemento();
    }
}

class Caretaker{
    private ArrayList<Memento> mems = new ArrayList<>();

    public void addMementos(Memento m){
        mems.add(m);
    }

    public Memento getMemento()
    {
        return mems.get(1);
    }
}