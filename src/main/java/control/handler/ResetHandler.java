package control.handler;

import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;


public class ResetHandler implements ActionHandler {

    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        model.reset();
    }
}
