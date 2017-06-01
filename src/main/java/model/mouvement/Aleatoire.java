package model.mouvement;

import model.Terrain;
import model.Tortue;

import java.util.Random;

public class Aleatoire extends MouvementStrategie {

    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    protected Terrain terrain;
    protected Random aleatoire;

    public Aleatoire(Terrain terrain) {
        this.terrain = terrain;
        aleatoire = new Random();
    }

    @Override
    public void bouger(Tortue tortue) {


        int variationAngle = aleatoire.nextInt(20) - 10;

        tortue.setDirection(tortue.getDirection() + variationAngle);

        int x = Math.floorMod((int) Math.round(tortue.getX() + tortue.getVitesse() * Math.cos(ratioDegRad * tortue.getDirection())),
                terrain.getLargeur());
        int y = Math.floorMod((int) Math.round(tortue.getY() + tortue.getVitesse() * Math.sin(ratioDegRad * tortue.getDirection())),
                terrain.getHauteur());

        tortue.setPosition(x, y);
    }
}
