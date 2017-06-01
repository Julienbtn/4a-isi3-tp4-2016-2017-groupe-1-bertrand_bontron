package model;


import model.mouvement.MouvementStrategie;
import java.awt.*;


public abstract class Tortue {

    protected int x;
    protected int y;
    protected double direction;
    protected double vitesse;
    protected Color couleur;

    private MouvementStrategie mouvement;


    public Tortue(MouvementStrategie mouvement) {
        this(0, 0, 0, mouvement);
    }

    public Tortue(int x, int y, MouvementStrategie mouvement) {
        this(x, y, 0, mouvement);
    }

    public Tortue(int x, int y, int couleurId, MouvementStrategie mouvement) {
        this(x, y , couleurId, 10, -90, mouvement);
    }

    public Tortue(int x, int y, int couleurId, double vitesse, double direction, MouvementStrategie mouvement){
        this.x = x;
        this.y = y;
        this.couleur = Couleur.getCouleur(couleurId);
        this.vitesse = vitesse;
        this.direction = direction;
        this.mouvement = mouvement;
    }


    public void reset() {
        x = 0;
        y = 0;
        direction = 0;
        vitesse = 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getVitesse() {
        return vitesse;
    }

    public double getDirection() {
        return direction;
    }

    public Color getColor() {
        return couleur;
    }


    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public void setColor(Color couleur) {
        this.couleur = couleur;
    }


    public void avancer() {
        mouvement.bouger(this);
    }

    public void droite(int angle) {
        direction = (direction + angle) % 360;
    }

    public void gauche(int angle) {
        direction = (direction - angle) % 360;
    }


    /**
     * quelques classiques
     */

    public void carre() {
        poly(4);
    }

    public void poly(int cotes) {
        for (int j = 0; j < cotes; j++) {
            avancer();
            droite(360 / cotes);
        }
    }

    public void spiral(int cotes, int angle) {
        for (int i = 0; i < cotes; i++) {
            avancer();
            droite(360 / angle);
        }
    }

    // Distance euclidienne à un point
    public Double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    // carré de distance euclidienne à un point
    public Double distance2(int x, int y) {
        return Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2);
    }



}
