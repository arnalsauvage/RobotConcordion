package robot;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RunWith(ConcordionRunner.class)
public class MouvementFixture {
    private final Robot wallE = new Robot(0 , new Battery(), new RoadBookCalculator());

    public String resultatDeplacement(String mouvement) throws InaccessibleCoordinate, UnlandedRobotException, InsufficientChargeException, LandSensorDefaillance {
        String resultat = "";
        wallE.land(new Coordinates(5,5), new LandSensor(new Random()));
        switch (mouvement) {
            case "se déplace en avant":
                wallE.moveForward();
                break;
            case "se déplace en arrière":
                wallE.moveBackward();
                break;
            case "tourne dans le sens des aiguilles d'une montre":
                wallE.turnRight();
                break;
            case "tourne dans le sens inverse des aiguilles d'une montre":
                wallE.turnLeft();
                break;
        }
        if (wallE.getXposition()==5 && wallE.getYposition()==4) {
            resultat = "il avance d'une case vers le nord";
        }
        if (wallE.getXposition()==5 && wallE.getYposition()==6) {
            resultat = "il avance d'une case vers le sud";
        }
        if (wallE.getDirection() == Direction.EAST) {
            resultat = "il est orienté vers l'est";
        }
        if (wallE.getDirection() == Direction.WEST) {
            resultat = "il est orienté vers l'ouest";
        }
        return resultat;
    }
}
