package control;

import control.Controleur;
import model.Terrain;
import model.Tortue;


public class ControleurManuel extends ControleurTortue {

    protected Tortue tortueCourante;

    public ControleurManuel(Terrain model) {
        super(model);
    }

    public void addTortue(Tortue tortue){
        super.addTortue(tortue);
        tortueCourante = tortue;
    }


    public Tortue getTortueCourante() {
        return tortueCourante;
    }
}
