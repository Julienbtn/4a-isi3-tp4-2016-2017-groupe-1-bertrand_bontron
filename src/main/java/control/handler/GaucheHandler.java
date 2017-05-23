package control.handler;

import control.Controleur;
import control.ControleurAutonomie;
import control.ControleurManuel;
import model.Terrain;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class GaucheHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        ((ControleurManuel)controleur).getTortueCourante().gauche(45);
        model.notifyObservers();
    }

}
