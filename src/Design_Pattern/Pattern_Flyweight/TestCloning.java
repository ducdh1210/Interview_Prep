package Design_Pattern.Pattern_Flyweight;

/**
 * Created by ducdh1210 on 10/10/14.
 */
public class TestCloning {
    public static void main(String[] args) {
        // Handles routing makeCopy method calls to the
        // right subclasses of Animal
        CloneFactory animalMaker = new CloneFactory();

        // Creates a new Sheep instance
        Sheep sally = new Sheep();

        // Creates a clone of Sally and stores it in its own
        // memory location
        Sheep clonedSheep = (Sheep) animalMaker.getClone(sally); // clonedSheep can also be of type Animal. But either way, downcast to (Sheep) is required

        // These are exact copies of each other

        System.out.println(sally);

        System.out.println(clonedSheep);

        System.out.println("Sally HashCode: " + System.identityHashCode(System.identityHashCode(sally)));

        System.out.println("Clone HashCode: " + System.identityHashCode(System.identityHashCode(clonedSheep)));






    }

}
