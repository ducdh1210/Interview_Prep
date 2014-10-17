package Design_Pattern.Pattern_Observer;

/**
 * Created by ducdh1210 on 10/13/14.
 */

/**  This interface handles adding, deleting, and updating all observers  **/
public interface Subject {

    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();

}
