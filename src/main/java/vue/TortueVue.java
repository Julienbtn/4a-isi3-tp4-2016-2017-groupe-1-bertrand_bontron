package vue;


import model.Tortue;

import java.awt.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class TortueVue{

    protected static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    protected Tortue tortue;

    public TortueVue(Tortue tortue){
        this.tortue = tortue;
    }

    public void drawTurtle (Graphics g) {

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getX(),tortue.getY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=ratioDegRad*(- tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)rb / (float)rp );
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        g.setColor(Color.green);
        g.fillPolygon(arrow);
    }

}
