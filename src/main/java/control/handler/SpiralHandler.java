package control.handler;


import control.Controleur;
import control.ControleurAutonomie;
import model.Terrain;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class SpiralHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        controleur.getTortueCourante().spiral(50, 40, 6);
    }

}
