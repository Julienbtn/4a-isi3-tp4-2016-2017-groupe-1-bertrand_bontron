package model;// package logo;

import model.mouvement.MouvementStrategie;
import vue.tortue.TortueTriangleVue;

import java.awt.*;
import java.util.Observable;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 Source originale : J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/2001

 **************************************************************************/


public abstract class Tortue {

    protected static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche
    private static final Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.red,
            Color.green, Color.lightGray, Color.magenta, Color.orange, Color.gray,
            Color.pink, Color.yellow};

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



    public void setMouvement(MouvementStrategie mouvement) {
        this.mouvement = mouvement;
    }


    public void reset() {
        x = 0;
        y = 0;
        direction = -90;
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

    public void setColor(Color n) {
        couleur = n;
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
        for (int i = 0; i < 4; i++) {
            avancer();
            droite(90);
        }
    }

    public void poly(int n, int a) {
        for (int j = 0; j < a; j++) {
            avancer();
            droite(360 / a);
        }
    }

    public void spiral(int n, int k, int a) {
        for (int i = 0; i < k; i++) {
            avancer();
            droite(360 / a);
            n = n + 1;
        }
    }

    public Double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public Double distance2(int x, int y) {
        return Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2);
    }



}
