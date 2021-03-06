package control.handler;


import control.Controleur;
import control.ControleurAutonomie;
import control.ControleurManuel;
import model.Terrain;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class DroiteHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        ((ControleurManuel)controleur).getTortueCourante().droite(45);
        model.notifyObservers();
    }

}
