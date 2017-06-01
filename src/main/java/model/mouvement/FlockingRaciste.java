package model.mouvement;


import model.Terrain;
import model.Tortue;

import java.awt.Color;
import java.util.List;

public class FlockingRaciste extends Flocking {

    public FlockingRaciste(Terrain terrain, int rayon) {
        super(terrain, rayon);
    }


    public List<Tortue> getVoisins(Tortue tortue){
        int currX = tortue.getX();
        int currY = tortue.getY();
        Color color = tortue.getColor();
        return terrain.filtrerTortues((Tortue tortue1) -> (
                tortue1 != tortue
                        && tortue1.getColor().equals(color)
                        && tortue1.distance2(currX, currY) <= rayonVoisin2
        ));
    }
}
