package Design_Pattern.Pattern_Observer;

/**
 * Created by ducdh1210 on 10/13/14.
 */

/** Represent each Observer that is monitoring changes in the subject */
public class StockObserver implements  Observer{

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    /* Statically used as a counter */
    private static int observerIDTracker = 0;

    /* Used to track observers */
    private int observerID;

    /* Will hold reference to StockGrabber object */
    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {

        /* Store the reference to the stockGrabber object so I can make calls to its methods */
        this.stockGrabber = stockGrabber;
        /* Assign the observer ID and increment the static counter */
        this.observerID = ++ observerIDTracker;
        System.out.println("StockObserver.observerIDTracker: " + StockObserver.observerIDTracker);
        System.out.println("this.observerID: " + this.observerID);
        /* Add observer to the Subject object's ArrayList*/
        stockGrabber.register(this);
    }

    /* Call updates to all observers */
    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;
        printPrices();

    }

    @Override
    public int getObserverID() {
        return this.observerID;
    }

    public void printPrices(){
        System.out.println(observerID + "\nIBM : " + ibmPrice + "\nAAPL: " + aaplPrice + "\nGOOG: " + googPrice + "\n");
    }
}
