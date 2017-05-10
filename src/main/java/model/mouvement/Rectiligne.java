package model.mouvement;

import model.Terrain;
import model.Tortue;


public class Rectiligne extends MouvementStrategie {

    private Terrain terrain;

    public Rectiligne(Terrain terrain){
        this.terrain = terrain;
    }

    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)
    @Override
    public void bouger(Tortue tortue) {
        int x = Math.floorMod((int) Math.round(tortue.getX() + tortue.getVitesse() * Math.cos(ratioDegRad * tortue.getDirection())),
                terrain.getLargeur());
        int y = Math.floorMod((int) Math.round(tortue.getY() + tortue.getVitesse() * Math.sin(ratioDegRad * tortue.getDirection())),
                terrain.getHauteur());

        tortue.setPosition(x, y);
    }
}
