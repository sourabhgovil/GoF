package gof.behavioural;


import java.util.ArrayList;
import java.lang.*;

/**
 * Created by sgovil on 5/2/17.
 */
abstract class Iterator {
    public abstract Object First();
    public abstract Object Next();
    public abstract Object Current();
    public abstract boolean IsDone();
}

abstract class Aggregator{
    public abstract Iterator CreateIterator();
}

class ConcreteAggregator extends Aggregator {

    private ArrayList _item = new ArrayList();

    Object get_item(int index) {
        return _item.get(index);
    }

    public void set_item(int index, Object value) {
        _item.add(index, value);
    }

    public Iterator CreateIterator()
    {
        return new ConcreteIterator(this);
    }

    public int Count()
    {
        return _item.size();
    }

}

class ConcreteIterator extends Iterator{

    private ConcreteAggregator _aggregator;
    private int _current =0;

    public ConcreteIterator(ConcreteAggregator aggregator)
    {
        this._aggregator = aggregator;
    }

    public Object First(){
        return _aggregator.get_item(0);
    }
    public Object Next(){
        Object ret = null;

        if(_current < _aggregator.Count() -1)
        {
            ret = _aggregator.get_item(++_current);
        }
        return ret;
    }

    public Object Current(){
        return _aggregator.get_item(_current);
    }
    public boolean IsDone(){
        return _current >= _aggregator.Count();
    }


}

public class IteratorPattern
{
    public static void main(String [] args)
    {
        ConcreteAggregator a = new ConcreteAggregator();
        a.set_item(0,"Name");
        a.set_item(1,2);
        a.set_item(2,5);
        a.set_item(3,4);

        Iterator i = a.CreateIterator();

        System.out.println("Iterating over collection:");

        Object item = i.First();
        while(item != null)
        {
            System.out.println(item);
            item = i.Next();
        }
    }

}