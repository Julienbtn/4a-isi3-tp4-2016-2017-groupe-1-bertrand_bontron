package vue.tortue;


import model.Tortue;

import java.awt.*;

public class TortueRondVue extends TortueVue {

    private static final int RAYON = 7;

    public TortueRondVue(Tortue tortue) {
        super(tortue);
    }

    @Override
    public void drawTurtle (Graphics g) {

        g.setColor(tortue.getColor());
        g.fillOval(tortue.getX(), tortue.getY(), RAYON, RAYON);

    }
}
