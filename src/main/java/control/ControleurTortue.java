package control;

import model.Terrain;
import model.Tortue;


public abstract class ControleurTortue extends Controleur {


    public ControleurTortue(Terrain model){
        super();
        this.terrain = model;
    }


    public void addTortue(Tortue tortue) {
        terrain.addTortue(tortue);
    }




}
