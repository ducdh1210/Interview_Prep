package Design_Pattern.Pattern_Decorator;

/**
 * Created by ducdh1210 on 10/17/14.
 */
public class Mozzarella extends ToppingDecorator{

    public Mozzarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Mozzarella");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ", Mozzarella";
    }

    public double getCost(){
        return tempPizza.getCost() + 0.50;
    }



}
