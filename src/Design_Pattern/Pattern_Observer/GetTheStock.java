package Design_Pattern.Pattern_Observer;

/**
 * Created by ducdh1210 on 10/13/14.
 */

import  java.text.DecimalFormat;

public class GetTheStock implements  Runnable{

    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int startTime, String stock, double price) {
        this.startTime = startTime;
        this.stock = stock;
        this.price = price;
        this.stockGrabber = stockGrabber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++){
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}

            double randNum = (Math.random() * 0.06) - 0.03;

            DecimalFormat df = new DecimalFormat("#.##");

            price = Double.valueOf(df.format((price + randNum)));

            if (stock == "IBM"){
                ((StockGrabber)stockGrabber).setIbmPrice(price);
            }else if (stock == "AAPL"){
                ((StockGrabber)stockGrabber).setAaplPrice(price);
            }else if (stock == "GOOG"){
                ((StockGrabber)stockGrabber).setGoogPrice(price);
            }

            System.out.println(stock + " " + df.format((price + randNum))+ df.format(randNum) );

            System.out.println();


        }

    }
}
