package model.mouvement;

import model.Terrain;
import model.Tortue;

import java.util.Iterator;


public class Flocking extends MouvementStrategie {

    private Terrain terrain;
    private int rayon;
    private double influence;

    public Flocking(Terrain terrain, int rayon, double influence) {
        this.terrain = terrain;
        this.rayon = rayon * rayon;
        this.influence = influence;
    }

    @Override
    public void bouger(Tortue tortue) {
        int vitesseMoy = tortue.getVitesse(), directionMoy = tortue.getDirection();
        int nbVoisins = 1;

        int currX = tortue.getX(), currY = tortue.getY();

        Iterator<Tortue> voisins = terrain.getTortues();
        while (voisins.hasNext()) {
            Tortue voisin = voisins.next();
            if (voisin.distance2(currX, currY) < rayon) {
                vitesseMoy += voisin.getVitesse();
                directionMoy += voisin.getDirection();
                nbVoisins++;
            }
        }
        vitesseMoy /= nbVoisins;
        directionMoy /= nbVoisins;

        int directionDiff = Math.floorMod(tortue.getDirection() - directionMoy, 360);
        if (directionDiff > 180)
            directionDiff = directionDiff - 360;
        tortue.setDirection(Math.floorMod((int) (tortue.getDirection() + (directionDiff * this.influence)), 360));

        int x = Math.floorMod((int) Math.round(tortue.getX() + tortue.getVitesse() * Math.cos(ratioDegRad * tortue.getDirection())),
                terrain.getLargeur());
        int y = Math.floorMod((int) Math.round(tortue.getY() + tortue.getVitesse() * Math.sin(ratioDegRad * tortue.getDirection())),
                terrain.getHauteur());

        tortue.setPosition(x, y);
    }


}
