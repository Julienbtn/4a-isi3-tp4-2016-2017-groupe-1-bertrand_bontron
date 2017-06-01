package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.function.Predicate;


public class Terrain extends Observable {

    protected List<Tortue> tortues;
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
            this.notifyObservers(tortue);
        }
    }

    public void pasSuivant(){
        for (Tortue tortue : tortues){
            tortue.avancer();
        }
        notifyObservers();
    }

    public void avancerTortue(int tortueId){
        tortues.get(tortueId).avancer();
        notifyObservers();
    }

    public void reset(){
        this.tortues = new ArrayList<>();
        notifyObservers(this.tortues);
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Tortue getTortueProche(int x, int y) {
        return getTortueProche(x, y, 1e6);
    }

    public Tortue getTortueProche(int x, int y, double distanceMax) {

        Tortue proche = null;
        distanceMax = distanceMax * distanceMax;
        for (Tortue courante : tortues) {
            double distance = courante.distance2(x, y);
            if (distance < distanceMax) {
                proche = courante;
                distanceMax = distance;
            }
        }
        return proche;
    }

    public void notifyObservers(){
        setChanged();
        super.notifyObservers();
    }

    public void notifyObservers(Object obj){
        setChanged();
        super.notifyObservers(obj);
    }

    public List<Tortue> filtrerTortues(Predicate<Tortue> predicate) {
        List<Tortue> valides = new ArrayList<>();
        for (Tortue tortue : tortues)
            if (predicate.test(tortue))
                valides.add(tortue);
        return valides;
    }
}
