package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;


public class Terrain extends Observable {

    protected ArrayList<Tortue> tortues;
    protected final int largeur;
    protected final int hauteur;

    public Terrain(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.tortues = new ArrayList<>();
    }

    public int getNombreTortues() {
        return tortues.size();
    }

    public Tortue getTortue(int id) {
        return tortues.get(id);
    }

    public Iterator<Tortue> getTortues() {
        return tortues.iterator();
    }

    public void addTortue(Tortue tortue) {
        if (!tortues.contains(tortue)) {
            tortues.add(tortue);
            this.setChanged();
            this.notifyObservers(tortue);
        }
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Tortue getTortueProche(int x, int y) {
        return getTortueProche(x, y, 10);
    }

    public Tortue getTortueProche(int x, int y, double distanceMin) {

        Tortue proche = null;
        distanceMin = distanceMin * distanceMin;
        for (Tortue courante : tortues) {
            double distance = courante.distance2(x, y);
            if (distance < distanceMin) {
                proche = courante;
                distanceMin = distance;
            }
        }
        return proche;
    }
}
