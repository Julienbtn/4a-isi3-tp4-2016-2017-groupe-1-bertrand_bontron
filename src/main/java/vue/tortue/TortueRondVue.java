package vue.tortue;


import model.Tortue;

import java.awt.*;

public class TortueRondVue extends TortueVue {

    public TortueRondVue(Tortue tortue) {
        super(tortue);
    }

    @Override
    public void drawTurtle (Graphics g) {

        // la position de la tortue p
        int x = tortue.getX();
        int y = tortue.getY();


        g.setColor(tortue.getColor());
        g.fillOval(x,y,rp,rp);

    }
}
