package model;// package logo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
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
	protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)
	private static final Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.red,
			Color.green, Color.lightGray, Color.magenta, Color.orange, Color.gray,
			Color.pink, Color.yellow};
	
	protected int x;
	protected int y;
	protected int direction;
	protected int couleur;


	public void setColor(int n) {couleur= n;}
	public int getColor() {return couleur;}

	public Tortue() {
		reset();
	}


	public Tortue(int x, int y) {
		reset();
		this.x = x;
		this.y = y;
	}


	public void reset() {
		x = 0;
		y = 0;
		direction= -90;
		couleur= 0;
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

	public int getDir() {
		return direction;
	}

	protected Color decodeColor(int c) {
		return (c < colors.length) ? colors[c] : Color.black;
	}

	public void avancer(int dist) {
		int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*direction));
		int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*direction));

		x = newX;
		y = newY;

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

	public void couleur(int n) {
		couleur= n % 12;
	}

	public void couleurSuivante() {
	 	couleur(couleur+1);
	}

	/** quelques classiques */

	public void carre() {
		for (int i=0;i<4;i++) {
			avancer(100);
			droite(90);
		}
	}

	public void poly(int n, int a) {
		for (int j=0;j<a;j++) {
			avancer(n);
			droite(360/a);
		}
	}

	public void spiral(int n, int k, int a) {
		for (int i = 0; i < k; i++) {
			couleurSuivante();
			avancer(n);
			droite(360/a);
			n = n+1;
		}
	}



}
