package Design_Pattern.Pattern_Decorator;

/**
 * Has a "Has a" relationship with Pizza. This is an aggregation relationship
 */
abstract class ToppingDecorator implements Pizza{
    protected Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza) {
        /* Assigns the type instance to this attribute of a Pizza */
        /* All decorators can dynamically customize the Pizza instance Plain Pizza because of this */
        this.tempPizza = newPizza;
        System.out.println("Put a new topping");
    }

    public String getDescription(){
        return tempPizza.getDescription();
    }

    public double getCost(){
        return tempPizza.getCost();
    }

}
