package gof.behavioural;

import javax.print.attribute.standard.MediaPrintableArea;
import java.security.MessageDigest;

/**
 * Created by sgovil on 5/3/17.
 */
public class MediatorPattern {
    public static void main(String[] args)
    {
        System.out.println("hi");

        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);
        m.set_colleague1(c1);
        m.set_colleague2(c2);

        c1.Send("hi");
        c2.Send("bye");
    }
}

abstract class Mediator{
    public abstract void Send(String message, Colleague colleague);
}

abstract class Colleague
{
    protected Mediator mediator;

    public Colleague(Mediator mediator)
    {
        this.mediator = mediator;
    }
}

class ConcreteMediator extends Mediator {

    public void set_colleague1(ConcreteColleague1 colleague1) {
        this._colleague1 = colleague1;
    }

    public void set_colleague2(ConcreteColleague2 colleague2) {
        this._colleague2 = colleague2;
    }

    private ConcreteColleague1 _colleague1;
    private ConcreteColleague2 _colleague2;



    public void Send(String message, Colleague colleague)
    {
        if(colleague == _colleague1)
        {
            _colleague2.Notify(message);
        }
        else
        {
           _colleague1.Notify(message);
        }
    }
}

  class ConcreteColleague1 extends Colleague
{
    public ConcreteColleague1(Mediator mediator)
    {
        super(mediator);
    }

    public void Send(String message)
    {
        mediator.Send(message, this);
    }

    public void Notify(String message)
    {
        System.out.println("Colleague1 gets message: " + message);
    }
}

class ConcreteColleague2 extends Colleague
{
    public ConcreteColleague2(Mediator mediator)
    {
        super(mediator);
    }

    public void Send(String message)
    {
        mediator.Send(message, this);
    }

    public void Notify(String message)
    {
        System.out.println("Colleague2 gets message: " + message);
    }
}

