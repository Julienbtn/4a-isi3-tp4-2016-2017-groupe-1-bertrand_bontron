package control;

import control.handler.*;
import model.Terrain;
import model.Tortue;

import java.awt.event.MouseEvent;


public class ControleurManuel extends ControleurTortue {

    protected Tortue tortueCourante;

    public ControleurManuel(Terrain model) {
        super(model);

        overrideActionHandler("Avancer", new AvancerHandler());
        overrideActionHandler("Gauche", new GaucheHandler());
        overrideActionHandler("Droite", new DroiteHandler());
        overrideActionHandler("Carré", new CarreHandler());
        overrideActionHandler("Polygone", new PolyHandler());
        overrideActionHandler("Spiral", new SpiralHandler());
        overrideActionHandler("Ajouter", new AjouterHandler());
    }

    public void addTortue(Tortue tortue){
        super.addTortue(tortue);
        tortueCourante = tortue;
    }


    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    public void mouseClicked(MouseEvent event) {
        Tortue tortue = terrain.getTortueProche(event.getX(), event.getY(), 10);
        if (tortue != null) {
            tortueCourante = tortue;
            System.out.println("Nouvelle tortue");
        }
    }
}
