package model.mouvement;


import model.Terrain;
import model.Tortue;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FlockingRaciste extends Flocking {

    public FlockingRaciste(Terrain terrain, int rayon) {
        super(terrain, rayon);
    }


    public List<Tortue> getVoisins(Tortue tortue){
        int currX = tortue.getX();
        int currY = tortue.getY();
        Color color = tortue.getColor();
        return terrain.filtrerTortues((Tortue t) -> (
                t != tortue
                        && t.getColor().equals(color)
                        && t.distance2(currX, currY) <= rayonVoisin2
        ));
    }
}
