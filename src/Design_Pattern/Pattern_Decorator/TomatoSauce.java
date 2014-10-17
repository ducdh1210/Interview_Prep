package Design_Pattern.Pattern_Decorator;

/**
 * Created by ducdh1210 on 10/17/14.
 */
public class TomatoSauce extends ToppingDecorator {
    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Tomato Sauce");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ", Tomato Sauce";
    }

    public double getCost(){
        return tempPizza.getCost() + 0.35;
    }
}
