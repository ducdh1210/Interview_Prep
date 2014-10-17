package Design_Pattern.Pattern_Observer;

/**
 * Created by ducdh1210 on 10/13/14.
 */
public class Tester {

    public static void main(String[] args) {

        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);
        System.out.println("ObserverID: " + observer1.getObserverID());
        StockObserver observer2 =  new StockObserver(stockGrabber);
        System.out.println("ObserverID: " + observer2.getObserverID());

        stockGrabber.setIbmPrice(197.0);
        stockGrabber.setAaplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        stockGrabber.unregister(observer1);
        System.out.println("ObserverID: " + observer1.getObserverID());

        StockObserver observer3 =  new StockObserver(stockGrabber);
        System.out.println("ObserverID: " + observer3.getObserverID());


        stockGrabber.setIbmPrice(197.0);
        stockGrabber.setAaplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

    }
}
