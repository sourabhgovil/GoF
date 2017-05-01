package gof.behavioural;

/**
 * Created by sgovil on 4/30/17.
 */


public class CoR {

    public static void main(String [] args)
    {
        Approver larry = new Director();
        Approver sam = new VicePresident();
        Approver tammy = new President();

        larry.SetSuccessor(sam);
        sam.SetSuccessor(tammy);

        Purchase p = new Purchase(2034, 500.0, "assets a");
        larry.ProcessRequest(p);

        p = new Purchase(2035, 25500.0, "assets b");
        larry.ProcessRequest(p);

        p = new Purchase(2036, 175500.0, "assets c");
        larry.ProcessRequest(p);

    }

}

abstract class Approver
{
    protected Approver successor;

    public void SetSuccessor(Approver successor)
    {
        this.successor = successor;

    }
    public abstract void ProcessRequest(Purchase request);
}



class Purchase{

    private int _number;
    private double _amount;
    private String _purpose;

    public int get_number() {
        return _number;
    }

    public void set_number(int _number) {
        this._number = _number;
    }

    public double get_amount() {
        return _amount;
    }

    public void set_amount(double _amount) {
        this._amount = _amount;
    }

    public String get_purpose()
    {
        return _purpose;
    }

    public void set_purpose(String _purpose)
    {
        this._purpose = _purpose;
    }

    public Purchase(int number, double amount, String purpose)
    {
        this._number = number;
        this._amount = amount;
        this._purpose = purpose;
    }
}

class Director extends Approver
{
    public void ProcessRequest(Purchase request)
    {
        if (request.get_amount() < 10000.0)
        {
            System.out.format("%s approves request# %s", this.getClass().getSimpleName(), request.get_amount() );
            System.out.println();
        }
        else if (successor != null)
            successor.ProcessRequest(request);
    }
}

class VicePresident extends Approver
{
    public void ProcessRequest(Purchase request)
    {
        if (request.get_amount() < 50000.0)
        {
            System.out.format("%s approves request# %s", this.getClass().getSimpleName(), request.get_amount() );
            System.out.println();
        }
        else if (successor != null)
            successor.ProcessRequest(request);
    }
}

class President extends Approver
{
    public void ProcessRequest(Purchase request)
    {
        if (request.get_amount() < 100000.0)
        {
            System.out.format("%s approves request# %s", this.getClass().getSimpleName(), request.get_amount() );
            System.out.println();
        }
        else
            System.out.format("%s is an amount which will be approved by a Committee.", request.get_amount());
    }
}
