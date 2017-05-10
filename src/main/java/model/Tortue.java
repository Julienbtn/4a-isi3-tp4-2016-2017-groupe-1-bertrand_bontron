package model;// package logo;

import model.mouvement.MouvementStrategie;
import model.mouvement.Rectiligne;

import java.awt.*;
import java.util.Observable;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

	Source originale : J. Ferber - 1999-2001

			   Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/2001

**************************************************************************/


public class Tortue extends Observable
{

	protected static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
	private static final Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.red,
			Color.green, Color.lightGray, Color.magenta, Color.orange, Color.gray,
			Color.pink, Color.yellow};
	
	protected int x;
	protected int y;
	protected int direction;
	protected int vitesse;
	protected Color couleur;

	private MouvementStrategie mouvement;

	public void setColor(Color n) {couleur= n;}
	public Color getColor() {return couleur;}


	public Tortue(int x, int y, int couleurId) {
		this.x = x;
		this.y = y;
		this.vitesse = 5;
		this.couleur = Couleur.getCouleur(couleurId);
		direction= -90;
	}

	public void setMouvement(MouvementStrategie mouvement){
		this.mouvement = mouvement;
	}

	public Tortue() {
		this(0, 0, 0);
	}

	public Tortue(int x, int y) {
		this(x, y, 0);
	}

	public void reset() {
		x = 0;
		y = 0;
		couleur = Color.black;
		direction= -90;
		vitesse = 10;
		setChanged();
		notifyObservers();
  	}

	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
		setChanged();
		notifyObservers();
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getDirection() {
		return direction;
	}

	protected Color decodeColor(int c) {
		return (c < colors.length) ? colors[c] : Color.black;
	}

	public void avancer() {
		mouvement.bouger(this);

		setChanged();
		notifyObservers();
	}

	public void droite(int angle) {
		direction= (direction+angle) % 360;
		setChanged();
		notifyObservers();
	}

	public void gauche(int angle) {
		direction= (direction-angle) % 360;
		setChanged();
		notifyObservers();
	}

	public void couleur(int couleurId) {
		this.couleur= Couleur.getCouleur(couleurId);
	}


	/** quelques classiques */

	public void carre() {
		for (int i=0;i<4;i++) {
			avancer();
			droite(90);
		}
	}

	public void poly(int n, int a) {
		for (int j=0;j<a;j++) {
			avancer();
			droite(360/a);
		}
	}

	public void spiral(int n, int k, int a) {
		for (int i = 0; i < k; i++) {
			avancer();
			droite(360/a);
			n = n+1;
		}
	}

	public Double distance(int x, int y){
		return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
	}
	public Double distance2(int x, int y){
		return Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2);
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}
}
