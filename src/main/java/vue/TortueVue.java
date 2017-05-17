package vue;


import model.Tortue;

import java.awt.*;

public abstract class TortueVue {

    protected Tortue tortue;
    protected TortueVue(){};
    public TortueVue(Tortue tortue){
        this.tortue = tortue;
    }
    /*
    abstract void drawTurtle(Graphics g);
    public static TortueVue instancier(Tortue tortue){

    }*/
}
