package Design_Pattern.Pattern_Factory.EnemyShip;

/**
 * Created by ducdh1210 on 10/9/14.
 */
import java.util.Scanner;

public class EnemyShipTesting {
    public static void main(String argp[]){

        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;

        Scanner user_input = new Scanner(System.in);
        System.out.println("What ship type? (U/B/R)");

        String typeOfShip;
        if (user_input.hasNextLine()){
            typeOfShip = user_input.nextLine();
            theEnemy = shipFactory.makeEnemyShip(typeOfShip);
            doStuffEnemy(theEnemy);
        }
    }

    public static void doStuffEnemy(EnemyShip enemyShip){
        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShoots();
    }
}
