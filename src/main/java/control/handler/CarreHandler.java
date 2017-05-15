package control.handler;


import control.Controleur;
import control.ControleurAutonomie;
import model.Terrain;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class CarreHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        controleur.getTortueCourante().carre();
    }

}
