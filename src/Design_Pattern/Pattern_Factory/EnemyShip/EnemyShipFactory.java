package Design_Pattern.Pattern_Factory.EnemyShip;

/**
 * Created by ducdh1210 on 10/9/14.
 */
public class EnemyShipFactory {
    public EnemyShip makeEnemyShip(String newShipType) {
        EnemyShip newShip = null;
        if (newShipType.equals("U")){
            return new UFOEnemyShip();
        }else if (newShipType.equals("R")){
            return new RockEnemyShip();
        }else if (newShipType.equals("B")){
            return new BigUFOEnemyShip();
        }else return null;

    }
}
