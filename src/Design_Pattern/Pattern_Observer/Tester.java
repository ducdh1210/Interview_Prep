package Design_Pattern.Pattern_Observer;

/**
 * Created by ducdh1210 on 10/13/14.
 */
public class Tester {

    public static void main(String[] args) {

       /* StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);
        StockObserver observer2 =  new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.0);
        stockGrabber.setAaplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        stockGrabber.unregister(observer1);

        stockGrabber.setIbmPrice(197.0);
        stockGrabber.setAaplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);*/

        StockGrabber stockGrabber = new StockGrabber();

        Runnable getIBM = new GetTheStock(stockGrabber,2,"IBM",197.0);
        Runnable getAPPL = new GetTheStock(stockGrabber,2,"IBM",677.60);
        Runnable getGOOG = new GetTheStock(stockGrabber,2,"IBM",676.40);

        new Thread(getIBM).start();
        new Thread(getAPPL).start();
        new Thread(getGOOG).start();




    }
}
