package vue.tortue;


import model.Tortue;

import java.awt.*;

public abstract class TortueVue {

    protected Tortue tortue;

    public TortueVue(Tortue tortue){
        this.tortue = tortue;
    }

    public abstract void drawTurtle(Graphics g);
}
