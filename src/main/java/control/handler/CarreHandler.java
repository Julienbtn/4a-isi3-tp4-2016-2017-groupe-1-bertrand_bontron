package control.handler;


import control.Controleur;
import control.ControleurAutonomie;
import control.ControleurManuel;
import control.ControleurTortue;
import model.Terrain;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class CarreHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        ((ControleurManuel)controleur).getTortueCourante().carre();
        model.notifyObservers();
    }

}
