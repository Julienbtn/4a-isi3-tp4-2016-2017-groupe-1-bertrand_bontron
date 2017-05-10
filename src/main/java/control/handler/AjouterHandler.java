package control.handler;

import control.Controleur;
import model.Terrain;
import model.Tortue;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class AjouterHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        controleur.addTortue();

    }
}
