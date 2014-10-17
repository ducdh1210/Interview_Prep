package Design_Pattern.Pattern_Decorator;

/**
 * Created by ducdh1210 on 10/17/14.
 */
public class PizzaMaker {
    public static void main(String[] args) {
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println("Ingredients: " + basicPizza.getDescription());
        System.out.println("Cost: " + basicPizza.getCost());
    }
}
