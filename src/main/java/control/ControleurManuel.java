package control;

import control.Controleur;
import model.Terrain;
import model.Tortue;

import java.awt.event.MouseEvent;


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

    public void mouseClicked(MouseEvent event) {
        Tortue tortue = terrain.getTortueProche(event.getX(), event.getY());
        if (tortue != null) {
            tortueCourante = tortue;
            System.out.println("Nouvelle tortue");
        }
    }
}
