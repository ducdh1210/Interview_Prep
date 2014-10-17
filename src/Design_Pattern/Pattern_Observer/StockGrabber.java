package Design_Pattern.Pattern_Observer;

import java.util.ArrayList;

/**
 * Created by ducdh1210 on 10/13/14.
 */

/** Use the subject interface to update all Observers */
public class StockGrabber implements Subject{

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {
        /* Create an ArrayList to hold all observers */
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        /* Add a new observer to the ArrayList */
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        /* Get the index in the observer to delete */
        int observeIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observeIndex + 1) + " is deleted");
        /* Remove the observer from ArrayList */
        observers.remove(observeIndex);
    }

    @Override
    public void notifyObserver() {
        /* Cycle through all observers to delete. Note that it is the Observer object who did the update */
        for (Observer observer : observers){
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    /* anytime a price is changed, notifyObserver() is called */
    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }

    public void setAaplPrice(double aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObserver();
    }
}
