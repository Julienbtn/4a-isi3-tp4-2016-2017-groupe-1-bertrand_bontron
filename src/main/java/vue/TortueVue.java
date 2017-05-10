package vue;


import model.Tortue;

import java.awt.*;


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
        Point point = new Point(tortue.getX(),tortue.getY());
        Polygon fleche = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=ratioDegRad*(- tortue.getDirection());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)rb / (float)rp );
        //Rayon de la fleche
        double r=Math.sqrt( rp*rp + rb*rb );
        //Sens de la fleche

        //Pointe
        Point point2=new Point((int) Math.round(point.x+r*Math.cos(theta)),
                (int) Math.round(point.y-r*Math.sin(theta)));
        fleche.addPoint(point2.x,point2.y);
        fleche.addPoint((int) Math.round( point2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( point2.y+r*Math.sin(theta + alpha) ));

        //Base2
        fleche.addPoint((int) Math.round( point2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( point2.y+r*Math.sin(theta - alpha) ));

        fleche.addPoint(point2.x,point2.y);
        g.setColor(tortue.getColor());
        g.fillPolygon(fleche);
    }

}
