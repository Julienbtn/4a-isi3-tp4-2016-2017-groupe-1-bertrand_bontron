package model.mouvement;

import model.Terrain;
import model.Tortue;

import java.util.ArrayList;


public class Flocking extends MouvementStrategie {

    private static int MAX_SPEED = 3;
    private static int MAX_FORCE = 50;
    private static double COHESION_WEIGHT = 0.1;
    private static double ALIGNMENT_WEIGHT = 0.1;
    private static double SEPARATION_WEIGHT = 5;

    private Terrain terrain;
    private int rayonVoisin2;
    private int rayonTropProche;
    private double influence;

    public Flocking(Terrain terrain, int rayon, double influence) {
        this.terrain = terrain;
        this.rayonVoisin2 = rayon * rayon;
        this.influence = influence;
        this.rayonTropProche = 40;
    }

    @Override
    public void bouger(Tortue tortue) {

        int currX = tortue.getX();
        int currY = tortue.getY();
        double currVitesse = tortue.getVitesse();
        double currDirection = Math.toRadians(tortue.getDirection());

        // liste les voisins
        ArrayList<Tortue> voisins = new ArrayList<>();
        terrain.getTortues().forEachRemaining((Tortue t) -> {
            if (t != tortue && t.distance2(currX, currY) <= rayonVoisin2)
                voisins.add(t);
        });

        /// Cohesion
        // Centre de gravité
        double moyX = 0, moyY = 0;
        for (Tortue voisin : voisins){
            moyX += voisin.getX();
            moyY += voisin.getY();
        }
        if (voisins.size() > 0){
            moyX /= voisins.size();
            moyY /= voisins.size();
        }

        // Diriger vers centre (steer_to)
        double cohesionX, cohesionY;
        if (voisins.size() > 0){
            cohesionX = moyX - currX;
            cohesionY = moyY - currY;
            double distance = Math.sqrt(currY * currY + currX * currX);
            // si proche, on approche pas trop
            // sinon (loin) on approche à vitesse max
            if (distance > 50){
                cohesionX *= MAX_SPEED / 50;
                cohesionY *= MAX_SPEED / 50;
            }else{
                cohesionX *= MAX_SPEED / distance;
                cohesionY *= MAX_SPEED / distance;
            }
        }else{
            cohesionX = 0;
            cohesionY = 0;
        }

        /// Alignement
        moyX = 0;
        moyY = 0;
        for (Tortue voisin : voisins){
            double vitesse = voisin.getVitesse();
            double direction = Math.toRadians(voisin.getDirection());
            moyX += Math.cos(direction) * vitesse;
            moyY += Math.sin(direction) * vitesse;
        }
        if (voisins.size() > 0){
            moyX /= voisins.size();
            moyY /= voisins.size();
            // limitation de l'alignement
            double norme = Math.sqrt(moyX * moyX + moyY * moyY);
            if (norme > MAX_FORCE){
                moyX *= MAX_FORCE / norme;
                moyY *= MAX_FORCE / norme;
            }
        }

        double alignementX = moyX;
        double alignementY = moyY;

        /// separation
        moyX = 0;
        moyY = 0;
        double separationX = 0, separationY = 0;
        int nbProches = 0;
        for (Tortue voisin : voisins){
            double distance = voisin.distance(currX, currY);
            if (distance < rayonTropProche){
                nbProches++;
                double ajoutX = currX - voisin.getX();
                double ajoutY = currY - voisin.getY();
                double norme = Math.sqrt(ajoutY * ajoutY + ajoutX * ajoutX);
                moyX += ajoutX / norme / distance;
                moyY += ajoutY / norme / distance;
            }
        }
        if (nbProches > 0){
            separationX = moyX / nbProches;
            separationY = moyY / nbProches;
        }

        /// déplacement
        // sans influence des voisins
        double movX = Math.cos(currDirection) * currVitesse;
        double movY = Math.sin(currDirection) * currVitesse;

        /*
        tortue.setPosition(
                Math.floorMod((int)(currX + movX), terrain.getLargeur()),
                Math.floorMod((int)(currY + movY), terrain.getHauteur())
        );*/

        // ajoute influence des voisins
        movX += (cohesionX * COHESION_WEIGHT) +
                (alignementX * ALIGNMENT_WEIGHT) +
                (separationX * SEPARATION_WEIGHT);
        movY += (cohesionY * COHESION_WEIGHT) +
                (alignementY * ALIGNMENT_WEIGHT) +
                (separationY * SEPARATION_WEIGHT);

        // limite la vitesse
        double norme = Math.sqrt(movX * movX + movY * movY);
        if (norme > MAX_SPEED){
            movX *= MAX_SPEED / norme;
            movY *= MAX_SPEED / norme;
            norme = MAX_SPEED;
        }
        // update vitesse / direction /  position
        tortue.setVitesse(norme);
        tortue.setDirection(Math.toDegrees(Math.atan2(movY, movX)));

        int newX = Math.floorMod((int) (currX + movX), terrain.getLargeur());
        int newY = Math.floorMod((int) (currY + movY), terrain.getHauteur());
        tortue.setPosition(newX, newY);
    }


}
