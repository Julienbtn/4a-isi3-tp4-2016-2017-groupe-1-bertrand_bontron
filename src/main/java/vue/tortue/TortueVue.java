package vue.tortue;


import model.Tortue;

import java.awt.*;

public abstract class TortueVue {

    protected static final int rp = 10;
    protected static final int rb = 5; // Taille de la pointe et de la base de la fleche

    protected Tortue tortue;

    public TortueVue(Tortue tortue){
        this.tortue = tortue;
    }

    public abstract void drawTurtle(Graphics g);
}
