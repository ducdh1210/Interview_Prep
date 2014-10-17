package Design_Pattern.Pattern_Observer;

/**
 * Created by ducdh1210 on 10/13/14.
 */

/** This Observer interface update method is called when the subject changes **/
public interface Observer {

    public void update(double ibmPrice, double aaplPrice, double googPrice);

    public int getObserverID();
}
