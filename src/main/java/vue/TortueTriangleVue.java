package vue;


import com.sun.javafx.geom.Vec2d;
import model.Tortue;

import java.awt.*;


public class TortueTriangleVue extends TortueVue{

    protected static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche
    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    protected Tortue tortue;


    public void drawTurtle(Graphics g) {

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point point = new Point(tortue.getX(), tortue.getY());
        Polygon fleche = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = ratioDegRad * (-tortue.getDirection());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) rb / (float) rp);
        //Rayon de la fleche 1
        double r = Math.sqrt(rp * rp + rb * rb);

        //Pointe
        Point point2 = new Point((int) Math.round(point.x + r * Math.cos(theta)),
                (int) Math.round(point.y - r * Math.sin(theta)));
        fleche.addPoint(point2.x, point2.y);
        /*fleche.addPoint((int) Math.round(point2.x - r * Math.cos(theta + alpha)),
                (int) Math.round(point2.y + r * Math.sin(theta + alpha)));*/

        //Base
        fleche.addPoint((int) Math.round(point2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(point2.y + r * Math.sin(theta - alpha)));

        fleche.addPoint(point2.x, point2.y);
        g.setColor(tortue.getColor());
        g.fillPolygon(fleche);
    }

    public void drawTurtleRond(Graphics g) {

        // la position de la tortue p
        int x = tortue.getX();
        int y = tortue.getY();


        g.setColor(tortue.getColor());
        g.fillOval(x,y,rp,rp);

    }

    public void drawTurtleCerfVolant(Graphics g) {

        int x = tortue.getX();
        int y = tortue.getY();
        //Calcule les 4 coins du cerf-volant a partir de
        // la position de la tortue p
        Point point = new Point(x, y);
        Polygon cerfVolant = new Polygon();


        //Calcule des deux bases
        //Angle de la droite
        double theta = Math.toRadians(tortue.getDirection());
        //Rayon de la fleche
        double longueur = Math.sqrt(rp * rp + rb * rb)/2;

        Vec2d vect = new Vec2d(longueur * Math.cos(theta),longueur * Math.sin(theta));

        Point p1 = new Point((int)(x+vect.x*2), (int)(y + vect.y*2));
        Point p2 = new Point((int)(x-vect.y), (int)(y + vect.x));
        Point p3 = new Point((int)(x-vect.x), (int)(y - vect.y));
        Point p4 = new Point((int)(x+vect.y), (int)(y - vect.x));

        cerfVolant.addPoint(p1.x,p1.y);
        cerfVolant.addPoint(p2.x,p2.y);
        cerfVolant.addPoint(p3.x,p3.y);
        cerfVolant.addPoint(p4.x,p4.y);
        cerfVolant.addPoint(p1.x,p1.y);
        g.setColor(tortue.getColor());
        g.fillPolygon(cerfVolant);

    }

}
