package control.handler;


import control.Controleur;
import control.ControleurManuel;
import model.Terrain;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class SpiralHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        ((ControleurManuel)controleur).getTortueCourante().spiral(50, 40, 6);
        model.notifyObservers();
    }

}
