package Design_Pattern.Pattern_Strategy;

/**
 * Created by ducdh1210 on 10/9/14.
 */
public class Bird extends Animal{

    // The constructor initializes all objects

    public Bird(){

        super();

        this.setSound("Tweet");

        // We set the Flys interface polymorphically
        // This sets the behavior as a non-flying Animal

        //flyingType = new ItFlys();

        this.setFlyingAbility( new ItFlys() );

    }

}