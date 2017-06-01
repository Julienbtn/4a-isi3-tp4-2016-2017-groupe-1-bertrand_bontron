package control;

import control.handler.ResetHandler;
import model.Terrain;
import model.Tortue;


public abstract class ControleurTortue extends Controleur {


    public ControleurTortue(Terrain model){
        super();
        this.terrain = model;
        overrideActionHandler("Effacer", new ResetHandler());
    }


    public void addTortue(Tortue tortue) {
        terrain.addTortue(tortue);
    }




}
