package Design_Pattern.Pattern_Decorator;

/**
 * Created by ducdh1210 on 10/17/14.
 */

/** Every Pizza made will start as a PlainPizza, this object will used used as Pizza object in
 * a class that implements ToppingDecorator */
/** Implements the Pizza interface with only the required methods from the interface */
public class PlainPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}
