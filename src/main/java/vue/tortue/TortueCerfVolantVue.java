package vue.tortue;


import com.sun.javafx.geom.Vec2d;
import model.Tortue;

import java.awt.*;

public class TortueCerfVolantVue extends TortueVue {

    private static final int LONGUEUR = 6;

    public TortueCerfVolantVue(Tortue tortue) {
        super(tortue);
    }

    @Override
    public void drawTurtle(Graphics g) {

            int x = tortue.getX();
            int y = tortue.getY();
            //Calcule les 4 coins du cerf-volant a partir de
            // la position de la tortue p
            Polygon cerfVolant = new Polygon();


            //Angle de la droite
            double theta = Math.toRadians(tortue.getDirection());

            Vec2d vect = new Vec2d(LONGUEUR * Math.cos(theta),LONGUEUR * Math.sin(theta));

            Point p1 = new Point((int)(x+vect.x*2), (int)(y + vect.y*2)); // pointe avant
            Point p2 = new Point((int)(x-vect.y), (int)(y + vect.x)); // sommet gauche
            Point p3 = new Point((int)(x-vect.x), (int)(y - vect.y)); // pointe arrière
            Point p4 = new Point((int)(x+vect.y), (int)(y - vect.x)); // sommet droit

            cerfVolant.addPoint(p1.x,p1.y);
            cerfVolant.addPoint(p2.x,p2.y);
            cerfVolant.addPoint(p3.x,p3.y);
            cerfVolant.addPoint(p4.x,p4.y);
            cerfVolant.addPoint(p1.x,p1.y);
            g.setColor(tortue.getColor());
            g.fillPolygon(cerfVolant);

        }
}
