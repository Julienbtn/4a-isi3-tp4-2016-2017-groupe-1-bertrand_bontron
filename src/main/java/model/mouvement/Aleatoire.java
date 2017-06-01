package model.mouvement;

import model.Terrain;
import model.Tortue;

import java.util.Random;

public class Aleatoire implements MouvementStrategie {

    protected Terrain terrain;
    protected Random aleatoire;

    public Aleatoire(Terrain terrain) {
        this.terrain = terrain;
        aleatoire = new Random();
    }


    public void bouger(Tortue tortue) {


        int variationAngle = aleatoire.nextInt(20) - 10;
        double direction  = tortue.getDirection() + variationAngle;
        double directionRad = Math.toRadians(direction);
        double vitesse = tortue.getVitesse();

        tortue.setDirection(direction);

        int x = Math.floorMod(
                (int) Math.round(tortue.getX() + vitesse * Math.cos(directionRad)),
                terrain.getLargeur()
        );
        int y = Math.floorMod(
                (int) Math.round(tortue.getY() + vitesse * Math.sin(directionRad)),
                terrain.getHauteur()
        );

        tortue.setPosition(x, y);
    }
}
