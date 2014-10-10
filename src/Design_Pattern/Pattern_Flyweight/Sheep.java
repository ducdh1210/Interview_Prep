package Design_Pattern.Pattern_Flyweight;

/**
 * Created by ducdh1210 on 10/10/14.
 */
public class Sheep implements Animal {

    public Sheep() {
        System.out.println("Sheep is made");
    }

    @Override
    public Animal makeCopy() {
        System.out.println("Sheep is being made");
        Animal sheepObject = null; //  "Sheep sheepObject = null" is also safer but less flexible
        try {
            // Calls the Animal super classes clone()
            // Then casts the results to Sheep
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            // If Animal didn't extend Cloneable this error
            // is thrown
            e.printStackTrace();
        }

        return sheepObject;
    }

    @Override
    public String toString() {
        return "Dolly is my hero, baa!!!!";
    }
}
