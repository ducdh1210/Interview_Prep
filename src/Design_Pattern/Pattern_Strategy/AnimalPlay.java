package Design_Pattern.Pattern_Strategy;

/**
 * Created by ducdh1210 on 10/9/14.
 */
public class AnimalPlay {
    public static void main(String[] args){

        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.tryToFly());

        System.out.println("Bird: " + tweety.tryToFly());

        // This allows dynamic changes for flyingType
        sparky.setFlyingAbility(new ItFlys());
        System.out.println("Dog: " + sparky.tryToFly());

    }

}
